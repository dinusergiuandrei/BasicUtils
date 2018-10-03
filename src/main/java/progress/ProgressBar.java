package progress;

public class ProgressBar {
    private Integer totalUnits;

    private String startToken;

    private String endToken;

    private String unitToken;

    private String emptyToken;

    public ProgressBar(Integer totalUnits, String startToken, String endToken, String unitToken, String emptyToken) {
        this.totalUnits = totalUnits;
        this.startToken = startToken;
        this.endToken = endToken;
        this.unitToken = unitToken;
        this.emptyToken = emptyToken;
        updateAndPrint(0);
    }

    public ProgressBar(Integer totalUnits) {
        this(totalUnits, "[", "]", "-", ".");
    }

    public void updateAndPrint(Integer points){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.startToken);
        if(points>totalUnits)
            throw new IllegalArgumentException("Can not print " + points + " on a " + totalUnits + " length progress bar.");
        for (int i = 0; i < points; ++i) {
            stringBuilder.append(this.unitToken);
        }
        for (int i=points; i<totalUnits; ++i){
            stringBuilder.append(this.emptyToken);
        }
        stringBuilder.append(this.endToken);
        System.out.println(stringBuilder.toString());
    }
}
