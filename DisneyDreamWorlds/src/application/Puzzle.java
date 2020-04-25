package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class Puzzle {
	private String puzzleID;
	private String puzzleText;
	private String puzzleAnswer;
	private int puzzleAttempts;
	private String puzzleHint;
	private String puzzleLocation;
	private int puzzleScore;
	private Boolean puzzleIsSolved;
	private Boolean puzzleIsLocked;
	
	public Puzzle() {
		puzzleID = "";
		puzzleText = "";
		puzzleAnswer = "";
		puzzleAttempts = 0;
		puzzleAnswer = "";
		puzzleAttempts = 0;
		puzzleHint = "";
		puzzleLocation = "";
		puzzleScore = 0;
		puzzleIsSolved = false;
		puzzleIsLocked = false;
	}
	
	public Puzzle(String puzzleID, String puzzleText, String puzzleAnswer, int puzzleAttempts, 
			String puzzleHint, String puzzleLocation, int puzzleScore, Boolean puzzleIsSolved, Boolean puzzleIsLocked) {
		this.puzzleID = puzzleID;
		this.puzzleText = puzzleText;
		this.puzzleAnswer = puzzleAnswer;
		this.puzzleAttempts = puzzleAttempts;
		this.puzzleHint = puzzleHint;
		this.puzzleLocation = puzzleLocation;
		this.puzzleScore = puzzleScore;
		this.puzzleIsSolved = puzzleIsSolved;
		this.puzzleIsLocked = puzzleIsLocked;
	}
	
	// Getters
	public String getPuzzleID() {
		return puzzleID;
	}
	
	public String getPuzzleText() {
		return puzzleText;
	}
	
	public String getPuzzleAnswer() {
		return puzzleAnswer;
	}
	
	public int getPuzzleAttempts() {
		return puzzleAttempts;
	}
	
	public String getPuzzleHint() {
		return puzzleHint;
	}
	
	public String getPuzzleLocation() {
		return puzzleLocation;
	}
	
	public int getPuzzleScore() {
		return puzzleScore;
	}
	
	public Boolean getPuzzleIsSolved() {
		return puzzleIsSolved;
	}
	
	public Boolean getPuzzleIsLocked() {
		return puzzleIsLocked;
	}
	
	// Setters
	public void setPuzzleID(String puzzleID) {
		this.puzzleID = puzzleID;
	}
	
	public void setPuzzleText(String puzzleText) {
		this.puzzleText = puzzleText;
	}
	
	public void setPuzzleAnswer(String puzzleAnswer) {
		this.puzzleAnswer = puzzleAnswer;
	}
	
	public void setPuzzleAttempts(int puzzleAttempts) {
		this.puzzleAttempts = puzzleAttempts;
	}
	
	public void setPuzzleHint(String puzzleHint) {
		this.puzzleHint = puzzleHint;
	}
	
	public void setPuzzleLocation(String puzzleLocation) {
		this.puzzleLocation = puzzleLocation;
	}
	
	public void setPuzzleScore(int puzzleScore) {
		this.puzzleScore = puzzleScore;
	}
	
	public void setPuzzleIsSolved(Boolean puzzleIsSolved) {
		this.puzzleIsSolved = puzzleIsSolved;
	}
	
	public void setPuzzleIsLocked(Boolean puzzleIsLocked) {
		this.puzzleIsLocked = puzzleIsLocked;
	}
	
	// This display a hint for the current puzzle
	public void displayPuzzleHint(String text, ImageView emojiImageView_4, Stage primaryStage) {
		Text puzzleHint = new Text(text);
		
		VBox puzzleHintBox = new VBox(10);
		puzzleHintBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button("OK");
		
		puzzleHintBox.getChildren().add(puzzleHint);
		puzzleHintBox.getChildren().add(emojiImageView_4);
		puzzleHintBox.getChildren().add(okButton);
		
		Scene puzzleHintScene = new Scene(puzzleHintBox, 450, 120);
		Stage puzzleHintStage = new Stage();
		
		puzzleHintStage.setX(primaryStage.getX() + (primaryStage.getWidth() - puzzleHintScene.getWidth())/2);
		puzzleHintStage.setY(primaryStage.getY() + (primaryStage.getHeight() - puzzleHintScene.getHeight())/2);
		
		puzzleHintStage.setScene(puzzleHintScene);
		puzzleHintStage.show();
		puzzleHintStage.setTitle("Puzzle Hint");
		
		okButton.setOnAction(e -> {
			puzzleHintStage.close();
		});
	}
	
}
