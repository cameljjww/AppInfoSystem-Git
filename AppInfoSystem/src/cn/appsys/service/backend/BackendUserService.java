package cn.appsys.service.backend;

import java.util.Map;





public interface BackendUserService {
	/**
	 * 
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object>backedLogin( String userCode,String userPassword )throws Exception;
}
