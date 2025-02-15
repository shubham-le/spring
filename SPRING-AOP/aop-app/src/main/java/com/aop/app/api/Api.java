package com.aop.app.api;

import java.util.Base64;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

	@GetMapping("/live")
	public String live() {
		return "LIVE>>>";
	}

	@GetMapping("/id")
	public String id(@RequestParam String name) {
		return "ID: " + Math.random();
	}

	@GetMapping("/name")
	public String name(@RequestParam Integer id) {
		return "Name: " + Base64.getEncoder().encode(new Date().toLocaleString().getBytes());
	}
	
	@GetMapping("/getUserById")
	public String getUserById(@RequestParam Integer id) {
		return "Name: " + Base64.getEncoder().encode(new Date().toLocaleString().getBytes());
	}
}
