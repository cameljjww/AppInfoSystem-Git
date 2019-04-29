package cn.appsys.controller.deve;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.deve.DevUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value="/dev")
public class DevLoginController {
	private Logger logger = Logger.getLogger(DevLoginController.class);
	
	@Resource
	private DevUserService devUserService;
	//跳转到登录页面
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController ================== login跳转");
		return "devlogin";
	}
	//doLogin  Start
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String dologin(@RequestParam("devCode") String devCode,
						@RequestParam("devPassword") String devPassword,
						HttpServletRequest request,
						HttpSession session) {
		logger.debug("LoginController =============doLoginStart");
		DevUser user = null;
		Map<String,Object> map = new HashMap<>();
		String exit =null;
			try {
				map = devUserService.devLogin(devCode, devPassword);
				user = (DevUser) map.get("user");
				exit = (String) map.get("exit");
			} catch (Exception e) {
				e.printStackTrace();
			}
		if(exit.equals("noexit")) {
			request.setAttribute("error", "用户不存在");
			return("devlogin");
		}else {
			if(null != user ) {
				session.setAttribute(Constants.DEV_USER_SESSION, user);
				return "redirect:/dev/main";		
			}else {
				request.setAttribute("error", "密码不正确");
				return("devlogin");
			}
		}	
	}
	//验证session进入系统
	@RequestMapping(value="main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.DEV_USER_SESSION) == null){
			return "redirect:/dev/login";
		}
		logger.debug("LoginController================================= 用户名字或者密码不正确");
		return "developer/main";
	}
	//清除sesison退出系统
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		logger.debug("LoginController================================= doLoginOUT");
		//清除session
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
}

