package kr.co.prototype.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.prototype.dao.BoardDao;
import kr.co.prototype.dao.FileDao;
import kr.co.prototype.domain.BoardDto;
import kr.co.prototype.domain.vo.BoardVo;
import kr.co.prototype.domain.vo.FileVo;
import kr.co.prototype.prototypeUtils.FileUtils;
import kr.co.prototype.prototypeUtils.StringUtils;
import kr.co.prototype.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Resource(name = "fileUtils")
  private FileUtils fileUtils;

  @Autowired
  private BoardDao boardDao;

  @Autowired
  private FileDao fileDao;

  StringUtils stringUtils = new StringUtils();

  @Override
  public BoardDto get(int seq, Integer boardFileSeq) {

    return boardDao.findBySeqAndBoardFileSeq(seq, boardFileSeq);
  }

  @Override
  public void set(BoardVo boardVo, HttpServletRequest httpServletRequest, Map<String, Object> map) throws Exception {
    List<FileVo> list = fileUtils.insertFile(map, httpServletRequest);

    if (!list.isEmpty()) {
      for (FileVo fileVo : list) {
        fileDao.save(fileVo);
        boardVo.setBoardFileSeq(fileVo.getSeq());
      }

      boardDao.save(boardVo);
      return;
    }

    boardVo.setBoardFileSeq(null);
    boardDao.save(boardVo);
  }

  @Override
  public String modify(BoardDto boardDto, HttpServletRequest httpServletRequest) {
    if (boardDao.existsBySeqAndUid(new BoardDto(boardDto.getSeq())) == 0) {
      return "No board";
    }

    if (boardDao.existsBySeqAndUid(new BoardDto(boardDto.getSeq(), boardDto.getUid())) == 0) {
      return "No uid";
    }

    if (!stringUtils.isEmpty(boardDto.getDeleteCheck()) && boardDao.updateBySeqAndUid(boardDto) == 1) {
      FileVo downloadFileInfo = fileDao.findBySeq(boardDto.getBoardFileSeq());

      if (downloadFileInfo == null) {
        return "File delete fail";
      }

      boardDao.updateBySeq(boardDto.getSeq());
      fileDao.deleteBySeq(boardDto.getBoardFileSeq());

      fileUtils.deleteFile(downloadFileInfo, httpServletRequest);

      return "success";
    }

    if (boardDao.updateBySeqAndUid(boardDto) == 0) {
      return "Update fail";
    }

    return "success";
  }

  @Override
  @Transactional(rollbackFor = {Exception.class})
  public String delete(BoardDto boardDto, HttpServletRequest httpServletRequest) {
    if (boardDao.existsBySeqAndUid(new BoardDto(boardDto.getSeq())) == 0) {
      return "No board";
    }

    if (boardDao.existsBySeqAndUid(new BoardDto(boardDto.getSeq(), boardDto.getUid())) == 0) {
      return "No uid";
    }

    int boardFileSeq = boardDto.getBoardFileSeq();

    if (boardDao.deleteBySeqAndUid(boardDto) == 0) {
      return "Board delete fail";
    }

    if (boardFileSeq != 0) {
      FileVo downloadFileInfo = fileDao.findBySeq(boardFileSeq);

      if (downloadFileInfo == null) {
        return "File delete fail";
      }

      fileDao.deleteBySeq(boardFileSeq);

      fileUtils.deleteFile(downloadFileInfo, httpServletRequest);
    }

    return "success";
  }

}
