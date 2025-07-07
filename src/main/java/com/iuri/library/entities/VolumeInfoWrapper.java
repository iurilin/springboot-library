package com.iuri.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iuri.library.entitiesDTO.VolumeInfoDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfoWrapper {

	private VolumeInfoDTO volumeInfo;

	public VolumeInfoDTO getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfoDTO volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

}
