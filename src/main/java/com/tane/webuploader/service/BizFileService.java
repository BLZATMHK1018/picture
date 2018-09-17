package com.tane.webuploader.service;

import java.util.List;

import com.tane.webuploader.entity.BizFile;

/**
 * @author ZhangFen
 * @date 2018年9月12日  下午5:05:23
 */
public interface BizFileService {

	void save(BizFile bizFile)throws Exception;

	List<BizFile> queryList() throws Exception;

}
