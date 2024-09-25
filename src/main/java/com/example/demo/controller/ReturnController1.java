package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

// 응답의 형태가 여러가지기 때문에 @ResponseBody를 쓰면 안됨
@Controller
public class ReturnController1 {
	
	// 메소드의 리턴타입에 따라 반환할 데이터의 형식이 설정됨
	// ModelAndView: 데이터와 화면경로를 설정하는 객체
	public ModelAndView ex1() {
		
		ModelAndView modelAndView = new ModelAndView("return/sample").addObject("data", "banana");
		
		return modelAndView;
		
	}

}
