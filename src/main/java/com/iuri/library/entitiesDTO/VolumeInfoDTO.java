package com.iuri.library.entitiesDTO;

import java.util.List;

public class VolumeInfoDTO {
	
	private String title;
	private List<String> authors;
	private String publisher;
	private String publishedDate;
	private String description;
	private ImageLinksDTO imageLinks;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ImageLinksDTO getImageLinks() {
		return imageLinks;
	}
	public void setImageLinks(ImageLinksDTO imageLinks) {
		this.imageLinks = imageLinks;
	}
	
	

}
