package com.nsc.webtemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.webtemplate.model.ProductRepository;
import com.nsc.webtemplate.model.table.Product;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("product/list");
		view.addObject("products", repository.findAll());
		return view;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView view = new ModelAndView("product/add");
		return view;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id") String id) {
		ModelAndView view = new ModelAndView("product/edit");
		view.addObject("product", repository.findOne(id));
		return view;
	}

	@RequestMapping("/save")
	public ModelAndView save(@RequestParam(value = "csItem") String csItem,
			@RequestParam(value = "csItemType") String csItemType, @RequestParam(value = "csStock") int csStock,
			@RequestParam(value = "csStock_HIS") int csStock_HIS, @RequestParam(value = "csPreOrder") int csPreOrder) {
		repository.save(new Product(csItem, csItemType, csStock, csStock_HIS, csPreOrder));
		ModelAndView view = new ModelAndView("product/list");
		view.addObject("products", repository.findAll());
		return view;
	}

	@RequestMapping("/update")
	public ModelAndView update(@RequestParam(value = "id") String id, @RequestParam(value = "csItem") String csItem,
			@RequestParam(value = "csItemType") String csItemType, @RequestParam(value = "csStock") int csStock,
			@RequestParam(value = "csStock_HIS") int csStock_HIS, @RequestParam(value = "csPreOrder") int csPreOrder) {
		Product product = repository.findOne(id);
		product.setCsItem(csItem);
		product.setCsItemType(csItemType);
		product.setCsStock(csStock);
		product.setCsStock_HIS(csStock_HIS);
		product.setCsPreOrder(csPreOrder);
		repository.save(product);
		ModelAndView view = new ModelAndView("product/list");
		view.addObject("products", repository.findAll());
		return view;
	}
}
