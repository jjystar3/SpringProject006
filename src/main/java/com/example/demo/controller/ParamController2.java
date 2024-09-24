package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/param2")
public class ParamController2 {
	
	//사용자가 전달한 파라미터 처리하기
	
	//localhost:8080/param2/ex1?i=100
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1(@RequestParam(name = "i") int i) {
		
		System.out.println("int형 파라미터 수집:" + i);
		
		return "ok";
	}

	//localhost:8080/param2/ex2?i=100&c=a
	@ResponseBody
	@GetMapping("/ex2")
	public String ex2(@RequestParam(name = "i") int i,
						@RequestParam(name = "c") char c) {
		
		System.out.println("int형 파라미터 수집:" + i);
		System.out.println("char형 파라미터 수집:" + c);
		
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/ex3")
	// arr 이라는 이름으로 파라미터를 여러개 전달할 수 있음
	// 예: ?arr=1&arr=2&arr=3
	public String ex3(@RequestParam(name = "arr") int[] arr) {
		
		System.out.println("int형 배열 수집:" + Arrays.toString(arr));
		
		return "ok";
	}

	@ResponseBody
	@GetMapping("/ex4")
	// ?list=1&list=2&list=3
	public String ex4(@RequestParam(name = "list") ArrayList<Integer> list) {
		
		System.out.println("int형 리스트 수집:" + list);
		
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/ex5")
	// ?date=2024-09-24
	// 기본값: "yyyy-MM-dd"
	// 그 외: "yyyy/MM/dd" or "yyyyMMdd"
	public String ex5(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		
		System.out.println("날짜 데이터 수집:" + date);
		
		return "ok";
	}
	
	//localhost:8080/param2/ex6/100
	@ResponseBody
	@GetMapping("/ex6/{i}")
	public String ex6(@PathVariable(name = "i") int i) {

		System.out.println("int형 파라미터 수집: " + i);
		return "ok";
	}

	//localhost:8080/param2/ex7?title=자바프로그래밍입문&publisher=한빛컴퍼니&price=1000
	@ResponseBody
	@GetMapping("/ex7")
	public String ex7(@ModelAttribute BookDTO dto) { // 어노테이션 생략 가능

		System.out.println("객체 타입 파라미터 수집: " + dto);
		return "ok";
	}
}
