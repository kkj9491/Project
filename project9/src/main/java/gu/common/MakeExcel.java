package gu.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.poi.ss.usermodel.Workbook;
import net.sf.jxls.transformer.XLSTransformer;

public class MakeExcel {

	static final Logger LOGGER = LoggerFactory.getLogger(AdminInterceptor.class);
	
	public MakeExcel() {}
	
	public String get_Filename(){
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddmmm");
		return ft.format(new Date());
	}
	
	public String get_Filename(String pre) {
		return pre + get_Filename();
	}
	
	/*
	Make Excel * Download.
	*/
	public void download(HttpServletRequest request, HttpServletResponse response, Map<String , Object> beans, String filename, String templateFile) {
		
		String tempPath = request.getSession().getServletContext().getRealPath("/WEB-INF/templete");
		
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(tempPath + "/" + templateFile));
			XLSTransformer transformer = new XLSTransformer();
			Workbook resultWorkbook = transformer.transformXLS(is, beans);
			
		} catch () {
			
		}
	}
	
}
