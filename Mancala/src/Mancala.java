/**
 * Created by zhiqinhuang on 4/9/17.
 */
public class Mancala {
    public static void main(String[] args){
        BoardState.PITSNUMBER=Integer.parseInt(args[0]);
        BoardState boardState=new BoardState();
        Board board=new Board();
        board.printBoard(boardState);
    }

    /**
     * print game result on command line
     * @param boardState
     */
    void showResult(BoardState boardState){
        int[] result=Refugee.judge(boardState);
        System.out.println(result);
        if (result[0]>result[1]){
            System.out.println("player A won");
        }
        if (result[0]<result[1]){
            System.out.println("player B won");
        }
        if (result[0]==result[1]){
            System.out.println("draw");
        }
    }
}
