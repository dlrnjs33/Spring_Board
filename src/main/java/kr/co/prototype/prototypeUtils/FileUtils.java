package kr.co.prototype.prototypeUtils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.prototype.domain.vo.FileVo;

@Component("fileUtils")
public class FileUtils {

  public static String getFilePath(HttpServletRequest httpServletRequest) {
    String path = httpServletRequest.getSession().getServletContext().getRealPath("/");
    String filePath = path + "resources/upload/";
    return filePath;
  }

  public List<FileVo> insertFile(Map<String, Object> map, HttpServletRequest httpServletRequest) throws Exception {

    String filePath = getFilePath(httpServletRequest);
    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

    List<FileVo> list = new ArrayList<FileVo>();

    File file = new File(filePath);
    if (!file.exists()) {
      file.mkdirs();
    }

    while (iterator.hasNext()) {
      MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
      if (!multipartFile.isEmpty()) {
        String originalFileName = multipartFile.getOriginalFilename();
        String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String storedFileName = StringUtils.getRandomString() + originalFileExtension;
        int fileSize = Long.valueOf(multipartFile.getSize()).intValue();

        multipartFile.transferTo(new File(filePath + storedFileName));

        list.add(new FileVo(originalFileName, storedFileName, fileSize));
      }
    }

    return list;
  }

  public void deleteFile(FileVo downalodFileInfo, HttpServletRequest httpServletRequest) {
    String storedFileName = downalodFileInfo.getStoredFileName();
    String filePath = FileUtils.getFilePath(httpServletRequest);
    String deleteFilePath = filePath + "/" + storedFileName;

    File file = new File(deleteFilePath);
    file.delete();
  }

  public void downloadFile(FileVo downloadFileInfo, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
    String storedFileName = downloadFileInfo.getStoredFileName();
    String originalFileName = downloadFileInfo.getOriginalFileName();
    String filePath = kr.co.prototype.prototypeUtils.FileUtils.getFilePath(httpServletRequest);
    byte fileByte[];

    try {
      fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath + storedFileName));
      httpServletResponse.setContentType("application/octet-stream");
      httpServletResponse.setContentLength(fileByte.length);
      httpServletResponse.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
      httpServletResponse.setHeader("Content-Transfer-Encoding", "binary");
      httpServletResponse.getOutputStream().write(fileByte);
      httpServletResponse.getOutputStream().flush();
      httpServletResponse.getOutputStream().close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}