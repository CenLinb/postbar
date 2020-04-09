package com.chinasofti.postbar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chinasofti.postbar.dto.UserDto;

public interface PbUserMapper {
	// 根据用户名和密码查询数据
	@Select("SELECT * FROM pb_user WHERE userName=#{userName} and password=#{password}")
	UserDto selectUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

	@Update("Update pb_user SET loginTime=#{loginTime} where userName=#{userName} and password=#{password}")
	void updateUserLoginTimeByUserNameAndPassword(@Param("userName") String userName,
			@Param("password") String password, @Param("loginTime") String loginTime);

	/** -根据用户名查询用户数量- */
	@Select("SELECT COUNT(*) FROM pb_user WHERE userName=#{userName}")
	int getUserNumByUserName(String userName);

	@Insert("INSERT INTO pb_user (userUUID,userName,password,loginTime,admin) VALUES(#{userUUID},#{userName},#{password},#{loginTime},#{admin})")
	void insertUser(UserDto userDto);

}
