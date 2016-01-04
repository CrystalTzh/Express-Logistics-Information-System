
/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum Shelf {
	AShelf("A架"), BShelf("B架"), CShelf("C架"), DShelf("D架");

	private String shelf;

	private Shelf(String shelf) {
		this.shelf = shelf;
	}

	public String toString() {
		return shelf;
	}

	/**
	 * 通过字符串获取shelf
	 * @param str
	 * @return
	 */
	public static Shelf getbyStr(String str) {
		if (str.equals(AShelf.toString())) {
			return AShelf;
		} else if (str.equals(BShelf.toString())) {
			return BShelf;
		} else if (str.equals(CShelf.toString())) {
			return CShelf;
		} else {
			return DShelf;
		}
	}
	
	/**
	 * 通过数字获取shelf
	 * @param index
	 * @return
	 */
	public static Shelf getbyIndex(int index) {
		if(index == 0) {
			return AShelf;
		} else if(index == 1) {
			return BShelf;
		} else if(index == 2) {
			return CShelf;
		} else if(index == 3) {
			return DShelf;
		}
		return null;
	}
}
