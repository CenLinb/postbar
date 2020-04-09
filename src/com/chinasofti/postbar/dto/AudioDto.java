package com.chinasofti.postbar.dto;

public class AudioDto {
	String auSetUUID;
	String userUUID;
	Integer auSetSpd;
	Integer auSetPit;
	Integer auSetVol;
	Integer auSetVoiPer;

	public AudioDto() {
		super();
	}

	public AudioDto(String auSetUUID, String userUUID, Integer auSetSpd, Integer auSetPit, Integer auSetVol,
			Integer auSetVoiPer) {
		super();
		this.auSetUUID = auSetUUID;
		this.userUUID = userUUID;
		this.auSetSpd = auSetSpd;
		this.auSetPit = auSetPit;
		this.auSetVol = auSetVol;
		this.auSetVoiPer = auSetVoiPer;
	}

	public String getAuSetUUID() {
		return auSetUUID;
	}

	public void setAuSetUUID(String auSetUUID) {
		this.auSetUUID = auSetUUID;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public Integer getAuSetSpd() {
		return auSetSpd;
	}

	public void setAuSetSpd(Integer auSetSpd) {
		this.auSetSpd = auSetSpd;
	}

	public Integer getAuSetPit() {
		return auSetPit;
	}

	public void setAuSetPit(Integer auSetPit) {
		this.auSetPit = auSetPit;
	}

	public Integer getAuSetVol() {
		return auSetVol;
	}

	public void setAuSetVol(Integer auSetVol) {
		this.auSetVol = auSetVol;
	}

	public Integer getAuSetVoiPer() {
		return auSetVoiPer;
	}

	public void setAuSetVoiPer(Integer auSetVoiPer) {
		this.auSetVoiPer = auSetVoiPer;
	}

	@Override
	public String toString() {
		return "AudioDto [auSetUUID=" + auSetUUID + ", userUUID=" + userUUID + ", auSetSpd=" + auSetSpd + ", auSetPit="
				+ auSetPit + ", auSetVol=" + auSetVol + ", auSetVoiPer=" + auSetVoiPer + "]";
	}

}
