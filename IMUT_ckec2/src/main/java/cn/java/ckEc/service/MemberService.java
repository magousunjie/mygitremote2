package cn.java.ckEc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.java.ckEc.entity.Member;

public interface MemberService 
{
	public Map<String,Object> memberRegister(Member member);
	
	public Map<String,Object> memberLogin(Map<String,Object> map,HttpServletRequest request);
}
