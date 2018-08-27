package com.niudingfeng.financialplanner.annotation;

import java.lang.annotation.*;


/**        
 * Title:自定义注解     
 * Description: 标识是否忽略REST安全性检查
 * @author lin
 * @created 2018年8月22日 下午4:25:32
 */      
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented
public @interface IgnoreSecurity {

}
