package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {
    private final List<String> bridge = List.of("U", "U", "D");

    @ParameterizedTest
    @MethodSource("generateData")
    void conditionTest(List<String> choiceLog, int result){
        int position = choiceLog.size() - 1;
        String moveResult = choiceLog.get(choiceLog.size() - 1);
        Player player = new Player(position, choiceLog);

        BridgeGame bridgeGame = new BridgeGame(bridge, player);
        int actual = bridgeGame.condition();

        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(List.of("U"), BridgeGame.RUNNING),
                Arguments.of(List.of("D"), BridgeGame.GAME_OVER),
                Arguments.of(List.of("U", "U"), BridgeGame.RUNNING),
                Arguments.of(List.of("U", "D"), BridgeGame.GAME_OVER),
                Arguments.of(List.of("U", "U", "D"), BridgeGame.SUCCESS)
        );
    }
}
