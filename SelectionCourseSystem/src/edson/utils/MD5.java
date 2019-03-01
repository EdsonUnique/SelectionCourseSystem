package edson.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.junit.Test;

public class MD5 {
	public static String getMD5(String str) throws Exception {
	 try {
	 // 生成一个MD5加密计算摘要
	 MessageDigest md = MessageDigest.getInstance("MD5");
	 // 计算md5函数
	 md.update(str.getBytes());
	 // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	 // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	 return new BigInteger(1, md.digest()).toString(16);
	 } catch (Exception e) {
		 e.printStackTrace();
		 throw new Exception("服务器出现错误，请稍候尝试");
	 }
	}
	@Test
	public void test() throws Exception{//3b3693121f0e1ae66d6e4308bae82dd2
//		for(int i=36;i<70;i++)
//		System.out.println(MD5.getMD5("15111140"+i));
		System.out.println(MD5.getMD5("123456"));
	}
}
