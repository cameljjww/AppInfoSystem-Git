package cn.appsys.controller.deve;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.service.deve.DevUserService;


@Controller
@RequestMapping(value="/devLogin")
public class DevLoginController {
	private Logger logger = Logger.getLogger(DevLoginController.class);
	
	@Resource
	private DevUserService devUserService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController ================== login跳转成功");
		return "devlogin";
	}
	

}

