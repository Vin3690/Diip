package helper;

public class ResourceHelper {

	public static String getResourcePath(String path) {
		String Basepath = System.getProperty("user.dir");
		return Basepath + path;
	}

	/*
	 * public static void main(String[] args) { String
	 * path=ResourceHelper.getResourcePath(
	 * "\\src\\main\\resources\\configFiles\\log4j.properties");
	 * System.out.println(path); }
	 */

}
