package cn.lonecloud.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailCfg {
	
	private final static String RESOURCENAME="mail.properties";
	
	private MailCfg() {
		InputStream is=this.getClass().getResourceAsStream(RESOURCENAME);
		if (is==null) {
			try {
				throw new FileNotFoundException("没有找到资源文件");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Properties properties=new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private final static MailCfg MAIL_CFG=new MailCfg();
	/**
	 * 邮箱请求地址
	 */
	private String mailURL;
	/**
	 * 企业唯一标示Id
	 */
	private String corpId;
	/**
	 * 通讯录密钥
	 */
	private String contactsSecret;

	public String getMailURL() {
		return mailURL;
	}

	public void setMailURL(String mailURL) {
		this.mailURL = mailURL;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getContactsSecret() {
		return contactsSecret;
	}

	public void setContactsSecret(String contactsSecret) {
		this.contactsSecret = contactsSecret;
	}
	
	public static MailCfg getInstance(){
		return MAIL_CFG;
	}
}
