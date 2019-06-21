package kr.co.prototype.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.prototype.service.FileService;

@Controller
@RequestMapping("/board")
public class FileController {

	@Autowired
	private FileService service;

	@GetMapping("/{seq}/download")
	public void downloadFile(int seq, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
		service.downloadFile(seq, httpServletResponse, httpServletRequest);
	}

}