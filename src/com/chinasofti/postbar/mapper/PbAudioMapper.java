package com.chinasofti.postbar.mapper;

import org.apache.ibatis.annotations.Insert;

import com.chinasofti.postbar.dto.AudioDto;

public interface PbAudioMapper {

	@Insert("INSERT INTO pb_audio (auSetUUID,userUUID,auSetSpd,auSetPit,auSetVol,auSetVoiPer) VALUES (#{auSetUUID},#{userUUID},#{auSetSpd},#{auSetPit},#{auSetVol},#{auSetVoiPer})")
	void insertAudio(AudioDto audioDto);

}
