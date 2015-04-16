package com.env.commons.utils;

/**  
 * Description: <类功能描述-必填> 
 * Copyright:   Copyright (c)2012  
 * Company:     GreenDB 
 * @author:     cyx  
 * @version:    1.0  
 * Create at:   2012-12-21 下午4:22:51  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2012-12-21   cyx      1.0       如果修改了;必填  
 */ 

import java.math.BigDecimal;
import java.text.NumberFormat;
 



/**
 * 数字格式化工具类
 * 〈功能详细描述〉
 *
 * @author cyx
 * @version [版本号, 2012-12-18]


 */
public class NumberFormatUtils {
/**
 * 
 */
private  static   NumberFormat nf=null;

     static{
        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
     }
     
     
    /**
     * BigDecimal转换成String
     * 〈功能详细描述〉
     *
     * @param data
     * @return
    
     */
    public static String format(BigDecimal data){
        return  nf.format(data); 
    }
}

