package com.hurricane.learn.springboot.web.entity;

import java.util.Date;

public class FilePiece {
	public static final String LOCAL_SAVE_DIR = "E:/piece/";
	private String id;//WU_FILE_0
	private String name;
	private String type;//octet-stream
	private long size;
	private int chunks;
	private int chunk;
	private Date lastModifiedDate;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public int getChunks() {
		return chunks;
	}
	public void setChunks(int chunks) {
		this.chunks = chunks;
	}
	public int getChunk() {
		return chunk;
	}
	public void setChunk(int chunk) {
		this.chunk = chunk;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "FilePiece [id=" + id + ", name=" + name + ", type=" + type
				+ ", size=" + size + ", chunks=" + chunks + ", chunk=" + chunk
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
}
