/**
 * Created by zhiqinhuang on 4/8/17.
 */
class BoardState {
    static int PITSNUMBER; // the number of pits of each player
    int mancalaA, mancalaB;
    int[] pitsA = new int[PITSNUMBER], pitsB = new int[PITSNUMBER];
    boolean nextPlayer; // the player takes next move, false -> player A

    /**
     * initialize board
     */
    BoardState() {
        this.mancalaA = 0;
        this.mancalaB = 0;
        this.nextPlayer = false; // player A
        for (int i = 0; i < PITSNUMBER; i++) {
            this.pitsA[i] = 4;
            this.pitsB[i] = 4;
        }
    }

    /**
     * move marbles in n-th pit
     * which side moves
     * initial @param fromMancala as 0
     */
    void updateMove(int n, char side, int fromMancala) {
        if (n < 0 || n > BoardState.PITSNUMBER) {
            System.out.println("Pit does not exist. Range from 1 to " + BoardState.PITSNUMBER);
            return;
        }
        if (n != 0) {
            if (side == 'a') {
                int surplus = this.moveInPitsA(n, 0);
                if (surplus > 1) {
                    this.mancalaA += 1;
                    this.updateMove(0, 'b', surplus - 1);
                }
                if (surplus == 1) {
                    this.mancalaA += 1;
                }
            }
            if (side == 'b') {
                int surplus = this.moveInPitsB(n, 0);
                if (surplus > 1) {
                    this.mancalaB += 1;
                    this.updateMove(0, 'a', surplus - 1);
                }
                if (surplus == 1) {
                    this.mancalaB += 1;
                }
            }
        } else {
            if (side == 'a') {
                int surplus=this.moveInPitsA(n,fromMancala);
                if (surplus > 1) {
                    this.mancalaA += 1;
                    this.updateMove(0, 'b', surplus - 1);
                }
                if (surplus == 1) {
                    this.mancalaA += 1;
                }
            }
            if (side == 'b') {
                int surplus=this.moveInPitsB(n,fromMancala);
                if (surplus > 1) {
                    this.mancalaB += 1;
                    this.updateMove(0, 'a', surplus - 1);
                }
                if (surplus == 1) {
                    this.mancalaB += 1;
                }
            }
        }
    }

    /**
     * move marbles in pits of player A
     *
     * @param n move the n-th pit
     *          0 means from mancala
     *          fromMancala marbles from Mancala
     * @return the marbles left when it reaches the end
     */
    private int moveInPitsA(int n, int fromMancala) {
        if (n != 0) {
            int marbleNumber = this.pitsA[n - 1];
            int pitsLeft = BoardState.PITSNUMBER - n;
            if (marbleNumber <= pitsLeft) { // no marbles left to mancala and opposite pits
                for (int i = n; i < n + marbleNumber; i++) {
                    this.pitsA[i] += 1;
                }
                return 0;
            } else {
                for (int i = n; i < BoardState.PITSNUMBER; i++) {
                    this.pitsA[i] += 1;
                }
                return marbleNumber - pitsLeft;
            }
        } else {
            int pitsLeft = BoardState.PITSNUMBER;
            if (fromMancala <= pitsLeft) { // no marbles left to mancala and opposite pits
                for (int i = 0; i < fromMancala; i++) {
                    this.pitsA[i] += 1;
                }
                return 0;
            } else {
                for (int i = 0; i < BoardState.PITSNUMBER; i++) {
                    this.pitsA[i] += 1;
                }
                return fromMancala - pitsLeft;
            }
        }
    }

    /**
     * move marbles in pits of player B
     *
     * @param n move the n-th pit
     * @return the marbles left when it reaches the end
     */
    private int moveInPitsB(int n, int fromMancala) {
        if (n != 0) {
            int marbleNumber = this.pitsB[n - 1];
            int pitsLeft = BoardState.PITSNUMBER - n;
            if (marbleNumber <= pitsLeft) { // no marbles left to mancala and opposite pits
                for (int i = n; i < n + marbleNumber; i++) {
                    this.pitsB[i] += 1;
                }
                return 0;
            } else {
                for (int i = n; i < BoardState.PITSNUMBER; i++) {
                    this.pitsB[i] += 1;
                }
                return marbleNumber - pitsLeft;
            }
        } else {
            int pitsLeft = BoardState.PITSNUMBER;
            if (fromMancala <= pitsLeft) { // no marbles left to mancala and opposite pits
                for (int i = 0; i < fromMancala; i++) {
                    this.pitsB[i] += 1;
                }
                return 0;
            } else {
                for (int i = 0; i < BoardState.PITSNUMBER; i++) {
                    this.pitsB[i] += 1;
                }
                return fromMancala - pitsLeft;
            }
        }
    }
}
