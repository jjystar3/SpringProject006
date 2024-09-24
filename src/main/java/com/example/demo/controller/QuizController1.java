package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/method/q")
public class QuizController1 {

	@ResponseBody
	@GetMapping
	public String quiz1() {
		System.out.println("get메소드 요청..");
		return "ok";
	}

	@ResponseBody
	@PostMapping
	public String quiz2() {
		System.out.println("post메소드 요청..");
		return "ok";
	}

	@ResponseBody
	@PutMapping
	public String quiz3() {
		System.out.println("put메소드 요청..");
		return "ok";
	}

	@ResponseBody
	@DeleteMapping()
	public String quiz4() {
		System.out.println("delete메소드 요청..");
		return "ok";
	}

}
