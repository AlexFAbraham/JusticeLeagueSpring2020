package application;

public class Score {
	
	private String scoreID;
	private String scoreName;
	private int scoreNumber;
	
	Score() {
		scoreID = "S01";
		scoreName = "?";
		scoreNumber = 0;
	}
	
	Score(String scoreID, String scoreName, int scoreNumber) {
		this.scoreID = scoreID;
		this.scoreName = scoreName;
		this.scoreNumber = scoreNumber;
	}
	
	public String getScoreID() {
		return scoreID;
	}

	public void setScoreID(String scoreID) {
		this.scoreID = scoreID;
	}

	public String getScoreName() {
		return scoreName;
	}

	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}

	public int getScoreNumber() {
		return scoreNumber;
	}

	public void setScoreNumber(int scoreNumber) {
		this.scoreNumber = scoreNumber;
	}
	
	
}
