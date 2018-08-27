package com.niudingfeng.financialplanner.utils;

import java.util.UUID;


/**        
 * Title: 生成UUID    
 * @author lin
 * @created 2018年8月22日 下午5:13:16
 */      
public class CodecUtil {
	
	public static String createUUID(){
		return UUID.randomUUID().toString();
	}
}
