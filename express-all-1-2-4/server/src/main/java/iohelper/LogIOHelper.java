/**
 * @author 谭琼
 * 2015年12月16日
 */
package iohelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.LogPO;

/**
 * 日志文件读写
 */
public class LogIOHelper {
	
	// 读取文件中的所有内容
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	
	@SuppressWarnings("unchecked")
	public ArrayList<LogPO> readFromFile(File file) {
		//文件不存在，新建一个空文件
		try {
			if(!file.exists()) {
				FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream objectOut = new ObjectOutputStream(out);
				ArrayList<LogPO> logInfo = new ArrayList<LogPO>();
				objectOut.writeObject(logInfo);
				objectOut.close();
				out.close();
			}
				inOne = new FileInputStream(file);
				inTwo = new ObjectInputStream(inOne);
				ArrayList<LogPO> logInfo = (ArrayList<LogPO>) inTwo.readObject();
				System.out.println(logInfo.size()+"日志条目");
				inOne.close();
				inTwo.close();
				return logInfo;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//重写文件
	public boolean writeToFile(ArrayList<LogPO> logInfo, File file) {
		
		try {
			outOne = new FileOutputStream(file);
			outTwo = new ObjectOutputStream(outOne);
			outTwo.writeObject(logInfo);
			outTwo.close();
			outOne.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
