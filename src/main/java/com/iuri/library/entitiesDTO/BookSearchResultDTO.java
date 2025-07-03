package com.iuri.library.entitiesDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iuri.library.entities.VolumeInfoWrapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookSearchResultDTO {
	
	private List<VolumeInfoWrapper> item;

	public List<VolumeInfoWrapper> getItem() {
		return item;
	}

	public void setItem(List<VolumeInfoWrapper> item) {
		this.item = item;
	}
	
	
}
