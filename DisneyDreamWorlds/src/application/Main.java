// Copy and Paste in Run Configurations/Arguments
// --module-path "C:\Users\franx\eclipse-workspace\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
// --add-modules javafx.controls,javafx.graphics,javafx.media
// C:\Users\franx\eclipse-workspace\javafx-sdk-11.0.2\lib (the path where you have your lib files)
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.Random;

public class Main extends Application {
	
	// Launch!
	public static void main(String[] args) {
		launch(args);
	}
	
	// Reason we only name varibles is so we don't have to pass them
	// through functions/methods as parameters every time we need to
	// ======================================
	// |						            |
	// |						            |
	// |      Game Menu Scene variables     |	
	// |						            |
	// |						            |
	// ======================================
	
	// primaryScene = start menu
	// newGameScene = new player starts a new game
	// loadGameScene = an existing player loads an existing game
	// scoreBoardScene = displays the top scores of players that finished the game
	// helpScene = displays instructions/information about the game
	// gameScene = player plays either a new game or existing game
	// monsterVideoScene = when a player enters a room where a monster is located, a short video is played
	Scene primaryScene, newGameScene, loadGameScene, scoreBoardScene, helpScene, gameScene, monsterVideoScene;
	
	Stage playerInventoryStage, playerMapStage, helpStage, commandListStage, itemHelpStage, itemStage, 
	    monsterStage, invalidStage, puzzleHelpStage, monsterHelpStage, inventoryHelpStage, statsStage;
	
	// newGameButton = start/begin a new game!
	// loadGameButton = load an existing game!
	// scoreButton = see  at the  score board!
	// helpButton = see commands of  the game!
	// exitGameButton = exit the  game... duh!
	Button newGameButton, loadGameButton, scoreButton, helpButton, exitGameButton;
	
	// Image and sound related variables!
	// 1 = MouseClick, 2 = Success, 3 = Fail,
	// 4 = Footsteps,  5= Horror
	AudioClip   soundEffect_1;
	AudioClip   soundEffect_2;
	AudioClip   soundEffect_3;
	AudioClip 	soundEffect_4;
	AudioClip   soundEffect_5;
	AudioClip backgroundSound;
	
	Image puzzleImage, itemImage, monsterImage;
	
	ImageView logoImageView, mapImageView, locationImageView, puzzleImageView, itemImageView, monsterImageView, helpImageView, wakingUpImageView, 
							  fightingImageView, commandListImageView, puzzleHelpImageView, itemHelpImageView, monsterHelpImageView, inventoryHelpImageView;
		
	Background backgroundImage;
	
	// Game Title / Logo!
	Label gameTitleLabel;
	
	// Label and Buttons!
	VBox gameMenuBox;
	
	// Background Sound file path
	String backgroundSoundPath;
	
	// =============================================
	// |						                   |
	// |						                   |
	// |      Create New Game Scene variables      |	
	// |						                   |
	// |						                   |
	// =============================================
	
	// Some labels...
	Label createNewGameLabel, usernameLabel, passwordLabel;
	
	// createNewGameButton = create new game and starts game
	// cancelButton = cancels  the creation  of the  account
	Button createNewGameButton, cancelButton;
	
	// usernameTextField = enter username for the new account
	// passwordTextField = enter password for the new account
	TextField usernameTextField, passwordTextField;
	
	// PasswordField
	PasswordField passwordPasswordField;
	
	// CheckBox
	CheckBox passwordCheckBox;
	
	// Button and TextFields are here
	GridPane createNewGamePane, helpPane;
	
	// GridPane and a label  are here
	VBox createNewGameBox;
	
	// ==========================================
	// |						                |
	// |						                |
	// |      Game Running Scene variables      |	
	// |						                |
	// |						                |
	// ==========================================
	
	// Message displayed in the game
	Text messageText;
	
	// Stores integer
	IntegerProperty integer;
	
	// Animation.1
	Timeline time;
	
	// Animation.2
	KeyFrame key;
	
	// Classes / ArrayList / general stuff
	Map map;
	Player player;
	Item item;
	Puzzle puzzle;
	Monster monster;
	
	ImageView helpImageView_1;
	ImageView helpImageView_2;
	
	ImageView emojiImageView_1;
	ImageView emojiImageView_2;
	ImageView emojiImageView_3;
	ImageView emojiImageView_4;
	
	// Item
	ArrayList<Item> itemArrayList;
	Item generalItem, item01, item02, item03, item04, item05, item06, item07,
	          item08, item09, item10, item11, item12, item13, item14, item15;
	
	// Puzzle
	ArrayList<Puzzle> puzzleArrayList;
	Puzzle generalPuzzle, puzzle01, puzzle02, puzzle03,
				puzzle04, puzzle05, puzzle06, puzzle07;
	
	// Monster
	ArrayList<Monster> monsterArrayList;
	Monster generalMonster, monster01, monster02, monster03, monster04,
							monster05, monster06, monster07, monster08;
	
	ArrayList<String> monsterPathVideo;
	ArrayList<String> monsterPathGif;
	ArrayList<String> generalCommandList;
	
	String userInputCommand;
	
	Rectangle2D screenBounds;
	
	TableView<Item> tableView1;
	
	TextField inventoryTextField;
	
	Text p1, p2, p3;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		screenBounds = Screen.getPrimary().getVisualBounds();
		
		try {
			map = new Map();
			map.createRoomFile();
			map.readRoomFile();
			
			item = new Item();
			puzzle = new Puzzle();
			monster = new Monster();
			
			createItemFile();
			readItemFile();
			createPuzzleFile();
			readPuzzleFile();
			createMonsterFile();
			readMonsterFile();
									
			emojiImageView_1 = new ImageView(new Image(new FileInputStream("AngryEmoji.png")));
			emojiImageView_2 = new ImageView(new Image(new FileInputStream("WearyEmoji.png")));
			emojiImageView_3 = new ImageView(new Image(new FileInputStream("GrimacingEmoji.png")));
			emojiImageView_4 = new ImageView(new Image(new FileInputStream("ThinkingEmoji.png")));
			
			emojiImageView_1.setFitWidth(20);
			emojiImageView_2.setFitWidth(20);
			emojiImageView_3.setFitWidth(20);
			emojiImageView_4.setFitWidth(20);
			
			emojiImageView_1.setFitHeight(20);
			emojiImageView_2.setFitHeight(20);
			emojiImageView_3.setFitHeight(20);
			emojiImageView_4.setFitHeight(20);
			
			puzzleImage = new Image(new FileInputStream("PuzzleImage.png"));
			itemImage = new Image(new FileInputStream("ItemImage.png"));
			monsterImage = new Image(new FileInputStream("MonsterImage.png"));
			
			mapImageView = new ImageView(new Image(new FileInputStream("Map.png")));
			locationImageView = new ImageView(new Image(new FileInputStream("Location.png")));	
			// Help Images
			helpImageView = new ImageView(new Image(new FileInputStream("Help.png")));
			fightingImageView = new ImageView(new Image(new FileInputStream("Fighting.gif")));
			itemHelpImageView = new ImageView(new Image(new FileInputStream("ItemHelp.png")));
			puzzleHelpImageView = new ImageView(new Image(new FileInputStream("PuzzleHelp.png")));
			monsterHelpImageView = new ImageView(new Image(new FileInputStream("MonsterHelp.png")));
			commandListImageView = new ImageView(new Image(new FileInputStream("CommandList.png")));
			inventoryHelpImageView = new ImageView(new Image(new FileInputStream("InventoryHelp.png")));
			wakingUpImageView = new ImageView(new Image(new FileInputStream("WakingUp.gif")));
			
			wakingUpImageView.setFitWidth(300);
			wakingUpImageView.setFitHeight(200);
			
			fightingImageView.setFitWidth(200);
			fightingImageView.setFitHeight(200);
			
			commandListImageView.setFitWidth(screenBounds.getWidth()/2);
			commandListImageView.setFitHeight(screenBounds.getHeight()-80);
			
			backgroundSoundPath = "BackgroundSound.mp3";
			backgroundSound = new AudioClip(new File(backgroundSoundPath).toURI().toString());
			backgroundSound.setCycleCount(AudioClip.INDEFINITE);
			backgroundSound.setVolume(0.3);
			backgroundSound.play();
			
			// Additional Stages within the game
			playerInventoryStage = new Stage();
			inventoryHelpStage = new Stage();
			monsterHelpStage = new Stage();
			commandListStage = new Stage();
			puzzleHelpStage = new Stage();
			playerMapStage = new Stage();
			itemHelpStage = new Stage();
			invalidStage = new Stage();
			monsterStage = new Stage();
			statsStage = new Stage();
			helpStage = new Stage();
			itemStage = new Stage();
			
			// TableView
			tableView1 = new TableView<>();
			
			// Monster Videos
			monsterPathVideo = new ArrayList<String>();
			addMonsterVideoToArrayList();
			// Monster Gifs
			monsterPathGif = new ArrayList<String>();
			addMonsterGifToArrayList();
			// Command List
			generalCommandList = new ArrayList<String>();
			addGeneralCommandToArrayList();
			
			inventoryTextField = new TextField();
			
			p1 = new Text();
			p2 = new Text();
			p3 = new Text();
			
			// =====================================
			// |						           |
			// |						           |
			// |          Main Menu Scene          |	
			// |						           |
			// |						           |
			// =====================================
			newGameButton = new Button("New Game");
			loadGameButton = new Button("Load Game");
			scoreButton = new Button("Score");
			helpButton = new Button("Help");
			exitGameButton = new Button("Exit Game");
			
			// Background Image
			backgroundImage = new Background(new BackgroundImage(new Image(new FileInputStream("IntroImageBackground.png")),
										BackgroundRepeat.NO_REPEAT,
										BackgroundRepeat.NO_REPEAT,
										BackgroundPosition.DEFAULT,
										new BackgroundSize(1.0,1.0,true,true,false,false)));
			
			// Sound Effects
			String path_1 = "MouseClickSoundEffect.mp3";
			soundEffect_1 = new AudioClip(new File(path_1).toURI().toString());
			
			String path_2 = "SucessSoundEffect.mp3";
			soundEffect_2 = new AudioClip(new File(path_2).toURI().toString());
			
			String path_3 = "SadSoundEffect.mp3";
			soundEffect_3 = new AudioClip(new File(path_3).toURI().toString());
			
			String path_4 = "FootstepsSoundEffect.mp3";
			soundEffect_4 = new AudioClip(new File(path_4).toURI().toString());
			
			String path_5 = "HorrorSoundEffect.mp3";
			soundEffect_5 = new AudioClip(new File(path_5).toURI().toString());
			
			// Logo Image Label
			logoImageView = new ImageView(new Image(new FileInputStream("Logo.png")));
			logoImageView.setScaleX(1.5);
			logoImageView.setScaleY(1.5);
			// Label / Title of the Game / Label Size / Insets(N,E,S,W)
			gameTitleLabel = new Label("", logoImageView);
			gameTitleLabel.setPadding(new Insets(20,20,50,20));
			
			// Setting Button sizes
			newGameButton.setPrefSize(100, 30);
			loadGameButton.setPrefSize(100, 30);
			scoreButton.setPrefSize(100, 30);
			helpButton.setPrefSize(100, 30);
			exitGameButton.setPrefSize(100, 30);
		
			gameMenuBox = new VBox(10);
			gameMenuBox.setPrefSize(800, 600);
			gameMenuBox.getChildren().addAll(gameTitleLabel, newGameButton, loadGameButton, scoreButton, helpButton, exitGameButton);
			gameMenuBox.setAlignment(Pos.CENTER);
			gameMenuBox.setBackground(backgroundImage);
						
			// Scene (Pane + Width + Height) / set Intro scene
			primaryScene = new Scene(gameMenuBox, screenBounds.getWidth()/2, screenBounds.getHeight());
			primaryStage.setTitle("Disney Dream Worlds!");
			primaryStage.setScene(primaryScene);
			
			// Something happens when button is clicked!
			// New Game Button!
			newGameButton.setOnAction(e -> {
				soundEffect_1.play(1.0);
				primaryStage.setTitle("Creating New Game");
				showNewGameScene(primaryStage);
			});
			// Load Game Button!
			loadGameButton.setOnAction(e -> {
				soundEffect_1.play(1.0);
				primaryStage.setTitle("Loading Existing Game");
				showLoadGameScene(primaryStage);
			});
			// Score Button!
			scoreButton.setOnAction(e -> {
				soundEffect_1.play(1.0);
				primaryStage.setTitle("Score Board");
				showScoreBoardScene(primaryStage);
			});
			// Help Button!
			helpButton.setOnAction(e -> {
				soundEffect_1.play(1.0);
				primaryStage.setTitle("Help Menu");
				showHelpScene(primaryStage);
			});
			// Exit Game Button!
			exitGameButton.setOnAction(e -> {
				System.exit(0);
			});
			
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// This function adds all short monster videos to arrayList
	public void addMonsterVideoToArrayList() {
		monsterPathVideo.add("SnowWhiteApproaches.mp4");
		monsterPathVideo.add("CinderellaApproaches.mp4");
		monsterPathVideo.add("JasmineApproaches.mp4");
		monsterPathVideo.add("RapunzelApproaches.mp4");
		monsterPathVideo.add("ArielApproaches.mp4");
		monsterPathVideo.add("MulanApproaches.mp4");
		monsterPathVideo.add("PocahontasApproaches.mp4");
		monsterPathVideo.add("MickeyApproaches.mp4");
	}
	
	public void addMonsterGifToArrayList() {
		monsterPathGif.add("SnowWhite.gif");
		monsterPathGif.add("Cinderella.gif");
		monsterPathGif.add("Jasmine.gif");
		monsterPathGif.add("Rapunzel.gif");
		monsterPathGif.add("Ariel.gif");
		monsterPathGif.add("Mulan.gif");
		monsterPathGif.add("Pocahontas.gif");
		monsterPathGif.add("MickeyMouse.gif");
	}
	
	// This function adds all possible command to arrayList
	public void addGeneralCommandToArrayList() {
		// ====================================
		// |						          |
		// |   Main Game Commands Sceneario   | Scenario 1 : you can add map here
		// |						          |
		// ====================================
		// Move where?
		generalCommandList.add("move north");
		generalCommandList.add("north");
		generalCommandList.add("n");
		generalCommandList.add("move east");
		generalCommandList.add("east");
		generalCommandList.add("e");
		generalCommandList.add("move south");
		generalCommandList.add("south");
		generalCommandList.add("s");
		generalCommandList.add("move west");
		generalCommandList.add("west");
		generalCommandList.add("w");
		// More in-game commands
		generalCommandList.add("save");
		generalCommandList.add("help");
		generalCommandList.add("commands");
		generalCommandList.add("command list");
		generalCommandList.add("check stats");
		generalCommandList.add("look stats");
		generalCommandList.add("open stats");
		generalCommandList.add("stats");
		// Score
		generalCommandList.add("check score");
		generalCommandList.add("look score");
		generalCommandList.add("score");
		// Go back to main menu
		generalCommandList.add("main menu");
		generalCommandList.add("start menu");
		generalCommandList.add("menu");
		// Exit game without saving
		generalCommandList.add("exit game");
		generalCommandList.add("exit");
		// Open map
		generalCommandList.add("look map");
		generalCommandList.add("open map");
		generalCommandList.add("map");
		// Explore room
		generalCommandList.add("explore room");
		generalCommandList.add("explore");
		// Inventory
		generalCommandList.add("check inventory");
		generalCommandList.add("look inventory");
		generalCommandList.add("inventory");
		generalCommandList.add("i");
		// ====================================
		// |						          |
		// |    Item Interaction Scenario     | Scenario 2
		// |						          |
		// ====================================
		// Interaction with Items
		generalCommandList.add("pick up");
		generalCommandList.add("pick up item");
		generalCommandList.add("store");
		generalCommandList.add("store item");
		generalCommandList.add("ignore item");
		// "ignore" already in command list (puzzle) but add in help picture too
		generalCommandList.add("examine");
		generalCommandList.add("examine item");
		// ====================================
		// |						          |
		// |  Inventory Interaction Scenario  | Scenario 3
		// |						          |
		// ====================================
		// Inventory Interaction / Items
		generalCommandList.add("use");
		generalCommandList.add("consume");
		generalCommandList.add("equip");
		generalCommandList.add("unequip");
		generalCommandList.add("drop");
		// ====================================
		// |						          |
		// |   Puzzle Interaction Scenario    | Scenario 4
		// |						          |
		// ====================================
		// Interaction with Puzzles
		generalCommandList.add("answer puzzle");
		generalCommandList.add("solve puzzle");
		generalCommandList.add("answer");
		generalCommandList.add("solve");
		generalCommandList.add("hint");
		generalCommandList.add("ignore puzzle");
		generalCommandList.add("ignore");
		// ====================================
		// |						          |
		// |   Monster Interaction Scenario   | Scenario 5
		// |						          |
		// ====================================
		// Interaction with Monsters
		generalCommandList.add("fight");
		generalCommandList.add("attack");
		generalCommandList.add("run");
		generalCommandList.add("flee");
	}
	
	// =====================================
	// |						           |
	// |						           |
	// |      Creating New Game Scene      |	
	// |						           |
	// |						           |
	// =====================================
	// In this Scene, the player is able to create a new account
	// The player must enter a non-existent username and a password
	// Once both has been validated, the player will proceed to the game!
	public void showNewGameScene(Stage primaryStage) {
		createNewGameBox = new VBox();
		createNewGameBox.setAlignment(Pos.CENTER);
		createNewGameBox.setPadding(new Insets(10));
		
		createNewGamePane = new GridPane();
		createNewGamePane.setAlignment(Pos.CENTER);
		createNewGamePane.setVgap(10);
		createNewGamePane.setHgap(10);
		createNewGamePane.setPadding(new Insets(10));
		
		createNewGameLabel = new Label("Create a New Account");
		createNewGameLabel.setFont(new Font("Arial", 24));
		createNewGameLabel.setPadding(new Insets(10,10,30,10));
		
		// Username
		usernameLabel = new Label("Username");
		createNewGamePane.add(usernameLabel, 0, 0);	
		
		usernameTextField = new TextField();
		usernameTextField.setPromptText("Username");
		createNewGamePane.add(usernameTextField, 1, 0);
		
		// Password
		passwordLabel = new Label("Password");
		createNewGamePane.add(passwordLabel, 0, 1);
		passwordTextField = new TextField();
		
		passwordTextField.setPromptText("Password");
		passwordTextField.setManaged(false);
		passwordTextField.setVisible(false);
		createNewGamePane.add(passwordTextField, 1, 1);
		
		passwordPasswordField = new PasswordField();
		passwordPasswordField.setPromptText("Password");
		createNewGamePane.add(passwordPasswordField, 1, 1);
		
		passwordCheckBox = new CheckBox("Show/Hide password");
		createNewGamePane.add(passwordCheckBox, 1, 2);
		// When checkbox's state is chenged...
		// If checkbox is checked, show passwordTextField
		passwordTextField.managedProperty().bind(passwordCheckBox.selectedProperty());
		passwordTextField.visibleProperty().bind(passwordCheckBox.selectedProperty());
		// If checkbox is not checked, show passwordPasswordField
		passwordPasswordField.managedProperty().bind(passwordCheckBox.selectedProperty().not());
		passwordPasswordField.visibleProperty().bind(passwordCheckBox.selectedProperty().not());
		
		passwordTextField.textProperty().bindBidirectional(passwordPasswordField.textProperty());
		
		createNewGameButton = new Button("Create");
		createNewGamePane.add(createNewGameButton, 1, 3);
		
		cancelButton = new Button("Cancel");
		createNewGamePane.add(cancelButton, 1, 4);
		
		createNewGameBox.getChildren().addAll(createNewGameLabel, createNewGamePane);
		
		newGameScene = new Scene(createNewGameBox, screenBounds.getWidth()/2, screenBounds.getHeight());
		primaryStage.setScene(newGameScene);
		
		// Buttons On Action!
		createNewGameButton.setOnAction(e -> {
			soundEffect_1.play(1.0);
			
			String verifyUsername = usernameTextField.getText();
			String verifyPassword = passwordTextField.getText();
						
			Boolean validUsername = false;
			Boolean validPassword = false;
			VBox errorBox = new VBox(10);
			errorBox.setAlignment(Pos.CENTER);
			
			if (verifyUsername.length() <= 3) {
				errorBox.getChildren().add(new Text("Username is too short!"));
			}
			else if (verifyUsername.length() >= 11) {
				errorBox.getChildren().add(new Text("Username is too long!"));
			}
			else {
				validUsername = true;
			}
			if (verifyPassword.length() <= 3) {
				errorBox.getChildren().add(new Text("Password is too short!"));
			}
			else {
				validPassword = true;
			}
			if (validUsername == true && validPassword == true){
				
				if (validUsernameFile(primaryStage, usernameTextField.getText())) {
					
					primaryStage.setTitle("Game Running!");
					player = new Player();
				
					player.setPlayerUsername(usernameTextField.getText());
					player.setPlayerPassword(passwordTextField.getText());
				
					Random random = new Random();
					player.setPlayerID(String.valueOf(random.nextInt(9999999) + usernameTextField.getText().toUpperCase().substring(0,1) + passwordTextField.getText().toUpperCase().charAt(0)));
				
					createPlayerFile(player);
					
					showStartGameScene(primaryStage);
					backgroundSound.stop();
				}
			}
			else {
				errorBox.getChildren().add(emojiImageView_3);
				Button okButton = new Button("OK");
				errorBox.getChildren().add(okButton);
				Scene errorScene = new Scene(errorBox, 250, 150);
				Stage errorStage = new Stage();
								
				errorStage.setX(primaryStage.getX() + (primaryStage.getWidth() - errorScene.getWidth())/2);
				errorStage.setY(primaryStage.getY() + (primaryStage.getHeight() - errorScene.getHeight())/2);
				
				errorStage.setScene(errorScene);
				errorStage.show();
				errorStage.setTitle("Error Message");
				
				okButton.setOnAction(f -> {
					errorStage.close();
				});
			}
		});
		cancelButton.setOnAction(e -> {
			soundEffect_1.play(1.0);
			primaryStage.setTitle("Disney Dream Worlds!");
			primaryStage.setScene(primaryScene);
		});
	}
	
	public void createPlayerFile(Player player) {
		try {
			File userFile = new File(player.getPlayerUsername() + ".txt");
		
			userFile.createNewFile();
		
			FileWriter playerFileWriter = new FileWriter(player.getPlayerUsername() + ".txt");
			
			playerFileWriter.write(player.getPlayerID() + "~");
			playerFileWriter.write(player.getPlayerUsername() + "~");
			playerFileWriter.write(player.getPlayerPassword() + "~");
			playerFileWriter.write(player.getPlayerCurrentHealth() + "~");
			playerFileWriter.write(player.getPlayerTotalHealth() + "~");
			playerFileWriter.write(player.getPlayerMinAttack() + "~");
			playerFileWriter.write(player.getPlayerMaxAttack() + "~");
			playerFileWriter.write(player.getPlayerDefense() + "~");
			playerFileWriter.write(player.getPlayerScore() + "~\n");
			playerFileWriter.write(player.getPlayerLocation() + "~");
			
			for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
				playerFileWriter.write(itemArrayList.get(itemIndex).getItemLocation() + "~");
				playerFileWriter.write(itemArrayList.get(itemIndex).getItemIsPickedUp() + "~");
				playerFileWriter.write(itemArrayList.get(itemIndex).getItemIsEquipped() + "~");
				playerFileWriter.write(itemArrayList.get(itemIndex).getItemIsLocked() + "~\n");
			}
			
			for (int puzzleIndex = 0; puzzleIndex < puzzleArrayList.size(); puzzleIndex++) {
				playerFileWriter.write(puzzleArrayList.get(puzzleIndex).getPuzzleIsSolved() + "~");
				playerFileWriter.write(puzzleArrayList.get(puzzleIndex).getPuzzleIsLocked() + "~\n");
			}
			
			for (int monsterIndex = 0; monsterIndex < monsterArrayList.size(); monsterIndex++) {
				playerFileWriter.write(monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() + "~");
				playerFileWriter.write(monsterArrayList.get(monsterIndex).getMonsterIsDefeated() + "~\n");
			}
			
			playerFileWriter.close();
		}
		catch(Exception e) {
			
		}
	}
	
