public abstract class Exporter {
    /**
     * Contract:
     * - Must accept any valid ExportRequest
     * - Must not throw exceptions for valid input
     * - Must not lose or alter data
     * - Must always return a valid ExportResult
     */
    public abstract ExportResult export(ExportRequest req);
}
