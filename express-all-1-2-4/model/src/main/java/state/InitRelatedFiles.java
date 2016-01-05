/**
 * @author 谭琼
 * 2015年12月21日
 */
package state;

/**
 * 期初建账设计的文件名常量
 */
public enum InitRelatedFiles {
	//营业厅基本信息，中转中心基本信息、仓库库存基本信息
	OFFICEINFO("营业厅基本信息.txt"), TRANSFEROFFICEINFO("中转中心基本信息.txt"), INVENTOTYINFO("仓库库存基本信息.txt"),
	//司机基本信息、车辆基本信息、用户账户基本信息
	DRIVERINFO("司机基本信息.txt"), CARINFO("车辆基本信息.txt"), USERACCOUNTNFO("用户账户基本信息.txt"),
	//银行账户基本信息
	BANKACCOUNTINFO("银行账户基本信息.txt");
	
	private String fileName;
	private InitRelatedFiles(String fileName) {
		this.fileName = fileName;
	}
	
	public String toString() {
		return fileName;
	}
}
