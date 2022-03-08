package com.junefw.infra.modules.code;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {
	
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static String namespace = "com.junefw.infra.modules.code.CodeMpp";

	public List<Code> selectList() {
		List<Code> list = sqlSession.selectList(namespace + ".selectList", "");
		return list;
	}
//	infrCodeGroup	
	public List<Code> selectList2() {List<Code> list = sqlSession.selectList(namespace + ".selectList", ""); return list;}
	public int insert(Code dto) { return sqlSession.insert(namespace + ".insert", dto);}
	public Code selectOne(CodeVo vo) { return sqlSession.selectOne(namespace + ".selectOne", vo);}	
	public int update(Code dto) { return sqlSession.update(namespace + ".update", dto);}	

	
//	infrCode
	public List<Code> selectListCode() {List<Code> list = sqlSession.selectList(namespace + ".selectListCode", ""); return list;}	
	public int insertCode(Code dto) { return sqlSession.insert(namespace + ".insertCode", dto);}
	public Code selectOneCode(CodeVo vo) { return sqlSession.selectOne(namespace + ".selectOneCode", vo);}	
	public int updateCode(Code dto) { return sqlSession.update(namespace + ".updateCode", dto);}	


}