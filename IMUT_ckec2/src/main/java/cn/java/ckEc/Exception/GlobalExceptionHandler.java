package cn.java.ckEc.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(Exception.class)
	public void handlerException(Exception ex)
	{
		ex.printStackTrace();
		
		return 
	}
}
