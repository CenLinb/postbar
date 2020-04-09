package com.chinasofti.postbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.postbar.dto.AudioDto;
import com.chinasofti.postbar.dto.RegisterDto;
import com.chinasofti.postbar.dto.UserDto;
import com.chinasofti.postbar.mapper.PbAudioMapper;
import com.chinasofti.postbar.mapper.PbRegisterMapper;
import com.chinasofti.postbar.mapper.PbUserMapper;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	PbUserMapper pbUserMapper;
	@Autowired
	PbRegisterMapper pbRegisterMapper;
	@Autowired
	PbAudioMapper pbAudioMapper;

	@Override
	public UserDto getUserByUserNameAndPassword(String userName, String md5Password) {
		return pbUserMapper.selectUserByUserNameAndPassword(userName, md5Password);
	}

	@Override
	public void updateUserLoginTimeByUserNameAndPassword(String userName, String md5Password, String loginTime) {
		pbUserMapper.updateUserLoginTimeByUserNameAndPassword(userName, md5Password, loginTime);
	}

	@Override
	public int getUserNumByUserName(String userName) {
		return pbUserMapper.getUserNumByUserName(userName);
	}

	@Override
	public void addUserRegister(RegisterDto registerDto, UserDto userDto, AudioDto audioDto) {
		pbUserMapper.insertUser(userDto);
		pbRegisterMapper.insertRegister(registerDto);
		pbAudioMapper.insertAudio(audioDto);
	}

}
