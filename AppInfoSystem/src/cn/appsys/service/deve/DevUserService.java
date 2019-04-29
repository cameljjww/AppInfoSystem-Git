package cn.appsys.service.deve;

import java.util.Map;


public interface DevUserService {
	/**
	 * 开发者用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public Map<String, Object> devLogin(String devCode,String devPassword) throws Exception;
}
