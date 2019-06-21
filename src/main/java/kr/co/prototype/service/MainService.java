package kr.co.prototype.service;

import java.util.List;

import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.PageDto;

public interface MainService {

	public List<BoardDto> get(PageDto pageDto, BoardDto boardDto);

}
