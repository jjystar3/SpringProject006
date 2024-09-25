package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param")
@ResponseBody
public class QuizController2 {
	
	@GetMapping("/q1")
	public String q1(@RequestParam(name = "text") String text) {
		System.out.println("String타입 파라미터 수집: " + text);
		return "ok";
	}

	@GetMapping("/q2")
	public String q2(@RequestParam(name = "a") float a, @RequestParam(name = "b") Boolean b) {
		System.out.println("float타입 파라미터 수집: " + a + ", boolean타입 파라미터 수집: " + b);
		return "ok";
	}
	
	@GetMapping("/q3")
	public String q3(@RequestParam(name = "arr") char[] arr) {
		
		System.out.println("char형 배열 수집:" + Arrays.toString(arr));
		
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("배열의 개수:" + arr.length);
		
		return "ok";
	}
	
	//4,5,6번: 복잡한 파라미터는 메세지 바디에 데이터를 담을 것
	//@RequestBody 사용하여 JSON형식의 문자열을 클래스로 변환
	
	@PostMapping("/q4")
	public String q4(@RequestBody StudentDTO dto) {
		System.out.println("객체 수집: " + dto);
		return "ok";
	}
	
	@PostMapping("/q5")
	public String q5(@RequestBody ArrayList<StudentDTO> list) {
		System.out.println("객체 타입 리스트 수집: " + list);
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}

		System.out.println("리스트의 개수:"+list.size());
		
		return "ok";
	}
	
	@PostMapping("/q6")
	public String q6(@RequestBody ArrayList<CarDTO> list) { //JSON -> 클래스 변환
		System.out.println("객체 타입 리스트 수집: " + list);
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}

		System.out.println("리스트 마지막 요소:"+list.get(list.size()-1));
		
		return "ok";
	}
}
