package cn.java.ckEc.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import cn.java.ckEc.entity.Normal;

public interface NormalService 
{
    public Map<String,Object> normalRegister(Normal normal);
	
	public Map<String,Object> normalLogin(Map<String,Object> map,HttpServletRequest request);
}
