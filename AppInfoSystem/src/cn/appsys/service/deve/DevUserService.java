package cn.appsys.service.deve;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	/**
	 * 用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser devLogin(String devCode,String devPassword) throws Exception;
}
