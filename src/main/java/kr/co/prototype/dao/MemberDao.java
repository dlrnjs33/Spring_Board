package kr.co.prototype.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.prototype.domain.vo.MemberVo;

@Mapper
public interface MemberDao {

	public MemberVo findByUidAndPassword(MemberVo memberVO);

	public int countByUid(@Param("uid") String uid);

	public int save(MemberVo memberVO);

}
