public class Main {
    public static void main(String[] args) {

        ShardedStore cache = new ShardedStore(3, 2);

        System.out.println(cache.get("X")); // fetches from DB
        System.out.println(cache.get("X")); // cache hit

        cache.put("Y", "hello");
        System.out.println(cache.get("Y"));
    }
}
