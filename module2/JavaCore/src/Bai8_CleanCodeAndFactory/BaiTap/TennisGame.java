package Bai8_CleanCodeAndFactory.BaiTap;

public class TennisGame {

    public static final int MAX_SCORE = 4;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String gameScore = "";
        int tempScore = 0;
        boolean isEqualScore = player1Score == player2Score;
        if (isEqualScore) {
            gameScore = getScoreEqual(player1Score);
        } else if (player1Score >= MAX_SCORE || player2Score >= MAX_SCORE) {
            gameScore = getScoreReset(player1Score, player2Score);
        } else {
            gameScore = getScorePlaying(player1Score, player2Score, gameScore);
        }
        return gameScore;
    }

    private static String getScorePlaying(int player1Score, int player2Score, String gameScore) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                gameScore += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    gameScore += "Love";
                    break;
                case 1:
                    gameScore += "Fifteen";
                    break;
                case 2:
                    gameScore += "Thirty";
                    break;
                case 3:
                    gameScore += "Forty";
                    break;
            }
        }
        return gameScore;
    }

    private static String getScoreEqual(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static String getScoreReset(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}