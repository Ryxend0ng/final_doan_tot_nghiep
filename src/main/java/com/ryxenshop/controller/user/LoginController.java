package com.ryxenshop.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryxenshop.controller.BaseController;
import com.ryxenshop.dto.CartDTO;
import com.ryxenshop.dto.CartItemDTO;
import com.ryxenshop.entities.User;

@Controller
@RequestMapping("/ryxen-shop/")
public class LoginController extends BaseController {

	@GetMapping("dang-nhap.html")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("totalItems", getTotalItems(request));
		return "user/login/login";
	}

	public Integer getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}

		CartDTO cart = (CartDTO) httpSession.getAttribute("cart");
		List<CartItemDTO> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItemDTO item : cartItems) {
			total += item.getQuantity();
		}

		return total;
	}

	@GetMapping("login-success")
	public String showPageSuccess() throws Exception {
		User user = getUserLogined();
		if ("GUEST".equals(user.getUserRoles().get(0).getRoleName())) {
			return "redirect:/ryxen-shop/home.html";
		} else {
			return "redirect:/ryxen-shop/admin/dashboard";
		}
	}

}
