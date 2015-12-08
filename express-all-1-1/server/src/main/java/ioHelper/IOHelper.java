/**
 * @author 谭琼
 * 2015年11月30日
 */
package ioHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class IOHelper {
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;

	// 读取文件中的所有内容
	public Hashtable readFromFile(File file) {
		try {
			//文件不存在，新建一个空文件
			if (!file.exists()) {
					FileOutputStream out = new FileOutputStream(file);
					ObjectOutputStream objectOut = new ObjectOutputStream(out);
					Hashtable InfoTabel = new Hashtable();
					objectOut.writeObject(InfoTabel);
					objectOut.close();
					out.close();
			}

			inOne = new FileInputStream(file);
			inTwo = new ObjectInputStream(inOne);
			Hashtable InfoTabel = (Hashtable) inTwo.readObject();
			inOne.close();
			inTwo.close();
			return InfoTabel;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 重写文件
	public boolean writeToFile(Hashtable InfoTabel, File file) {
		try {
			outOne = new FileOutputStream(file);
			outTwo = new ObjectOutputStream(outOne);
			outTwo.writeObject(InfoTabel);
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
