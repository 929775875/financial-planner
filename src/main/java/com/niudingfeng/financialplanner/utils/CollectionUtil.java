package com.niudingfeng.financialplanner.utils;

import java.util.Collection;


/**        
 * Title: Collection 工具类    
 * Description: 
 * @author lin
 * @created 2018年8月22日 下午5:14:01
 */      
public class CollectionUtil {
	public static boolean isNotEmpty(Collection<?> c){
		if (c != null && c.size() != 0 ) {
			return true;
		}
		return false;
	}
}
