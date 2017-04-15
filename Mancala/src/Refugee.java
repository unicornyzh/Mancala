/**
 * Created by zhiqinhuang on 4/14/17.
 */
class Refugee {
    /**
     * whether the game is end
     * @param boardState
     * @return
     */
    static boolean isEnd(BoardState boardState){
        // situations of pits
        boolean isAEmpty=true,isBEmpty=true;

        for (int i=0;i<BoardState.PITSNUMBER;i++){
            if (boardState.pitsA[i]!=0){
                isAEmpty=false;
                break;
            }
        }
        for (int i=0;i<BoardState.PITSNUMBER;i++){
            if (boardState.pitsB[i]!=0){
                isBEmpty=false;
                break;
            }
        }
        return (isAEmpty||isBEmpty);
    }

    /**
     * calculate total marbles when game is end
     * @param boardState
     * @return
     */
    static int[] judge(BoardState boardState){
        int[] result=new int[2];
        if (isEnd(boardState)){
            result[0]=boardState.mancalaA; // score of player A
            result[1]=boardState.mancalaB;
        }
        return result;
    }
}
