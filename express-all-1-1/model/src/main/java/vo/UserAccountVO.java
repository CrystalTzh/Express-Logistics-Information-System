package vo;

import java.io.Serializable;

import state.UserRole;

public class UserAccountVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountID;// 账号
	String userName;// 用户名
	String initialPassword;// 初始密码
	String password;// 密码
	UserRole userRole;// 职位
	
	public UserAccountVO() {}
	
	public UserAccountVO(String accountID, String userName,
			String initialPassword, String password, UserRole userRole) {
		this.accountID = accountID;
		this.userName = userName;
		this.initialPassword = initialPassword;
		this.password = password;
		this.userRole = userRole;
	}

	public String getAccountID() {
		return accountID;
	}

	public String getUserName() {
		return userName;
	}

	public String getInitialPassword() {
		return initialPassword;
	}

	public String getPassword() {
		return password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	
}
