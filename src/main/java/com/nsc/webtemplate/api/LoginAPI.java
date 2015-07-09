package com.nsc.webtemplate.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.webtemplate.model.Users;
import com.nsc.webtemplate.model.UsersRepository;

@Controller
@RequestMapping("/user")
public class LoginAPI {

	@Autowired
	private UsersRepository repository;

	@RequestMapping(value = "login")
	@ResponseBody
	public ResponseData userLogin(@RequestParam(value = "username") String userName,
			@RequestParam(value = "password") String passWord) {
		ResponseData res = new ResponseData();
		res.setStatusCode(1);
		res.setDescription("Status OK");
		Users user = repository.findByUserNameAndPassWord(userName, passWord);
		if (user == null) {
			res.setData(null);
		} else {
			res.setData(user);
		}
		return res;
	}

}
