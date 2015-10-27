package com.bx.common.constant;

public class Const {
	
	public static int ZORO = 0;
	public static int PAGESIZE = 10;
	public static int FILE_SIZE=16*1024;
	public static int APPID = 150525;
	public static String USER_INFO = "userinfo";
	public static String STAFF_INFO = "staffinfo";
	
	
	
	public static int CAP_EXPRISE_MINITE = 30;
	
	/**
	 * 预约中
	 */
	public static String ORDER_STATUS_0 = "0";
	/**
	 * 代步中
	 */
	public static String ORDER_STATUS_1 = "1";
	/**
	 * 已完成
	 */
	public static String ORDER_STATUS_2 = "2";
	/**
	 * 已取消
	 */
	public static String ORDER_STATUS_3 = "3";
	
	/**
	 * 身份验证
	 */
	public static String ORDER_TYPE_0 = "0";
	/**
	 * 预约
	 */
	public static String ORDER_TYPE_1 = "1";
	/**
	 * 充值
	 */
	public static String ORDER_TYPE_2 = "2";
	
	/**
	 * 预授权金额
	 */
	public static int PRE_AUTH_MONEY=3000;
	
	/**
	 * 绑定身份预授权金额
	 */
	public static int PRE_AUTH_MONEY_BIND=1;
	
	/**
	 * 验证码短信
	 */
	public static String SMS_CAP = "TPL_SMS_CAP";
	/**
	 * 密码短信
	 */
	public static String SMS_PASSWORD = "TPL_SMS_PASSWORD";
	/**
	 * 预约码短信
	 */
	public static String SMS_APPO = "TPL_SMS_APPO";
	
	/**
	 * 未删除
	 */
	public static String DEL_FLG_ACTIVE = "0";
	/**
	 * 已删除
	 */
	public static String DEL_FLG_INACTIVE = "1";
	
	public static String E001 = "E001";
	public static String E002 = "E002";
	public static String E003 = "E003";
	public static String E004 = "E004";
	public static String E005 = "E005";
	public static String E006 = "E006";
	public static String E007 = "E007";
	public static String E008 = "E008";
	public static String E009 = "E009";
	public static String E010 = "E010";
	public static String E016 = "E016";
	public static String E500 = "E500";

	public static String I001 = "I001";
	public static String I002 = "I002";
	public static String I003 = "I003";

	public static String C001 = "C001";
	public static String C002 = "C002";
	public static String C003 = "C003";
	
	//工程绝对路径
	public static String REAL_PATH = System.getProperty("iyobo.root");
}
