package com.cms.service.userCenter.util;
import java.text.DecimalFormat;

public class MoneyUtils {
	private static String ls_number[] = {
        "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static String ls_flag[] = {
        "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元", "角", "分"};
    private static String lz_flag[] = {
        "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "张"};

    private MoneyUtils() {
    }
    
    /**
     * 将金额转化成大写
     * @param aje
     * @return
     */
    public static String toUpper(double aje) {
        String ls_money = "";
        String ls_chinese = "";
        if (aje < 0.001)return "零元整";
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        df.applyPattern("#.00");
        ls_money = df.format(aje);
        ls_money = StringTokenizer2.replace(ls_money, ".", "");

        int li_len = ls_money.length();
        int offsize = 14 - li_len;
        if (li_len > 14 || li_len == 0) {
            return "";
        }
        else {
            for (int i = 0; i < li_len; i++) {
                int x = Integer.parseInt(ls_money.substring(i, i + 1));
                ls_chinese = ls_chinese + ls_number[x] + ls_flag[offsize + i];
            }
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零仟", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零佰", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零拾", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零亿", "亿");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零万", "万");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "亿万", "亿零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零元", "元");
            if (ls_chinese.indexOf("零角") > -1) {
                ls_chinese = StringTokenizer2.replace(ls_chinese, "零角", "零");
            }
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            if (ls_chinese.indexOf("零分") > -1) {
                ls_chinese = StringTokenizer2.replace(ls_chinese, "零分", "整");
            }
            return ls_chinese;
        }
    }
    
    /**
     * 将整数数字转化成大写
     * @param aje
     * @return
     */
    public static String toUpperTool(String aje) {
        String ls_chinese = "";
        int li_len = aje.length();
        int offsize = 12 - li_len;
        if (li_len > 9 || li_len == 0) {
            return "";
        }
        int intvalue = Integer.parseInt(aje);
        if ( intvalue==0)return "零张";
        else {
            for (int i = 0; i < li_len; i++) {
                int x = Integer.parseInt(aje.substring(i, i + 1));
                ls_chinese = ls_chinese + ls_number[x] + lz_flag[offsize + i];
            }
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零仟", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零佰", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零拾", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零亿", "亿");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零万", "万");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "亿万", "亿零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零零", "零");
            ls_chinese = StringTokenizer2.replace(ls_chinese, "零张", "张");
            return ls_chinese;
        }
    }
    
    public static String double2String(double aje) {    	
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        df.applyPattern("#.00");
        return df.format(aje);
    }
    /**
     * 如果金额为0.0时，调用此方法可以防止输出结果为.00的情况
     * @param args
     */
    public static String double2String2(double args){
    	DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
        df.applyPattern("#0.00");
        return df.format(args);
    }
    /**
     * 金额转换为￥123450，这样的样式，并去掉小数点
     */
    public static String toChinaSign(String money){
    	String jine =money;
		int dd111 = jine.indexOf(".");
		int h11 = jine.length() - 1;
		int length11 = jine.length();
		int u11 = h11 - dd111;
		String finalMoney11 = null;
		if ("1".equalsIgnoreCase(String.valueOf(u11))) {
			finalMoney11 = "￥" + jine.substring(0, dd111)
					+ jine.substring(dd111 + 1, dd111 + 2) + "0";
		} else {
			finalMoney11 = "￥" + jine.substring(0, dd111)
					+ jine.substring(dd111 + 1, dd111 + 3);
		}
		return finalMoney11;
    }
}
