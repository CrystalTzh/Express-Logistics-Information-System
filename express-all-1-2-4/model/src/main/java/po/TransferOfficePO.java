/**
 * @author 谭琼
 * 2015年12月11日
 */
package po;

import java.io.Serializable;

import state.City;

/**
 * 中转中心类
 */
public class TransferOfficePO implements Serializable{

	private static final long serialVersionUID = 1L;
	String transferOfficeID;
	City city;
	
	public TransferOfficePO(City city) {
		this.city = city;
	}
	

	public void setTransferOfficeID(String transferOfficeID) {
		this.transferOfficeID = transferOfficeID;
	}

	public String getTransferOfficeID() {
		return transferOfficeID;
	}

	public City getCity() {
		return city;
	}

}
