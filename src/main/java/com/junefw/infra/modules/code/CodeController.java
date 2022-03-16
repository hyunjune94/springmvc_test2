package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {

		int count = service.selectOneCount(vo);
		
		vo.setParamsPaging(count);
		
		if(count != 0) {
			List<Code> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
			// by pass
		}

		return "code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm() throws Exception {
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(Code dto) throws Exception {

		System.out.println();
	//	입력 실행
		service.insert(dto);

		return "redirect:/code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(CodeVo vo, Model model) throws Exception {

		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());

		Code rt = service.selectOne(vo);
		
		model.addAttribute("item", rt);
		
		return "code/codeGroupView";
	}
	
	@RequestMapping(value = "/code/codeGroupForm2")	//주소입력
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectOne(vo);
		
		model.addAttribute("rt",rt);
		
		return "code/codeGroupForm2";	//보여지는 jsp파일
	}
	
	@RequestMapping(value = "/code/codeGroupUpdt")	//주소입력
	public String codeGroupUpdt(Code dto) throws Exception {
		
		service.update(dto);
		return "redirect:/code/codeGroupView?ifcg=" + dto.getIfcgSeq();
	}
	
	//--------------------------------------------------
	//code
	@RequestMapping(value = "/code/codeList")
	public String codeList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {

		int count = service.selectOneCountCode(vo);
		
		vo.setParamsPaging(count);
		
		if(count != 0) {
			List<Code> list = service.selectListCode(vo);
			model.addAttribute("list", list);
			
			List<Code> listCodeGroup = service.selectList(vo);
			model.addAttribute("listCodeGroup", listCodeGroup);
		} else {
			// by pass
		}

		return "code/codeList";
	}
	
	@RequestMapping(value = "/code/codeForm")
	public String codeForm(Model model) throws Exception {
		
//		List<Code> list = service.selectListCode();
//		model.addAttribute("list",list);
		return "code/codeForm";
	}
	
	@RequestMapping(value = "/code/codeInst")
	public String codeInst(Code dto) throws Exception {

		service.insertCode(dto);

		return "redirect:/code/codeList";
	}
	
	@RequestMapping(value = "/code/codeView")
	public String codeView(CodeVo vo, Model model) throws Exception {

		Code rt = service.selectOneCode(vo);
		
		model.addAttribute("item", rt);
		
		return "code/codeView";
	}
	
	@RequestMapping(value = "/code/codeForm2")	//주소입력
	public String codeForm2(CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectOneCode(vo);
		
		model.addAttribute("item",rt);
		
		return "code/codeForm2";	//보여지는 jsp파일
	}
	
	@RequestMapping(value = "/code/codeUpdt")	//주소입력
	public String codeUpdt(Code dto) throws Exception {
		System.out.println("asdasdf");
		service.updateCode(dto);
		return "redirect:/code/codeView?ifcd=" + dto.getIfcdSeq();
	}	
	
	
}