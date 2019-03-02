package cn.java.ckEc.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import cn.java.ckEc.entity.Normal;
import cn.java.ckEc.mapper.NormalMapper;
import cn.java.ckEc.service.NormalService;

public class NormalServiceImpl implements NormalService
{
	@Autowired
	private NormalMapper normalMapper ;
	
	@Override
	public Map<String, Object> normalRegister(Normal normal) {
		
			Map<String,Object> resqMap = new HashMap<String,Object>();
			Map<String,Object> data = new HashMap<String,Object>();
			
			String username = normal.getUsername();
			
			//检查用户名是否被注册
			Normal findByUsername = normalMapper.selectByUserName(username);
			
			if(findByUsername != null)               //用户名已注册.code-2 
			{
				resqMap.put("code",-2);                     
				resqMap.put("message","用户名已注册");
				resqMap.put("data",data);
				
				return resqMap ;
			}
			
			normal.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			
			int count = normalMapper.insert(normal); // 检测是否大于等于1
			System.out.println(count);
			
			resqMap.put("code",0);                    //插入成功,注册成功
			resqMap.put("message","ok");
			resqMap.put("data",data);
			
			return resqMap ;
	}

	@Override
	public Map<String, Object> normalLogin(Map<String, Object> map, HttpServletRequest request) {
		
		Map<String,Object> resqMap = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
		
		//用户名或密码为空
		String username = (String) map.get("username");
		String password = (String) map.get("password");
		
		if(username.trim()==null||password.trim()==null )
		{
			resqMap.put("code", -1);
			resqMap.put("message", "请输入用户名和密码");
			resqMap.put("data", data);
			
			return resqMap ;
		}
		
		Normal normal = normalMapper.selectByUserName(username);
		if(normal!=null)
		{
			if(normal.getPassword().equals(password))
			{
				//用户名密码正确
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String loginTime = sdf.format(new Date());
				HttpSession session = request.getSession();
				session.setAttribute("user", normal);
				
				data.put("loginTime", loginTime);
				data.put("username", normal.getUsername());
				data.put("isNormal", true);
				
				resqMap.put("code", 0);
				resqMap.put("message", "ok");
				resqMap.put("data",data);
				
				return resqMap ;
				
			}
			else
			{   //用户名正确，密码不正确
				resqMap.put("code", -2);
				resqMap.put("message", "密码不正确");
				resqMap.put("data", data);
				
				return resqMap;
			}
		}
		else
		{
			//用户名不存在
			resqMap.put("code", -3);
			resqMap.put("message", "用户不存在");
			resqMap.put("data", data);
			
			return resqMap;
		}
	}

}
