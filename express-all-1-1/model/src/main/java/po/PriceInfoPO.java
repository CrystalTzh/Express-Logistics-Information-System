/**
 * 持久化对象包
 * @author 谭琼
 * 2015年12月4日
 */
package po;

import java.io.Serializable;

/**
 * 价格常量持久化对象
 */
public class PriceInfoPO implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	String price;//价格常量
	
	public PriceInfoPO() {}
	
	public PriceInfoPO(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
