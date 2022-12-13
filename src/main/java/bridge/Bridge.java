package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean canMove(int position, String answer){
        return bridge.get(position).equals(answer);
    }
}
