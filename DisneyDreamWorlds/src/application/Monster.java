package application;

public class Monster {
	private String monsterID;
	private String monsterName;
	private String monsterDescription1;
	private String monsterDescription2;
	private String monsterDescription3;
	private int monsterHealth;
	private int monsterMinAttack;
	private int monsterMaxAttack;
	private int monsterDefense;
	private String monsterLocation;
	private Boolean monsterIsDefeated;
	
	public Monster() {
		monsterID = "";
		monsterName = "";
		monsterDescription1 = "";
		monsterHealth = 0;
		monsterMinAttack = 0;
		monsterMaxAttack = 0;
		monsterDefense = 0;
		monsterLocation = "";
		monsterIsDefeated = false;
	}
	
	public Monster(String monsterID, String monsterName, String monsterDescription1, String monsterDescription2, String monsterDescription3 , int monsterHealth, 
			int monsterMinAttack, int monsterMaxAttack, int monsterDefense, String monsterLocation, Boolean monsterIsDefeated) {
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.monsterDescription1 = monsterDescription1;
		this.monsterDescription2 = monsterDescription2;
		this.monsterDescription3 = monsterDescription3;
		this.monsterHealth = monsterHealth;
		this.monsterMinAttack = monsterMinAttack;
		this.monsterMaxAttack = monsterMaxAttack;
		this.monsterDefense = monsterDefense;
		this.monsterLocation = monsterLocation;
		this.monsterIsDefeated = monsterIsDefeated;
	}
	
	// Getters
	public String getMonsterID() {
		return monsterID;
	}
	
	public String getMonsterName() {
		return monsterName;
	}
	
	public String getMonsterDescription1() {
		return monsterDescription1;
	}
	
	public String getMonsterDescription2() {
		return monsterDescription2;
	}
	
	public String getMonsterDescription3() {
		return monsterDescription3;
	}
	
	public int getMonsterHealth() {
		return monsterHealth;
	}
	
	public int getMonsterMinAttack() {
		return monsterMinAttack;
	}
	
	public int getMonsterMaxAttack() {
		return monsterMaxAttack;
	}
	
	public int getMonsterDefense() {
		return monsterDefense;
	}
	
	public String getMonsterLocation() {
		return monsterLocation;
	}
	
	public Boolean getMonsterIsDefeated() {
		return monsterIsDefeated;
	}
	
	// Setters
	public void setMonsterID(String monsterID) {
		this.monsterID = monsterID;
	}
	
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	
	public void setMonsterDescription1(String monsterDescription1) {
		this.monsterDescription1 = monsterDescription1;
	}
	
	public void setMonsterDescription2(String monsterDescription2) {
		this.monsterDescription2 = monsterDescription2;
	}
	
	public void setMonsterDescription3(String monsterDescription3) {
		this.monsterDescription3 = monsterDescription3;
	}
	
	public void setMonsterHealth(int monsterHealth) {
		this.monsterHealth = monsterHealth;
	}
	
	public void setMonsterMinAttack(int monsterMinAttack) {
		this.monsterMinAttack = monsterMinAttack;
	}
	
	public void setMonsterMaxAttack(int monsterMaxAttack) {
		this.monsterMaxAttack = monsterMaxAttack;
	}
	
	public void setMonsterDefense(int monsterDefense) {
		this.monsterDefense = monsterDefense;
	}
	
	public void setMonsterLocation(String monsterLocation) {
		this.monsterLocation = monsterLocation;
	}
	
	public void setMonsterIsDefeated(Boolean monsterIsDefeated) {
		this.monsterIsDefeated = monsterIsDefeated;
	}
}
