package cn.java.ckEc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.ckEc.entity.Normal;
import cn.java.ckEc.service.NormalService;
import cn.java.ckEc.utils.Validator;

@RequestMapping("/normal")
@Controller
public class NormalController 
{
	@Autowired
	NormalService normalService ;
	
	@RequestMapping("/signUp")
	@ResponseBody
   public Map<String,Object> register(@Valid Normal normal,BindingResult errorResult )
   {
		//errorMap的key为校验不合法的字段，value为对应的提示信息
	    Map<String,Object> errorMap = Validator.fieldValidate(errorResult); 
	    
	    Map<String,Object> resqMap = new HashMap<String,Object>();
		Map<String,Object> data = new HashMap<String,Object>();
				
		data.put("errorMap", errorMap);
				
		if(errorMap == null)
		{
			return normalService.normalRegister(normal);                   //上传参数符合要求
					
		}
		else
		{					
			resqMap.put("code", -1);                                        //code-1校验不成功 
			resqMap.put("message", "字段校验不合法");
			resqMap.put("data", data);
			return resqMap ;
		}
     }
	
	
	@RequestMapping("/signIn")
	@ResponseBody
   public Map<String,Object> login(@RequestBody Map<String,Object> map,HttpServletRequest request )
   {
		return normalService.normalLogin(map, request);
   }
}
