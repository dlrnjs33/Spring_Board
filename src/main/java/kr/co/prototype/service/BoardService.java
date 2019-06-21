package kr.co.prototype.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.vo.BoardVo;

public interface BoardService {

	public BoardDto get(int seq, Integer boardFileSeq);

	public void set(BoardVo boardVo, HttpServletRequest httpServletRequest, Map<String, Object> map) throws Exception;

	public String modify(BoardDto boardDto, HttpServletRequest httpServletRequest);

	public String delete(BoardDto boardDto, HttpServletRequest httpServletRequest);

}
