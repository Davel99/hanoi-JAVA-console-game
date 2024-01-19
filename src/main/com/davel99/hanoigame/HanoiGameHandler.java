package main.com.davel99.hanoigame;

public class HanoiGameHandler {
	public HanoiTower[] towers;
	public HanoiRing[] rings;
	
	public HanoiGameHandler(int totalTowers, int totalRings) {
		this.towers = new HanoiTower[totalTowers];
		this.rings = new HanoiRing[totalRings];
		this.start();
	}
	
	public void start() {
		
	}
	
	public void addRings() {
		int ringCount = 0;
		int towerCount = 0;
		while(ringCount < this.rings.length) {
			if(towerCount >= this.towers.length) towerCount = 0;
			HanoiRing ring = this.rings[ringCount];
			HanoiTower tower = this.towers[towerCount];
			if(tower.canAddRing(ring)) tower.addRing(ring);
			System.out.println("Ring "+ringCount+" added to tower "+towerCount);
			ringCount++;
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
			this.rings[i] = new HanoiRing(i,"Green");
		}
		
	}

}
