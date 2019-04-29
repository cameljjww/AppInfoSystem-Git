package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;
import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getDevLogin(@Param("devCode")String devCode)throws Exception;
}
