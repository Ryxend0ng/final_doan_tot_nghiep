package com.ryxenshop.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryxenshop.controller.BaseController;
import com.ryxenshop.entities.Introduce;
import com.ryxenshop.service.IntroduceService;

@Controller
@RequestMapping("/ryxen-shop/")
public class IntroduceController extends BaseController {
	@Autowired
	private IntroduceService introduceSevice;

	@GetMapping("introduce.html")
	public String getIntroduce() {
		return "user/introduce/introduce";
	}

	@GetMapping("load-introduce")
	public ResponseEntity<Map<String, Object>> getHtml() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("content",
				(introduceSevice.findAll() != null && introduceSevice.findAll().size() > 0)
						? introduceSevice.findAll().get(0)
						: new Introduce());
		return ResponseEntity.ok(result);
	}
}
