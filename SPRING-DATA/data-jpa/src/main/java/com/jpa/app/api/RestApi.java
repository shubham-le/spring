package com.jpa.app.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.app.entity.UserMaster;
import com.jpa.app.service.UserService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/app")
public class RestApi {

	private UserService userService;
	
	public RestApi(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/live")
	public String liveness() {
		return "LIVE...";
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserMaster> addUsers(@RequestBody UserMaster userMaster) {
		return ResponseEntity.ok(userService.save(userMaster));
	}
	
	@GetMapping("/users") @Transactional
	public ResponseEntity<List<UserMaster>> users() {
		var data = userService.findAll();
		data.forEach(e -> System.out.println("UID: " + e.getUserId() + ", ROLE: " + e.getRoleMaster()));
		return ResponseEntity.ok(data);
	}
}
