package com.nsc.webtemplate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nsc.webtemplate.Config;
import com.nsc.webtemplate.model.ProductRepository;

@Controller
@RequestMapping(Config.apiBaseName+"/productapi")
public class ProductAPI extends BaseAPI {
	@Autowired
	private ProductRepository repository;

	@RequestMapping(value = "/load")
	@ResponseBody
	public ResponseData load() {
		ResponseData res = new ResponseData();
		res.setStatusCode(0);
		res.setData(repository.findAll());
		res.setDescription("Status OK");
		return res;
	}
}
