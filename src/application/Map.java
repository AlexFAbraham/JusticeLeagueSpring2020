package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Map {
	// This array list stores all of the rooms's attributes
	// updates every time it reads the file
	// (right after the program is run)
	ArrayList<Room> roomArrayList = new ArrayList<Room>();
	// This room is used for each room
	// It stores the current room's attributes
	Room generalRoom = new Room();
	
	// Storing Rooms
	// Room00 is a wall (Nothing here)
	Room room01 = new Room();
	Room room02 = new Room();
	Room room03 = new Room();
	Room room04 = new Room();
	Room room05 = new Room();
	Room room06 = new Room();
	Room room07 = new Room();
	Room room08 = new Room();
	Room room09 = new Room();
	Room room10 = new Room();
	Room room11 = new Room();
	Room room12 = new Room();
	Room room13 = new Room();
	Room room14 = new Room();
	Room room15 = new Room();
	Room room16 = new Room();
	Room room17 = new Room();
	Room room18 = new Room();
	Room room19 = new Room();
	Room room20 = new Room();
	Room room21 = new Room();
	Room room22 = new Room();
	Room room23 = new Room();
	Room room24 = new Room();
	Room room25 = new Room();
	Room room26 = new Room();
	Room room27 = new Room();
	Room room28 = new Room();
	Room room29 = new Room();
	Room room30 = new Room();
	
	// This function creates the "RoomFile.txt"
	// if the file "RoomFile.txt" doesn't exist
	// Also, it writes the rooms to this file
	// This function is useful and important in case 
	// any user makes a mistake or accidentally deletes
	// the file "RoomFile.txt". The user must run the program
	// and it will automatically create a new file
	public void createRoomFile() {
		try {
			File roomFile = new File("RoomFile.txt");
			
			if(!roomFile.exists()) {				
				roomFile.createNewFile();
				
				FileWriter roomFileWriter = new FileWriter("RoomFile.txt");
				
				// Write to file
				for (int i = 0; i < 30; i++) {
					if (i < 9) {
						roomFileWriter.write("R0" + (i+1) + "~");
					}
					else {
						roomFileWriter.write("R" + (i+1) + "~");
					}
					
					roomFileWriter.write("false~");
					
					switch(i+1) {
						case 1:
							roomFileWriter.write("Start~");
							roomFileWriter.write("R02,R00,R00,R00~");
							roomFileWriter.write("You have been placed under a spell by the evil sorcerer. "
									+ "You must travel through your altered chilhood movie memories. "
									+ "Only after defeating the wizard you can wake up and break the spell. "
									+ "The room is dark and a single door lies before you to the north.~");
							break;
						case 2:
							roomFileWriter.write("Snow White 1: The Woods~");
							roomFileWriter.write("R04,R03,R01,R06~");
							roomFileWriter.write("You feel rushed through space and time. "
									+ "You open your eyes and see you are in the woods. "
									+ "You are surrounded by seven dwarves. "
									+ "They tell you Snow White has been enchanted, but she is not asleep. "
									+ "She has become more evil than maleficent ever was. "
									+ "They ask you to stop her.~");
							break;
						case 3:
							roomFileWriter.write("Snow White 2: Dwarfs' House~");
							roomFileWriter.write("R00,R00,R00,R02~");
							roomFileWriter.write("You enter the shack. "
									+ "You see tools on the walls and a table with something covered by a cloth. "
									+ "Birds chirp on the window sill. "
									+ "Hand-crafted wooden chairs surround a cozy fireplace.~");
							break;
						case 4:
							roomFileWriter.write("Snow White 3: Castle Entrance~");
							roomFileWriter.write("R00,R05,R02,R00~");
							roomFileWriter.write("You approach a giant castle with menacing dark spires. "
									+ "You cross the draw bridge into the cold stone fortress. "
									+ "Tattered tapestries of the royal symbol adorn the walls with only a few torches lightning the interior. "
									+ "You see a staircase.~");
							break;
						case 5:
							roomFileWriter.write("Snow White 4: Castle Spire~");
							roomFileWriter.write("R00,R00,R00,R04~");
							roomFileWriter.write("You ascend the stairs to find Snow White cackling and brewing a devious concotion in a giant cast iron pot. "
									+ "She notices you!"
									+ "\"I will help the sorcerer put the world to sleep!\" "
									+ "She cackles as she throws powder into the pot, a giant green splash erupts from the cauldron as she prepares to fight you. "
									+ "Will you fight Snow White?~");
							break;
						case 6:
							roomFileWriter.write("Cinderella 1: Rundown House~");
							roomFileWriter.write("R09,R02,R00,R07~");
							roomFileWriter.write("You feel rushed through space and time. "
									+ "You come to consciousness in a run-down house. "
									+ "You see 3 women in rags attempting to clean this dump of a shack. "
									+ "They tell you they have been imprisioned in a house that breaks every day and they cannot leave. "
									+ "They are forced to clean for eternity. "
									+ "Their evil stepsister Cinderella is to blame. "
									+ "They ask if you can defeat her so that they may live in peace.~");
							break;
						case 7:
							roomFileWriter.write("Cinderella 2: Fairy Godmother's House~");
							roomFileWriter.write("R08,R06,R00,R00~");
							roomFileWriter.write("You see a dirt path that leads you to a quaint and every clean little cottage. "
									+ "Squirrels run along the laundry lines and the door is lined with flowering vines. "
									+ "You enter to encounter three flying fairy creatures: one read, one blue, and one green. "
									+ "They tell you that they did their best to raise Cinderella to be gracious and caring person, but she kept her rage inside until it finally burst. "
									+ "She has doomed all common folk to toil day out. "
									+ "There may be an item to help you laying around.~");
							break;
						case 8:
							roomFileWriter.write("Cinderella 3: Castle Entrance~");
							roomFileWriter.write("R00,R09,R07,R00~");
							roomFileWriter.write("You approach a beautiful white castle with gold painted iron fences surrounding it. "
									+ "You pass through the gates and over a little brook when you are stopped by Prince Charming. "
									+ "The price says you cannot go to the garden unless you answer his riddle. "
									+ "He does not look that big. Maybe you can run past him or answer his riddle.~");
							break;
						case 9:
							roomFileWriter.write("Cinderella 4: Castle Garden~");
							roomFileWriter.write("R10,R00,R06,R08~");
							roomFileWriter.write("You enter the garden. "
									+ "You are almost knocked over by servants rushing and running around to fix the plants and bring their queen tea. "
									+ "The rose bushes are taller and more vibrant than any you have ever seen. "
									+ "At the end of the row, you see Queen Cinderella, standing under a gold trimmed white gazebo. "
									+ "Behind the gazebo to the north lies another strange door. Cinderella looks displeased by your presence.~");
							break;
						case 10:
							roomFileWriter.write("Aladdin 1: Desert~");
							roomFileWriter.write("R12,R11,R09,R00~");
							roomFileWriter.write("You pass out. "
									+ "You awaken to the wind blowing sand across your face. "
									+ "You are in a barren desert. As you behin to climb a sand dune you see Aladding rubbing a lamp, but nothing is happening. "
									+ "Aladding tells you that Jasmine stole Genie and used the last wish to make herself the matriarch of the city. "
									+ "Aladding asks for your help and you get on the magic carpet abd fly into the sky.~");
							break;
						case 11:
							roomFileWriter.write("Aladdin 2: Cave of Wonders~");
							roomFileWriter.write("R13,R00,R00,R10~");
							roomFileWriter.write("You see a giant lion's head surrounding the cavern entrance. "
									+ "It speaks, \"Are you wise enough?\" "
									+ "The lion'shead extends from the ground and swallows you, Aladdin and carpet. "
									+ "Aladdin lights a torch and you see treasure all around you. "
									+ "Boxes filled with gems and gold coins, but as you touch one it turns to sand. "
									+ "You see a scrool where Genie's lamp used to be.~");
							break;
						case 12:
							roomFileWriter.write("Aladdin 3: City Market~");
							roomFileWriter.write("R00,R13,R10,R00~");
							roomFileWriter.write("You land carpet in the middle of the city market. "
									+ "People bustling around yelling watch out street rat. "
									+ "Amidst the confusion you notice a single vendor who has no customers. "
									+ "Maybe he has something for trade. "
									+ "You can get back on carpet and go back to the desert or fight your way through the crowd.~");
							break;
						case 13:
							roomFileWriter.write("Aladdin 4: Throne Room~");
							roomFileWriter.write("R00,R14,R11,R12~");
							roomFileWriter.write("As the crowd dies down you see the Castle before you. "
									+ "You enter the main chamber into the throne room. "
									+ "Jasmine sits upon the golden throne with her pet tiger asleep at her feet. "
									+ "You see a strange door behind the throne.~");
							break;
						case 14:
							roomFileWriter.write("Tangled 1: Tower in Meadow~");
							roomFileWriter.write("R00,R16,R00,R13~");
							roomFileWriter.write("You open the door, and the world turns to sand and crumbles around you. "
									+ "You see a stone tower with no doors and one window rise before you. "
									+ "Prince Horace throws a ladder out the window and says: "
									+ "\"Hurry adventurer. Rapunzel has trapped me in this tower and I cannot leave until she is defeated.\"~");
							break;
						case 15:
							roomFileWriter.write("Tangled 2: Castle Attic~");
							roomFileWriter.write("R00,R17,R00,R00~");
							roomFileWriter.write("In the Castle attic you see cobwebs covering the roof, an empty dust covered bed in the corner of the room, and a nightstand with a mirror on it with drawers ajar. "
									+ "Horace asks you to descend the tower and defeat Rapunzel.~");
							break;
						case 16:
							roomFileWriter.write("Tangled 3: Anti-chamber~");
							roomFileWriter.write("R00,R00,R17,R14~");
							roomFileWriter.write("You descend the dark cold stone stairs to find yourself in an antichamber. "
									+ "You see a scroll with a riddle. "
									+ "As the rats scurry across the ground you must choose what to do!~");
							break;
						case 17:
							roomFileWriter.write("Tangled 4: Beauty Room~");
							roomFileWriter.write("R16,R00,R18,R15~");
							roomFileWriter.write("You descend the final flight of stairs and see Rapunzel laughing maniacally and mixing potions. "
									+ "She says: \"I have made a serum that will make everyone's hair fall out and go bald! "
									+ "Soon everyone will worship me with the longest and most golden of hair.\"~");
							break;
						case 18:
							roomFileWriter.write("Ariel 1: Beach~");
							roomFileWriter.write("R17,R20,R19,R00~");
							roomFileWriter.write("You wash ashore coming to consciousness coughing up water. "
									+ "As you begin to think this perverse nightmare is over, a crab named Sebastian scuttles over and tells you how he fled the kitchen after Ariel told Chef Louis to cook him. "
									+ "Will you put a stop to this Sea Witch? No doubt about it. You are still stuck under this spell "
									+ "You dive into the water after Sebastian and see a coral reef, a dark cave and a strange door.~");
							break;
						case 19:
							roomFileWriter.write("Ariel 2: Ariel's Cave~");
							roomFileWriter.write("R18,R21,R00,R00~");
							roomFileWriter.write("You swim through a beautiful brighly fluorescent colored coral reef until you come to a chamber with an air pocket. "
									+ "There are seashells lining the wall and a small pedestal with a fork in it. "
									+ "There is a scroll impaled upon the fork, you take it and read a riddle. "
									+ "The beach is behind you. "
									+ "You see the beach that is behind you, and a path through the seaweed and coral.~");
							break;
						case 20:
							roomFileWriter.write("Ariel 3: Ursula's Cave~");
							roomFileWriter.write("R00,R00,R21,R18~");
							roomFileWriter.write("You swim towards a dark and gloomy cave. "
									+ "You run out of breath as the light begins to fade two seahorses. "
									+ "Flotsam and Jetsam pull you into an air pocket. "
									+ "Ursula lies waiting in the shadows of the shallow water. "
									+ "She says: \"The red headed witch has turned my babies into seahorses.\" "
									+ "Defeat the sea witch and will be in your debt.~");
							break;
						case 21:
							roomFileWriter.write("Ariel 4: Atlantis Castle~");
							roomFileWriter.write("R20,R22,R00,R19~");
							roomFileWriter.write("Made of coral, the gates before you are open. "
									+ "Spires resembling tridents extend from the sea floor and you see Ariel. "
									+ "You notice a strange door behind Ariel. "
									+ "Ariel begins to cast a whirpool. "
									+ "Quick! Will you flee or fight Ariel?~");
							break;
						case 22:
							roomFileWriter.write("Mulan 1: Shrine~");
							roomFileWriter.write("R25,R23,R00,R21~");
							roomFileWriter.write("Your vision fades in and out. "
									+ "As you behin to regain your senses you notice you are in a shrine. "
									+ "Stones with kanji carved into them are lines against the walls. "
									+ "Incense almost burnt out stands in a though at the end of the room. "
									+ "Tall magnificent pillars stand in the four corners as you hear rain ping off the tile roof. "
									+ "What you thought to be a snake slithering up to you begins to stand and yells: \"Good morning! "
									+ "I am Mushu and you have to help me stop Mulan!\" "
									+ "You see three different paths.~");
							break;
						case 23:
							roomFileWriter.write("Mulan 2: Training Grounds~");
							roomFileWriter.write("R24,R00,R00,R22~");
							roomFileWriter.write("You enter the military encampment and see rows upon rows of soldiers practicing the martial art of Kung Fu. "
									+ "The caption, Shang, at the front asks his pupils to answer proverbs. He might have one for you. "
									+ "You see a mountain and a shrine...~");
							break;
						case 24:
							roomFileWriter.write("Mulan 3: Mountains~");
							roomFileWriter.write("R00,R00,R23,R25~");
							roomFileWriter.write("You brave the cold of the mountain. "
									+ "There was a battle here recently. Torn banners and soldiers lay strewn across the base of the mountain. "
									+ "You see a cart missing a wheel not far away. "
									+ "You can see the military encampment and a castle.~");
							break;
						case 25:
							roomFileWriter.write("Mulan 4: Hun Castle~");
							roomFileWriter.write("R26,R24,R22,R00~");
							roomFileWriter.write("Giant wooden dragons and guardians line the doors to the castle. "
									+ "As you enter the room and see the open room covered in red banners, you see a familiar strange door. "
									+ "When suddenly a woman drops from the roof and draws her sword blocking your path to the door. "
									+ "Mulan challenges you to a duel. You may leave the castle and travel to the mountains or to the shrine, or face Mulan and try to make it to the door.~");
							break;
						case 26:
							roomFileWriter.write("Pocahontas 1: Willow Tree~");
							roomFileWriter.write("R28,R00,R25,R27~");
							roomFileWriter.write("As you shift through this bizarre world yet again, you find it hard to stand. "
									+ "A grand-mother willow tree lifts you up and places you on a rock. "
									+ "She tells you that Pocahontas has taken command of the tribe and will eradicate the English foreigners. "
									+ "Grand-mother willow tells a racoon named Meeko to travel with you and try to stop Pocahontas.~");
							break;
						case 27:
							roomFileWriter.write("Pocahontas 2: Settlers Camp~");
							roomFileWriter.write("R29,R26,R00,R00~");
							roomFileWriter.write("You enter the English settlers camp. "
									+ "The townsfolk gather around a friendly native who is asking them riddles. "
									+ "You skirt along the wooden barricade to get a closer look. "
									+ "The native holding a cloth sack sees you and asks you a riddle.~");
							break;
						case 28:
							roomFileWriter.write("Pocahontas 3: River~");
							roomFileWriter.write("R00,R00,R26,R29~");
							roomFileWriter.write("You come upon a river with a cliff side above it. "
									+ "Colorful fall leaves begin to encircle all around you in the wind. "
									+ "There is a canoe at the shore line across the river, and a path leading to an open meadow.~");
							break;
						case 29:
							roomFileWriter.write("Pocahontas 4: Battlefield~");
							roomFileWriter.write("R30,R28,R27,R00~");
							roomFileWriter.write("You see past battles between the natives and English have taken place here. "
									+ "A light fog engulfs bodies strewen across the field. "
									+ "Amidst the fog Meeko finds something shiny! "
									+ "You see a river, the settlers camp, and a colossal strange door. "
									+ "This colossal strange door is being protected by Pocahontas! "
									+ "You must defeat her to find out what's behind this door.~");
							break;
						case 30:
							roomFileWriter.write("Boss Room~");
							roomFileWriter.write("R00,R00,R29,R00~");
							roomFileWriter.write("You see a rocky spire before you, waves crashing against the rocks. "
									+ "You notice giant ears poking out of the pointy hat of the sorcerer. "
									+ "The sorcerer turns to you, and says: \"Hah-Ho! It seems you found me.\" in a shrill voice. "
									+ "You realize, you must defeat Mickey Mouse!~");
					}
					roomFileWriter.write("\n");
				}
				roomFileWriter.close();
			}
		}
		catch (Exception e) {
			
		}
	}
	
	// This function reads the "RoomFile.txt"
	// The user/player is able to change any of the room's attributes
	// however, roomID must not be changed ever! and
	// 'roomsAround' must not be below 0 or above 30 (the highest room)
	public void readRoomFile() {
		// Each room has 5 attributes
		// 1. roomID = Unique Id of the room
		// 2. roomIsVisited = Whether room has been visited before or not
		// 3. roomName = room name
		// 4. roomAround = rooms around each room (N/E/S/W)
		// 5. roomDescription = room decription
		int attributeCounter = 0;
		BufferedReader reader;
		String line;
		// An arrayList of characters is used to read the file
		// when a '~' is found, it will put together all of the
		// characters found before it and stored in the variable
		// "word". Each "word" will be stored in a temporal arrayList
		// called generalRoom arrayList. Once the generalRoom
		// arrayList has 5 elements or "words", it will add all of 
		// them into the Room arrayList.
		ArrayList<Character> roomInfo = new ArrayList<Character>();
		String word = "";
		
		try {
			reader = new BufferedReader(new FileReader("RoomFile.txt"));
			line = reader.readLine();
			roomArrayList.clear();
			
			// While there is a line to read
			while (line != null) {
				// this variable is used to keep track of what type of variable
				// we are dealing with when storing it in the arrayList
				attributeCounter = 0;
				
				for (char c: line.toCharArray()) {
					if (c != '~') {
						roomInfo.add(c);
					}
					else {
						word = roomInfo.toString().substring(1, 3*roomInfo.size()-1).replaceAll(", ", "");
						
						if (attributeCounter == 0) {
							generalRoom.setRoomID(word);
						}
						else if (attributeCounter == 1) {
							generalRoom.setRoomIsVisited(Boolean.parseBoolean(word));
						}
						else if (attributeCounter == 2) {
							generalRoom.setRoomName(word);
						}
						else if (attributeCounter == 3) {
							String[] integerWord = word.split(",");
							String[] temporalIDs = new String[integerWord.length];
							for (int i = 0; i < temporalIDs.length; i++) {
								temporalIDs[i] = integerWord[i];
								generalRoom.setRoomAround(temporalIDs);
							}
						}
						else {
							generalRoom.setRoomDescription(word);
							storeRoomAttributes();
						}
						attributeCounter++;
						roomInfo.clear();
					}
				}
				line = reader.readLine();
			}
		}
		catch (Exception e) {
			
		}
	}
	
	// This function stores the rooms read from file in the room arrayList!
	public void storeRoomAttributes() {
		if (generalRoom.getRoomID().equals("R01")) {
			room01.setRoomID(generalRoom.getRoomID());
			room01.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room01.setRoomName(generalRoom.getRoomName());
			room01.setRoomAround(generalRoom.getRoomAround());
			room01.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room01);
		}
		else if (generalRoom.getRoomID().equals("R02")) {
			room02.setRoomID(generalRoom.getRoomID());
			room02.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room02.setRoomName(generalRoom.getRoomName());
			room02.setRoomAround(generalRoom.getRoomAround());
			room02.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room02);
		}
		else if (generalRoom.getRoomID().equals("R03")) {
			room03.setRoomID(generalRoom.getRoomID());
			room03.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room03.setRoomName(generalRoom.getRoomName());
			room03.setRoomAround(generalRoom.getRoomAround());
			room03.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room03);
		}
		else if (generalRoom.getRoomID().equals("R04")) {
			room04.setRoomID(generalRoom.getRoomID());
			room04.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room04.setRoomName(generalRoom.getRoomName());
			room04.setRoomAround(generalRoom.getRoomAround());
			room04.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room04);
		}
		else if (generalRoom.getRoomID().equals("R05")) {
			room05.setRoomID(generalRoom.getRoomID());
			room05.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room05.setRoomName(generalRoom.getRoomName());
			room05.setRoomAround(generalRoom.getRoomAround());
			room05.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room05);
		}
		else if (generalRoom.getRoomID().equals("R06")) {
			room06.setRoomID(generalRoom.getRoomID());
			room06.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room06.setRoomName(generalRoom.getRoomName());
			room06.setRoomAround(generalRoom.getRoomAround());
			room06.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room06);
		}
		else if (generalRoom.getRoomID().equals("R07")) {
			room07.setRoomID(generalRoom.getRoomID());
			room07.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room07.setRoomName(generalRoom.getRoomName());
			room07.setRoomAround(generalRoom.getRoomAround());
			room07.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room07);
		}
		else if (generalRoom.getRoomID().equals("R08")) {
			room08.setRoomID(generalRoom.getRoomID());
			room08.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room08.setRoomName(generalRoom.getRoomName());
			room08.setRoomAround(generalRoom.getRoomAround());
			room08.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room08);
		}
		else if (generalRoom.getRoomID().equals("R09")) {
			room09.setRoomID(generalRoom.getRoomID());
			room09.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room09.setRoomName(generalRoom.getRoomName());
			room09.setRoomAround(generalRoom.getRoomAround());
			room09.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room09);
		}
		else if (generalRoom.getRoomID().equals("R10")) {
			room10.setRoomID(generalRoom.getRoomID());
			room10.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room10.setRoomName(generalRoom.getRoomName());
			room10.setRoomAround(generalRoom.getRoomAround());
			room10.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room10);
		}
		else if (generalRoom.getRoomID().equals("R11")) {
			room11.setRoomID(generalRoom.getRoomID());
			room11.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room11.setRoomName(generalRoom.getRoomName());
			room11.setRoomAround(generalRoom.getRoomAround());
			room11.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room11);
		}
		else if (generalRoom.getRoomID().equals("R12")) {
			room12.setRoomID(generalRoom.getRoomID());
			room12.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room12.setRoomName(generalRoom.getRoomName());
			room12.setRoomAround(generalRoom.getRoomAround());
			room12.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room12);
		}
		else if (generalRoom.getRoomID().equals("R13")) {
			room13.setRoomID(generalRoom.getRoomID());
			room13.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room13.setRoomName(generalRoom.getRoomName());
			room13.setRoomAround(generalRoom.getRoomAround());
			room13.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room13);
		}
		else if (generalRoom.getRoomID().equals("R14")) {
			room14.setRoomID(generalRoom.getRoomID());
			room14.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room14.setRoomName(generalRoom.getRoomName());
			room14.setRoomAround(generalRoom.getRoomAround());
			room14.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room14);
		}
		else if (generalRoom.getRoomID().equals("R15")) {
			room15.setRoomID(generalRoom.getRoomID());
			room15.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room15.setRoomName(generalRoom.getRoomName());
			room15.setRoomAround(generalRoom.getRoomAround());
			room15.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room15);
		}
		else if (generalRoom.getRoomID().equals("R16")) {
			room16.setRoomID(generalRoom.getRoomID());
			room16.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room16.setRoomName(generalRoom.getRoomName());
			room16.setRoomAround(generalRoom.getRoomAround());
			room16.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room16);
		}
		else if (generalRoom.getRoomID().equals("R17")) {
			room17.setRoomID(generalRoom.getRoomID());
			room17.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room17.setRoomName(generalRoom.getRoomName());
			room17.setRoomAround(generalRoom.getRoomAround());
			room17.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room17);
		}
		else if (generalRoom.getRoomID().equals("R18")) {
			room18.setRoomID(generalRoom.getRoomID());
			room18.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room18.setRoomName(generalRoom.getRoomName());
			room18.setRoomAround(generalRoom.getRoomAround());
			room18.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room18);
		}
		else if (generalRoom.getRoomID().equals("R19")) {
			room19.setRoomID(generalRoom.getRoomID());
			room19.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room19.setRoomName(generalRoom.getRoomName());
			room19.setRoomAround(generalRoom.getRoomAround());
			room19.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room19);
		}
		else if (generalRoom.getRoomID().equals("R20")) {
			room20.setRoomID(generalRoom.getRoomID());
			room20.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room20.setRoomName(generalRoom.getRoomName());
			room20.setRoomAround(generalRoom.getRoomAround());
			room20.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room20);
		}
		else if (generalRoom.getRoomID().equals("R21")) {
			room21.setRoomID(generalRoom.getRoomID());
			room21.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room21.setRoomName(generalRoom.getRoomName());
			room21.setRoomAround(generalRoom.getRoomAround());
			room21.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room21);
		}
		else if (generalRoom.getRoomID().equals("R22")) {
			room22.setRoomID(generalRoom.getRoomID());
			room22.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room22.setRoomName(generalRoom.getRoomName());
			room22.setRoomAround(generalRoom.getRoomAround());
			room22.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room22);
		}
		else if (generalRoom.getRoomID().equals("R23")) {
			room23.setRoomID(generalRoom.getRoomID());
			room23.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room23.setRoomName(generalRoom.getRoomName());
			room23.setRoomAround(generalRoom.getRoomAround());
			room23.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room23);
		}
		else if (generalRoom.getRoomID().equals("R24")) {
			room24.setRoomID(generalRoom.getRoomID());
			room24.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room24.setRoomName(generalRoom.getRoomName());
			room24.setRoomAround(generalRoom.getRoomAround());
			room24.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room24);
		}
		else if (generalRoom.getRoomID().equals("R25")) {
			room25.setRoomID(generalRoom.getRoomID());
			room25.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room25.setRoomName(generalRoom.getRoomName());
			room25.setRoomAround(generalRoom.getRoomAround());
			room25.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room25);
		}
		else if (generalRoom.getRoomID().equals("R26")) {
			room26.setRoomID(generalRoom.getRoomID());
			room26.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room26.setRoomName(generalRoom.getRoomName());
			room26.setRoomAround(generalRoom.getRoomAround());
			room26.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room26);
		}
		else if (generalRoom.getRoomID().equals("R27")) {
			room27.setRoomID(generalRoom.getRoomID());
			room27.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room27.setRoomName(generalRoom.getRoomName());
			room27.setRoomAround(generalRoom.getRoomAround());
			room27.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room27);
		}
		else if (generalRoom.getRoomID().equals("R28")) {
			room28.setRoomID(generalRoom.getRoomID());
			room28.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room28.setRoomName(generalRoom.getRoomName());
			room28.setRoomAround(generalRoom.getRoomAround());
			room28.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room28);
		}
		else if (generalRoom.getRoomID().equals("R29")) {
			room29.setRoomID(generalRoom.getRoomID());
			room29.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room29.setRoomName(generalRoom.getRoomName());
			room29.setRoomAround(generalRoom.getRoomAround());
			room29.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room29);
		}
		else if (generalRoom.getRoomID().equals("R30")) {
			room30.setRoomID(generalRoom.getRoomID());
			room30.setRoomIsVisited(generalRoom.getRoomIsVisited());
			room30.setRoomName(generalRoom.getRoomName());
			room30.setRoomAround(generalRoom.getRoomAround());
			room30.setRoomDescription(generalRoom.getRoomDescription());
			roomArrayList.add(room30);
		}
	}
}
