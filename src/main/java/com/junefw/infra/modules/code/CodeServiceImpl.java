package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeDao dao;
	
//	infrCodeGroup
	@Override
	public int selectOneCount(CodeVo vo) throws Exception {
		return dao.selectOneCount(vo);
	}
	
	@Override
	public List<Code> selectList(CodeVo vo) throws Exception {
		return dao.selectList(vo); 
	}

	@Override
	public int insert(Code dto) throws Exception {
		return dao.insert(dto); 
	}
	
	@Override
	public Code selectOne(CodeVo vo) throws Exception {
		return dao.selectOne(vo);
	}

	@Override
	public int update(Code dto) throws Exception {
		return dao.update(dto); 
	}	
	
	@Override
	public int delete(CodeVo vo) throws Exception {
		return dao.delete(vo);
	}

	@Override
	public int updateDelete(CodeVo vo) throws Exception {
		return updateDelete(vo);
	}

	//	infrCode
	@Override
	public int selectOneCountCode(CodeVo vo) throws Exception {
		return dao.selectOneCountCode(vo);
	}
	
	@Override
	public List<Code> selectListCode(CodeVo vo) throws Exception {
		return dao.selectListCode(vo); 
	}

	@Override
	public int insertCode(Code dto) throws Exception {
		return dao.insertCode(dto); 
	}

	@Override
	public Code selectOneCode(CodeVo vo) throws Exception {
		return dao.selectOneCode(vo);
	}

	@Override
	public int updateCode(Code dto) throws Exception {
		return dao.updateCode(dto); 
	}
	
	@PostConstruct
	public void selectListForCache() {
		List<Code> codeListFromDb = (ArrayList<Code>) dao.selectListForCache();
		
		Code.cachedCodeArrayList.clear();
		Code.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + Code.cachedCodeArrayList.size() + "cached!");
		
	}

}