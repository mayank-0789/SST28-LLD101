package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Global metrics registry — thread-safe Singleton.
 *
 * Implementation: Double-Checked Locking with volatile field.
 * - Private constructor with reflection guard.
 * - readResolve() preserves the singleton across serialization.
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static volatile MetricsRegistry INSTANCE;
    private final Map<String, Long> counters = new HashMap<>();

    // Private constructor — also guards against reflection-based api's
    private MetricsRegistry() {
        if (INSTANCE != null) {
            throw new IllegalStateException(
                "Singleton already constructed — use MetricsRegistry.getInstance()");
        }
    }

    // Double-Checked Locking — lazy, thread-safe
    public static MetricsRegistry getInstance() {
        if (INSTANCE == null) {
            synchronized (MetricsRegistry.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MetricsRegistry();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // Preserve singleton guarantee across Java serialization
    protected Object readResolve() {
        return getInstance();
    }   
}
