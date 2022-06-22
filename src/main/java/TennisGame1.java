import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private Integer score1 = 0;
    private Integer score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (Objects.equals(score1, score2))return getStringScore(score1);

        if (score1>=4 || score2>=4) return  getMinusResult(score1, score2);

        return  getResultScore(score);
    }

    private String getResultScore(String score) {
        int tempScore=0;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = score1;
            else { score +="-"; tempScore = score2;}
            score = tempScore(score, tempScore);
        }
        return score;
    }

    private String tempScore(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;

        }
        return score;
    }

    private String getMinusResult(Integer score1, Integer score2) {
        int minusResult = score1-score2;
        if (minusResult ==1) return "Advantage player1";
        if (minusResult ==-1) return "Advantage player2";
        if (minusResult >=2) return  "Win for player1";
        return "Win for player2";
    }

    private String getStringScore(Integer score1) {
        switch (score1)
        {
            case 0:
                    return "Love-All";
            case 1:
                    return "Fifteen-All";
            case 2:
                    return "Thirty-All";
            default:
                    return "Deuce";

        }
    }
}
