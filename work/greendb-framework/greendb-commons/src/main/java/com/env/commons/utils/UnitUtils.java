package com.env.commons.utils;

/**  
 * Description: <类功能描述-必填> 
 * Copyright:   Copyright (c)2014
 * @version:    1.0  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 *       如果修改了;必填  
 */


import java.math.BigDecimal;

/**
 * 单位工具类 用于单位换算等
 * 
 */
public class UnitUtils {

    /**
     * 将重量转换为标准单位KG
     * 
     * @param unitId
     * @param totalNum
     * @return toNum
     */
    public static BigDecimal transformWeight(final int unitId,
	    final BigDecimal totalNum) {
	// 标准单位kg 的unitId为3 2为克 4为吨
	BigDecimal toNum = new BigDecimal(0);
	if (unitId == 3) {
	    toNum = totalNum.setScale(3, BigDecimal.ROUND_HALF_UP);
	}
	// 克
	else if (unitId == 2) {
	    toNum = totalNum.divide(new BigDecimal(1000), 3);
	}
	// 吨
	else if (unitId == 4) {
	    toNum = totalNum.multiply(new BigDecimal(1000));
	}
	// 其他的原路返回
	else {
	    toNum = totalNum.setScale(3, BigDecimal.ROUND_HALF_UP);
	}
	return toNum.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 将体积单位转换为标准单位立方米
     * 
     * @param unitId
     * @param totalNum
     * @return toNum
     */
    public static BigDecimal transformVolume(final int unitId,
	    final BigDecimal totalNum) {
	// 标准单位立方米的unitId为57 11为立方厘米 56为立方尺 58为立方英尺
	BigDecimal toNum = new BigDecimal(0);
	if (unitId == 57) {
	    toNum = totalNum.setScale(3, BigDecimal.ROUND_HALF_UP);
	}
	// 立方厘米
	else if (unitId == 11) {
	    toNum = totalNum.divide(new BigDecimal(1000000), 3);
	}
	// 立方英尺
	else if (unitId == 58) {
	    toNum = (totalNum.multiply(new BigDecimal(0.02831685))).setScale(3,
		    BigDecimal.ROUND_HALF_UP);
	}
	// 立方尺
	else if (unitId == 56) {
	    toNum = totalNum.divide(new BigDecimal(35.314667), 3);
	} else {
	    toNum = totalNum.setScale(3, BigDecimal.ROUND_HALF_UP);
	}
	return toNum.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

}
