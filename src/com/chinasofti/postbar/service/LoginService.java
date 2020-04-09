package com.chinasofti.postbar.service;

import com.chinasofti.postbar.dto.AudioDto;
import com.chinasofti.postbar.dto.RegisterDto;
import com.chinasofti.postbar.dto.UserDto;

public interface LoginService {
	UserDto getUserByUserNameAndPassword(String userName, String md5Password);

	void updateUserLoginTimeByUserNameAndPassword(String userName, String md5Password, String loginTime);

	int getUserNumByUserName(String userName);

	public void addUserRegister(RegisterDto registerDto, UserDto userDto, AudioDto audioDto);
}
