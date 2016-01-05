/**
 * @author 谭琼
 * 2015年12月14日
 */
package vo;

import java.io.Serializable;

import state.City;

public class TransferOfficeVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String transferOfficeID;
	City city;
	
	public TransferOfficeVO() {} 
	
	public TransferOfficeVO(City city) {
		this.city = city;
	}

	public void setTransferOfficeID(String transferOfficeID) {
		this.transferOfficeID = transferOfficeID;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getTransferOfficeID() {
		return transferOfficeID;
	}

	public City getCity() {
		return city;
	}
	
}
