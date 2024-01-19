package main.com.davel99.hanoigame;

import java.util.Scanner;

public class HanoiConsoleHandler {
	public HanoiGameHandler game;
	public boolean isGameOn;
	public Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		

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
		System.out.println("Choose tower ID which first ring you want to move out");
		String towerFrom = this.s.nextLine();
		System.out.println("Choose tower ID which first ring you want to move in");
		String towerTo = this.s.nextLine();
		
		int from = Integer.valueOf(towerFrom);
		int to = Integer.valueOf(towerTo);
		
		String controlsMessage = "Press any key to continue or x to exit";
		String movementStatus = "Movement failed, try again. " + controlsMessage;
		
	}
	
	public void printTowerData() {
		int towersLen = this.game.towers.length;
		for(int i = 0; i < towersLen; i++) {
			HanoiTower tower = this.game.towers[i];
			int ringsSize = tower.rings.size();
			String consoleResponse = "Tower "+tower.id+":";
			
			for(int ringCount = 0; ringCount < ringsSize; ringCount++) {
				HanoiRing ring = tower.rings.get(ringCount);
				consoleResponse += ring.size + "|";
			}
			System.out.println(consoleResponse);
		}
	}

}
