package kr.co.prototype.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {

	public void downloadFile(int seq, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest);

}
