package com.nsc.webtemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.webtemplate.model.CustomerRepository;
import com.nsc.webtemplate.model.table.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("customer/list");
		view.addObject("customers", repository.findAll());
		return view;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView("customer/add");
		return view;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id") String id) {
		ModelAndView view = new ModelAndView("customer/edit");
		view.addObject("customer", repository.findOne(id));
		return view;
	}

	@RequestMapping("/update")
	public ModelAndView update(@RequestParam(value = "id") String id,
			@RequestParam(value = "csCustomerId") String csCustomerId,
			@RequestParam(value = "csCustomerName") String csCustomerName,
			@RequestParam(value = "csAddress") String csAddress, @RequestParam(value = "csRoute") int csRoute) {
		Customer customer = repository.findOne(id);
		customer.setCsCustomerId(csCustomerId);
		customer.setCsCustomerName(csCustomerName);
		customer.setCsAddress(csAddress);
		customer.setCsRoute(csRoute);
		repository.save(customer);
		ModelAndView view = new ModelAndView("customer/list");
		view.addObject("customers", repository.findAll());
		return view;
	}

	@RequestMapping("/save")
	public ModelAndView save(@RequestParam(value = "csCustomerId") String csCustomerId,
			@RequestParam(value = "csCustomerName") String csCustomerName,
			@RequestParam(value = "csAddress") String csAddress, @RequestParam(value = "csRoute") int csRoute) {
		repository.save(new Customer(csCustomerId, csCustomerName, csAddress, csRoute));
		ModelAndView view = new ModelAndView("customer/list");
		view.addObject("customers", repository.findAll());
		return view;
	}

}
