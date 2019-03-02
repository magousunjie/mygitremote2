package cn.java.ckEc.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;

import cn.java.ckEc.utils.FilesUpload;

@Component
@RequestMapping("/upload")
public class FileUploadComponent 
{
	@RequestMapping("/sculpture")
	@ResponseBody
	public Map<String,Object> uploadSculpture(MultipartRequest files,HttpServletRequest request)
	{
		Map<String,String> uploadMap =  FilesUpload.uploadFiles(request, files); 
		
		Map<String,Object> resqMap = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
		
		int size = uploadMap.size();
		
		if(size>1)
		{
			resqMap.put("errorCode", 0);
			resqMap.put("message", "此处不能上传多张照片");
			resqMap.put("data", data);
			
			return resqMap ;
		}
		
		String headSculpturePath = "" ;
		Set<String> setKey = uploadMap.keySet();
		for(String key : setKey)
		{
			headSculpturePath = uploadMap.get(key);
		}
		
		data.put("headSculpturePath", headSculpturePath);
		resqMap.put("errorCode", 0);
		resqMap.put("message", "ok");
		resqMap.put("data", data);
		
		return resqMap ;
	}
}
