package kr.co.prototype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.PageDto;
import kr.co.prototype.service.MainService;

@Controller
public class MainController {

  @Autowired
  private MainService service;

  @GetMapping("/")
  public String index(Model model, PageDto pageDto, BoardDto boardDto) {
    List<BoardDto> boards = service.get(pageDto, boardDto);

    model.addAttribute("boards", boards);
    model.addAttribute("boardSearch", boardDto);
    model.addAttribute("page", pageDto);

    return "index";
  }

}