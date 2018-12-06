package gu.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	static final Logger LOGGER = LoggerFactory.getLogger(AdminInterceptor.class);
	static final Integer IMG_WIDTH = 100;
	static final Integer IMG_HEIGHT = 100;
	
	
	// 파일업로드
	public FileVO saveFile(MultipartFile uploadfile) {
		if(uploadfile == null || uploadfile.getSize() == 0) {
			return null;
		}
		
		String filePath = LocaleMessage.getMessage("info.filePath"); 
		String newName = getNewName();
		filePath = getRealPath(filePath, newName);
		
		saveFileOne(uploadfile, filePath, newName);
		
		FileVO filedo = new FileVO();
		filedo.setFilename(uploadfile.getOriginalFilename());
		filedo.setRealname(newName);
		filedo.setFilesize(uploadfile.getSize());
				
		return filedo;
	}

	/*
	멀티 파일 업로드
	*/
	public List<FileVO> saveAllFiles(List<MultipartFile> upfiles){
		List<FileVO> filelist = new ArrayList<FileVO>();
		String filePath = LocaleMessage.getMessage("info.filePath");
		
		for(MultipartFile uploadfile : upfiles ) {
			if(uploadfile.getSize()==0) {
				continue;
			}
			
			String newName = getNewName();			
			
			
			
		}
		
		return null;
	}

	
	
	

	
	
	
	private void saveFileOne(MultipartFile uploadfile, String filePath, String newName) {
		// TODO Auto-generated method stub
		
	}

	private String getRealPath(String filePath, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getNewName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
