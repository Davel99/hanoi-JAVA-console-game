package main.com.davel99.hanoigame;

import java.util.LinkedList;

public class HanoiTower {
	public int id;
	public LinkedList<HanoiRing> rings = new LinkedList<HanoiRing>();
	
	public HanoiTower(Integer id) {
		this.id = id;
	}
	
	public boolean canAddRing(HanoiRing ring) {
		return this.checkRing(ring.size);
	}
	
	public boolean addRing(HanoiRing ring) {
		this.rings.addFirst(ring);
		return true;
		
	}
	
	public boolean checkRing(int size) {
		if(this.rings.isEmpty())return true;
		if(size < this.rings.getFirst().size) return true;
		return false;
	}

}
