package bridge.Model.WrappingType;

import bridge.Enum.CrossResult;

import java.util.List;

public class CrossResults {
    private final List<CrossResult> crossResults;

    public CrossResults(List<CrossResult> crossResults) {
        this.crossResults = crossResults;
    }

    public int nextPosition() {
        return crossResults.size();
    }

    public void add(CrossResult crossResult) {
        crossResults.add(crossResult);
    }

    public boolean contain(CrossResult crossResult) {
        return crossResults.contains(crossResult);
    }

    public CrossResult get(int position) {
        return crossResults.get(position);
    }
}
