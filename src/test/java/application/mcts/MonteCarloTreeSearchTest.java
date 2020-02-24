package application.mcts;

import application.ImmutablePosition;
import application.game.Board;
import application.game.COLOUR;
import application.game.verifiers.OthelloVerifier;
import org.junit.Test;

public class MonteCarloTreeSearchTest {
    private final Board board = new Board(8, new OthelloVerifier(), 0.01, 10.0, 1.0);


    @Test
    public void test() {
        MonteCarloTreeSearch monteCarloTreeSearch = new MonteCarloTreeSearch(board, COLOUR.WHITE, 3000, 0, null, 1.0);
        ImmutablePosition immutablePosition = monteCarloTreeSearch.run(1).getPositionToCreateBoard();
        System.out.println("immutablePosition = " + immutablePosition);


    }
}
