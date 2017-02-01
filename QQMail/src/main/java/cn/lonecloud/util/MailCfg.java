package cn.lonecloud.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.lonecloud.cfg.Constants.ExceptionConstants;
import cn.lonecloud.exception.MailException;

public class MailCfg {

	private final static String RESOURCENAME = "/mail.properties";

	private MailCfg() {
		setProperty(RESOURCENAME);
	}
	private final static MailCfg MAIL_CFG = new MailCfg();
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

	public static MailCfg getInstance() {
		return MAIL_CFG;
	}
	/**
	 * 设置配置信息
	 * @Description: 
	 * @param path
	 */
	private void setProperty(String path) {
		InputStream is = this.getClass().getResourceAsStream(path);
		if (is == null) {
			throw new MailException(ExceptionConstants.SOURCENOTFOUND);
		}
		Properties properties = new Properties();
		try {
			properties.load(is);
			mailURL = properties.getProperty("mailURL");
			corpId = properties.getProperty("corpId");
			contactsSecret = properties.getProperty("contactsSecret");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MailException(ExceptionConstants.LOADFILEERR);
		}
	}
}
