package com.bx.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.bx.common.constant.Const;

public class StringUtil {
	
	@SuppressWarnings("rawtypes")
	static Pager p = new Pager();
	
	/**
	 * 获取异常的详细信息
	 * @param e 异常
	 * @return 异常的详细信息
	 */
	public static String getExceptionDetail(Exception e) {
		StringBuffer sb = new StringBuffer();
		if(null != e) {
			StackTraceElement[] ste = e.getStackTrace();
			sb.append(e.getMessage() + "\n");
			for (int i = 0; i < ste.length; i++) {
				sb.append(ste[i].toString() + "\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 把密码加密
	 * @param password 输入的密码
	 * @return
	 */
	public static String passwordToMD5(String password) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return (buf.toString());
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	/**
	 * 判断字符串不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}
	
	/**
	 * 判断两字符串是否相等
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		return StringUtils.equals(str1, str2);
	}
	

	

	/**
	 * 获得不带时分秒的系统当前时间
	 * @return
	 */
	public static String systemDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return (sdf.format(new Date())).toString();
	}
	
	/**
	 * 获得系统带时分秒的系统当前时间
	 * @return
	 */
	public static String systemTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	/*
	 * 转换日期为String
	 * 默认格式为yyyy-MM-dd
	 */
	public static String parseDay(Date date,String...format){
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = null;
		if(format.length !=0){
			sdf = new SimpleDateFormat(format[0]);
		}else{
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.format(date);
	}
	/**
	 * 返回两个日期相差的毫秒数
	 * @param before
	 * @param after
	 * @return
	 */
	public static Long dateSub(Date before,Date after){
		
		long diff = after.getTime() - before.getTime();
		return diff;
		
	}
	/**
	 * 获得当前月的第一天
	 * @return
	 */
	public static Long firstDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance(Locale.CANADA);
		c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));
		return Long.parseLong(sdf.format(c.getTime()));
	}
	
	/**
	 * 获得当前年的一月一号
	 * @return
	 */
	public static Long yearFirstDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance(Locale.CANADA);
		c.set(Calendar.DAY_OF_YEAR, c.getMinimum(Calendar.DAY_OF_YEAR));
		return Long.parseLong(sdf.format(c.getTime()));
	}
	
	public static void uploadFile(String realPath,MultipartFile src) throws IllegalStateException, IOException{
		File dest = new File(realPath);
		if(dest.exists()){//若果上传的文件已存在，重新编名？覆盖？
			
		}
		src.transferTo(dest);
	}
	
