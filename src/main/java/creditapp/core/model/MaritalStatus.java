package creditapp.core.model;

public enum MaritalStatus {
    DIVORCED,
    SEPARATED(100),
    SINGLE,
    WIDOWED,
    MARRIED(100);

    private final int scoringPoints;

    MaritalStatus(int scoringPoints) {
        this.scoringPoints = scoringPoints;
    }

    MaritalStatus() {
        this.scoringPoints = 0;
    }

    public int getScoringPoints() {
        return scoringPoints;
    }
}


