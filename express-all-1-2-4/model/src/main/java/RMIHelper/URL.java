package RMIHelper;

public class URL {
	
	private static int port = 32004; 
	private static String serverIP = "127.0.0.1";
	
	public static int getPort(){
		return port;
	}
	
	public static String getServerIP() {
		return serverIP;
	}
	
	public static void setServerIP(String ip) {
		serverIP = ip;
	}
	
	public static String getURL(String serviceName) {
//		"rmi://127.0.0.1:32004/priceInfoConstdataService";
		String url = "rmi://" + serverIP + ":" + port + "/" + serviceName;
		return url;
	}
}
