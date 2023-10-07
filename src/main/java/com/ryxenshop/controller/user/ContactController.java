package com.ryxenshop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryxenshop.controller.BaseController;
import com.ryxenshop.entities.Contact;
import com.ryxenshop.service.ContactService;

@Controller
@RequestMapping("/ryxen-shop/")
public class ContactController extends BaseController {

	@Autowired
	private ContactService contactService;

	@GetMapping("contact.html")
	public String showContact() {
		return "/user/contact/contact";
	}

	@PostMapping("contact")
	public ResponseEntity<Boolean> contact(@ModelAttribute Contact contact) throws Exception {
		Contact result = contactService.saveOrUpdate(contact, getUserLogined());
		if (result != null && result.getId() != null) {
			return ResponseEntity.ok(Boolean.TRUE);
		}
		return ResponseEntity.ok(Boolean.FALSE);
	}
}