	// This function validates the username of the player
	// It verifies if the username is on use or not
	public Boolean validUsernameFile(Stage primaryStage, String username) {

		File userFile = new File(username + ".txt");
	
		if (userFile.exists()) {
			Text t1 = new Text(username + " is already in use!");
			Text t2 = new Text("Please choose another username");
		
			t1.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
			t2.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		
			Button okButton = new Button("OK");
		
			VBox box = new VBox(10);
			box.setAlignment(Pos.CENTER);
		
			box.getChildren().add(t1);
			box.getChildren().add(t2);
			box.getChildren().add(emojiImageView_2);
			box.getChildren().add(okButton);
		
			Scene userScene = new Scene(box , 250, 150);
			Stage userStage = new Stage();
		
			userStage.setX(primaryStage.getX() + (primaryStage.getWidth() - userScene.getWidth())/2);
			userStage.setY(primaryStage.getY() + (primaryStage.getHeight() - userScene.getHeight())/2);
		
			userStage.setScene(userScene);
			userStage.show();
			userStage.setTitle("Username in use");
		
			okButton.setOnAction(e -> {
				userStage.close();
			});
			return false;
		}
		return true;
	}
	
	// ====================================
	// |						          |
	// |						          |
	// |      New Game Running Scene      |	
	// |						          |
	// |						          |
	// ====================================
	// New Game Starts!
	// This function uses Two GridPane
	// One inside another one
	// One GridPane displays the Directions, Room Names and encounters
	// While the other one, displays everyhing, the game title, 
	// the game text (room description), the other GridPane, and 
	// a TextField that stores the user's input
	public void showStartGameScene(Stage primaryStage) {
		// Set gaps/space Vertically and Horizontally and center it
		GridPane roomTable = new GridPane();
		roomTable.setVgap(10);
		roomTable.setHgap(50);
		roomTable.setAlignment(Pos.CENTER);
		
		// CSS
		roomTable.setStyle("-fx-padding: 10;" + 
                			"-fx-border-style: solid inside;" + 
                			"-fx-border-width: 2;" +
                			"-fx-border-insets: 5;" + 
                			"-fx-border-radius: 5;" + 
							"-fx-border-color: black;");
		
		GridPane gameBox = new GridPane();
		gameBox.setVgap(50);
		gameBox.setAlignment(Pos.CENTER);
		
		String index = player.getPlayerLocation();
		int indexLocation = Integer.parseInt(index.substring(1))-1;
				
		// this variable indicates whether the direction is N/E/W/S
		int direction = 0;
		
		Text t01 = new Text("Direction");
		t01.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		Text t02 = new Text("Room Name");
		t02.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		Text t03 = new Text("Encounter");
		t03.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		// True or False indicates whether the program displays
		// either the room name or what's in that room
		direction = 0;
		Text t04 = new Text("North");
		Text t05 = new Text(displayRoom(direction, false));
		Text t06 = new Text(displayRoom(direction, true));
		
		direction = 1;
		Text t07 = new Text("East");
		Text t08 = new Text(displayRoom(direction, false));
		Text t09 = new Text(displayRoom(direction, true));
		
		direction = 2;
		Text t10 = new Text("South");
		Text t11 = new Text(displayRoom(direction, false));
		Text t12 = new Text(displayRoom(direction, true));
		
		direction = 3;
		Text t13 = new Text("West");
		Text t14 = new Text(displayRoom(direction, false));
		Text t15 = new Text(displayRoom(direction, true));
		
		// Add Texts to Grid
		roomTable.add(t01,0,0);
		roomTable.add(t02,1,0);
		roomTable.add(t03,2,0);
		roomTable.add(t04,0,1);
		roomTable.add(t05,1,1);
		roomTable.add(t06,2,1);
		roomTable.add(t07,0,2);
		roomTable.add(t08,1,2);
		roomTable.add(t09,2,2);
		roomTable.add(t10,0,3);
		roomTable.add(t11,1,3);
		roomTable.add(t12,2,3);
		roomTable.add(t13,0,4);
		roomTable.add(t14,1,4);
		roomTable.add(t15,2,4);
		
		// Need to center each node(element) one by one
		GridPane.setHalignment(t01, HPos.CENTER);
		GridPane.setHalignment(t02, HPos.CENTER);
		GridPane.setHalignment(t04, HPos.CENTER);
		GridPane.setHalignment(t05, HPos.CENTER);
		GridPane.setHalignment(t06, HPos.CENTER);
		GridPane.setHalignment(t07, HPos.CENTER);
		GridPane.setHalignment(t08, HPos.CENTER);
		GridPane.setHalignment(t09, HPos.CENTER);
		GridPane.setHalignment(t10, HPos.CENTER);
		GridPane.setHalignment(t11, HPos.CENTER);
		GridPane.setHalignment(t12, HPos.CENTER);
		GridPane.setHalignment(t13, HPos.CENTER);
		GridPane.setHalignment(t14, HPos.CENTER);
		GridPane.setHalignment(t15, HPos.CENTER);
		
		// TextField now stores the user's input 
		// when the keyboard ENTER is pressed
		TextField userInputTextField = new TextField();
		userInputCommand = new String();
		
		// Command entered
		userInputTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {	
				
				userInputCommand = userInputTextField.getText().toLowerCase();
				
				// This function validates the command, if false, display invalid command message
				if (player.validateCommand(userInputCommand, generalCommandList).equals(false)) {
					if (invalidStage.isShowing()) {
						invalidStage.close();
						player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
					}
					else {
						player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
					}
				}
				else if (userInputTextField.getText().equals("explore") || userInputTextField.getText().equals("explore room")) {
					checkForSomething(primaryStage, gameBox, userInputTextField);
				}
				else if (userInputTextField.getText().equals("open map") || userInputTextField.getText().equals("map") || userInputTextField.getText().equals("look map")) {
					//player.displayMap(player, playerMapStage, mapImageView, locationImageView, puzzleImage, itemImage, monsterImage, puzzleArrayList, itemArrayList, monsterArrayList);
					if (!playerMapStage.isShowing()) 
						player.displayMap(player, playerMapStage, mapImageView, locationImageView, puzzleImage, itemImage, monsterImage, puzzleArrayList, itemArrayList, monsterArrayList);
				}
				else if (userInputTextField.getText().equals("check inventory") || userInputTextField.getText().equals("look inventory") || userInputTextField.getText().equals("inventory") || userInputTextField.getText().equals("i")) {
					if (player.getPlayerInventory().size() < 1 && player.getPlayerEquipment().size() < 1) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
					}
					if (!playerInventoryStage.isShowing()) 
						player.playerChecksInventory(player, itemArrayList, emojiImageView_2, emojiImageView_3, generalCommandList, map.roomArrayList, playerInventoryStage, primaryStage, 
								tableView1, screenBounds, commandListStage, inventoryHelpStage, commandListImageView, inventoryHelpImageView, invalidStage, inventoryTextField);
				}
				else if (userInputTextField.getText().equals("help")) {
					if (!helpStage.isShowing())
						player.helpCommand(helpStage, helpImageView, screenBounds, "Help");
				}
				else if (userInputTextField.getText().equals("commands") || userInputTextField.getText().equals("command list")) {
					if (!commandListStage.isShowing())
						player.helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
				}
				else if (userInputTextField.getText().equals("stats") || userInputTextField.getText().equals("look stats") || userInputTextField.getText().equals("open stats") || userInputTextField.getText().equals("check stats")) {
					if (statsStage.isShowing()) {
						statsStage.close();
						player.displayStats(emojiImageView_3, primaryStage, player, statsStage);
					}
					else {
						player.displayStats(emojiImageView_3, primaryStage, player, statsStage);
					}
				}
				else if (userInputTextField.getText().equals("start menu") || userInputTextField.getText().equals("main menu") || userInputTextField.getText().equals("menu")) {
					try {
						if(playerInventoryStage.isShowing())
							playerInventoryStage.close();
						if(playerMapStage.isShowing())
							playerMapStage.close();
						if(helpStage.isShowing())
							helpStage.close();
						if(commandListStage.isShowing())
							commandListStage.close();
						
						start(primaryStage);
					} catch (Exception f) {
						f.printStackTrace();
					}
				}
				// if the user moves, then update the GridPane
				// if the user moves into a monster room, play short monster video
				else {
					if (player.doMoveCommand(userInputCommand, userInputTextField, player, map, itemArrayList, puzzleArrayList, emojiImageView_2, generalCommandList, primaryStage, locationImageView, invalidStage)) {
						gameBox.getChildren().clear();
						Boolean validMonster = false;
						for (int monsterIndex = 0; monsterIndex < monsterArrayList.size(); monsterIndex++) {
							if (monsterArrayList.get(monsterIndex).getMonsterLocation().equals(player.getPlayerLocation()) && monsterArrayList.get(monsterIndex).getMonsterIsDefeated().equals(false)) {
								validMonster = true;
								checkForMonster(primaryStage, monsterIndex);
							}	
						}
						// 
						if (validMonster == false) {
							showStartGameScene(primaryStage);
						}
					}
				}
				userInputTextField.clear();
			}
		});
		
		int monsterTotalScore = 0;
		for (int monsterIndex = 0; monsterIndex < monsterArrayList.size(); monsterIndex++) {
			if (monsterArrayList.get(monsterIndex).getMonsterIsDefeated().equals(true)) {
				monsterTotalScore += 200;
			}
		}
		
		// Setting Score
		int puzzleTotalScore = 0;
		for (int puzzleIndex = 0; puzzleIndex < puzzleArrayList.size(); puzzleIndex++) {
			if (puzzleArrayList.get(puzzleIndex).getPuzzleIsSolved().equals(true)) {
				puzzleTotalScore += puzzleArrayList.get(puzzleIndex).getPuzzleScore();
			}
		}
		
		player.setPlayerScore((player.getPlayerEquipment().size()*100) + (player.getPlayerInventory().size()*100) + puzzleTotalScore + monsterTotalScore);
		Label score = new Label("Score: " + player.getPlayerScore());
		score.setStyle("-fx-font-size: 13px;" +
				       "-fx-font-weight: bold");
		
		// Add to GridPane
		gameBox.add(logoImageView, 0, 0);
		gameBox.add(displayAnimatedMessage(map.roomArrayList.get(indexLocation).getRoomDescription()), 0,1);
		gameBox.add(roomTable, 0, 2);
		gameBox.add(userInputTextField, 0,3);
		gameBox.add(score, 0, 4);
		
		// Need to center each node(element) one by one
		GridPane.setHalignment(logoImageView, HPos.CENTER);
		GridPane.setHalignment(roomTable, HPos.CENTER);
		GridPane.setHalignment(userInputTextField, HPos.CENTER);
		GridPane.setHalignment(score, HPos.CENTER);
		
		gameScene = new Scene(gameBox, screenBounds.getWidth()/2, screenBounds.getHeight());
		primaryStage.setScene(gameScene);
		primaryStage.setTitle("Game Running!");
	}
	
	// This function checks is there is an item or puzzle 
	// in the current player's location
	public void checkForSomething(Stage primaryStage, GridPane gameBox, TextField userInputTextField) {
		Boolean puzzleFound = false;
		Boolean monsterFound = false;
		Boolean somethingFound = false;
		
		for (int monsterIndex = 0; monsterIndex < monsterArrayList.size(); monsterIndex++) {
			if (monsterArrayList.get(monsterIndex).getMonsterLocation().equals(player.getPlayerLocation()) && monsterArrayList.get(monsterIndex).getMonsterIsDefeated().equals(false)) {
				somethingFound = true;
				monsterFound = true;
				
				gameBox.getChildren().clear();
				displayMonsterFoundScene(primaryStage, gameBox, monsterIndex, userInputTextField);
			}
		}
		
		
		// If a puzzle is found
		// It means an item is found too! (reward)
		for (int puzzleIndex = 0; puzzleIndex < puzzleArrayList.size(); puzzleIndex++) {
			if (puzzleArrayList.get(puzzleIndex).getPuzzleLocation().equals(player.getPlayerLocation()) && puzzleArrayList.get(puzzleIndex).getPuzzleIsLocked().equals(false)) {
				puzzleFound = true;
				somethingFound = true;
				
				for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
					if (itemArrayList.get(itemIndex).getItemLocation().equals(player.getPlayerLocation())) {			
						if (puzzleArrayList.get(puzzleIndex).getPuzzleAttempts() > 0) {
							
							gameBox.getChildren().clear();
							displayPuzzleFoundScene(primaryStage, gameBox, puzzleIndex, itemIndex, userInputTextField);
						}
						else {
							somethingFound = false;
						}
					}
				}
			}
		}
		
		// If puzzle is not found
		// It does not mean an item is not
		if (puzzleFound == false && monsterFound == false) {
			for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
				if (itemArrayList.get(itemIndex).getItemLocation().equals(player.getPlayerLocation()) && (itemArrayList.get(itemIndex).getItemIsPickedUp().equals(false) && itemArrayList.get(itemIndex).getItemIsLocked().equals(false))) {
					
					gameBox.getChildren().clear();
					displayItemFoundScene(primaryStage, gameBox, itemIndex, userInputTextField, "You found an item!");
					somethingFound = true;
					}
				}
		}
		
		// If nothing is found
		if (somethingFound == false) {
			if (invalidStage.isShowing()) {
				invalidStage.close();
				player.displayInvalidCommandMessage("nothing here", emojiImageView_2, primaryStage, invalidStage);
			}
			else {
				player.displayInvalidCommandMessage("nothing here", emojiImageView_2, primaryStage, invalidStage);
			}
		}
	}
	
	// 
	public void displayMonsterFoundScene(Stage primaryStage, GridPane gameBox, int monsterIndex, TextField userInputTextField) {
		Text youFoundMonster= new Text(monsterArrayList.get(monsterIndex).getMonsterName() + " is ready to fight!");
		youFoundMonster.setStyle("-fx-font-size: 18px;" +
				  				 "-fx-font-weight: bold");
		
		Text monsterFound = new Text("What will you do?");
		monsterFound.setStyle("-fx-font-size: 18px;" +
 				 "-fx-font-weight: bold");
		
		if (!gameBox.getChildren().contains(logoImageView)) {
			gameBox.add(logoImageView, 0, 0);
		}
		if (!gameBox.getChildren().contains(youFoundMonster)) {
			gameBox.add(youFoundMonster, 0, 1);
		}
		if (!gameBox.getChildren().contains(monsterFound)) {
			gameBox.add(monsterFound, 0, 2);
		}
		if (!gameBox.getChildren().contains(userInputTextField)) {
			gameBox.add(userInputTextField, 0, 4);
		}

		try {
			ImageView gif = new ImageView(new Image(new FileInputStream(monsterPathGif.get(monsterIndex))));
			gif.setFitWidth(250);
			gif.setFitHeight(150);
			gameBox.add(gif, 0, 3);
			GridPane.setHalignment(gif, HPos.CENTER);
			
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		
		GridPane.setHalignment(logoImageView, HPos.CENTER);
		GridPane.setHalignment(youFoundMonster, HPos.CENTER);
		GridPane.setHalignment(monsterFound, HPos.CENTER);
		GridPane.setHalignment(userInputTextField, HPos.CENTER);
		
		primaryStage.setTitle("Monster Encountered");
		
		userInputTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				userInputCommand = userInputTextField.getText().toLowerCase();
								
				if (userInputCommand.equals("ignore") || userInputCommand.equals("ignore monster") || userInputCommand.equals("ignore " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase()) ||
						userInputCommand.equals("run") || userInputCommand.equals("run away") || userInputCommand.equals("flee") || userInputCommand.equals("escape")) {
					showStartGameScene(primaryStage);
				}
				else if (userInputCommand.equals("examine") || userInputCommand.equals("examine monster") || userInputCommand.equals("examine " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase())) {
					monsterExamineCommand(primaryStage, monsterStage, emojiImageView_3, monsterIndex);
				}
				else if (userInputCommand.equals("fight") || userInputCommand.equals("fight monster") || userInputCommand.equals("fight " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase()) || 
						 userInputCommand.equals("attack") || userInputCommand.equals("attack monster") || userInputCommand.equals("attack " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase()) || 
						 userInputCommand.equals("hit") || userInputCommand.equals("hit monster") || userInputCommand.equals("hit " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase())) {
					gameBox.getChildren().clear();
					displayMonsterFightScene(primaryStage, gameBox, monsterIndex, userInputTextField);
				}
				else if (userInputCommand.equals("help")) {
					if (!monsterHelpStage.isShowing())
						player.helpCommand(monsterHelpStage, monsterHelpImageView, screenBounds, "Monster Help");
				}
				else if (userInputCommand.equals("commands") || userInputCommand.equals("command list")) {
					if (!commandListStage.isShowing())
						player.helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
				}
				else if (userInputTextField.getText().equals("check inventory") || userInputTextField.getText().equals("look inventory") || userInputTextField.getText().equals("inventory") || userInputTextField.getText().equals("i")) {
					if (player.getPlayerInventory().size() < 1 && player.getPlayerEquipment().size() < 1) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
					}
					if (!playerInventoryStage.isShowing()) 
						player.playerChecksInventory(player, itemArrayList, emojiImageView_2, emojiImageView_3, generalCommandList, map.roomArrayList, playerInventoryStage, primaryStage, 
								tableView1, screenBounds, commandListStage, inventoryHelpStage, commandListImageView, inventoryHelpImageView, invalidStage, inventoryTextField);
				}
				else if (player.validateCommand(userInputCommand, generalCommandList).equals(false)) {
					if (userInputCommand.equals("move")) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
					}
					else {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
					}
				}
				else {
					if (invalidStage.isShowing()) {
						invalidStage.close();
						player.displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
					else {
						player.displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
				}
				userInputTextField.clear();
			}
		});
	}
	
	//
	public void displayMonsterFightScene(Stage primaryStage, GridPane gameBox, int monsterIndex, TextField userInputTextField) {
		Text fight = new Text("Fighting Monster...");
		fight.setStyle("-fx-font-size: 20px;" +
					   "-fx-font-weight: bold");
		
		GridPane fightPane = new GridPane();
		fightPane.setVgap(10);
		fightPane.setHgap(50);
		fightPane.setAlignment(Pos.CENTER);
		
		fightPane.setStyle("-fx-padding: 10;" + 
        				   "-fx-border-style: solid inside;" + 
        				   "-fx-border-width: 2;" +
        				   "-fx-border-insets: 5;" + 
        				   "-fx-border-radius: 5;" + 
						   "-fx-border-color: black;");		
		
		Label monster = new Label(monsterArrayList.get(monsterIndex).getMonsterName());
		Label playerL = new Label(player.getPlayerUsername());
		Label vs = new Label("VS.");
		
		Text m1 = new Text("Monster's Health: " + monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() + "/" + monsterArrayList.get(monsterIndex).getMonsterTotalHealth());
		Text m2 = new Text("Monster's Attack: " + monsterArrayList.get(monsterIndex).getMonsterMinAttack() + "-" + monsterArrayList.get(monsterIndex).getMonsterMaxAttack());
		Text m3 = new Text("Monster's Defense: " + monsterArrayList.get(monsterIndex).getMonsterDefense());
		
		
		Text p1 = new Text("Your health: " + player.getPlayerCurrentHealth() + "/" + player.getPlayerTotalHealth());
		Text p2 = new Text("Your attack: " + player.getPlayerMinAttack() + "-" + player.getPlayerMaxAttack());
		Text p3 = new Text("Your defense: " + player.getPlayerDefense());
		
		
		monster.setStyle("-fx-font-size: 18px;" +
				"-fx-font-weight: bold");
		playerL.setStyle("-fx-font-size: 18px;" +
				"-fx-font-weight: bold");
		vs.setStyle("-fx-font-size: 18px;" +
				"-fx-font-weight: bold");
		
		m1.setStyle("-fx-font-size: 15px;");
		m2.setStyle("-fx-font-size: 15px;");
		m3.setStyle("-fx-font-size: 15px;");
		
		p1.setStyle("-fx-font-size: 15px;");
		p2.setStyle("-fx-font-size: 15px;");
		p3.setStyle("-fx-font-size: 15px;");
		
		GridPane.setHalignment(m1, HPos.CENTER);
		GridPane.setHalignment(m2, HPos.CENTER);
		GridPane.setHalignment(m3, HPos.CENTER);
		
		GridPane.setHalignment(p1, HPos.CENTER);
		GridPane.setHalignment(p2, HPos.CENTER);
		GridPane.setHalignment(p3, HPos.CENTER);
		
		fightPane.add(monster, 0, 0);
		fightPane.add(vs, 1, 0);
		fightPane.add(playerL, 2, 0);
		
		fightPane.add(m1, 0, 1);
		fightPane.add(m2, 0, 2);
		fightPane.add(m3, 0, 3);
		
		fightPane.add(p1, 2, 1);
		fightPane.add(p2, 2, 2);
		fightPane.add(p3, 2, 3);
		
		gameBox.add(logoImageView, 0, 0);
		gameBox.add(fight, 0, 1);
		gameBox.add(fightingImageView, 0, 2);
		gameBox.add(fightPane, 0, 3);
		gameBox.add(userInputTextField, 0, 4);
		
		GridPane.setHalignment(logoImageView, HPos.CENTER);
		GridPane.setHalignment(fightingImageView, HPos.CENTER);
		GridPane.setHalignment(fight, HPos.CENTER);
		GridPane.setHalignment(monster, HPos.CENTER);
		GridPane.setHalignment(playerL, HPos.CENTER);
		GridPane.setHalignment(vs, HPos.CENTER);
		GridPane.setHalignment(userInputTextField, HPos.CENTER);
		
		primaryStage.setTitle("Fighting Monster");
		
		userInputTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				
				int playerDamage = 0;
				int monsterDamage = 0;
				Boolean monsterAlive = true;
				
				userInputCommand = userInputTextField.getText().toLowerCase();
				
				if (userInputCommand.equals("ignore") || userInputCommand.equals("ignore monster") || userInputCommand.equals("ignore " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase()) ||
						userInputCommand.equals("run") || userInputCommand.equals("run away") || userInputCommand.equals("flee") || userInputCommand.equals("escape")) {
					showStartGameScene(primaryStage);
				}
				else if (userInputCommand.equals("fight") || userInputCommand.equals("fight monster") || userInputCommand.equals("fight " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase()) || 
						 userInputCommand.equals("attack") || userInputCommand.equals("attack monster") || userInputCommand.equals("attack " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase()) || 
						 userInputCommand.equals("hit") || userInputCommand.equals("hit monster") || userInputCommand.equals("hit " + monsterArrayList.get(monsterIndex).getMonsterName().toLowerCase())) {

					// NewMonsterHealth = CurrentMonsterHealth - (playerDamage - monsterDefense)
					playerDamage = (int)((Math.random()*(player.getPlayerMaxAttack()-player.getPlayerMinAttack()+1)+player.getPlayerMinAttack()) - monsterArrayList.get(monsterIndex).getMonsterDefense());
					if (playerDamage <= 0)
						playerDamage = 0;
					monsterArrayList.get(monsterIndex).setMonsterCurrentHealth(monsterArrayList.get(monsterIndex).getMonsterCurrentHealth()-playerDamage);
					
					// Monster is Defeated
					if (monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() <= 0) {
						monsterArrayList.get(monsterIndex).setMonsterCurrentHealth(0);
						monsterArrayList.get(monsterIndex).setMonsterIsDefeated(true);
						displayMonsterAttacked(primaryStage, monsterIndex, emojiImageView_3, playerDamage, monsterDamage, monsterArrayList.get(monsterIndex).getMonsterIsDefeated(), player.getPlayerCurrentHealth(), soundEffect_2);
						monsterAlive = false;
						//showStartGameScene(primaryStage);
					}
					
					m1.setText("Monster's Health: " + monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() + "/" + monsterArrayList.get(monsterIndex).getMonsterTotalHealth());
					
					if (monsterAlive.equals(true)) {
						// NewPlayerHealth = CurrentPlayerHealth - (monsterDamage - playerDefense)
						monsterDamage = (int)((Math.random()*(monsterArrayList.get(monsterIndex).getMonsterMaxAttack()-monsterArrayList.get(monsterIndex).getMonsterMinAttack()+1)+monsterArrayList.get(monsterIndex).getMonsterMinAttack()) - player.getPlayerDefense());
						if (monsterDamage <= 0)
							monsterDamage = 0;
						player.setPlayerCurrentHealth(player.getPlayerCurrentHealth()-monsterDamage);
					
						// Player is defeated
						if (player.getPlayerCurrentHealth() <= 0) {
							player.setPlayerCurrentHealth(0);
							displayMonsterAttacked(primaryStage, monsterIndex, emojiImageView_2, playerDamage, monsterDamage, monsterArrayList.get(monsterIndex).getMonsterIsDefeated(), player.getPlayerCurrentHealth(), soundEffect_3);
						}
					
						p1.setText("Your health: " + player.getPlayerCurrentHealth() + "/" + player.getPlayerTotalHealth());
						p2.setText("Your attack: " + player.getPlayerMinAttack() + "-" + player.getPlayerMaxAttack());
						p3.setText("Your defense: " + player.getPlayerDefense());
					}
					
					if (monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() > 0 && player.getPlayerCurrentHealth() > 0) {
						displayMonsterAttacked(primaryStage, monsterIndex, emojiImageView_3, playerDamage, monsterDamage, monsterArrayList.get(monsterIndex).getMonsterIsDefeated(), player.getPlayerCurrentHealth(), soundEffect_1);
					}
				}
				else if (userInputCommand.equals("update") || userInputCommand.equals("refresh") || userInputCommand.equals("stats")) {
					p1.setText("Your health: " + player.getPlayerCurrentHealth() + "/" + player.getPlayerTotalHealth());
					p2.setText("Your attack: " + player.getPlayerMinAttack() + "-" + player.getPlayerMaxAttack());
					p3.setText("Your defense: " + player.getPlayerDefense());
				}
				else if (userInputCommand.equals("help")) {
					if (!puzzleHelpStage.isShowing())
						player.helpCommand(puzzleHelpStage, puzzleHelpImageView, screenBounds, "Puzzle Help");
				}
				else if (userInputCommand.equals("commands") || userInputCommand.equals("command list")) {
					if (!commandListStage.isShowing())
						player.helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
				}
				else if (userInputTextField.getText().equals("check inventory") || userInputTextField.getText().equals("look inventory") || userInputTextField.getText().equals("inventory") || userInputTextField.getText().equals("i")) {
					if (player.getPlayerInventory().size() < 1 && player.getPlayerEquipment().size() < 1) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
					}
					if (!playerInventoryStage.isShowing()) 
						player.playerChecksInventory(player, itemArrayList, emojiImageView_2, emojiImageView_3, generalCommandList, map.roomArrayList, playerInventoryStage, primaryStage, 
								tableView1, screenBounds, commandListStage, inventoryHelpStage, commandListImageView, inventoryHelpImageView, invalidStage, inventoryTextField);
				}
				else if (player.validateCommand(userInputCommand, generalCommandList).equals(false)) {
					if (userInputCommand.equals("move")) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
					}
					else {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
					}
				}
				else {
					if (invalidStage.isShowing()) {
						invalidStage.close();
						player.displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
					else {
						player.displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
				}
				
				
				userInputTextField.clear();
			}
		});
	}
	
	//
	public void displayMonsterAttacked(Stage primaryStage, int monsterIndex, ImageView emoji, int playerDamage, int monsterDamage, Boolean monsterIsDefeated, int playerHealth, AudioClip sound) {
		Text m = new Text("You dealt " + playerDamage + " damage to " + monsterArrayList.get(monsterIndex).getMonsterName() + "!");
		m.setStyle("-fx-font-size: 15px;" +
				   "-fx-font-weight: bold");
		
		VBox attackBox = new VBox(10);
		attackBox.setAlignment(Pos.CENTER);
		
		attackBox.getChildren().add(m);
		
		if (!monsterIsDefeated) {
			Text p = new Text(monsterArrayList.get(monsterIndex).getMonsterName() + " dealt you " + monsterDamage + " damage!");
			p.setStyle("-fx-font-size: 15px;" +
					   "-fx-font-weight: bold");
			
			attackBox.getChildren().add(p);
		}
		else {
			Text d = new Text(monsterArrayList.get(monsterIndex).getMonsterName() + " has been defeated!");
			d.setStyle("-fx-font-size: 15px;" +
					   "-fx-font-weight: bold");
			
			attackBox.getChildren().add(d);
			
			sound.play();
		}
		
		Button okButton = new Button("OK");
		
		attackBox.getChildren().add(emoji);
		attackBox.getChildren().add(okButton);
		
		Scene attackScene = new Scene(attackBox, 300, 150);
		Stage attackStage = new Stage();
		
		attackStage.setX(primaryStage.getX() + (primaryStage.getWidth() - attackScene.getWidth())/2);
		attackStage.setY(primaryStage.getY() + (primaryStage.getHeight() - attackScene.getHeight())/2);
		
		attackStage.setScene(attackScene);
		attackStage.show();
		attackStage.setTitle("Monster attacked");

		attackStage.setOnCloseRequest(e -> {
			if (playerHealth <=0) {
				displayDeathMessage(primaryStage, sound, emoji);
			}
			else if (monsterArrayList.get(7).getMonsterIsDefeated().equals(true)) {
				displayWinMessage1(primaryStage, emoji, wakingUpImageView);
			}
			else if (monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() <= 0){
				showStartGameScene(primaryStage);
			}
		});
		
		// If ok button pressed
		okButton.setOnAction(f -> {
			sound.stop();
			attackStage.close();
			
			if (playerHealth <= 0) {
				displayDeathMessage(primaryStage, sound, emoji);
			}
			else if (monsterArrayList.get(7).getMonsterIsDefeated().equals(true)) {
				displayWinMessage1(primaryStage, emoji, wakingUpImageView);
			}
			else if (monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() <= 0){
				showStartGameScene(primaryStage);
			}
		});
	}
	
	
	// 
	public void displayWinMessage1(Stage primaryStage, ImageView emoji, ImageView gif) {
		VBox box = new VBox(10);
		box.setAlignment(Pos.CENTER);
		
		Text a = new Text("You did it!");
		Text b = new Text("You have defeated the Final Boss");
		Text c = new Text("and woke up of this nightmare!");
		
		a.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		b.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		c.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		
		Button okButton = new Button("OK");
		
		soundEffect_5.play();
		
		box.getChildren().add(a);
		box.getChildren().add(b);
		box.getChildren().add(c);
		box.getChildren().add(gif);
		box.getChildren().add(okButton);
		
		Scene winScene = new Scene(box, 350, 380);
		Stage winStage = new Stage();
		
		winStage.setX(primaryStage.getX() + (primaryStage.getWidth() - winScene.getWidth())/2);
		winStage.setY(primaryStage.getY() + (primaryStage.getHeight() - winScene.getHeight())/2);
		
		winStage.setScene(winScene);
		winStage.show();
		winStage.setTitle("You won");

		winStage.setOnCloseRequest(e -> {
			soundEffect_5.stop();
			displayWinMessage2(primaryStage, emoji);
		});
		
		// If ok button pressed
		okButton.setOnAction(f -> {
			soundEffect_5.stop();
			winStage.close();
			displayWinMessage2(primaryStage, emoji);
		});
	}
	
	// 
	public void displayWinMessage2(Stage primaryStage, ImageView emoji) {
		VBox box = new VBox(10);
		box.setAlignment(Pos.CENTER);
		
		player.setPlayerScore(player.getPlayerScore() + 1000);
		
		Text a = new Text("Your final score is: " + player.getPlayerScore());
		Text b = new Text("Going back to start menu");
		
		a.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		b.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		
		Button okButton = new Button("OK");
		
		box.getChildren().add(a);
		box.getChildren().add(b);
		box.getChildren().add(okButton);
		
		Scene winScene = new Scene(box, 300, 150);
		Stage winStage = new Stage();
		
		winStage.setX(primaryStage.getX() + (primaryStage.getWidth() - winScene.getWidth())/2);
		winStage.setY(primaryStage.getY() + (primaryStage.getHeight() - winScene.getHeight())/2);
		
		winStage.setScene(winScene);
		winStage.show();
		winStage.setTitle("You won");
		
		winStage.setOnCloseRequest(e -> {
			try {
				start(primaryStage);
			}
			catch (Exception g) {
				;
			}
		});
		
		// If ok button pressed
		okButton.setOnAction(f -> {
			winStage.close();
			
			try {
				start(primaryStage);
			}
			catch (Exception g) {
				;
			}
		});
	}
	
	// 
	public void displayDeathMessage(Stage primaryStage, AudioClip sound, ImageView emoji) {
		VBox b = new VBox(10);
		b.setAlignment(Pos.CENTER);
		
		Text d = new Text("You died!");
		Text s = new Text("Your final score is: " + player.getPlayerScore());
		Text m = new Text("Going back to start manu");
		
		d.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		s.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		m.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		
		
		Button okButton = new Button("OK");
		
		sound.play();
		
		b.getChildren().add(d);
		b.getChildren().add(s);
		b.getChildren().add(m);
		b.getChildren().add(emoji);
		b.getChildren().add(okButton);
		
		Scene deathScene = new Scene(b, 350, 150);
		Stage deathStage = new Stage();
		
		deathStage.setX(primaryStage.getX() + (primaryStage.getWidth() - deathScene.getWidth())/2);
		deathStage.setY(primaryStage.getY() + (primaryStage.getHeight() - deathScene.getHeight())/2);
		
		deathStage.setScene(deathScene);
		deathStage.show();
		deathStage.setTitle("You died");
		
		deathStage.setOnCloseRequest(e -> {
			try {
				start(primaryStage);
			}
			catch (Exception g) {
				;
			}
		});
		
		// If ok button pressed
		okButton.setOnAction(f -> {
			sound.stop();
			deathStage.close();
			
			try {
				start(primaryStage);
			}
			catch (Exception g) {
				;
			}
		});
	}
	
	// 
	public void monsterExamineCommand(Stage primaryStage, Stage monsterStage, ImageView emoji, int monsterIndex) {
		Label l = new Label("Monster Description: " + monsterArrayList.get(monsterIndex).getMonsterName());
		l.setStyle("-fx-font-size: 18px;" +
				   "-fx-font-weight: bold");
		
		Text commandMessage = new Text(monsterArrayList.get(monsterIndex).getMonsterDescription1() + "\n" + monsterArrayList.get(monsterIndex).getMonsterDescription2() + "\n" + monsterArrayList.get(monsterIndex).getMonsterDescription3() + "\n\n" +
				"Monster's Health: " + monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() + "/" + monsterArrayList.get(monsterIndex).getMonsterTotalHealth() + "\nMonster's Attack: " + monsterArrayList.get(monsterIndex).getMonsterMinAttack() + 
				"-" + monsterArrayList.get(monsterIndex).getMonsterMaxAttack() + "\nMonster's Defense: " + monsterArrayList.get(monsterIndex).getMonsterDefense());
		commandMessage.setTextAlignment(TextAlignment.CENTER);
		
		VBox commandBox = new VBox(10);
		commandBox.setAlignment(Pos.CENTER);
			
		Button okButton = new Button("OK");
		
		Scene itemCommandScene = new Scene(commandBox, 500, 250);
		monsterStage.setTitle("Monster Description");
		
		commandBox.getChildren().add(l);
		commandBox.getChildren().add(commandMessage);
		commandBox.getChildren().add(emoji);
		commandBox.getChildren().add(okButton);
		
		itemStage.setResizable(false);
		
		itemStage.setX(primaryStage.getX() + (primaryStage.getWidth() - itemCommandScene.getWidth())/2);
		itemStage.setY(primaryStage.getY() + (primaryStage.getHeight() - itemCommandScene.getHeight())/2);
		
		itemStage.setScene(itemCommandScene);
		itemStage.show();
		
		okButton.setOnAction(f -> {
			itemStage.close();
		});
	}
	
	// This function automatically displays when 
	// the player enters a monster's room!	
	public void checkForMonster(Stage primaryStage, int monsterIndex) {
		String index = monsterArrayList.get(monsterIndex).getMonsterID();	
		int indexLocation = Integer.parseInt(index.substring(1))-1;
	
		Media media = new Media(new File(monsterPathVideo.get(indexLocation)).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		// This binds the video with the size of the window
		DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
		
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
	    mediaView.setPreserveRatio(false);
        
        // Play as soon as the player enters the room
		mediaView.setVisible(true);
		mediaPlayer.setAutoPlay(true);
		
		// When the media ends, go back to the text
		mediaPlayer.setOnEndOfMedia(() -> {
			mediaView.setVisible(false); 
			showStartGameScene(primaryStage);
		});    
		
		Group group = new Group();
		
		group.getChildren().add(mediaView);
		monsterVideoScene = new Scene(group, screenBounds.getWidth()/2, screenBounds.getHeight());
		primaryStage.setTitle("Video");
		primaryStage.setScene(monsterVideoScene);
	}
	
	// This function asks the player what he/she would like to do with the item
	public void displayItemFoundScene(Stage primaryStage, GridPane gameBox, int itemIndex, TextField userInputTextField, String message) {
		Text youFoundItem = new Text(message);
		youFoundItem.setStyle("-fx-font-size: 18px;" +
							  "-fx-font-weight: bold");
		
		Text itemFound = new Text("What would you like to do with this " + itemArrayList.get(itemIndex).getItemName() + "?");
		
		if (!gameBox.getChildren().contains(logoImageView)) {
			gameBox.add(logoImageView, 0, 0);
		}
		if (!gameBox.getChildren().contains(youFoundItem)) {
			gameBox.add(youFoundItem, 0, 1);
		}
		if (!gameBox.getChildren().contains(itemFound)) {
			gameBox.add(itemFound, 0, 2);
		}
		if (!gameBox.getChildren().contains(userInputTextField)) {
			gameBox.add(userInputTextField, 0, 3);
		}
		
		GridPane.setHalignment(logoImageView, HPos.CENTER);
		GridPane.setHalignment(youFoundItem, HPos.CENTER);
		GridPane.setHalignment(itemFound, HPos.CENTER);
		GridPane.setHalignment(userInputTextField, HPos.CENTER);
		
		primaryStage.setTitle("Item Found");
		
		userInputTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				userInputCommand = userInputTextField.getText().toLowerCase();
				
				if (userInputCommand.equals("ignore") || userInputCommand.equals("ignore item") || userInputCommand.equals("ignore " + itemArrayList.get(itemIndex).getItemName().toLowerCase())) {
					showStartGameScene(primaryStage);
				}
				else if (userInputCommand.equals("pick up") || userInputCommand.equals("pick up item") || userInputCommand.equals("pick up " + itemArrayList.get(itemIndex).getItemName().toLowerCase()) || 
						 userInputCommand.equals("store") || userInputCommand.equals("store item") || userInputCommand.equals("store " + itemArrayList.get(itemIndex).getItemName().toLowerCase())) {
					itemArrayList.get(itemIndex).setItemIsPickedUp(true);
					
					player.getPlayerInventory().add(itemArrayList.get(itemIndex));
					
					// Updates inventory table if open
					if (playerInventoryStage.isShowing()) {
						tableView1.setItems(player.getItems(player));
					}
					
					// Updates item images in map
					if (playerMapStage.isShowing()) {
						double x = playerMapStage.getX();
						double y = playerMapStage.getY();
						
						playerMapStage.close();
						player.displayMap(player, playerMapStage, mapImageView, locationImageView, puzzleImage, itemImage, monsterImage, puzzleArrayList, itemArrayList, monsterArrayList);
						
						playerMapStage.setX(x);
						playerMapStage.setY(y);
					}
					if (itemStage.isShowing()) {
						itemStage.close();
						itemCommandAction(primaryStage, itemArrayList.get(itemIndex).getItemName() + " is now in your inventory!", emojiImageView_3, true, itemStage, itemArrayList.get(itemIndex).getItemName());					
					}
					else {
						itemCommandAction(primaryStage, itemArrayList.get(itemIndex).getItemName() + " is now in your inventory!", emojiImageView_3, true, itemStage, itemArrayList.get(itemIndex).getItemName());					
					}
				}
				else if (userInputCommand.equals("examine") || userInputCommand.equals("examine item") || userInputCommand.equals("examine " + itemArrayList.get(itemIndex).getItemName().toLowerCase())) {
					if (itemStage.isShowing()) {
						itemStage.close();
						itemCommandAction(primaryStage, itemArrayList.get(itemIndex).getItemDescription() + "\n\nBonus Health: " + itemArrayList.get(itemIndex).getItemHealthAmount() + "\nBonus Attack: " + itemArrayList.get(itemIndex).getItemAttackAmount() + "\nBonus Defense: " + itemArrayList.get(itemIndex).getItemDefenseAmount(), emojiImageView_4, false, itemStage, itemArrayList.get(itemIndex).getItemName());
					}
					else {
						itemCommandAction(primaryStage, itemArrayList.get(itemIndex).getItemDescription() + "\n\nBonus Health: " + itemArrayList.get(itemIndex).getItemHealthAmount() + "\nBonus Attack: " + itemArrayList.get(itemIndex).getItemAttackAmount() + "\nBonus Defense: " + itemArrayList.get(itemIndex).getItemDefenseAmount(), emojiImageView_4, false, itemStage, itemArrayList.get(itemIndex).getItemName());
					}
				}
				else if (userInputCommand.equals("help")) {
					if (!itemHelpStage.isShowing())
						player.helpCommand(itemHelpStage, itemHelpImageView, screenBounds, "Item Help");
				}
				else if (userInputCommand.equals("commands") || userInputCommand.equals("command list")) {
					if (!commandListStage.isShowing())
						player.helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
				}
				else if (userInputTextField.getText().equals("check inventory") || userInputTextField.getText().equals("look inventory") || userInputTextField.getText().equals("inventory") || userInputTextField.getText().equals("i")) {
					if (player.getPlayerInventory().size() < 1 && player.getPlayerEquipment().size() < 1) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("empty inventory", emojiImageView_2, primaryStage, invalidStage);
						}
					}
					if (!playerInventoryStage.isShowing()) 
						player.playerChecksInventory(player, itemArrayList, emojiImageView_2, emojiImageView_3, generalCommandList, map.roomArrayList, playerInventoryStage, primaryStage, 
								tableView1, screenBounds, commandListStage, inventoryHelpStage, commandListImageView, inventoryHelpImageView, invalidStage, inventoryTextField);
				}
				// This function validates the command, if false, display invalid command message
				else if (player.validateCommand(userInputCommand, generalCommandList).equals(false)) {
					if (userInputCommand.equals("move")) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
					}
					else {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
					}
				}
				else {
					if (invalidStage.isShowing()) {
						invalidStage.close();
						player.displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
					else {
						player.displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
				}
			}
		});
	}
	
	// Item Description or Picked up Message/Stage
	public void itemCommandAction(Stage primaryStage, String message, ImageView emoji, Boolean itemIsPickedUp, Stage itemStage, String item) {
		Text commandMessage = new Text(message);
		commandMessage.setTextAlignment(TextAlignment.CENTER);
		VBox commandBox = new VBox(10);
		commandBox.setAlignment(Pos.CENTER);
			
		Button okButton = new Button("OK");
		
		Scene itemCommandScene = new Scene(commandBox, 300, 150);
		
		if (itemIsPickedUp) {
			itemStage.setTitle("Item Stored");
		}		
		else {
			Label l = new Label("Item Description: " + item);
			l.setStyle("-fx-font-size: 18px;" +
					"-fx-font-weight: bold");
			commandBox.getChildren().add(l);
			itemStage.setTitle("Item Description");
			itemStage.setWidth(400);
			itemStage.setHeight(250);
		}
		
		commandBox.getChildren().add(commandMessage);
		commandBox.getChildren().add(emoji);
		commandBox.getChildren().add(okButton);
		
		itemStage.setResizable(false);
		
		itemStage.setX(primaryStage.getX() + (primaryStage.getWidth() - itemCommandScene.getWidth())/2);
		itemStage.setY(primaryStage.getY() + (primaryStage.getHeight() - itemCommandScene.getHeight())/2);
		
		itemStage.setScene(itemCommandScene);
		itemStage.show();
		
		okButton.setOnAction(f -> {
			itemStage.close();
			if(itemIsPickedUp) {
				showStartGameScene(primaryStage);
			}
		});
	}
	
	// If a puzzle is found, display "Puzzle Found"
	// The player is able to choose solve or ignore puzzle
	public void displayPuzzleFoundScene(Stage primaryStage, GridPane gameBox, int puzzleIndex, int itemIndex, TextField userInputTextField) {
		Text youFoundPuzzle = new Text("You found a puzzle!");
		youFoundPuzzle.setStyle("-fx-font-size: 18px;" +
								"-fx-font-weight: bold");

		gameBox.add(logoImageView, 0, 0);
		gameBox.add(youFoundPuzzle, 0, 1);
		gameBox.add(userInputTextField, 0, 2);
		
		GridPane.setHalignment(logoImageView, HPos.CENTER);
		GridPane.setHalignment(youFoundPuzzle, HPos.CENTER);
		GridPane.setHalignment(userInputTextField, HPos.CENTER);
		
		primaryStage.setTitle("Solving Puzzle");
		
		userInputTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				userInputCommand = userInputTextField.getText();
				userInputCommand = userInputCommand.toLowerCase();
				
				// This function validates the command, if false, display invalid command message
				if (player.validateCommand(userInputCommand, generalCommandList).equals(false)) {
					if (userInputCommand.equals("move")) {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
					}
					else {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage(userInputCommand, emojiImageView_1, primaryStage, invalidStage);
						}
					}
				}
				else {
					if (userInputCommand.equals("ignore puzzle") || userInputCommand.equals("ignore")) {
						showStartGameScene(primaryStage);
					}
					else if (userInputCommand.equals("answer puzzle") || userInputCommand.equals("solve puzzle") || userInputCommand.equals("solve") || userInputCommand.equals("answer")) {
						gameBox.getChildren().clear();
						displaySolvingPuzzleScene(primaryStage, gameBox, puzzleIndex, itemIndex, userInputTextField);
					}
					else if (userInputCommand.equals("help")) {
						if (!puzzleHelpStage.isShowing())
							player.helpCommand(puzzleHelpStage, puzzleHelpImageView, screenBounds, "Puzzle Help");
					}
					else if (userInputCommand.equals("commands") || userInputCommand.equals("command list")) {
						if (!commandListStage.isShowing())
							player.helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
					}
					else {
						if (invalidStage.isShowing()) {
							invalidStage.close();
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
						else {
							player.displayInvalidCommandMessage("scenario command", emojiImageView_1, primaryStage, invalidStage);
						}
					}
				}
				userInputTextField.clear();
			}
		});
		
	}
	
	// If user chooses to solve puzzle, display puzzle text
	// Player can ignore the puzzle still, but can also
	// ask for help, hint or answer correctly the puzzle
	public void displaySolvingPuzzleScene(Stage primaryStage, GridPane gameBox, int puzzleIndex, int itemIndex, TextField userInputTextField) {
		Text youFoundPuzzle = new Text("You found a puzzle!");
		youFoundPuzzle.setStyle("-fx-font-size: 18px;" +
								"-fx-font-weight: bold");
		
		GridPane puzzlePane = new GridPane();
		puzzlePane.setVgap(10);
		puzzlePane.setHgap(50);
		puzzlePane.setAlignment(Pos.CENTER);
		
		// CSS
		puzzlePane.setStyle("-fx-padding: 10;" + 
		            		"-fx-border-style: solid inside;" + 
		               		"-fx-border-width: 2;" +
		             		"-fx-border-insets: 5;" + 
		               		"-fx-border-radius: 5;" + 
							"-fx-border-color: black;");
		
		// Attempts Left Text
		Text attemptsLeft = new Text("Attempts left = " + puzzleArrayList.get(puzzleIndex).getPuzzleAttempts());
		// Add To GridPane
		puzzlePane.add(attemptsLeft, 0, 0);
		// Align
		GridPane.setHalignment(attemptsLeft, HPos.CENTER);
		
		gameBox.add(logoImageView, 0, 0);
		gameBox.add(youFoundPuzzle, 0, 1);
		gameBox.add(displayAnimatedMessage(puzzleArrayList.get(puzzleIndex).getPuzzleText()), 0, 2);
		gameBox.add(puzzlePane, 0, 3);
		gameBox.add(userInputTextField, 0, 4);
		
		GridPane.setHalignment(logoImageView, HPos.CENTER);
		GridPane.setHalignment(youFoundPuzzle, HPos.CENTER);
		GridPane.setHalignment(attemptsLeft, HPos.CENTER);
		GridPane.setHalignment(userInputTextField, HPos.CENTER);
		
		primaryStage.setTitle("Solving Puzzle");
				
		userInputTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				userInputCommand = userInputTextField.getText().toLowerCase();
				
				//if (userInputCommand.equals("ignore puzzle") || userInputCommand.equals("ignore")) {
				//	showStartGameScene(primaryStage);
				//}
				if (userInputCommand.equals("hint")) {
					puzzle.displayPuzzleHint(puzzleArrayList.get(puzzleIndex).getPuzzleHint(), emojiImageView_4, primaryStage);
				}
				else if (userInputCommand.equals("help")) {
					if (!puzzleHelpStage.isShowing())
						player.helpCommand(puzzleHelpStage, puzzleHelpImageView, screenBounds, "Puzzle Help");
				}
				else if (userInputCommand.equals("commands") || userInputCommand.equals("command list")) {
					if (!commandListStage.isShowing())
						player.helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
				}
				// Player sucessfully answers the puzzle
				else if (userInputCommand.equals(puzzleArrayList.get(puzzleIndex).getPuzzleAnswer())) {
					String message = "Correct! You get +" + puzzleArrayList.get(puzzleIndex).getPuzzleScore() + " points!";
					puzzleArrayList.get(puzzleIndex).setPuzzleIsSolved(true);
					displayPuzzleSolved(primaryStage, puzzleIndex, itemIndex, soundEffect_2, message, emojiImageView_3, true, gameBox, userInputTextField);
					displayItemFoundScene(primaryStage, gameBox, itemIndex, userInputTextField, "You've unlocked an item!");	
				}
				else {
					// Player's answer is incorrect
					// Setting both puzzle and item(reward) = true
					// So they will not show up again in the game!
					if (puzzleArrayList.get(puzzleIndex).getPuzzleAttempts() <= 1) {
						
						itemArrayList.get(itemIndex).setItemIsLocked(true);
						
						String message = "Incorrect! The answer was " + puzzleArrayList.get(puzzleIndex).getPuzzleAnswer();
						displayPuzzleSolved(primaryStage, puzzleIndex, itemIndex, soundEffect_3, message, emojiImageView_2, false, gameBox, userInputTextField);
						
					}
					else {
						puzzle.displayPuzzleHint("Incorrect!", emojiImageView_4, primaryStage);
						puzzleArrayList.get(puzzleIndex).setPuzzleAttempts(puzzleArrayList.get(puzzleIndex).getPuzzleAttempts()-1);
						attemptsLeft.setText("Attempts left = " + puzzleArrayList.get(puzzleIndex).getPuzzleAttempts());	
					}
				}
				userInputTextField.clear();
			}
		});
	}
	
	// This function displays based on what the player answered
	// If the player answered correctly, the player is rewarded 
	// with an item, if not, then the player doesn't get the item
	// Either way, the puzzle will not show again in the game
	public void displayPuzzleSolved(Stage primaryStage, int puzzleIndex, int itemIndex, AudioClip soundEffect, String message, ImageView emoji, Boolean successfullySolved, GridPane gameBox, TextField userInputTextField) {
		puzzleArrayList.get(puzzleIndex).setPuzzleIsLocked(true);
		
		soundEffect.play(1.0);
		
		Text puzzleSolved = new Text(message);
		
		VBox puzzleSolvedBox = new VBox(10);
		puzzleSolvedBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button("OK");
		
		puzzleSolvedBox.getChildren().add(puzzleSolved);
		puzzleSolvedBox.getChildren().add(emoji);
		puzzleSolvedBox.getChildren().add(okButton);
		
		Scene puzzleSolvedScene = new Scene(puzzleSolvedBox, 450, 120);
		Stage puzzleSolvedStage = new Stage();
		
		puzzleSolvedStage.setX(primaryStage.getX() + (primaryStage.getWidth() - puzzleSolvedScene.getWidth())/2);
		puzzleSolvedStage.setY(primaryStage.getY() + (primaryStage.getHeight() - puzzleSolvedScene.getHeight())/2);
		
		puzzleSolvedStage.setScene(puzzleSolvedScene);
		puzzleSolvedStage.show();
		puzzleSolvedStage.setTitle("Puzzle Solved");
		
		// 
		if (successfullySolved.equals(true)) {
			gameBox.getChildren().clear();
			displayItemFoundScene(primaryStage, gameBox, itemIndex, userInputTextField, "You've unlocked an item!");
			userInputTextField.clear();
			
			puzzleSolvedStage.setOnCloseRequest(e -> {
				soundEffect.stop();
			});
		}
		else {
			puzzleSolvedStage.setOnCloseRequest(e -> {
				soundEffect.stop();
				showStartGameScene(primaryStage);
			});
		}
		
		// If ok button pressed
		okButton.setOnAction(f -> {
			soundEffect.stop();
			puzzleSolvedStage.close();
			
			if (successfullySolved.equals(false)) {
				showStartGameScene(primaryStage);
			}
		});
	}
			
	// This function displays what room is 
	// in the "x" direction of the player
 	public String displayRoom(int direction, Boolean displayEncounter) {
		// Current player location (String ex."R01")
		// is converted into an integer (minus 1)
		// because IDs start with 1 but indexes start with 0.
		String index = player.getPlayerLocation();
		int indexLocation = Integer.parseInt(index.substring(1))-1;
		// This integer is then used as index to find the room in this direction
		// inside of the room arrayList, if it is equal to "R00" it means there
		// is a wall, so it will return "Nothing"
		if (map.roomArrayList.get(indexLocation).getRoomAround()[direction].equals("R00")) {
			return "Nothing";
		}
		else {
			// Else, this index will be used to get the room ID of the room in this direction
			// but this index is a String too, so we need to convert it to a integer,
			// once we have the index (Int) of the room we want, we display it!
			index = map.roomArrayList.get(indexLocation).getRoomAround()[direction];
			
			if (displayEncounter) {
				return displayEncounterRoom(direction);
			}
			else {
				indexLocation = Integer.parseInt(index.substring(1))-1;
				return map.roomArrayList.get(indexLocation).getRoomName();
			}
		}
	}

	// This function displays what might 
	// be encountered in "x" room in the north direction
	public String displayEncounterRoom(int direction) {
		// Current player location (String ex."R01")
		// is converted into an integer (minus 1)
		// because IDs start with 1 but indexes start with 0.
		String index = player.getPlayerLocation();
		int indexLocation = Integer.parseInt(index.substring(1))-1;
		
		// This integer is then used as index to find the room in this direction
		// inside of the room arrayList, if it is equal to "R00" it means there
		// is a wall, so it will return "Nothing"
		if (map.roomArrayList.get(indexLocation).getRoomAround()[direction].equals("R00")) {
			return "Nothing";
		}		
		else {
			// Else, this index will be used to get the room ID of the room in the "x" direction
			// but this index is a String too, so we need to convert it to a integer,
			// once we have the index (Int) of the room we want, we display it!
			index = map.roomArrayList.get(indexLocation).getRoomAround()[direction];
			indexLocation = Integer.parseInt(index.substring(1))-1;
			
			// We need the ID of the room to compare it with the 
			// location of puzzles, items, and monsters
			index = map.roomArrayList.get(indexLocation).getRoomID();
			
			// In the doc, the "Monster: Pocahontas" 's room also contains an item!
			for (int i = 0; i < monsterArrayList.size(); i++) {
				if (monsterArrayList.get(i).getMonsterLocation().equals(index) && monsterArrayList.get(i).getMonsterIsDefeated().equals(false)) {
					for (int j = 0; j < itemArrayList.size(); j++) {
						if (itemArrayList.get(j).getItemLocation().equals(index) && (itemArrayList.get(j).getItemIsPickedUp().equals(false) && itemArrayList.get(j).getItemIsLocked().equals(false))) {
							return "Monster/Item";
						}
					}
					return "Monster";
				}
			}
			// If a puzzle is found, means there is an item too!
			for (int i = 0; i < puzzleArrayList.size(); i++) {
				if (puzzleArrayList.get(i).getPuzzleLocation().equals(index) && puzzleArrayList.get(i).getPuzzleIsLocked().equals(false)) {
					for (int j = 0; j < itemArrayList.size(); j++) {
						if (itemArrayList.get(j).getItemLocation().equals(index) && (itemArrayList.get(j).getItemIsPickedUp().equals(false) && itemArrayList.get(j).getItemIsLocked().equals(false))) {
							return "Puzzle/Item";
						}
					}
				}
			}
			// However if we find an item, it doesn't mean we found a puzzle
			for (int i = 0; i < itemArrayList.size(); i++) {
				if (itemArrayList.get(i).getItemLocation().equals(index) && (itemArrayList.get(i).getItemIsPickedUp().equals(false) && itemArrayList.get(i).getItemIsLocked().equals(false))) {
					return "Item";
				}
			}
			// If nothing is found in this room, then return nothing.
			return "Nothing";
		}
	}

	// This function displays an animated message!
	public Text displayAnimatedMessage(String message) {
		messageText = new Text();
		messageText.setTextAlignment(TextAlignment.CENTER);
		messageText.setWrappingWidth(500);
		
		// Animation
		integer = new SimpleIntegerProperty(0);
		time = new Timeline();
		
		// Time it takes to display animated message
		// Stops when reaches end of the message
		key = new KeyFrame(
			Duration.seconds(0.002),
			event -> {
				if (integer.get() > message.length()) {
					time.stop();
				}
				else {
					messageText.setText(message.substring(0, integer.get()));
					integer.set(integer.get()+1);
				}
			}
		);
		// 
		
		time.getKeyFrames().add(key);
		time.setCycleCount(Animation.INDEFINITE);
		time.play();
		
		return messageText;
	}
	
	// 
	public void showLoadGameScene(Stage primaryStage) {
		
	}
	
	// 
	public void showScoreBoardScene(Stage primaryStage) {
		
	}
	
	// This function displays instructions/information about the game
	public void showHelpScene(Stage primaryStage) {
		helpPane = new GridPane();
		helpPane.setAlignment(Pos.CENTER);
		helpPane.setVgap(10);
		helpPane.setHgap(10);
		helpPane.setPadding(new Insets(10));
		
		Button okButton = new Button("Ok");
		helpPane.add(helpImageView, 0, 0);
		helpPane.add(okButton, 0, 1);
		
		helpScene = new Scene(helpPane, screenBounds.getWidth()/2, screenBounds.getHeight());
		primaryStage.setScene(helpScene);
		
		GridPane.setHalignment(okButton, HPos.CENTER);
		
		okButton.setOnAction(e -> {
			soundEffect_1.play(1.0);
			primaryStage.setTitle("Disney Dream Worlds!");
			primaryStage.setScene(primaryScene);
		});
	}
		
	// This function creates the file "ItemFile.txt"
	// This function is useful and important in case 
	// any user makes a mistake or accidentally deletes
	// the file "ItemFile.txt". The user must run the program
	// and it will automatically create a new file
	public void createItemFile() {
		try {
			File itemFile = new File("ItemFile.txt");
			
			if(!itemFile.exists()) {
				itemFile.createNewFile();
				
				FileWriter itemFileWriter = new FileWriter("ItemFile.txt");
				
				// Write to file
				for (int i = 0; i < 15; i++) {
					if (i < 9) {
						itemFileWriter.write("A0" + (i+1)  + "~");
					}
					else {
						itemFileWriter.write("A" + (i+1) + "~");
					}
					
					switch(i+1) {
						case 1:
							itemFileWriter.write("Poison Apple~");
							itemFileWriter.write("Looks tasty, but you shouldn't eat that.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("10~");
							itemFileWriter.write("0~");
							itemFileWriter.write("R04~");
							break;
						case 2:
							itemFileWriter.write("Apple~");
							itemFileWriter.write("A red apple.~");
							itemFileWriter.write("Consumable~");
							itemFileWriter.write("20~");
							itemFileWriter.write("0~");
							itemFileWriter.write("0~");
							itemFileWriter.write("R03~");
							break;
						case 3:
							itemFileWriter.write("Glass Slippers~");
							itemFileWriter.write("You would have to be pretty light on your feet to dance in these.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("0~");
							itemFileWriter.write("15~");
							itemFileWriter.write("R08~");
							break;
						case 4:
							itemFileWriter.write("Pumpkin~");
							itemFileWriter.write("The shape of it reminds you of a carriage.~");
							itemFileWriter.write("Consumable~");
							itemFileWriter.write("30~");
							itemFileWriter.write("15~");
							itemFileWriter.write("5~");
							itemFileWriter.write("R07~");
							break;
						case 5:
							itemFileWriter.write("Flying Carpet~");
							itemFileWriter.write("You prefer shag, but this will do.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("15~");
							itemFileWriter.write("0~");
							itemFileWriter.write("R12~");
							break;
						case 6:
							itemFileWriter.write("Magic Lamp~");
							itemFileWriter.write("A golden oil lamp. You expect me to believe someone fits in here!?~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("15~");
							itemFileWriter.write("15~");
							itemFileWriter.write("15~");
							itemFileWriter.write("R11~");
							break;
						case 7:
							itemFileWriter.write("Scissors~");
							itemFileWriter.write("Snip-Snip~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("25~");
							itemFileWriter.write("0~");
							itemFileWriter.write("R15~");
							break;
						case 8:
							itemFileWriter.write("Shower Cap~");
							itemFileWriter.write("Keeps your hair dry.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("20~");
							itemFileWriter.write("5~");
							itemFileWriter.write("R16~");
							break;
						case 9:
							itemFileWriter.write("Fishing Net~");
							itemFileWriter.write("A small net.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("20~");
							itemFileWriter.write("5~");
							itemFileWriter.write("R19~");
							break;
						case 10:
							itemFileWriter.write("Trident~");
							itemFileWriter.write("This thing could do some damage for an over glorified fork.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("10~");
							itemFileWriter.write("20~");
							itemFileWriter.write("10~");
							itemFileWriter.write("R20~");
							break;
						case 11: 
							itemFileWriter.write("Lucky Cricket~");
							itemFileWriter.write("Poor little guy stuck in a cage. He seems content.~");
							itemFileWriter.write("Consumable~");
							itemFileWriter.write("30~");
							itemFileWriter.write("0~");
							itemFileWriter.write("10~");
							itemFileWriter.write("R23~");
							break;
						case 12:
							itemFileWriter.write("Dragon Missile~");
							itemFileWriter.write("Fearsome rocket with ornate dragon head.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("25~");
							itemFileWriter.write("10~");
							itemFileWriter.write("R24~");
							break;
						case 13:
							itemFileWriter.write("Compass~");
							itemFileWriter.write("It just keeps spinning.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("10~");
							itemFileWriter.write("0~");
							itemFileWriter.write("25~");
							itemFileWriter.write("R27~");
							break;
						case 14:
							itemFileWriter.write("Corn~");
							itemFileWriter.write("This could be mistaken for gold.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("25~");
							itemFileWriter.write("5~");
							itemFileWriter.write("0~");
							itemFileWriter.write("R28~");
							break;
						case 15:
							itemFileWriter.write("Wedding Ring~");
							itemFileWriter.write("Precious.~");
							itemFileWriter.write("Equippable~");
							itemFileWriter.write("0~");
							itemFileWriter.write("30~");
							itemFileWriter.write("10~");
							itemFileWriter.write("R29~");
							break;
					}
					itemFileWriter.write("false~");
					itemFileWriter.write("false~");
					itemFileWriter.write("false~\n");
				}
				itemFileWriter.close();
			}
		}
		catch(Exception e) {
			
		}
	}

	// This function reads the file "ItemFile.txt"
	// The user/player is able to change any of the item's attributes
	// however, ID must not be changed ever!
	public void readItemFile() {
		// Each Item has 9 attributes
		// 1. itemID = Unique ID of the item
		// 2. itemName = name of the item
		// 3. itemDescription = description of the item
		// 4. itemType = equippable or consumable?
		// 5. itemHealthAmount = player's health increases based on this and the type of item
		// 6. itemAttackAmount = player's attack increases based on this and the type of item
		// 7. itemDefenseAmount = player's defense increases based on this and the type of item
		// 8. itemLocation = location of the item found in the map
		// 9. itemIsPickedUp = if the item is picked up (true) then it moves with the player around the map/game.
		int attributeCounter = 0;
		BufferedReader reader;
		String line;
		// An arrayList of characters is used to read the file
		// when a '~' is found, it will put together all of the
		// characters found before it and stored in the variable
		// "word". Each "word" will be stored in a temporal arrayList
		// called generalItem arrayList. Once the generalItem
		// arrayList has 9 elements or "words", it will add all of 
		// them into the Item arrayList.
		generalItem = new Item();
		item01 = new Item();
		item02 = new Item();
		item03 = new Item();
		item04 = new Item();
		item05 = new Item();
		item06 = new Item();
		item07 = new Item();
		item08 = new Item();
		item09 = new Item();
		item10 = new Item();
		item11 = new Item();
		item12 = new Item();
		item13 = new Item();
		item14 = new Item();
		item15 = new Item();
		
		itemArrayList = new ArrayList<Item>();
		ArrayList<Character> itemInfo = new ArrayList<Character>();
		String word = "";
		
		try {
			reader = new BufferedReader(new FileReader("ItemFile.txt"));
			line = reader.readLine();
			itemArrayList.clear();
			
			// While there is a line to read
			while (line != null) {
				// this variable is used to keep track of what type of variable
				// we are dealing with when storing it in the arrayList
				attributeCounter = 0;
				for (char c: line.toCharArray()) {
					if (c != '~') {
						itemInfo.add(c);
					}
					else {
						word = itemInfo.toString().substring(1, 3*itemInfo.size()-1).replaceAll(", ", "");
						
						if (attributeCounter == 0) {
							generalItem.setItemID(word);
						}
						else if (attributeCounter == 1) {
							generalItem.setItemName(word);
						}
						else if (attributeCounter == 2) {
							generalItem.setItemDescription(word);
						}
						else if (attributeCounter == 3) {
							generalItem.setItemType(word);
						}
						else if (attributeCounter == 4) {
							generalItem.setItemHealthAmount(Integer.parseInt(word));
						}
						else if (attributeCounter == 5) {
							generalItem.setItemAttackAmount(Integer.parseInt(word));
						}
						else if (attributeCounter == 6) {
							generalItem.setItemDefenseAmount(Integer.parseInt(word));
						}
						else if (attributeCounter == 7) {
							generalItem.setItemLocation(word);
						}
						else if (attributeCounter == 8) {
							generalItem.setItemIsPickedUp(Boolean.parseBoolean(word));
						}
						else if (attributeCounter == 9) {
							generalItem.setItemIsPickedUp(Boolean.parseBoolean(word));
						}
						else {
							generalItem.setItemIsPickedUp(Boolean.parseBoolean(word));
							storeItemAttributes();
						}
						attributeCounter++;
						itemInfo.clear();
					}
				}
				line = reader.readLine();
			}
		}
		catch(Exception e) {
			
		}
	}
	
	// This function stores the items read from file in the item arrayList!
	public void storeItemAttributes() {
		if (generalItem.getItemID().equals("A01")) {
			item01.setItemID(generalItem.getItemID());
			item01.setItemName(generalItem.getItemName());
			item01.setItemDescription(generalItem.getItemDescription());
			item01.setItemType(generalItem.getItemType());
			item01.setItemHealthAmount(generalItem.getItemHealthAmount());
			item01.setItemAttackAmount(generalItem.getItemAttackAmount());
			item01.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item01.setItemLocation(generalItem.getItemLocation());
			item01.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item01.setItemIsEquipped(generalItem.getItemIsEquipped());
			item01.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item01);
		}
		if (generalItem.getItemID().equals("A02")) {
			item02.setItemID(generalItem.getItemID());
			item02.setItemName(generalItem.getItemName());
			item02.setItemDescription(generalItem.getItemDescription());
			item02.setItemType(generalItem.getItemType());
			item02.setItemHealthAmount(generalItem.getItemHealthAmount());
			item02.setItemAttackAmount(generalItem.getItemAttackAmount());
			item02.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item02.setItemLocation(generalItem.getItemLocation());
			item02.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item02.setItemIsEquipped(generalItem.getItemIsEquipped());
			item02.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item02);
		}
		if (generalItem.getItemID().equals("A03")) {
			item03.setItemID(generalItem.getItemID());
			item03.setItemName(generalItem.getItemName());
			item03.setItemDescription(generalItem.getItemDescription());
			item03.setItemType(generalItem.getItemType());
			item03.setItemHealthAmount(generalItem.getItemHealthAmount());
			item03.setItemAttackAmount(generalItem.getItemAttackAmount());
			item03.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item03.setItemLocation(generalItem.getItemLocation());
			item03.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item03.setItemIsEquipped(generalItem.getItemIsEquipped());
			item03.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item03);
		}
		if (generalItem.getItemID().equals("A04")) {
			item04.setItemID(generalItem.getItemID());
			item04.setItemName(generalItem.getItemName());
			item04.setItemDescription(generalItem.getItemDescription());
			item04.setItemType(generalItem.getItemType());
			item04.setItemHealthAmount(generalItem.getItemHealthAmount());
			item04.setItemAttackAmount(generalItem.getItemAttackAmount());
			item04.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item04.setItemLocation(generalItem.getItemLocation());
			item04.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item04.setItemIsEquipped(generalItem.getItemIsEquipped());
			item04.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item04);
		}
		if (generalItem.getItemID().equals("A05")) {
			item05.setItemID(generalItem.getItemID());
			item05.setItemName(generalItem.getItemName());
			item05.setItemDescription(generalItem.getItemDescription());
			item05.setItemType(generalItem.getItemType());
			item05.setItemHealthAmount(generalItem.getItemHealthAmount());
			item05.setItemAttackAmount(generalItem.getItemAttackAmount());
			item05.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item05.setItemLocation(generalItem.getItemLocation());
			item05.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item05.setItemIsEquipped(generalItem.getItemIsEquipped());
			item05.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item05);
		}
		if (generalItem.getItemID().equals("A06")) {
			item06.setItemID(generalItem.getItemID());
			item06.setItemName(generalItem.getItemName());
			item06.setItemDescription(generalItem.getItemDescription());
			item06.setItemType(generalItem.getItemType());
			item06.setItemHealthAmount(generalItem.getItemHealthAmount());
			item06.setItemAttackAmount(generalItem.getItemAttackAmount());
			item06.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item06.setItemLocation(generalItem.getItemLocation());
			item06.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item06.setItemIsEquipped(generalItem.getItemIsEquipped());
			item06.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item06);
		}
		if (generalItem.getItemID().equals("A07")) {
			item07.setItemID(generalItem.getItemID());
			item07.setItemName(generalItem.getItemName());
			item07.setItemDescription(generalItem.getItemDescription());
			item07.setItemType(generalItem.getItemType());
			item07.setItemHealthAmount(generalItem.getItemHealthAmount());
			item07.setItemAttackAmount(generalItem.getItemAttackAmount());
			item07.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item07.setItemLocation(generalItem.getItemLocation());
			item07.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item07.setItemIsEquipped(generalItem.getItemIsEquipped());
			item07.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item07);
		}
		if (generalItem.getItemID().equals("A08")) {
			item08.setItemID(generalItem.getItemID());
			item08.setItemName(generalItem.getItemName());
			item08.setItemDescription(generalItem.getItemDescription());
			item08.setItemType(generalItem.getItemType());
			item08.setItemHealthAmount(generalItem.getItemHealthAmount());
			item08.setItemAttackAmount(generalItem.getItemAttackAmount());
			item08.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item08.setItemLocation(generalItem.getItemLocation());
			item08.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item08.setItemIsEquipped(generalItem.getItemIsEquipped());
			item08.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item08);
		}
		if (generalItem.getItemID().equals("A09")) {
			item09.setItemID(generalItem.getItemID());
			item09.setItemName(generalItem.getItemName());
			item09.setItemDescription(generalItem.getItemDescription());
			item09.setItemType(generalItem.getItemType());
			item09.setItemHealthAmount(generalItem.getItemHealthAmount());
			item09.setItemAttackAmount(generalItem.getItemAttackAmount());
			item09.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item09.setItemLocation(generalItem.getItemLocation());
			item09.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item09.setItemIsEquipped(generalItem.getItemIsEquipped());
			item09.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item09);
		}
		if (generalItem.getItemID().equals("A10")) {
			item10.setItemID(generalItem.getItemID());
			item10.setItemName(generalItem.getItemName());
			item10.setItemDescription(generalItem.getItemDescription());
			item10.setItemType(generalItem.getItemType());
			item10.setItemHealthAmount(generalItem.getItemHealthAmount());
			item10.setItemAttackAmount(generalItem.getItemAttackAmount());
			item10.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item10.setItemLocation(generalItem.getItemLocation());
			item10.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item10.setItemIsEquipped(generalItem.getItemIsEquipped());
			item10.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item10);
		}
		if (generalItem.getItemID().equals("A11")) {
			item11.setItemID(generalItem.getItemID());
			item11.setItemName(generalItem.getItemName());
			item11.setItemDescription(generalItem.getItemDescription());
			item11.setItemType(generalItem.getItemType());
			item11.setItemHealthAmount(generalItem.getItemHealthAmount());
			item11.setItemAttackAmount(generalItem.getItemAttackAmount());
			item11.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item11.setItemLocation(generalItem.getItemLocation());
			item11.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item11.setItemIsEquipped(generalItem.getItemIsEquipped());
			item11.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item11);
		}
		if (generalItem.getItemID().equals("A12")) {
			item12.setItemID(generalItem.getItemID());
			item12.setItemName(generalItem.getItemName());
			item12.setItemDescription(generalItem.getItemDescription());
			item12.setItemType(generalItem.getItemType());
			item12.setItemHealthAmount(generalItem.getItemHealthAmount());
			item12.setItemAttackAmount(generalItem.getItemAttackAmount());
			item12.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item12.setItemLocation(generalItem.getItemLocation());
			item12.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item12.setItemIsEquipped(generalItem.getItemIsEquipped());
			item12.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item12);
		}
		if (generalItem.getItemID().equals("A13")) {
			item13.setItemID(generalItem.getItemID());
			item13.setItemName(generalItem.getItemName());
			item13.setItemDescription(generalItem.getItemDescription());
			item13.setItemType(generalItem.getItemType());
			item13.setItemHealthAmount(generalItem.getItemHealthAmount());
			item13.setItemAttackAmount(generalItem.getItemAttackAmount());
			item13.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item13.setItemLocation(generalItem.getItemLocation());
			item13.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item13.setItemIsEquipped(generalItem.getItemIsEquipped());
			item13.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item13);
		}
		if (generalItem.getItemID().equals("A14")) {
			item14.setItemID(generalItem.getItemID());
			item14.setItemName(generalItem.getItemName());
			item14.setItemDescription(generalItem.getItemDescription());
			item14.setItemType(generalItem.getItemType());
			item14.setItemHealthAmount(generalItem.getItemHealthAmount());
			item14.setItemAttackAmount(generalItem.getItemAttackAmount());
			item14.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item14.setItemLocation(generalItem.getItemLocation());
			item14.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item14.setItemIsEquipped(generalItem.getItemIsEquipped());
			item14.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item14);
		}
		if (generalItem.getItemID().equals("A15")) {
			item15.setItemID(generalItem.getItemID());
			item15.setItemName(generalItem.getItemName());
			item15.setItemDescription(generalItem.getItemDescription());
			item15.setItemType(generalItem.getItemType());
			item15.setItemHealthAmount(generalItem.getItemHealthAmount());
			item15.setItemAttackAmount(generalItem.getItemAttackAmount());
			item15.setItemDefenseAmount(generalItem.getItemDefenseAmount());
			item15.setItemLocation(generalItem.getItemLocation());
			item15.setItemIsPickedUp(generalItem.getItemIsPickedUp());
			item15.setItemIsEquipped(generalItem.getItemIsEquipped());
			item15.setItemIsLocked(generalItem.getItemIsLocked());
			itemArrayList.add(item15);
		}
	}
	
	// This function creates the file "PuzzleFile.txt"
	// This function is useful and important in case 
	// any user makes a mistake or accidentally deletes
	// the file "PuzzleFile.txt". The user must run the program
	// and it will automatically create a new file
	public void createPuzzleFile() {
		try {
			File puzzleFile = new File("PuzzleFile.txt");
			
			if(!puzzleFile.exists()) {
				puzzleFile.createNewFile();
				
				FileWriter puzzleFileWriter = new FileWriter("PuzzleFile.txt");
				
				// Write to file
				for (int i = 0; i < 7; i++) {
					puzzleFileWriter.write("P0" + (i+1) + "~");
					
					switch(i+1) {
						case 1:
							puzzleFileWriter.write("What fruit did Snow White eat that cursed her with eternal sleep?~");
							puzzleFileWriter.write("apple~");
							puzzleFileWriter.write("3~");
							puzzleFileWriter.write("Usually found in the colors of red and green, sometimes yellow.~");
							puzzleFileWriter.write("R04~");
							puzzleFileWriter.write("200~");
							break;
						case 2:
							puzzleFileWriter.write("While I may seem immovable and permanent, I am actually rather fragile and with strong flames you can bend me to your will. "
									+ "I was the material of the slippers that adorned Cinderella's feet when she danced with the prince. What am I?~");
							puzzleFileWriter.write("glass~");
							puzzleFileWriter.write("5~");
							puzzleFileWriter.write("Rhymes with mass.~");
							puzzleFileWriter.write("R08~");
							puzzleFileWriter.write("100~");
							break;
						case 3:
							puzzleFileWriter.write("Aladdin's ally, Abu, is what type of animal?~");
							puzzleFileWriter.write("monkey~");
							puzzleFileWriter.write("3~");
							puzzleFileWriter.write("Type of primate with a tail.~");
							puzzleFileWriter.write("R11~");
							puzzleFileWriter.write("200~");
							break;
						case 4:
							puzzleFileWriter.write("The Sundrop ______ is the source of Rapunzel's healing power. And it rhymes with the last word in the previous sentence.~");
							puzzleFileWriter.write("flower~");
							puzzleFileWriter.write("3~");
							puzzleFileWriter.write("Bee hangout spot when they are not at the hive.~");
							puzzleFileWriter.write("R16~");
							puzzleFileWriter.write("200~");
							break;
						case 5:
							puzzleFileWriter.write("In the original The Little Mermaid (1989), how many tentacles does Ursula have? (spell out the number, ex. zero).~");
							puzzleFileWriter.write("six~");
							puzzleFileWriter.write("3~");
							puzzleFileWriter.write("Ursula resembles an octopus, but she has two arms...~");
							puzzleFileWriter.write("R19~");
							puzzleFileWriter.write("200~");
							break;
						case 6:
							puzzleFileWriter.write("Sun Tzu knew the Art of this? Do you know it as well?~");
							puzzleFileWriter.write("war~");
							puzzleFileWriter.write("5~");
							puzzleFileWriter.write("What is it good for? Absolutely nothing.~");
							puzzleFileWriter.write("R23~");
							puzzleFileWriter.write("150~");
							break;
						case 7:
							puzzleFileWriter.write("What has a mouth but cannot speak; has a bed but does not sleep; and is not a stream or a creek?~");
							puzzleFileWriter.write("river~");
							puzzleFileWriter.write("5~");
							puzzleFileWriter.write("It also bends but is not flexible, and it has a bank that does not store currency.~");
							puzzleFileWriter.write("R27~");
							puzzleFileWriter.write("100~");
							break;
					}
					puzzleFileWriter.write("false~");
					puzzleFileWriter.write("false~\n");
				}
				puzzleFileWriter.close();
			}
		}
		catch(Exception e) {
			
		}
	}
	
	// This function reads the file "PuzzleFile.txt"
	// The user/player is able to change any of the puzzle's attributes
	// however, ID must not be changed ever!
	public void readPuzzleFile() {
		// Each Puzzle has 9 attributes
		// 1. puzzleID = Unique ID of the puzzle
		// 2. puzzleText = Mission/Question/Text of the puzzle
		// 3. puzzleAnswer = Answer to the puzzle
		// 4. puzzleAttempts = Number of attempts to solve the puzzle
		// 5. puzzleHint = Hint that helps solve the puzzle
		// 6. puzzleLocation = Location of the puzzle found in the map
		// 7. puzzleScore = When the puzzle is solved, it grants score points!
		// 8. puzzleIsSolved = If the puzzle is solved, then don't show again
		int attributeCounter = 0;
		BufferedReader reader;
		String line;
		// An arrayList of characters is used to read the file
		// when a '~' is found, it will put together all of the
		// characters found before it and stored in the variable
		// "word". Each "word" will be stored in a temporal arrayList
		// called generalPuzzle arrayList. Once the generalPuzzle
		// arrayList has 8 elements or "words", it will add all of 
		// them into the Puzzle arrayList.
		generalPuzzle = new Puzzle();
		puzzle01 = new Puzzle();
		puzzle02 = new Puzzle();
		puzzle03 = new Puzzle();
		puzzle04 = new Puzzle();
		puzzle05 = new Puzzle();
		puzzle06 = new Puzzle();
		puzzle07 = new Puzzle();
		
		puzzleArrayList = new ArrayList<Puzzle>();
		ArrayList<Character> puzzleInfo = new ArrayList<Character>();
		String word = "";
		
		try {
			reader = new BufferedReader(new FileReader("PuzzleFile.txt"));
			line = reader.readLine();
			puzzleArrayList.clear();
			
			// While there is a line to read
			while (line != null) {
				// this variables is used to keep track of what type of variable
				// we are dealing with when storing it in the arrayList
				attributeCounter = 0;
				for (char c: line.toCharArray()) {
					if (c != '~') {
						puzzleInfo.add(c);
					}
					else {
						word = puzzleInfo.toString().substring(1, 3*puzzleInfo.size()-1).replaceAll(", ", "");
						
						if (attributeCounter == 0) {
							generalPuzzle.setPuzzleID(word);
						}
						else if (attributeCounter == 1) {
							generalPuzzle.setPuzzleText(word);
						}
						else if (attributeCounter == 2) {
							generalPuzzle.setPuzzleAnswer(word);
						}
						else if (attributeCounter == 3) {
							generalPuzzle.setPuzzleAttempts(Integer.parseInt(word));
						}
						else if (attributeCounter == 4) {
							generalPuzzle.setPuzzleHint(word);
						}
						else if (attributeCounter == 5) {
							generalPuzzle.setPuzzleLocation(word);
						}
						else if (attributeCounter == 6) {
							generalPuzzle.setPuzzleScore(Integer.parseInt(word));
						}
						else if (attributeCounter == 7) {
							generalPuzzle.setPuzzleIsSolved(Boolean.parseBoolean(word));
						}
						else {
							generalPuzzle.setPuzzleIsLocked(Boolean.parseBoolean(word));
							storePuzzleAttributes();
						}
						attributeCounter++;
						puzzleInfo.clear();
					}
				}
				line = reader.readLine();
			}
		}
		catch(Exception e) {
			
		}
		
	}
	
	// This function stores the puzzles read from file in the puzzle arrayList!
	public void storePuzzleAttributes() {
		if (generalPuzzle.getPuzzleID().equals("P01")) {
			puzzle01.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle01.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle01.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle01.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle01.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle01.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle01.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle01.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle01.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle01);
		}
		else if (generalPuzzle.getPuzzleID().equals("P02")) {
			puzzle02.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle02.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle02.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle02.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle02.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle02.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle02.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle02.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle02.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle02);
		}
		else if (generalPuzzle.getPuzzleID().equals("P03")) {
			puzzle03.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle03.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle03.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle03.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle03.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle03.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle03.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle03.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle03.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle03);
		}
		else if (generalPuzzle.getPuzzleID().equals("P04")) {
			puzzle04.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle04.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle04.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle04.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle04.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle04.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle04.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle04.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle04.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle04);
		}
		else if (generalPuzzle.getPuzzleID().equals("P05")) {
			puzzle05.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle05.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle05.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle05.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle05.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle05.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle05.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle05.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle05.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle05);
		}
		else if (generalPuzzle.getPuzzleID().equals("P06")) {
			puzzle06.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle06.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle06.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle06.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle06.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle06.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle06.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle06.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle06.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle06);
		}
		else if (generalPuzzle.getPuzzleID().equals("P07")) {
			puzzle07.setPuzzleID(generalPuzzle.getPuzzleID());
			puzzle07.setPuzzleText(generalPuzzle.getPuzzleText());
			puzzle07.setPuzzleAnswer(generalPuzzle.getPuzzleAnswer());
			puzzle07.setPuzzleAttempts(generalPuzzle.getPuzzleAttempts());
			puzzle07.setPuzzleHint(generalPuzzle.getPuzzleHint());
			puzzle07.setPuzzleLocation(generalPuzzle.getPuzzleLocation());
			puzzle07.setPuzzleScore(generalPuzzle.getPuzzleScore());
			puzzle07.setPuzzleIsSolved(generalPuzzle.getPuzzleIsSolved());
			puzzle07.setPuzzleIsLocked(generalPuzzle.getPuzzleIsLocked());
			puzzleArrayList.add(puzzle07);
		}
	}
	
	// This function creates the file "MonsterFile.txt"
	// This function is useful and important in case 
	// any user makes a mistake or accidentally deletes
	// the file "MonsterFile.txt". The user must run the program
	// and it will automatically create a new file
	public void createMonsterFile() {
		try {
			File monsterFile = new File("MonsterFile.txt");
			
			if(!monsterFile.exists()) {
				monsterFile.createNewFile();
				
				FileWriter monsterFileWriter = new FileWriter("MonsterFile.txt");
				
				// Write to file
				for (int i = 0; i < 8; i++) {
					monsterFileWriter.write("M0" + (i+1) + "~");
					
					switch(i+1) {
						case 1:
							monsterFileWriter.write("Snow White~");
							monsterFileWriter.write("She is a foster mom of seven dwarves.~");
							monsterFileWriter.write("Power: Forest animals attack you when she sings.~");
							monsterFileWriter.write("Weakness: Apples~");
							monsterFileWriter.write("50~");
							monsterFileWriter.write("50~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("R05~");
							break;
						case 2:
							monsterFileWriter.write("Cinderella~");
							monsterFileWriter.write("She is the best interior designer in all the land.~");
							monsterFileWriter.write("Power: Mice attack you at the snap of her fingers.~");
							monsterFileWriter.write("Weakness: Step Mothers, Steo Sisters, and Midnight~");
							monsterFileWriter.write("60~");
							monsterFileWriter.write("60~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("15~");
							monsterFileWriter.write("R09~");
							break;
						case 3:
							monsterFileWriter.write("Jasmine~");
							monsterFileWriter.write("She is a princess by day and world traveler by night.~");
							monsterFileWriter.write("Power: She has the largest Bengal tiger protecting her.~");
							monsterFileWriter.write("Weakness: Talking Parrots~");
							monsterFileWriter.write("70~");
							monsterFileWriter.write("70~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("15~");
							monsterFileWriter.write("R13~");
							break;
						case 4:
							monsterFileWriter.write("Rapunzel~");
							monsterFileWriter.write("She is a business woman who opened up her own hair salon.~");
							monsterFileWriter.write("Power: Her long hair can attack and protect her at the same time.~");
							monsterFileWriter.write("Weakness: Scissors~");
							monsterFileWriter.write("80~");
							monsterFileWriter.write("80~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("R17~");
							break;
						case 5:
							monsterFileWriter.write("Ariel~");
							monsterFileWriter.write("She is a dolphin trainer at SeaWorld.~");
							monsterFileWriter.write("Power: She can speak to all sea creatures.~");
							monsterFileWriter.write("Weakness: Sushi~");
							monsterFileWriter.write("90~");
							monsterFileWriter.write("90~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("R21~");
							break;
						case 6:
							monsterFileWriter.write("Mulan~");
							monsterFileWriter.write("She is a drill sergeant in the ROTC at her Alma Mater.~");
							monsterFileWriter.write("Power: Swift as a coursing river, and has the force of a great typhoon.~");
							monsterFileWriter.write("Weakness: Lucky Crickets~");
							monsterFileWriter.write("100~");
							monsterFileWriter.write("100~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("22~");
							monsterFileWriter.write("R25~");
							break;
						case 7:
							monsterFileWriter.write("Pocahontas~");
							monsterFileWriter.write("She has been given the title of honorary park ranger.~");
							monsterFileWriter.write("Power: She can paint with all the colors of the wind.~");
							monsterFileWriter.write("Weakness: Modern technology~");
							monsterFileWriter.write("110~");
							monsterFileWriter.write("110~");
							monsterFileWriter.write("10~");
							monsterFileWriter.write("20~");
							monsterFileWriter.write("22~");
							monsterFileWriter.write("R29~");
							break;
						case 8:
							monsterFileWriter.write("Mickey Mouse~");
							monsterFileWriter.write("King of the Disney Multiverse. Defeat him to wake up from the player's dream and win the game.~");
							monsterFileWriter.write("Power: Magical hat that gives him unlimited magical powers.~");
							monsterFileWriter.write("Weakness: Minnie Mouse~");
							monsterFileWriter.write("200~");
							monsterFileWriter.write("200~");
							monsterFileWriter.write("15~");
							monsterFileWriter.write("25~");
							monsterFileWriter.write("25~");
							monsterFileWriter.write("R30~");
							break;
					}
					monsterFileWriter.write("false~\n");
				}
				monsterFileWriter.close();
			}
		}
		catch (Exception e) {
			
		}
	}
	
	// This function reads the file "MonsterFile.txt"
	// The user/player is able to change any of the monster's attributes
	// however, ID must not be changed ever!
	public void readMonsterFile() {
		// Each Monster has 11 attributes
		// 1. monsterID = Unique ID of the monster
		// 2. monsterName = name of the monster
		// 3. monsterDescription1 = description of the monster
		// 4. monsterDescription2 = Power of the monster
		// 5. monsterDescription3 = Weakness of the monster
		// 6. monsterHealth = health of the monster
		// 7. monsterMinAttack = minimum attack damage of the monster
		// 8. monsterMaxAttack = maximum attack damage of the monster
		// 9. monsterDefense = armor of the monster
		// 10. monsterLocation = location of the monster in the map
		// 11. monsterIsDefeated = Whether the monster has been defeated or not
		int attributeCounter = 0;
		BufferedReader reader;
		String line;
		// An arrayList of characters is used to read the file
		// when a '~' is found, it will put together all of the
		// characters found before it and stored in the variable
		// "word". Each "word" will be stored in a temporal arrayList
		// called generalMonster arrayList. Once the generalMonster
		// arrayList has 11 elements or "words", it will add all of 
		// them into the Monster arrayList.
		generalMonster = new Monster();
		monster01 = new Monster();
		monster02 = new Monster();
		monster03 = new Monster();
		monster04 = new Monster();
		monster05 = new Monster();
		monster06 = new Monster();
		monster07 = new Monster();
		monster08 = new Monster();
		
		monsterArrayList = new ArrayList<Monster>();
		ArrayList<Character> monsterInfo = new ArrayList<Character>();
		String word = "";
		
		try {
			reader = new BufferedReader(new FileReader("MonsterFile.txt"));
			line = reader.readLine();
			monsterArrayList.clear();
			
			// While there is a line to read
			while (line != null) {
				// this variables is used to keep track of what type of variable
				// we are dealing with when storing it in the arrayList
				attributeCounter = 0;
				for (char c: line.toCharArray()) {
					if (c != '~') {
						monsterInfo.add(c);
					}
					else {
						word = monsterInfo.toString().substring(1, 3*monsterInfo.size()-1).replaceAll(", ", "");
						
						if (attributeCounter == 0) {
							generalMonster.setMonsterID(word);
						}
						else if (attributeCounter == 1) {
							generalMonster.setMonsterName(word);
						}
						else if (attributeCounter == 2) {
							generalMonster.setMonsterDescription1(word);
						}
						else if (attributeCounter == 3) {
							generalMonster.setMonsterDescription2(word);
						}
						else if (attributeCounter == 4) {
							generalMonster.setMonsterDescription3(word);
						}
						else if (attributeCounter == 5) {
							generalMonster.setMonsterCurrentHealth(Integer.parseInt(word));
						}
						else if (attributeCounter == 6) {
							generalMonster.setMonsterTotalHealth(Integer.parseInt(word));
						}
						else if (attributeCounter == 7) {
							generalMonster.setMonsterMinAttack(Integer.parseInt(word));
						}
						else if (attributeCounter == 8) {
							generalMonster.setMonsterMaxAttack(Integer.parseInt(word));
						}
						else if (attributeCounter == 9) {
							generalMonster.setMonsterDefense(Integer.parseInt(word));
						}
						else if (attributeCounter == 10) {
							generalMonster.setMonsterLocation(word);
						}
						else {
							generalMonster.setMonsterIsDefeated(Boolean.parseBoolean(word));
							storeMonsterAttributes();
						}
						attributeCounter++;
						monsterInfo.clear();
					}
				}
				line = reader.readLine();
			}
		}
		catch(Exception e) {
			
		}
	}
	
	// This function stores the monsters read from file in the monsters arrayList!
	public void storeMonsterAttributes() {
		if (generalMonster.getMonsterID().equals("M01")) {
			monster01.setMonsterID(generalMonster.getMonsterID());
			monster01.setMonsterName(generalMonster.getMonsterName());
			monster01.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster01.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster01.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster01.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster01.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster01.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster01.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster01.setMonsterDefense(generalMonster.getMonsterDefense());
			monster01.setMonsterLocation(generalMonster.getMonsterLocation());
			monster01.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster01);
		}
		else if (generalMonster.getMonsterID().equals("M02")) {
			monster02.setMonsterID(generalMonster.getMonsterID());
			monster02.setMonsterName(generalMonster.getMonsterName());
			monster02.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster02.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster02.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster02.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster02.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster02.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster02.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster02.setMonsterDefense(generalMonster.getMonsterDefense());
			monster02.setMonsterLocation(generalMonster.getMonsterLocation());
			monster02.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster02);
		}
		else if (generalMonster.getMonsterID().equals("M03")) {
			monster03.setMonsterID(generalMonster.getMonsterID());
			monster03.setMonsterName(generalMonster.getMonsterName());
			monster03.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster03.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster03.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster03.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster03.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster03.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster03.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster03.setMonsterDefense(generalMonster.getMonsterDefense());
			monster03.setMonsterLocation(generalMonster.getMonsterLocation());
			monster03.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster03);
		}
		else if (generalMonster.getMonsterID().equals("M04")) {
			monster04.setMonsterID(generalMonster.getMonsterID());
			monster04.setMonsterName(generalMonster.getMonsterName());
			monster04.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster04.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster04.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster04.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster04.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster04.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster04.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster04.setMonsterDefense(generalMonster.getMonsterDefense());
			monster04.setMonsterLocation(generalMonster.getMonsterLocation());
			monster04.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster04);
		}
		else if (generalMonster.getMonsterID().equals("M05")) {
			monster05.setMonsterID(generalMonster.getMonsterID());
			monster05.setMonsterName(generalMonster.getMonsterName());
			monster05.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster05.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster05.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster05.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster05.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster05.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster05.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster05.setMonsterDefense(generalMonster.getMonsterDefense());
			monster05.setMonsterLocation(generalMonster.getMonsterLocation());
			monster05.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster05);
		}
		else if (generalMonster.getMonsterID().equals("M06")) {
			monster06.setMonsterID(generalMonster.getMonsterID());
			monster06.setMonsterName(generalMonster.getMonsterName());
			monster06.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster06.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster06.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster06.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster06.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster06.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster06.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster06.setMonsterDefense(generalMonster.getMonsterDefense());
			monster06.setMonsterLocation(generalMonster.getMonsterLocation());
			monster06.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster06);
		}
		else if (generalMonster.getMonsterID().equals("M07")) {
			monster07.setMonsterID(generalMonster.getMonsterID());
			monster07.setMonsterName(generalMonster.getMonsterName());
			monster07.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster07.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster07.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster07.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster07.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster07.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster07.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster07.setMonsterDefense(generalMonster.getMonsterDefense());
			monster07.setMonsterLocation(generalMonster.getMonsterLocation());
			monster07.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster07);
		}
		else if (generalMonster.getMonsterID().equals("M08")) {
			monster08.setMonsterID(generalMonster.getMonsterID());
			monster08.setMonsterName(generalMonster.getMonsterName());
			monster08.setMonsterDescription1(generalMonster.getMonsterDescription1());
			monster08.setMonsterDescription2(generalMonster.getMonsterDescription2());
			monster08.setMonsterDescription3(generalMonster.getMonsterDescription3());
			monster08.setMonsterCurrentHealth(generalMonster.getMonsterCurrentHealth());
			monster08.setMonsterTotalHealth(generalMonster.getMonsterTotalHealth());
			monster08.setMonsterMinAttack(generalMonster.getMonsterMinAttack());
			monster08.setMonsterMaxAttack(generalMonster.getMonsterMaxAttack());
			monster08.setMonsterDefense(generalMonster.getMonsterDefense());
			monster08.setMonsterLocation(generalMonster.getMonsterLocation());
			monster08.setMonsterIsDefeated(generalMonster.getMonsterIsDefeated());
			monsterArrayList.add(monster08);
		}
	}
	
}
