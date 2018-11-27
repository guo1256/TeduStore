package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMd5 {
	@Test
	public void testString() {
		String str1 = "123456";
		String str2 = "123456";
		//获取消息摘要
		String md5Str1 = DigestUtils.md5Hex(str1);
		String md5Str2 = DigestUtils.md5Hex(str2);
		System.out.println(md5Str1);
		System.out.println(md5Str2);
	}
	
	@Test
	public void testFile() throws FileNotFoundException, IOException {
		String md5Str1 =
				DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		String md5Str2 =
				DigestUtils.md5Hex(new FileInputStream("pom2.xml"));
		System.out.println(md5Str1);
		System.out.println(md5Str2);
	}
	
	@Test
	public void testSalt() {
		String str = "123456";
		String salt = "大家好。我西古田了";
		System.out.println(DigestUtils.md5Hex(str+salt));
		System.out.println(DigestUtils.md5Hex(str));
	}
}
