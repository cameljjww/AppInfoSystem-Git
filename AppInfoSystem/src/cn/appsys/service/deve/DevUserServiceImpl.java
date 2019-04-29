package cn.appsys.service.deve;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	
	@Override
	public Map<String,Object> devLogin(String devCode, String devPassword) throws Exception {
		Map<String,Object> map = new HashMap<>();
		DevUser user = null;
		String exit = "noexit";
		user = mapper.getDevLogin(devCode);
		//匹配密码
		if(null != user){
			exit = "exit";
			if(!user.getDevPassword().equals(devPassword))
				user = null;	
		}
		map.put("exit", exit);
		map.put("user", user);
		return map;
	}
}
