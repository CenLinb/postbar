package com.chinasofti.postbar.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.postbar.basic.controller.BasicController;
import com.chinasofti.postbar.dto.AudioDto;
import com.chinasofti.postbar.dto.RegisterDto;
import com.chinasofti.postbar.dto.UserDto;
import com.chinasofti.postbar.service.LoginService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/loginController")
public class LoginController extends BasicController {
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response, String userName, String password) {
		JSONObject json = new JSONObject();// 要返回到页面的对象
		json.put("message", ""); // 在对象中先添加入一个数据
		String md5Password = this.md5(password); // 将原始密码进行MD5加密，数据库保存的是加密后的数据
		System.out.println("----------->" + userName + "---------" + md5Password);
		UserDto userDto = loginService.getUserByUserNameAndPassword(userName, md5Password);
		if (userDto == null) {
			json.put("message", "用户名和密码错误");
		} else {
			/*
			 * --这里需要将id,username,admin,datetime四个属性存入session中，暂时不写
			 * session.setAttribute("username", userDto.getUserName());
			 * session.setAttribute("admin", userDto.getAdmin()); session.setAttribute("id",
			 * userDto.getUserUUID());
			 */
			String loginTime = this.getStringDate(new Date());
			loginService.updateUserLoginTimeByUserNameAndPassword(userName, md5Password, loginTime);
			json.put("admin", userDto.getAdmin());// 将用户权限级别添加到json对象中
		}
		this.writeJson(json.toString(), response);// 将数据返回到页面
	}

	@ModelAttribute
	@RequestMapping(value = "/addRegister")
	public void addRegister(HttpServletResponse response, HttpServletRequest request, String userName, String password,
			String regSex, int regAge, String regEmial) {
		JSONObject json = new JSONObject();
		json.put("message", "");
		if (loginService.getUserNumByUserName(userName) != 0) {
			json.put("message", "用户名已存在");
		} else {
			String userUUID = this.getUUID();
			String md5Password = this.md5(password);
			String regTime = this.getStringDate(new Date());
			String regUUID = this.getUUID();
			String admin = "0";
			String photoAir = "/postbar/headPhoto/default/default.jpg";
			String auSetUUID = this.getUUID();
			int auSetPit = 5;
			int auSetSpd = 5;
			int auSetVol = 5;
			int auSetVoiPer = 0;

			RegisterDto registerDto = new RegisterDto();
			registerDto.setRegAge(regAge);
			registerDto.setRegEmial(regEmial);
			registerDto.setRegSex(regSex);
			registerDto.setRegTime(regTime);
			registerDto.setRegUUID(regUUID);
			registerDto.setUserUUID(userUUID);
			registerDto.setRegPhoto(photoAir);

			UserDto userDto = new UserDto();
			userDto.setPassword(md5Password);
			userDto.setUserName(userName);
			userDto.setUserUUID(userUUID);
			userDto.setAdmin(admin);

			AudioDto audioDto = new AudioDto();
			audioDto.setAuSetPit(auSetPit);
			audioDto.setAuSetSpd(auSetSpd);
			audioDto.setAuSetUUID(auSetUUID);
			audioDto.setAuSetVoiPer(auSetVoiPer);
			audioDto.setAuSetVol(auSetVol);
			audioDto.setUserUUID(userUUID);
			loginService.addUserRegister(registerDto, userDto, audioDto);
		}
		this.writeJson(json.toString(), response);
	}

}
