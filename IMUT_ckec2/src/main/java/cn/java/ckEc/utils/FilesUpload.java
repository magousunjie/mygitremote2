package cn.java.ckEc.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

/**
 * Description: 此工具类可以同时上传多个文件<br/>
 * Date: 上午11:54:12 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
public class FilesUpload {
    /**
     * 
     * Description: 多文件上传<br/>
     *
     * @author dingP
     * @param request：类型为HttpServletRequest
     * @param files：类型为MultipartRequest
     */
    public static Map<String, String> uploadFiles(HttpServletRequest request, MultipartRequest files) {
        Map<String, String> filePathMap = new HashMap<String, String>();
        try {
            Map<String, MultipartFile> filesMap = files.getFileMap();
            Set<String> keySet = filesMap.keySet();
            for (String key : keySet) {
                MultipartFile file = filesMap.get(key);
                String originalFilename = file.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                String path = request.getServletContext().getRealPath("/upload");
                
                String positivePath = "../upload/"+uuid+originalFilename;
                
                String basePath = path.split("webapps")[0]+"webapps\\upload";
                
                File uploadMkdir = new File(basePath);
                if(!uploadMkdir.exists())
                {
                	uploadMkdir.mkdir();
                }
                
                String filepath = basePath+"\\"+uuid+originalFilename;
                file.transferTo(new File(filepath));
                // 开始将路劲保存到map集合中
                filePathMap.put(uuid, positivePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePathMap;
    }
}
