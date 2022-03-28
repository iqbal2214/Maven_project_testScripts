package crm.com.autodesk.generic.utility;

import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	/**
	 * @author iqbal
	 * @return random_number
	 */
public int getRandomNum(){
	/**
	 * it is use to get random number
	 * boundary is 0 to 10000
	 */
	Random r=new Random();
	int rnum=r.nextInt(10000);
	return rnum;
}
/**
 * used to get the system date including time 
 * @author iqbal
 * @return
 */
public String getSystemDateAndTime() {
	Date date=new Date();
	return date.toString();
}

/**
 * it is used to get the System date in YYYY-MM-DD format.
 * @author Iqbal
 * @return
 */
public String getDateWith_YYYYMMDD_format() {
	Date date=new Date();
	String d=date.toString();
	String[] modified = d.split(" ");
	String YYYY=modified[5];
	String DD=modified[2];
	int MM=date.getMonth()+1;
	return YYYY+"-"+MM+"-"+DD;
}

/**
 * it is used to get the System date in DD-MM-YYYY format
 * @author Iqbal
 * @return void
 */
public String getDateWith_DDMMYYYY_format() {
	Date date=new Date();
	String d=date.toString();
	String[] modified = d.split(" ");
	String YYYY=modified[5];
	String DD=modified[2];
	int MM=date.getMonth()+1;
	return DD+"-"+MM+"-"+YYYY;
}

/**
 * used to get the current system time
 * @author Iqbal
 * @return void
 */
public String getCurrentTime() {
	Date date=new Date();
	String d=date.toString();
	String[] modified = d.split(" ");
	String time=modified[3];
	String newtime = time.replace(":", "-");
	return newtime;
}
}
