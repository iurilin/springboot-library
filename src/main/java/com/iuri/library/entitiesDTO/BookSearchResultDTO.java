package com.iuri.library.entitiesDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iuri.library.entities.VolumeInfoWrapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookSearchResultDTO {

	private List<VolumeInfoWrapper> items;

	public List<VolumeInfoWrapper> getItems() {
		return items;
	}

	public void setItems(List<VolumeInfoWrapper> items) {
		this.items = items;
	}

}
