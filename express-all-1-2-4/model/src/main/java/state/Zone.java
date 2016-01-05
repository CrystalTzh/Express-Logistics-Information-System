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
	
	/**
	 * 通过字符串获取zone
	 * @param str
	 * @return
	 */
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
	
	/**
	 * 通过数字获取zone
	 * @param index
	 * @return
	 */
	public static Zone getbyIndex(int index) {
		if(index == 0) {
			return PLANE;
		} else if(index == 1) {
			return CAR;
		} else if(index == 2) {
			return TRAIN;
		} else if(index == 3) {
			return EMPTY;
		}
		return null;
	}
	
}
