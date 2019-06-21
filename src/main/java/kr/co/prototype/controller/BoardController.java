package kr.co.prototype.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.PageDto;
import kr.co.prototype.domain.vo.BoardVo;
import kr.co.prototype.prototypeUtils.StringUtils;
import kr.co.prototype.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	StringUtils stringUtils = new StringUtils();

	@GetMapping("/{seq}")
	public String readPage(@PathVariable("seq") String seq, Integer boardFileSeq, String modify, PageDto pageDto,
			Model model) {
		if (!seq.equals("new")) {
			BoardDto boardDto = service.get(stringUtils.getInt(seq), boardFileSeq);

			model.addAttribute("board", boardDto);
			model.addAttribute("modify", modify);
		}

		model.addAttribute("page", pageDto);

		return "/board/board-create";
	}

	@PostMapping("/{seq}")
	public String write(@PathVariable("seq") int seq, @Valid BoardVo boardVo, BindingResult bindingResult,
			HttpServletRequest httpServletRequest, Map<String, Object> map) throws Exception {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);

			return "/board/board-write";
		}

		service.set(boardVo, httpServletRequest, map);

		return "redirect:/";
	}

	@PutMapping("/{seq}")
	@ResponseBody
	public String modify(@PathVariable("seq") int seq, @RequestBody @Valid BoardDto boardDto, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);

			return "fail";
		}

		boardDto.setSeq(seq);

		return service.modify(boardDto, httpServletRequest);
	}

	@DeleteMapping("/{seq}")
	@ResponseBody
	public String delete(@PathVariable("seq") int seq, @RequestBody BoardDto boardDto,
			HttpServletRequest httpServletRequest) {
		boardDto.setSeq(seq);

		return service.delete(boardDto, httpServletRequest);
	}

}