package com.tane.webuploader.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;


/**
 * 附件表
 * 
 * @author LSQ
 *
 */
@Table(name="biz_file")
public class BizFile {

	/**
	 * 主键
	 */
	@Column(name = "ID_AUTO")
	private Long idAuto;
	
	/**
	/**
	 * 文件地址
	 */
	@Column(name="URL")
	private String url;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ID")
	private String id;
	
	@Column(name="SIZE")
	private String size;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="CREATE_TIME")
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(Long idAuto) {
		this.idAuto = idAuto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
