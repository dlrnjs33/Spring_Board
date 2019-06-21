package kr.co.prototype.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.prototype.dao.MainDao;
import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.PageDto;
import kr.co.prototype.prototypeUtils.FileUtils;
import kr.co.prototype.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;

	@Autowired
	private MainDao mainDao;

	@Override
	public List<BoardDto> get(PageDto pageDto, BoardDto boardDto) {
		pageDto.setTotalCount(mainDao.countBySelectLikeBoardSearch(boardDto));
		pageDto.makePaging();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("page", pageDto);
		map.put("board", boardDto);

		return mainDao.findFirst10AllBySelectLikeBoardSearchOrderBySeqDesc(map);
	}

}
