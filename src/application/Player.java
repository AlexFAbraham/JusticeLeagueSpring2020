package application;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Player {
	private String playerID;
	private String playerUsername;
	private String playerPassword;
	// private String playerEmail;
	private int playerCurrentHealth;
	private int playerTotalHealth;
	private int playerMinAttack;
	private int playerMaxAttack;
	private int playerDefense;
	private ArrayList<Item> playerInventory;
	private String playerLocation;
	
	public Player() {
		playerID = "";
		playerUsername = "";
		playerPassword = "";
		playerCurrentHealth = 25;
		playerTotalHealth = 25;
		playerMinAttack = 15;
		playerMaxAttack = 25;
		playerDefense = 10;
		playerInventory = new ArrayList<Item>();
		playerLocation = "R01";
	}
	
	public Player(String playerID, String playerUsername, String playerPassword, int playerCurrentHealth, int playerTotalHealth, 
			int playerMinAttack, int playerMaxAttack, int playerDefense, ArrayList<Item> playerInventory, String playerLocation) {
		this.playerID = playerID;
		this.playerUsername = playerUsername;
		this.playerPassword = playerPassword;
		this.playerCurrentHealth = playerCurrentHealth;
		this.playerTotalHealth = playerTotalHealth;
		this.playerMinAttack = playerMinAttack;
		this.playerMaxAttack = playerMaxAttack;
		this.playerDefense = playerDefense;
		this.playerInventory = playerInventory;
		this.playerLocation = playerLocation;
	}
	
	// Getters
	public String getPlayerID() {
		return playerID;
	}
	
	public String getPlayerUsername() {
		return playerUsername;
	}
	
	public String getPlayerPassword() {
		return playerPassword;
	}
	
	public int getPlayerCurrentHealth() {
		return playerCurrentHealth;
	}
	
	public int getPlayerTotalHealth() {
		return playerTotalHealth;
	}
	
	public int getPlayerMinAttack() {
		return playerMinAttack;
	}
	
	public int getPlayerMaxAttack() {
		return playerMaxAttack;
	}
	
	public int getPlayerDefense() {
		return playerDefense;
	}
	
	public ArrayList<Item> getPlayerInventory() {
		return playerInventory;
	}
	
	public String getPlayerLocation() {
		return playerLocation;
	}
	
	// Setters
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	
	public void setPlayerUsername(String playerUsername) {
		this.playerUsername = playerUsername;
	}
	
	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}
	
	public void setPlayerCurrentHealth(int playerCurrentHealth) {
		this.playerCurrentHealth = playerCurrentHealth;
	}
	
	public void setPlayerTotalHealth(int playerTotalHealth) {
		this.playerTotalHealth = playerTotalHealth;
	}
	
	public void setPlayerMinAttack(int playerMinAttack) {
		this.playerMinAttack = playerMinAttack;
	}
	
	public void setPlayerMaxAttack(int playerMaxAttack) {
		this.playerMaxAttack = playerMaxAttack;
	}
	
	public void setPlayerDefense(int playerDefense) {
		this.playerDefense = playerDefense;
	}
	
	public void setPlayerInventory(ArrayList<Item> playerInventory) {
		this.playerInventory = playerInventory;
	}
	
	public void setPlayerLocation(String playerLocation) {
		this.playerLocation = playerLocation;
	}
	
	// This function verifies if the player move is valid or not
	public Boolean playerMoves(Player player, Map map, int direction) {
		// Convert player Location (String) to Int
		String index = player.getPlayerLocation();
		int indexLocation = Integer.parseInt(index.substring(1))-1;
			
		if (map.roomArrayList.get(indexLocation).getRoomAround()[direction].equals("R00")) {
			Text invalidMoveMessage = new Text("No room here!");
			invalidMoveMessage.setTextAlignment(TextAlignment.CENTER);
			VBox invalidMoveBox = new VBox(10);
			invalidMoveBox.setAlignment(Pos.CENTER);
			
			Button okButton = new Button("OK");
			
			invalidMoveBox.getChildren().add(invalidMoveMessage);
			invalidMoveBox.getChildren().add(okButton);
			
			Scene invalidMoveScene = new Scene(invalidMoveBox, 200, 100);
			Stage invalidMoveStage = new Stage();
			
			invalidMoveStage.setScene(invalidMoveScene);
			invalidMoveStage.show();
			
			okButton.setOnAction(e -> {
				invalidMoveStage.close();
			});
			
			return false;
		}
		else {
			player.setPlayerLocation(map.roomArrayList.get(indexLocation).getRoomAround()[direction]);
			return true;
		}
	}	
	
	// This function displays the map and the current player's location
	public void displayMap(Player player) {
		// get the image of the map and location pin and add it to the scene
		try {
			FileInputStream map = new FileInputStream("map.png");
			FileInputStream location  = new FileInputStream("location.png");
			Image backgroundImageImage = new Image(map);
			Image locationImage = new Image(location);
			ImageView mvMap = new ImageView(backgroundImageImage);
			ImageView mvLocation = new ImageView(locationImage);
				  
			Group root = new Group(); 
				       	        
			Scene scene = new Scene(root, 520, 400);
			Stage stage = new Stage();
			stage.setTitle("Map");
	        stage.setScene(scene);
			stage.setResizable(true);
				        
			Button okButton = new Button("Ok");
			okButton.setAlignment(Pos.CENTER);
			okButton.relocate(250, 350);
			
			okButton.setOnAction(e -> {
				stage.close();
			});
			
			root.getChildren().addAll(mvMap,mvLocation,okButton);
			
			// change location of the location pin to the player's current location
			switch(playerLocation) {
				case "R01":
					mvLocation.relocate(177.33, 270.67);   
					break;
				case "R02":
					mvLocation.relocate(140.67, 225.33);
					break;
				case "R03":
					mvLocation.relocate(193.33, 230.33);
					break;
				case "R04":
					mvLocation.relocate(136.67, 180.33);
					break;
				case "R05":
					mvLocation.relocate(200.67, 180.67);
				    break;
				case "R06":
					mvLocation.relocate(77.33, 225.33);
					break;
				case "R07":
					mvLocation.relocate(22.00, 230.00);
				    break;
				case "R08":
					mvLocation.relocate(22.00, 170.67);
					break;
				case "R09":
					mvLocation.relocate(80.67, 170.67);
					break;
				case "R10":
					mvLocation.relocate(80.67, 120.67);
				    break;
				case "R11":
					mvLocation.relocate(140.33, 120.67);
					break;
				case "R12":
					mvLocation.relocate(80.67, 70.67);
					break;
				case "R13":
					mvLocation.relocate(140.67, 70.67);
					break;
				case "R14":
					mvLocation.relocate(195.33, 70.33);
					break;
				case "R15":
					mvLocation.relocate(195.33, 120.63);
					break;
				case "R16":
					mvLocation.relocate(250.33, 70.33);
					break;
				case "R17":
					mvLocation.relocate(250.33, 123.33);
					break;
				case "R18":
					mvLocation.relocate(250.33, 175.33);
					break;
				case "R19":
					mvLocation.relocate(250.33, 230.33);
					break;
				case "R20":
					mvLocation.relocate(310.65, 175.33);
					break;
				case "R21":
					mvLocation.relocate(310.65, 230.33);
					break;
				case "R22":
					mvLocation.relocate(370.65, 230.33);
					break;
				case "R23":
					mvLocation.relocate(427.65, 230.33);
					break;
				case "R24":
					mvLocation.relocate(427.65, 175.33);
					break;
				case "R25":
					mvLocation.relocate(370.65, 175.33);
					break;
				case "R26":
					mvLocation.relocate(370.65, 123.33);
					break;
				case "R27":
					mvLocation.relocate(310.65, 123.33);
					break;
				case "R28":
					mvLocation.relocate(370.65, 70.33);
					break;
				case "R29":
					mvLocation.relocate(310.65, 70.33);
					break;
				case "R30":
					mvLocation.relocate(310.65, 20.33);
					break;
				default:
				    // code block	
			}
			stage.show();
		} 
		catch (Exception e)	{
				System.out.println("Map cannot be display");
		}
	}
	
	// This function checks the player's current inventory
	public void playerChecksInventory(Player player, ArrayList<Item> itemArrayList, ImageView emojiImageView_2) {
		// If no items in inventory
		if (player.getPlayerInventory().size() == 0) {
			Text noItemsMessage = new Text("No items in your inventory!");
			noItemsMessage.setTextAlignment(TextAlignment.CENTER);
			VBox noItemsBox = new VBox(10);
			noItemsBox.setAlignment(Pos.CENTER);
			
			Button okButton = new Button("OK");
			
			noItemsBox.getChildren().add(noItemsMessage);
			noItemsBox.getChildren().add(emojiImageView_2);
			noItemsBox.getChildren().add(okButton);
			
			Scene noItemsScene = new Scene(noItemsBox, 200, 150);
			Stage noItemsStage = new Stage();
			
			noItemsStage.setScene(noItemsScene);
			noItemsStage.show();
			
			
			okButton.setOnAction(e -> {
				noItemsStage.close();
			});
		}
		
		// Table Inventory if there is at least one item
		else {
			TableView<Item> tableView = new TableView<>();
			TableColumn<Item, String> nameColumn = new TableColumn<>("Item Name");
			TableColumn<Item, String> descriptionColumn = new TableColumn<>("Item Description");
			TableColumn<Item, String> typeColumn = new TableColumn<>("Item Type");
			
			nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
			descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemDescription"));
			typeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemType"));
			
			nameColumn.setMinWidth(200);
			descriptionColumn.setMinWidth(400);
			typeColumn.setMinWidth(200);
			
			tableView.setItems(getItems(player));
			tableView.getColumns().addAll(nameColumn, descriptionColumn, typeColumn);
				
			Group root = new Group();
			root.getChildren().add(tableView);
			Scene scene = new Scene(root,800,600);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Player Inventory");
			stage.show();
			
		}
	}
	
	// Get Items in inventory to table view
	public ObservableList<Item> getItems(Player player) {
		ObservableList<Item> item = FXCollections.observableArrayList();
		
		for (int inventoryIndex = 0; inventoryIndex < player.getPlayerInventory().size(); inventoryIndex++) {
			item.add(new Item(player.getPlayerInventory().get(inventoryIndex).getItemName(), player.getPlayerInventory().get(inventoryIndex).getItemDescription(), player.getPlayerInventory().get(inventoryIndex).getItemType()));		
		}
		
		return item;
	}
	
	// This function display an invalid command message
	// if the entered input is an invalid command
	public void displayInvalidCommandMessage(String userInputCommand, ImageView emojiImageView_1) {
		Text invalidCommandMessage = new Text("");
		
		if (userInputCommand.equals("move")) {
			invalidCommandMessage.setText("Please specify\nWhere would you like to move");
		}
		else {
			invalidCommandMessage.setText("Invalid Command!");
		}
		
		invalidCommandMessage.setTextAlignment(TextAlignment.CENTER);
		VBox invalidCommandBox = new VBox(10);
		invalidCommandBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button("OK");
		
		invalidCommandBox.getChildren().add(invalidCommandMessage);
		invalidCommandBox.getChildren().add(emojiImageView_1);
		invalidCommandBox.getChildren().add(okButton);
		
		Scene invalidCommandScene = new Scene(invalidCommandBox, 200, 150);
		Stage invalidCommandStage = new Stage();
		
		invalidCommandStage.setScene(invalidCommandScene);
		invalidCommandStage.show();
		invalidCommandStage.setTitle("Invalid Command");
		
		okButton.setOnAction(e -> {
			invalidCommandStage.close();
		});
	}
	
	// This function validates the player's input
	// whether the entered input is a valid command or not
	public Boolean validateCommand(String userInputCommand, ArrayList<String> commandList) {
		for (int i = 0; i < commandList.size(); i++) {
			if (userInputCommand.equals("move")) {
				return false;
			}
			else if (commandList.get(i).equals(userInputCommand)) {
				return true;
			}
		}		
		return false;
	}
	
	// This function takes the player's input and does something!
	public Boolean doCommand(String userInput, TextField userInputTextField, Player player, Map map, ArrayList<Item> itemArrayList, ArrayList<Puzzle> puzzleArrayList, 
			ImageView emojiImageView_2, ArrayList<String> generalCommandList) {
		int direction = 0;
		
		if (userInput.equals("move north") || userInput.equals("north") || userInput.equals("n")) {
			direction = 0;
		}
		else if (userInput.equals("move east") || userInput.equals("east") || userInput.equals("e")) {
			direction = 1;
		}
		else if (userInput.equals("move south") || userInput.equals("south") || userInput.equals("s")) {
			direction = 2;
		}
		else if (userInput.equals("move west") || userInput.equals("west") || userInput.equals("w")) {
			direction = 3;
		}
		else {
			Text invalidCommandMessage = new Text("Can't do this command in this scenario!");
			invalidCommandMessage.setTextAlignment(TextAlignment.CENTER);
			VBox invalidCommandBox = new VBox(10);
			invalidCommandBox.setAlignment(Pos.CENTER);
			
			Button okButton = new Button("OK");
			
			invalidCommandBox.getChildren().add(invalidCommandMessage);
			invalidCommandBox.getChildren().add(emojiImageView_2);
			invalidCommandBox.getChildren().add(okButton);
			
			Scene invalidCommandScene = new Scene(invalidCommandBox, 300, 150);
			Stage invalidCommandStage = new Stage();
			
			invalidCommandStage.setScene(invalidCommandScene);
			invalidCommandStage.show();
			
			okButton.setOnAction(e -> {
				invalidCommandStage.close();
			});
			
			return false;
		}
		
		return player.playerMoves(player, map, direction);
	}
}
