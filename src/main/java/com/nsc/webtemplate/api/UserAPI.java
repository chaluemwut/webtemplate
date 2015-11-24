package com.nsc.webtemplate.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nsc.webtemplate.Config;
import com.nsc.webtemplate.model.CustomerRepository;
import com.nsc.webtemplate.model.ProductRepository;
import com.nsc.webtemplate.model.UserTruckRepository;
import com.nsc.webtemplate.model.table.UserTruck;

@Controller
@RequestMapping(Config.apiBaseName + "/userapi")
public class UserAPI extends BaseAPI {
	@Autowired
	private ProductRepository productRep;

	@Autowired
	private CustomerRepository customerRep;

	@Autowired
	private UserTruckRepository userTruckRep;

	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(@RequestParam(value = "csUser") String csUser,
			@RequestParam(value = "csDivision") int csDivision, @RequestParam(value = "csTruck") int csTruck,
			@RequestParam(value = "csRoute") int csRoute) {
		UserTruck existUser = userTruckRep.findByCsUser(csUser);
		ResponseData res = new ResponseData();
		Map<String, Object> map = new HashMap<String, Object>();
		if (existUser == null) {
			// new user
			res.setStatusCode(0);
			res.setDescription("บันทึกสำเร็จ");
			UserTruck newUser = new UserTruck(csUser, csDivision, csTruck, csRoute);
			UserTruck userInfo = userTruckRep.save(newUser);
			map.put("user", userInfo);
		} else {
			// update date
			res.setStatusCode(-1);
			res.setDescription("มีผู้ใช้งานแล้วกรุณาเปลี่ยนใหม่");
			map.put("user", existUser);
			// existUser.setCsUser(csUser);
			// existUser.setCsDivision(csDivision);
			// existUser.setCsTruck(csTruck);
			// existUser.setCsRoute(csRoute);
			// userTruckRep.save(existUser);
		}
		map.put("customer", customerRep.findAll());
		map.put("product", productRep.findAll());
		res.setData(map);
		return res;
	}
}
