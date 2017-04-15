/**
 * Created by zhiqinhuang on 4/13/17.
 */
import java.util.ArrayList;
import java.util.List;
class MancalaAI {
    // Possible parameters
    int depth; // search depth
    int pits; // the number of pits
    List<Treenode> Tree;

    MancalaAI(int pits){
        super();
        this.depth=5;
        this.pits=pits;
    }

    /**
     * change search depth
     * @param depth
     */
    void changeParameters(int depth){
        this.depth=depth;
    }

    void Seaching(BoardState boardState){

    }

    /**
     * evaluate the current state
     * positive result means it is beneficial to player B
     * @param boardState
     */
    int staticEvaluationB(BoardState boardState){
        return boardState.mancalaB-boardState.mancalaA;
    }
}
