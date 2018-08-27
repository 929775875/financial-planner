package com.niudingfeng.financialplanner.utils;

  
/**        
 * Title: 字符串工具类    
 * @author lin
 * @created 2018年8月22日 下午5:15:29
 */      
public class StringUtil {
	  
	/**     
	 * @description 给定字符串是否为空或空串
	 * @author lin
	 * @created 2018年8月22日 下午5:15:46
	 * @param str
	 *
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && str.length() != 0) {
			return true;
		}
		return false;
	}

	/**     
	 * @description 给定字符串是否为空或空串
	 * @author lin
	 * @created 2018年8月22日 下午5:15:46
	 * @param str
	 *
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.length() != 0) {
			return false;
		}
		return true;
	}
}
