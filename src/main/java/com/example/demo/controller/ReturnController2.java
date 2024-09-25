package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/return2")
public class ReturnController2 {

//	// 스프링부트는 기본적으로 HTML 뷰를 반환하도록 설계되어 있음
//	@GetMapping("/ex1")
//	public String ex1() {
//		return "Hi~"; //파일의 경로로 해석됨
//		// tamplate/Hi~.html
//	}
	
	// 데이터를 그대로 반환
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1() {
		return "Hi~";
	}
	
	@ResponseBody
	@GetMapping("/ex2")
	public int ex2() {
		
		return 100;
	}
	
	// 자바의 객체를 json의 객체형식으로 변환하여 전송
    @ResponseBody
	@GetMapping("/ex3")
    public BookDTO ex3() {
        BookDTO bookDto = new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000);
        return bookDto; //Book 객체를 반환
    }
    
    @ResponseBody // 자바의 리스트를 JSON 형식으로 변환하여 전송
	@GetMapping("/ex4")
    public List<BookDTO> ex4() {
        List<BookDTO> list = new ArrayList<>();
        list.add(new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000));
        list.add(new BookDTO("스프링부트웹프로젝트","구멍가게코딩단",15000));
        list.add(new BookDTO("모두의리눅스","길벗출판사",30000));
        return list; //객체 리스트 반환
    }

    // enum: int char와 같은 "사용자 정의 자료형"
    
    // Entity를 사용할 때는 @ResponseBody 필요 없음
	@GetMapping("/ex5")
    public ResponseEntity ex5() {
		
		// 생성자 함수의 인자로 응답코드 설정
        return new ResponseEntity(HttpStatus.OK); //200 ok 성공코드
//		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR); //500 server error 에러코드
    }

	// ResponseEntity는 제네릭 타입으로
	// 바디에 넣을 데이터의 타입을 설정
	@GetMapping("/ex6")
    public ResponseEntity<String> ex6() {
        return new ResponseEntity<>("success..", HttpStatus.OK);  //200 ok 응답 + 문자열
    }

	@GetMapping("/ex7")
    public ResponseEntity<BookDTO> ex7() {
        BookDTO bookDto = new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);  //200 ok 응답 + Book 객체
    }

}
