package com.tane.webuploader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tane.webuploader.entity.BizFile;
import com.tane.webuploader.mapper.BizFileMapper;

@Service
public class BizFileServiceImpl implements BizFileService{

	@Autowired
	private BizFileMapper bizFileMapper;
	
	@Override
	public void save(BizFile bizFile) throws Exception {
		bizFileMapper.save(bizFile);
	}

	@Override
	public List<BizFile> queryList() throws Exception {
		List<BizFile> list = bizFileMapper.queryList();
		return list;
	}

}
