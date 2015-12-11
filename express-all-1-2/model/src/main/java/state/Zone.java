package state;

public enum Zone {
	PLANE("航空区"),CAR("汽车区"),TRAIN("火车区"),EMPTY("机动区");
	
	private String zone;
	
	private Zone(String zone) {
		this.zone = zone;
	}
	
	public String toString() {
		return zone;
	}
	
	public static Zone getbyStr(String str) {
		if(str.equals(PLANE.toString())) {
			return PLANE;
		} else if(str.equals(CAR.toString())) {
			return CAR;
		} else if(str.equals(TRAIN.toString())) {
			return TRAIN;
		} else {
			return EMPTY;
		}
	}
	
}
