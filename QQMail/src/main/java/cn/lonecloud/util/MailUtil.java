package cn.lonecloud.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.lonecloud.cfg.Constants.ExceptionConstants;
import cn.lonecloud.exception.MailException;
import cn.lonecloud.model.Department;

import com.alibaba.fastjson.JSON;

/**
 * QQ企业邮箱
 * 
 * @Title: MailUtil.java
 * @Package cn.lonecloud.util
 * @Description:
 * @author lonecloud
 * @date 2017年1月20日 下午9:32:54
 */
public class MailUtil {

	private static MailCfg cfg = MailCfg.getInstance();

	private static final Logger log = LoggerFactory.getLogger(MailUtil.class);

	/**
	 * 获取授权码
	 * 
	 * @Description:
	 * @return
	 */
	public static String getTokenKey() {
		String url = cfg.getMailURL() + "gettoken";
		Map<String, String> params = new HashMap<String, String>();
		params.put("corpid", cfg.getCorpId());
		params.put("corpsecret", cfg.getContactsSecret());
		String json = HttpRequest.sendGet(url, params);
		if (log.isDebugEnabled()) {
			log.debug(json);
		}
		Map map = JSON.parseObject(json);
		Object token = map.get("access_token");
		if (token == null) {
			throw new MailException(ExceptionConstants.ACCESSERR);
		}
		return token.toString();
	}

	/**
	 * 获取部门列表
	 * 
	 * @Description:
	 * @param id
	 *            部门Id
	 * @return
	 */
	public static List<Department> getDepartment(String id) {
		String tokenKey = getTokenKey();
		String url = cfg.getMailURL() + "department/list";
		Map<String, String> params = new HashMap<>();
		if (tokenKey != null) {
			params.put("access_token", tokenKey);
			params.put("id", id);
			String json = HttpRequest.sendGet(url, params);
			if (json.contains("ok")) {
				json = json.substring(json.indexOf("["), json.indexOf("]") + 1);
			}
			List<Department> departments = JSON.parseArray(json,
					Department.class);
			if (log.isDebugEnabled()) {
				for (Department department : departments) {
					log.debug(department.toString());
				}
			}
			return departments;
		}
		return null;
	}

	/**
	 * 更新某个部门
	 * 
	 * @Description:
	 * @param department
	 */
	public static void updateDepartment(Department department) {
		if (department == null) {
			throw new MailException("");
		}
	}
}
