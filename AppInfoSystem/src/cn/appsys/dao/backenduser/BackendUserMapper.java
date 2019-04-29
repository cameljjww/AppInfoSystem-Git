package cn.appsys.dao.backenduser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface BackendUserMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getBackedLogin(@Param("devCode")String devCode)throws Exception;
}
