package com.chinasofti.postbar.mapper;

import org.apache.ibatis.annotations.Insert;

import com.chinasofti.postbar.dto.RegisterDto;

public interface PbRegisterMapper {
	@Insert("INSERT INTO pb_register (regUUID,userUUID,regSex,regAge,regEmial,regPhoto,regTime) VALUES (#{regUUID},#{userUUID},#{regSex},#{regAge},#{regEmial},#{regPhoto},#{regTime})")
	void insertRegister(RegisterDto registerDto);
}
