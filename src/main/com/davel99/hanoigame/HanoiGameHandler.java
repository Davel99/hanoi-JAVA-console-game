package main.com.davel99.hanoigame;

import java.util.LinkedList;

public class HanoiGameHandler {
	public HanoiTower[] towers;
	public HanoiRing[] rings;
	
	public HanoiGameHandler(int totalTowers, int totalRings) {
		this.towers = new HanoiTower[totalTowers];
		this.rings = new HanoiRing[totalRings];
		this.generateTowers();
		this.generateRings();
		this.addRings();
		
	}
	
	public boolean canMakeMovement(int from, int to) {
		HanoiTower fromTower = this.towers[from];
		HanoiTower toTower = this.towers[to];
		
		if(fromTower.rings.isEmpty()) return false;
		if(toTower.rings.isEmpty()) return true;
		
		HanoiRing movedRing = fromTower.rings.getFirst();
		HanoiRing destinationRing = toTower.rings.getFirst();
		if(movedRing.size < destinationRing.size) return true;
		return false;
	}
	
	public boolean makeMovement(int from, int to) {
		HanoiTower fromTower = this.towers[from];
		HanoiTower toTower = this.towers[to];		
		HanoiRing movedRing = fromTower.rings.getFirst();
		fromTower.rings.removeFirst();
		toTower.addRing(movedRing);
		return true;		
	}
	
	public void addRings() {
		int ringCount = this.rings.length-1;
		int towerCount = 0;
		while(ringCount >= 0) {
			if(towerCount >= this.towers.length) towerCount = 0;
			HanoiRing ring = this.rings[ringCount];
			HanoiTower tower = this.towers[towerCount];
			if(tower.canAddRing(ring)) tower.addRing(ring);
			//System.out.println("Ring of size "+ ring.size +" added to tower "+towerCount);
			ringCount--;
			towerCount++;
		}
	}
	
	public void generateTowers() {
		for(int i = 0; i < this.towers.length; i ++) {
			this.towers[i] = new HanoiTower(i);
		}
	}
	
	public void generateRings() {
		for(int i = 0; i < this.rings.length; i ++) {
			this.rings[i] = new HanoiRing(i+1,"Green");
		}
		
	}
	
	public boolean checkGameStatus() {
		int filledTowers = 0;
		int finalTower = 0;
		for(int i = 0; i < this.towers.length; i++) {
			HanoiTower tower = this.towers[i];
			if(!tower.rings.isEmpty()) filledTowers++;
			else finalTower = i;
		}
		if(filledTowers != 1) return false;
		LinkedList<HanoiRing> finalRings = this.towers[finalTower].rings;
		int lastNumber = 0;
		boolean firstCheck = true;
		boolean isWinning = true;
		
		for(int i = 0; i < finalRings.size(); i++) {
			HanoiRing ring = finalRings.get(i);
			if(firstCheck) {
				firstCheck = false;
				lastNumber = ring.size;
			}
			else {
				if(!(lastNumber < ring.size)) isWinning = false;
			}
			
			if(!isWinning) break;
		}
		
		return isWinning;
	}
	

}
