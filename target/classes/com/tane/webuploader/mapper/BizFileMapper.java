package com.tane.webuploader.mapper;

import java.util.List;

import com.tane.webuploader.entity.BizFile;


public interface BizFileMapper {

	void save(BizFile bizFile);

	List<BizFile> queryList();

}
