package com.hurricane.learn.springboot.web.entity;

public class FileTransfer {
	
	private String name;
	private boolean isDictionary;
	private long size;
	private String fullPath;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDictionary() {
		return isDictionary;
	}
	public void setDictionary(boolean isDictionary) {
		this.isDictionary = isDictionary;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
	
	
	
}
