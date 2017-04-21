package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		
		List<BoardVO> list = service.getList(cri);
		int total = service.getTotal();
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageMaker(cri,total));
		
	}
	
	@GetMapping("/view")
	public void view(@ModelAttribute("cri") Criteria cri, Model model, BoardVO vo)throws Exception{
		System.out.println(vo.getBno());
		
		List<BoardVO> list = service.findByBno(vo.getBno());
		int total = service.getTotal();
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageMaker(cri,total));
		
	}
	
	@PostMapping("/view")
	public String postview(@ModelAttribute("cri") Criteria cri,BoardVO vo)throws Exception{
		System.out.println("되라 좀");
		service.remove(vo.getBno());
		return "redirect:/board/list";
	}
}
