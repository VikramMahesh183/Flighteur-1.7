package com.psa.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flight_reservation_app.entity.User;
import com.psa.flight_reservation_app.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showLoginPage") // index page link to Login page
	public String showLoginPage() {
		return "login/Login";
	}

	@RequestMapping("/showReg") // step1: controller to New Reg page
	public String showReg() {
		return "login/showReg";
	}

	@RequestMapping("/saveReg") // step2: New Reg page saved data to controller
	public String saveReg(@ModelAttribute("user") User user, ModelMap modelMap) {
		userRepo.save(user);
		return "login/Login";// redirects to login page
	}

	@RequestMapping("verifyLogin")
	public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "login/findFlights";
			} else {
				modelMap.addAttribute("error", " Invalid Email/password");
				return "login/Login";
			}
		} else {
			modelMap.addAttribute("emptymsg", "Email or password field cannot be empty!!!");
			return "login/Login";
		}

	}
}
