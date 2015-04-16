package com.env.commons.utils;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtil {
	/**
	 * @title 获取格式化的人民币（四舍五入）
	 * @author cyx
	 * @param money
	 *            待处理的人民币
	 * @param scale
	 *            小数点后保留的位数
	 * @param divisor
	 *            格式化值（万，百万，亿等等）
	 * @return
	 */
	public static String getFormatMoney(double money, int scale, double divisor) {
		if (divisor == 0) {
			return "0.00";
		}
		if (scale < 0) {
			return "0.00";
		}
		BigDecimal moneyBD = new BigDecimal(money);
		BigDecimal divisorBD = new BigDecimal(divisor);
		// RoundingMode.HALF_UP = 2
		return moneyBD.divide(divisorBD, scale, RoundingMode.HALF_UP)
				.toString();
	}

	/**
	 * @title 获取会计格式的人民币（四舍五入）——添加会计标识：','
	 * @author cyx
	 * @param money
	 *            待处理的人民币
	 * @param scale
	 *            小数点后保留的位数
	 * @param divisor
	 *            格式化值（万，百万，亿等等）
	 * @return
	 */
	public static String getAccountantMoney(double money, int scale,
			double divisor) {
		String disposeMoneyStr = getFormatMoney(money, scale, divisor);
		// 小数点处理
		int dotPosition = disposeMoneyStr.indexOf(".");
		String exceptDotMoeny = null;// 小数点之前的字符串
		String dotMeony = null;// 小数点之后的字符串
		if (dotPosition > 0) {
			exceptDotMoeny = disposeMoneyStr.substring(0, dotPosition);
			dotMeony = disposeMoneyStr.substring(dotPosition);
		} else {
			exceptDotMoeny = disposeMoneyStr;
		}
		// 负数处理
		int negativePosition = exceptDotMoeny.indexOf("-");
		if (negativePosition == 0) {
			exceptDotMoeny = exceptDotMoeny.substring(1);
		}
		StringBuffer reverseExceptDotMoney = new StringBuffer(exceptDotMoeny);
		reverseExceptDotMoney.reverse();// 字符串倒转
		char[] moneyChar = reverseExceptDotMoney.toString().toCharArray();
		StringBuffer returnMeony = new StringBuffer();// 返回值
		for (int i = 0; i < moneyChar.length; i++) {
			if (i != 0 && i % 3 == 0) {
				returnMeony.append(",");// 每隔3位加','
			}
			returnMeony.append(moneyChar[i]);
		}
		returnMeony.reverse();// 字符串倒转
		if (dotPosition > 0) {
			returnMeony.append(dotMeony);
		}
		if (negativePosition == 0) {
			return "-" + returnMeony.toString();
		} else {
			return returnMeony.toString();
		}
	}

	private final static String[] CN_Digits = { "零", "壹", "貳", "叁", "肆", "伍",
			"陆", "柒", "捌", "玖", };

	/**
	 * @title 将数字型货币转换为中文型货币
	 * @author cyx
	 * @param moneyValue
	 *            字符串形式的金额，小数部分，将多于3位部分舍去，不做四舍五入
	 * @return
	 */
	public static String CNValueOf(String moneyValue) {
		// 使用正则表达式，去除前面的零及数字中的逗号
		String value = moneyValue.replaceFirst("^0+", "");
		value = value.replaceAll(",", "");
		// 分割小数部分与整数部分
		int dot_pos = value.indexOf('.');
		String int_value;
		String fraction_value;
		if (dot_pos == -1) {
			int_value = value;
			fraction_value = "00";
		} else {
			int_value = value.substring(0, dot_pos);
			fraction_value = value.substring(dot_pos + 1, value.length())
					+ "00".substring(0, 2);// 也加两个0，便于后面统一处理
		}

		int len = int_value.length();
		if (len > 16)
			return "值过大";
		StringBuffer cn_currency = new StringBuffer();
		String[] CN_Carry = new String[] { "", "万", "亿", "万" };
		// 数字分组处理，计数组数
		int cnt = len / 4 + (len % 4 == 0 ? 0 : 1);
		// 左边第一组的长度
		int partLen = len - (cnt - 1) * 4;
		String partValue = null;
		boolean bZero = false;// 有过零
		String curCN = null;
		for (int i = 0; i < cnt; i++) {
			partValue = int_value.substring(0, partLen);
			int_value = int_value.substring(partLen);
			curCN = Part2CN(partValue, i != 0 && !"零".equals(curCN));
			// System.out.println(partValue+":"+curCN);
			// 若上次为零，这次不为零，则加入零
			if (bZero && !"零".equals(curCN)) {
				cn_currency.append("零");
				bZero = false;
			}
			if ("零".equals(curCN))
				bZero = true;
			// 若数字不是零，加入中文数字及单位
			if (!"零".equals(curCN)) {
				cn_currency.append(curCN);
				cn_currency.append(CN_Carry[cnt - 1 - i]);
			}
			// 除最左边一组长度不定外，其它长度都为4
			partLen = 4;
			partValue = null;
		}
		cn_currency.append("元");
		// 处理小数部分
		int fv1 = Integer.parseInt(fraction_value.substring(0, 1));
		int fv2 = Integer.parseInt(fraction_value.substring(1, 2));
		if (fv1 + fv2 == 0) {
			cn_currency.append("整");
		} else {
			cn_currency.append(CN_Digits[fv1]).append("角");
			cn_currency.append(CN_Digits[fv2]).append("分");
		}
		return cn_currency.toString();
	}
	/**
	 * @title 将一组数字（不多于四个）转化成中文表示
	 * @author cyx
	 * @param partValue
	 *            字符串形式的数字
	 * @param bInsertZero
	 *            是否在前面添加零
	 * @return
	 */
	private static String Part2CN(String partValue, boolean bInsertZero) {
		// 使用正则表达式，去除前面的0
		partValue = partValue.replaceFirst("^0+", "");
		int len = partValue.length();
		if (len == 0)
			return "零";
		StringBuffer sbResult = new StringBuffer();
		int digit;
		String[] CN_Carry = new String[] { "", "拾", "佰", "仟" };
		for (int i = 0; i < len; i++) {
			digit = Integer.parseInt(partValue.substring(i, i + 1));
			if (digit != 0) {
				sbResult.append(CN_Digits[digit]);
				sbResult.append(CN_Carry[len - 1 - i]);
			} else {
				// 若不是最后一位，且下不位不为零，追加零
				if (i != len - 1
						&& Integer.parseInt(partValue.substring(i + 1, i + 2)) != 0)
					sbResult.append("零");
			}
		}
		if (bInsertZero && len != 4)
			sbResult.insert(0, "零");
		return sbResult.toString();
	}

	public static void main(String[] args) {
		double money = -1269486459.86;
		int scale = 2;
		double divisor = 10000.00;
		System.out.println("原货币值: " + money);
		MoneyUtil util = new MoneyUtil();
		String formatMeony = util.getFormatMoney(money, scale, divisor);
		System.out.println("格式化货币值: " + formatMeony + "万元");
		String accountantMoney = util.getAccountantMoney(money, scale, divisor);
		System.out.println("会计货币值: " + accountantMoney + "万元");
		System.out.println("字符串数字转换为人民币金额: " + CNValueOf("234545.22"));
		System.out.println("字符串数字转换为人民币金额: " + Part2CN("4522",false));
	}

}
