package yufei.crm.utils;

import java.util.UUID;


public class UploadUtils {
	public static String getUUIDName(String uploadFileName) {
		String hz = uploadFileName.substring(uploadFileName.lastIndexOf("."));
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		
		return name+hz;
	}
	
	public static String getPath() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		char[] cs = uuid.substring(0,8).toCharArray();
		String path ="/";
		for (char c : cs) {
			path +=c+"/";
		}
		
		return path;
	}
	
	

	
}
