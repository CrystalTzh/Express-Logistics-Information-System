/**
 * @author 谭琼
 * 2015年12月8日
 */
package po;

import java.io.Serializable;

public class PricePO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	double price;//距离价格常量

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