	/**
	 * 上传多个文件到项目
	 * @param uploadPath 上传的路径
	 * @param upFiles 上传的文件
	 * @param upFileFileName 上传的文件名
	 */
	public static void uploadFiles(String uploadPath, List<File> upFiles, List<String> upFilesFileName) {
		for(int i = 0 ; i < upFiles.size() ; i++) {
			//创建一个文件输入流
			InputStream is = null;
			//创建一个输出流
			OutputStream os = null;
			try{
				is = new FileInputStream(upFiles.get(i));
				//设置目标文件   
				File toFile = new File(uploadPath, upFilesFileName.get(i));   
				os = new FileOutputStream(toFile);  
				//设置缓存   
				byte[] buffer = new byte[Const.FILE_SIZE];
				int count = Const.ZORO;
				//读取upFile文件输出到toFile文件中   
				while ((count = is.read(buffer)) > Const.ZORO) {   
				    os.write(buffer, Const.ZORO, count);   
			    }  
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 根据某个路径下文件下载文件
	 * @param filePath 文件的路径
	 * @param fileName 文件的名称
	 */
	public static void downFile(String filePath, String fileName,HttpServletResponse response) {
		FileInputStream fis = null;
		OutputStream out = null;
		if(StringUtil.isNotEmpty(fileName) && StringUtil.isNotEmpty(filePath)) {
			try {
				//fileName = java.net.URLDecoder.decode(fileName,"UTF-8");
				fileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
				fis = new FileInputStream(new File(filePath));
				//设置响应头和保存文件名
				response.setContentType("application/x-download");   
				response.addHeader("Content-Disposition","attachment;filename=" + fileName);
				//写出流信息
				int b = Const.ZORO;
				out = response.getOutputStream();
				byte [] buf = new byte[1024];
				while(-1 != (b = fis.read(buf))) {
					out.write(buf,0,b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 直接下载文件
	 * @param fileName 下载文件的文件名
	 */
	public static void downFileByName(String fileName,HttpServletResponse response) {
		FileInputStream fis = null;
		PrintWriter out = null;
		if(StringUtil.isNotEmpty(fileName)) {
			try {
				fileName = java.net.URLDecoder.decode(fileName,"UTF-8");
				fis = new FileInputStream(new File(fileName));
				//设置响应头和保存文件名
				response.setContentType("application/x-download");   
				response.addHeader("Content-Disposition","attachment;filename=" + fileName);
				//写出流信息
				int b = Const.ZORO;
				out = response.getWriter();
				while((b=fis.read()) != -1) {
					out.write(b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 获取文件的扩展名
	 * @param fileName 文件的名称
	 * @return
	 */
	public static String getExtension(String fileName) {
		return fileName.lastIndexOf(".") == -1?"" : fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	/**
	 * 解析excel文件
	 * @param input 文件输入流
	 * @param file 文件
	 * @return
	 */
	public static List<Cell[]> readExcel(File file){   
        try{   
           List<Cell[]> list = new ArrayList<Cell[]>();
           Workbook wb = null;
           String fileName = file.getName();
           String extension = getExtension(fileName);
           InputStream input = new FileInputStream(file);
           if("xls".equals(extension)) {
        	   wb = new HSSFWorkbook(input);
           }
           if("xlsx".equals(extension)) {
        	  wb = new XSSFWorkbook(input);
           }
           Sheet st = wb.getSheetAt(0);  //读取sheet的第一个工作表   
           int rows = st.getLastRowNum() + 1;//总行数   
           int cols;//总列数   
           for(int i=0;i<rows;i++){   
        	   Cell[] cells = null;
               Row row = st.getRow(i);//读取某一行数据   
               if(null != row){   
                  //获取行中数据个数
                  cols = row.getLastCellNum();   
                  cells = new Cell[cols];
                  for(int j=0;j<cols;j++){   
                     cells[j] = row.getCell(j);
                  }   
               }   
               list.add(cells);
           }  
           return list;
        }catch(IOException e){   
           e.printStackTrace();      
           return null;
        }   
	 }
	
	/**
	 * 转换成三位小数点的浮点数
	 * @param num 被计算的数
	 * @return
	 */
	public static double intToDouble(double num) {
		//格式化小数
		DecimalFormat df = new DecimalFormat("0.000");
		return Double.parseDouble(df.format(num));
	}
	
	public static  Long[] arrayToWrapArray(long[] array){
		if(array != null){
			Long [] arrayWrap = new Long[array.length];
			for (int i=0;i<array.length;i++) {
				arrayWrap[i] = array[i];
			}
			return arrayWrap;
		}
		return null;
	}
	
	public static Date getFirstDayOfLastMonth(Date...date){
		Calendar ca = Calendar.getInstance();
		if(date.length == 1){
			ca.setTime(date[0]);
		}
		ca.set(Calendar.DATE, ca.getActualMinimum(Calendar.DATE));
		ca.add(Calendar.MONTH, -1);
		ca.set(Calendar.SECOND,ca.getActualMinimum(Calendar.SECOND));
		ca.set(Calendar.MINUTE, ca.getActualMinimum(Calendar.MINUTE));
		ca.set(Calendar.HOUR_OF_DAY, ca.getActualMinimum(Calendar.HOUR));
		return ca.getTime();
	}
	
	public static Date getLastDayOfLastMonth(Date...date){
		
		Calendar ca = Calendar.getInstance();
		if(date.length == 1){
			ca.setTime(date[0]);
		}
		ca.set(Calendar.DATE, ca.getActualMaximum(Calendar.DATE));
		ca.add(Calendar.MONTH, -1);
		ca.set(Calendar.SECOND,ca.getActualMaximum(Calendar.SECOND));
		ca.set(Calendar.MINUTE, ca.getActualMaximum(Calendar.MINUTE));
		ca.set(Calendar.HOUR_OF_DAY, ca.getActualMaximum(Calendar.HOUR));
		return ca.getTime();
	}
	
	/**
	 * 获取uuid类型的字符串
	 * @return
	 */
	public static String getUUID() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String urlTrans(String url){
		if(isEmpty(url)){
			return url;
		}
		
		return url.replaceAll("\\&", "%26").replaceAll(" ", "%20").replaceAll("\\/", "%2F")
				.replaceAll("\\?", "%3F").replaceAll("\\%", "%25").replaceAll("\\#", "%23")
				.replaceAll("=", "%3D").replaceAll("\\\r", "%0D").replaceAll("\\\n", "%0A");
		
	}
	
	public static String deUrlTrans(String url){
		if(isEmpty(url)){
			return url;
		}
		
		return url.replaceAll("\\%26", "&").replaceAll("\\%20", " ").replaceAll("\\%2F", "/")
				.replaceAll("\\%3F", "?").replaceAll("\\%25", "%").replaceAll("\\%23", "#")
				.replaceAll("\\%3D", "=").replaceAll("\\%0D", "\r").replaceAll("\\%0A", "\n");
		
		
	}
	/**
	 * 数字转字母
	 * @param num
	 * @return
	 */
	public static String numToLetter(String num){
		
		StringBuffer buffer = new StringBuffer();
		for(byte b : num.getBytes()){
			buffer.append((char)(b + 17));
		}
		return buffer.toString();
	}

	/**
	 * 随机生成数字字符串
	 * @param length
	 * @return
	 */
	public static String randomInt(int length){
		
		StringBuffer buff = new StringBuffer();
		
		Random random = new Random();
		for(int i =0; i < length ;i++){
			buff.append(random.nextInt(10));
		}
		
		return buff.toString();
	}

	/**
	 * 生成随机密码
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}
	
}
