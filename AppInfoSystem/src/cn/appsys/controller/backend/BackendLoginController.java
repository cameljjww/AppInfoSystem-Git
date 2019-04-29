package cn.appsys.controller.backend;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.service.backend.BackendUserService;

@Controller
@RequestMapping(value="/backendLogin")
public class BackendLoginController {
	private Logger logger = Logger.getLogger(BackendLoginController.class);
	
	@Resource
	private BackendUserService bService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("BackendLoginController ================== login跳转成功");
		return "backendlogin";
	}
}
