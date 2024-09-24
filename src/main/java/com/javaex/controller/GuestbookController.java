package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.guestbookVo;
@RestController
public class GuestbookController {
	
	@Autowired
	private GuestbookService service;

	//Constructors

	//Getters and Setters

	//[Methods]
	
	@GetMapping(value ="/api/guests")
	public List<guestbookVo> list() {
		System.out.println("guestbookController.list()");
		
		List<guestbookVo> guestList = service.exegetPersonList();
		
		System.out.println(guestList);
		
		return guestList;
	}
	
	@PostMapping(value ="/api/guests")
	public int register(@RequestBody guestbookVo guestVo) {
		System.out.println("guestbookController.register()");
		int count = service.exeRegister(guestVo);
		
		return count;
		
	}
	
	@GetMapping(value ="/api/guests/{no}")
	public JsonResult showDelete(@PathVariable(value="no") int no) {
		System.out.println("guestbookController.deleteInfo()");
		
		guestbookVo guestVo = service.exegetPersonInfo(no);
		if (guestVo == null) {
			return JsonResult.fail("번호가 없습니다.");
		}else {
			return JsonResult.success(guestVo);
		}		
	}
	
	@DeleteMapping(value ="/api/guests/{no}")
	public JsonResult delete(@PathVariable(value = "no") int personId, @RequestBody guestbookVo guestVo) {
		System.out.println("guestbookController.delete()");
		String pw = guestVo.getPassword();
		System.out.println(pw);
		int count = 0;
		if(service.execheckPw(personId, pw)) {
			count = service.exeDeletePerson(personId);
		}
		
		if (count == 0) {
			return JsonResult.fail("번호가 없습니다.");
		}else {
			return JsonResult.success("삭제완료.");
		}			
	}
	
	
	
	
	
	
	
	
	
	

}
