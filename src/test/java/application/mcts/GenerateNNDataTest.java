package application.mcts;

import application.game.Board;
import application.game.COLOUR;
import application.game.verifiers.OthelloVerifier;
import com.google.common.collect.ImmutableList;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class GenerateNNDataTest {
    private Board board;
    private TreeNode treeNode;

    private GenerateNNData GenerateNNData;

    public void setup() {
        board = new Board(4, new OthelloVerifier(), 0.0, 0.0, 0.0);
        treeNode = TreeNode.builder().colour(COLOUR.WHITE).currentBoard(board).positionToCreateBoard(null).parent(null).rootColour(COLOUR.WHITE).hostname("127.0.0.1:5000").build();
    }

    public void writeSingleBoardTest() {
        File file = new File("intBoards/testWrite.txt");
        file.delete();
        try {
            ImmutableList.Builder<Double> builder = ImmutableList.builder();
            builder.add(0.0);
            GenerateNNData.write(board.asIntArray(), builder.build(), 1.0);
            String expected = "[[0,0,0,0,0,1,-1,0,0,-1,1,0,0,0,0,0],[0.0],1]";
            assertEquals(expected, readFile().get(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ImmutableList<String> readFile() throws IOException {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        File file = new File("intBoards/" + "testWrite.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            builder.add(line);
        }
        return builder.build();
    }


}




