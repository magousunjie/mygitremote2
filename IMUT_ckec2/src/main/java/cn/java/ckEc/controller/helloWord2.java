package cn.java.ckEc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class helloWord2 {

	@RequestMapping("/hello2")
	@ResponseBody
	public String test()
	{
		return "哈哈";
	}
}
