public class Chair {
    private String chairId;
    private int rowNum;
    private int colNum;
    private Tier tier;

    public Chair(String chairId, int rowNum, int colNum, Tier tier) {
        this.chairId = chairId;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.tier = tier;
    }

    public Tier getTier() { return tier; }
    public String getChairId() { return chairId; }
}
