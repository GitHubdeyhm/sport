package com.sport.util;

import java.util.UUID;

/**
 * 字符串处理工具类
 * @Date 2016-8-4 下午11:32:07
 */
public class StringUtil {
	/**
	 * hibernate的hql语句需要转义的特殊字符。
	 * 对于jdbc方式的sql语句待测试。
	 */
	private static final String hqlEscape = "_,%";
    /** 下划线字符 */
    private static final char UNDERLINE = '_';

	/**
	 * 判断一个字符串数组中是否存在至少一个元素为null或者空字符串。存在返回true，否则为false。
	 * @Date 2016-8-4下午11:33:25
	 * @param str 字符串数组
	 * @return 存在null或者空字符串返回true，否则为false。
	 */
	public static boolean isAnyNullOrEmpty(String... str) {
		for (String s : str) {
			if ((s == null) || (s.length() == 0)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 将hql特殊字符转义,默认转义字符为：\，可以通过escape关键字指定转义字符，escape关键字
	 * 只能用于模糊查询（like），不适用=号。
	 * 				特殊字符： _、%
	 * @Date 2016-8-4下午11:33:25
	 * @param escapeStr ：要转义的字符串
	 * @return ：转义后的字符串
	 */
	public static String hqlEscape(String escapeStr) {
		if (!isNullOrEmpty(escapeStr)) {
			//得到要转义的sql特殊字符
			for (String es : hqlEscape.split(",")) {
				escapeStr = escapeStr.replace(es, "/"+es);
			}
		}
		return escapeStr;
	}
	/**
	 * 得到随机生成的32位UUID值
	 * @Date 2016-8-4下午11:33:25
	 * @return ：32位的随机字符串值
	 */
	public static String getUUID() {
		 UUID uuid = UUID.randomUUID();
		 return uuid.toString().replace("-", "");
	}
	
	/**
	 * 如果字符串为null则返回空字符串。
	 * @Date 2017-7-10上午11:52:49
	 * @param str 字符串
	 * @return 如果字符串为null则返回空字符串
	 */
	public static String nonNullString(String str) {
		return (str == null) ? "" : str;
	}

	/**
	 * 判断一个字符串是否为null或者空字符串或者去除前后空格字符后为空。
	 * @Date 2016-8-4下午11:33:25
	 * @param str 字符串对象
	 * @return 为null或者空字符串或者去除前后空格字符后为空返回true，否则返回false。
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null ||  str.trim().length() == 0;
	}

	/**
	 * 将下划线命名规则转换为驼峰写法，常用于将数据库的字段名映射为java字段名。示例：
     * user_name -> userName    password ->password
	 * @date 2017-09-03 16:30
	 */
	public static String toCamelCaseName(String str) {
		int len = (str == null) ? 0 : str.length();//null或空字符串""
        if (len == 0) return str;
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == UNDERLINE) {
                i++;
                if (i < len) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
	}

    /**
     * 将驼峰命名规则转换为下划线写法，常用于将数据库的字段名映射为java字段名。示例：
     * userName -> user_name    password ->password
     * @date 2017-09-03 16:30
     */
    public static String toUnderlineName(String str) {
        int len = (str == null) ? 0 : str.length();//null或空字符串""
        if (len == 0) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 获取字符串的长度，如果字符串为空返回0
     * @date 2017-10-04 15:29
     * @return 如果字符串为空返回0
     */
    public static int getLength(String str) {
        return str == null ? 0 : str.length();
    }


	public static void main(String[] args) {
		System.out.println(hqlEscape("/&&_%%"));
		
		System.out.println(isNullOrEmpty(""));
		System.out.println(isNullOrEmpty(null));
		System.out.println(isNullOrEmpty("   "));
		System.out.println(isNullOrEmpty("sdf"));
		System.out.println(isNullOrEmpty(" dsf s  "));
		
	    System.out.println(getUUID());
	    
	    String s = "from dd from";
	    System.out.println(s.substring(s.indexOf("from")));

        System.out.println("-------------------------------");
        String[] name = {"userName", "user_name", "user_"};
        for (String i : name) {
            System.out.println(toCamelCaseName(i));
        }
        for (String i : name) {
            System.out.println(toUnderlineName(i));
        }
	}
}
