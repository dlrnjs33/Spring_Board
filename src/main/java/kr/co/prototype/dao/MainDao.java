package kr.co.prototype.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.prototype.domain.BoardDto;

@Mapper
public interface MainDao {

	public List<BoardDto> findFirst10AllBySelectLikeBoardSearchOrderBySeqDesc(Map<String, Object> map);

	public int countBySelectLikeBoardSearch(BoardDto boardDto);

}