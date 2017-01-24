package cn.lonecloud.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.lonecloud.util.HttpRequest;
import cn.lonecloud.util.MailUtil;

public class URLTest {

	private Map<String, String> params=new HashMap<>();

	@Test
	public void getTest(){
		String sendGet = HttpRequest.sendGet("http://www.baidu.com", params);
		System.out.println(sendGet);
	}
	@Test
	public void postTest(){
		String sendPost = HttpRequest.sendPost("http://www.baidu.com", params);
		System.out.println(sendPost);
	}
	@Test
	public void getTokenKey(){
		MailUtil.getTokenKey();
	}
	@Test
	public void getDepartment(){
		MailUtil.getDepartment("1");
	}
}
