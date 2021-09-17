package creditapp.core.model;

import java.util.Objects;

public class FinanceData {

    private final SourceOfIncome[] sourcesOfIncome;

    public FinanceData(SourceOfIncome... sourcesOfIncome) {
        this.sourcesOfIncome = sourcesOfIncome;
    }

    public SourceOfIncome[] getSourcesOfIncome() {
        return sourcesOfIncome;
    }
}
