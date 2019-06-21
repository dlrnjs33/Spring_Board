package kr.co.prototype.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.vo.BoardVo;

@Mapper
public interface BoardDao {

	public BoardDto findBySeqAndBoardFileSeq(@Param("seq") int seq, @Param("boardFileSeq") Integer boardFileSeq);

	public int existsBySeqAndUid(BoardDto boardDto);

	public void save(BoardVo boardVo);

	public int updateBySeqAndUid(BoardVo boardVo);

	public void updateBySeq(@Param("seq") int seq);

	public int deleteBySeqAndUid(BoardVo boardVO);

}