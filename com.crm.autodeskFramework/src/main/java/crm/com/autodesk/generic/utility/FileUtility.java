package crm.com.autodesk.generic.utility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author iqbal
 * @param key
 * @return
 * @throws IOException
 */

public class FileUtility {
	/**
	 * it is used to fetch the data from common.properties.
	 */
	public String getPropertyFile(String key) throws Throwable {
		FileInputStream  fis=new FileInputStream("./src/test/resources/Commondata/common.properties");
		Properties prob=new Properties();
		prob.load(fis);
		String value =prob.getProperty(key);
		return value;
	}

}
