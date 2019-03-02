package cn.java.ckEc.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.java.ckEc.entity.Member;
import cn.java.ckEc.mapper.MemberMapper;
import cn.java.ckEc.service.MemberService;

public class MemberServiceImpl implements MemberService
{
    @Autowired
    private MemberMapper memberMapper ;
    
	@Override
	public Map<String,Object> memberRegister(Member member) {
		Map<String,Object> resqMap = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
		
		String member_name = member.getMemberName();
		
		//检查用户名是否被注册
		Member findByUsername = memberMapper.selectByUserName(member_name);
		
		if(findByUsername != null)               //用户名已注册 code-2
		{
			resqMap.put("code",-2);                     
			resqMap.put("message","用户名已注册");
			resqMap.put("data",data);
			
			return resqMap ;
		}
		
		member.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		
		int count = memberMapper.insert(member);
		System.out.println(count);
		
		resqMap.put("code",0);                    //插入成功,注册成功,code0
		resqMap.put("message","ok");
		resqMap.put("data",data);
		
		return resqMap ;
	}

	@Override
	public Map<String, Object> memberLogin(Map<String, Object> map, HttpServletRequest request) {

		Map<String,Object> resqMap = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
		
		//用户名或密码为空
		String member_name = (String) map.get("member_name");
		String password = (String) map.get("password");
		
		if(member_name.trim()==null||password.trim()==null )
		{
			resqMap.put("code", -1);
			resqMap.put("message", "请输入用户名和密码");
			resqMap.put("data", data);
			
			return resqMap ;
		}
		
		Member member = memberMapper.selectByUserName(member_name);
		if(member!=null)
		{
			if(member.getPassword().equals(password))
			{
				//用户名密码正确
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //登录成功 code0
				String loginTime = sdf.format(new Date());
				HttpSession session = request.getSession();
				session.setAttribute("user", member);
				
				data.put("loginTime", loginTime);
				data.put("member_name", member.getMemberName());
				data.put("major", member.getMemberName());
				data.put("description", member.getDescription());
				data.put("isMember", true);
				
				resqMap.put("code", 0);
				resqMap.put("message", "ok");
				resqMap.put("data",data);
				
				return resqMap ;
				
			}
			else
			{   //用户名正确，密码不正确                            /
				resqMap.put("code", -2);
				resqMap.put("message", "密码不正确");
				resqMap.put("data", data);
				
				return resqMap;
			}
		}
		else
		{
			//用户名不存在
			resqMap.put("code", -1);
			resqMap.put("message", "用户不存在");
			resqMap.put("data", data);
			
			return resqMap;
		}
		
	}

}
