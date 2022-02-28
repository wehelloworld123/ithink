package com.fc.ithink.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
* MD5 工具类-建议添油加醋的对入参 str 改造一下
* @author Administrator
*
*/
public class MD5Util {
	static Logger logger = LoggerFactory.getLogger(MD5Util.class);

	//工具类不允许被实例化
	private MD5Util() throws Exception {
		throw new Exception("异常");
	}
	static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };



	/**
	 * GetFileMD5Util.getMD5()<BR>
	 * <P>Author :  zhengxiujiang </P>
	 * <P>Date : 2016年6月2日上午10:07:56</P>
	 * <P>Desc : 生成md5摘要 </P>
	 * @param file
	 * @return
	 */
	public static String getMD5(File file) {
		FileInputStream fis = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			logger.info("MD5摘要长度：" + md.getDigestLength());
			fis = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int length = -1;
			logger.info("开始生成摘要");
			long s = System.currentTimeMillis();
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			logger.info("摘要生成成功,总用时: " + (System.currentTimeMillis() - s) + "ms");
			byte[] b = md.digest();
			return byteToHexString(b);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			try {
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * GetFileMD5Util.byteToHexString()<BR>
	 * <P>Author :  zhengxiujiang </P>
	 * <P>Date : 2016年6月2日上午10:08:17</P>
	 * <P>Desc : 字节数组转16进制 </P>
	 * @param tmp
	 * @return
	 */
	private static String byteToHexString(byte[] tmp) {
		String s;
		// 用字节表示就是 16 个字节
		char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
		// 所以表示成 16 进制需要 32 个字符
		int k = 0; // 表示转换结果中对应的字符位置
		for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
			// 转换成 16 进制字符的转换
			byte byte0 = tmp[i]; // 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
			// >>> 为逻辑右移，将符号位一起右移
			str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		}
		s = new String(str); // 换后的结果转换为字符串
		return s;
	}

	public static String encode(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++){
			byteArray[i] = (byte) charArray[i];
		}

		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}

			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}


	public static void main(String[] args){

		int[][] arr = new int[8][8];
		for(int i =0 ;i <8;i++){
			arr[i][0] = 1;
			int count = 1;
			int a = i;
			int b = 1;
			digui(arr,a,b,count);
		}

	}

	private static void digui(int[][] arr,int a,int b,int count){
		boolean flag = false;
		try {
			for(int i =0 ;i<arr[a].length;i++){
				if(arr[a][i]==1){
					if(b+1<8) {
						digui(arr, a, b + 1, count);
					}else{
						digui(arr, a+1, 0, count);
					}
					flag = true;
				}

				for (int j = 0; j < arr[b].length; i++) {
					if (arr[j][b] == 1) {
						if (a + 1 < 8) {
							digui(arr, a + 1, b, count);
						} else {
							digui(arr, 0, b + 1, count);
						}
						flag = true;
					}

				}

			}
		}catch (Exception e){
			System.out.println("a:"+a);
			System.out.println("b:"+b);
		}
		if(!flag){
			arr[a][b] = 1;
			digui(arr,a+1,b,count+1);
		}
		if(count==8){
			System.out.println(arr);
		}
	}

}
