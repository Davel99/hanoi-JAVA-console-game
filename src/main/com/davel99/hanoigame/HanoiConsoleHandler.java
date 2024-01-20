package main.com.davel99.hanoigame;

import java.util.Scanner;

public class HanoiConsoleHandler {
	public HanoiGameHandler game;
	public boolean isGameOn;
	public Scanner s = new Scanner(System.in);
	public String messageFromTower = "Choose tower ID which first ring you want to move out";
	public String messageToTower = "Choose tower ID which first ring you want to move in";
	public String exitMessage = "Press any key to continue or x to exit";
	public String movementStatus;

	public static void main(String[] args) {
		new HanoiConsoleHandler();
	}
	
	public HanoiConsoleHandler() {
		this.game = new HanoiGameHandler(3,5);
		this.isGameOn = true;
		while(this.isGameOn) {
			this.startConsoleGameLoop();
		}
	}
	
	public void startConsoleGameLoop() {
		this.printTowerData();
		
		String towerFrom = this.readAnswer(messageFromTower);
		String towerTo = this.readAnswer(messageToTower);
		
		int from = Integer.valueOf(towerFrom);
		int to = Integer.valueOf(towerTo);
		boolean canMove = false;
		try {
			canMove = this.handleMovement(from, to);
			if(canMove) this.game.makeMovement(from, to);	
		} catch (Exception e) {
			this.movementStatus = "Something went wrong. Please make sure your inputs are correct. "+this.exitMessage;
		}	
		System.out.println(this.movementStatus);
		String answer = this.s.nextLine();
		if(answer.equals("x")) this.isGameOn = false;		
	}
	
	public boolean handleMovement(int from, int to) {		
		String movementStatus = "Movement failed, try again.";
		boolean canMove = this.game.canMakeMovement(from, to);
		if(canMove) movementStatus = "Success movement.";
		this.movementStatus = movementStatus + " " + this.exitMessage;
		return canMove;		
	}
	
	public String readAnswer(String message) {
		System.out.println(message);
		String answer = this.s.nextLine();
		return answer;
	}
	
	public void printTowerData() {
		int towersLen = this.game.towers.length;
		for(int i = 0; i < towersLen; i++) {
			HanoiTower tower = this.game.towers[i];
			int ringsSize = tower.rings.size()-1;
			String consoleResponse = "Tower "+tower.id+":   |";
			
			for(int ringCount = ringsSize; ringCount >= 0; ringCount--) {
				HanoiRing ring = tower.rings.get(ringCount);
				consoleResponse += ring.size + "|";
			}
			System.out.println(consoleResponse);
		}
	}

}
