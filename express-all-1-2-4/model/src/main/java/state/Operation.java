/**
 * @author 谭琼
 * 2015年12月16日
 */
package state;

/**
 * 各种类型的操作的常量
 */
public enum Operation {
	ADD("增加"), DELETE("删除"), MODIFY("修改"), FIND("查找"), WITHDEAR("撤销");
	
	private String op;
	
	private Operation(String operation) {
		this.op = operation;
	}
	
	public String toString() {
		return op;
	}
}
