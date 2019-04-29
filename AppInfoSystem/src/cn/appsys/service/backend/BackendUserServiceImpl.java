package cn.appsys.service.backend;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backenduser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;



@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	BackendUserMapper mapper = null;
	@Override
	public Map<String, Object> backedLogin(String userCode,String userPassword ) throws Exception {
		Map<String , Object> map = new HashMap<>();
		BackendUser user = null;
		String exit = "noexit";
		user = mapper.getBackedLogin(userCode);
		if(null != user) {
			exit = "exit";
			if(! userPassword.equals(user.getUserPassword())) {
				user = null;
			}
		}
		map.put("exit", exit);
		map.put("user", user);
		return map;
	}
	

}
