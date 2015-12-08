package state;
public enum UserRole {
	EXPRESSMAN("快递员"), OFFICEMAN("营业厅业务员"), TRANSITCENTERMAN("中转中心业务员"), 
	INVENTORYMAN("仓库管理人员"), MANAGER("总经理"), ADFINANCEMAN("高级财务人员"), GEFINACEMAN("普通财务人员");
	
	private String name;
	
	private UserRole(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
 }
