/**
 * @author 陶子涵
 * 2016/1/2
 */
package state;

public enum Transportation {

	COLLECTED("已揽件"),SENDEROFFICEARRIVED("到达寄件人城市营业厅"),SENDERRELAYARRIVED("到达寄件人城市中转中心"),
	RECEIVERRELAYARRIVED("到达收件人城市中转中心"),RECEIVEROFFICEARRIVED("到达收件人城市营业厅"),SENDING("派件中"),TRANFERING("中转中");	
	
	private String transportation;
	
	private Transportation(String transportation){
		this.transportation = transportation;
	}
	
	public String toString(){
		return transportation;
	}
	
//	public static Transportation transpoatationByStr(String str){
//		if(str.equals(COLLECTED.toString())){
//			return COLLECTED;
//		}
//		return null;
//	}
	
}
