package cn.appsys.controller.backend;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value="/backend")
public class BackendLoginController {
	private Logger logger = Logger.getLogger(BackendLoginController.class);
	
	@Resource
	private BackendUserService bService;
	//跳转到登录页面
	@RequestMapping("/login")
	public String login() {
		logger.debug("BackendUserService ================== login跳转");
		return "backendlogin";
	}
	//doLogin  Start
	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam("userCode")String userCode,
						@RequestParam("userPassword")String userPassword,
						HttpServletRequest request,
						HttpSession session){
		logger.debug("BackendLoginController ================== doLoginStart");
		Map<String,Object> map = new HashMap<>();
		BackendUser user = null;
		String exit = null;
		try {
			map = bService.backedLogin(userCode, userPassword);
			user = (BackendUser) map.get("user");
			exit = (String) map.get("exit");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(exit.equals("noexit")) {
			request.setAttribute("error", "用户不存在");
			return "backendlogin";
		}else {
			if(null != user) {
				session.setAttribute(Constants.USER_SESSION, user);
				return "redirect:backend/main";
						
			}else {
				request.setAttribute("error","密码不正确");
				return "backendlogin";
			}
		}
	}
	//验证session进入系统
	@RequestMapping("main")
	public String main(HttpSession session) {
		if(session.getAttribute(Constants.USER_SESSION) == null) {
			return "redirect:/backend/login";		
		}
		logger.debug("BackendUserService================================= 用户名字或者密码不正确");
		return "backendlogin/main";
	}
	//清除sesison退出系统
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		logger.debug("BackendUserService================================= doLoginOUT");
		//清除session
		session.removeAttribute(Constants.USER_SESSION);
		return "backendlogin";
	}
}
