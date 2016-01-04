/**
 * @author 谭琼
 * 2015年12月17日
 */
package exceptions.rmi;

/**
 * 服务器网络初始化异常类型
 */
public class ServerInitException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param e
	 */
	public ServerInitException(String m) {
		super(m);
	}


}
