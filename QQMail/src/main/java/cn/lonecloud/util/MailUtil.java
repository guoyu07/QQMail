package cn.lonecloud.util;

import java.util.HashMap;
import java.util.Map;

/**
 * QQ企业邮箱
 * @Title: MailUtil.java
 * @Package cn.lonecloud.util
 * @Description: 
 * @author lonecloud
 * @date 2017年1月20日 下午9:32:54
 */
public class MailUtil {
	
	private static MailCfg cfg=MailCfg.getInstance();
	
	
	public static String getTokenKey(){
		String url=cfg.getMailURL()+"gettoken";
		Map<String, String> params=new HashMap<String, String>();
		String json = HttpRequest.sendGet(url, params);
		System.out.println(json);
		return null;
	}
}
