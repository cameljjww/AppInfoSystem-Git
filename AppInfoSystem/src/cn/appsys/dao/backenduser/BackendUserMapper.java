package cn.appsys.dao.backenduser;


import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;
/**
 * 
 * @author 12965
 
 *
 */

public interface BackendUserMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getBackedLogin(@Param("userCode")String userCode)throws Exception;
}
