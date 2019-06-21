package kr.co.prototype.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.prototype.domain.vo.FileVo;

@Mapper
public interface FileDao {

	public void save(FileVo fileVo);

	public void deleteBySeq(@Param("seq") int seq);

	public FileVo findBySeq(@Param("seq") int seq);

}