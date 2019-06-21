package kr.co.prototype.serviceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.prototype.dao.FileDao;
import kr.co.prototype.domain.vo.FileVo;
import kr.co.prototype.prototypeUtils.FileUtils;
import kr.co.prototype.prototypeUtils.StringUtils;
import kr.co.prototype.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;

	@Autowired
	private FileDao fileDao;

	StringUtils stringUtils = new StringUtils();

	@Override
	public void downloadFile(int seq, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
		int boardFileSeq = seq;
		FileVo downloadFileInfo = fileDao.findBySeq(boardFileSeq);

		fileUtils.downloadFile(downloadFileInfo, httpServletResponse, httpServletRequest);
	}

}
