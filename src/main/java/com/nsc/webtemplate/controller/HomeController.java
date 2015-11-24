package com.nsc.webtemplate.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.webtemplate.model.CustomerRepository;
import com.nsc.webtemplate.model.ProductRepository;
import com.nsc.webtemplate.model.TransferRepository;
import com.nsc.webtemplate.model.UserTruckRepository;
import com.nsc.webtemplate.model.UsersRepository;
import com.nsc.webtemplate.model.table.Customer;
import com.nsc.webtemplate.model.table.Product;
import com.nsc.webtemplate.model.table.TransferData;
import com.nsc.webtemplate.model.table.TransferDisplay;
import com.nsc.webtemplate.model.table.UserTruck;
import com.nsc.webtemplate.model.table.Users;

@Controller
@RequestMapping("/home")
@SessionAttributes("isUser")
public class HomeController extends BaseController {

	@Autowired
	private TransferRepository transferRep;

	@Autowired
	private CustomerRepository customerRep;

	@Autowired
	private ProductRepository productRep;

	@Autowired
	private UserTruckRepository truckRep;

	@Autowired
	private UsersRepository userRep;

	@RequestMapping("/login")
	public ModelAndView loginAction(@RequestParam(value = "username") String userName,
			@RequestParam(value = "password") String passWord, HttpServletRequest req) {
		Users user = userRep.findByUserNameAndPassWord(userName, passWord);
		if (user == null) {
			ModelAndView loginView = new ModelAndView("login");
			loginView.addObject("message", "User does not exist");
			return loginView;
		} else {
			// isUser = userName;
			req.getSession().setAttribute("isUser", userName);
			return goToLanding();
		}

	}

	@RequestMapping("/landing")
	public ModelAndView list() {
		return goToLanding();
	}

	private ModelAndView goToLanding() {
		ModelAndView view = new ModelAndView("landing");
		List<TransferData> transferLst = transferRep.findAll();
		List<TransferDisplay> transferDisplays = toTransferDisplay(transferLst);
		view.addObject("displays", transferDisplays);
		return view;
	}

	private List<TransferDisplay> toTransferDisplay(List<TransferData> transferData) {
		List<TransferDisplay> ret = new ArrayList<>();
		for (TransferData data : transferData) {
			String customerId = data.getCustomerid();
			Customer customer = customerRep.findOne(customerId);
			String itemId = data.getProductid();
			Product product = productRep.findOne(itemId);
			UserTruck userTruck = truckRep.findOne(data.getTruckid());

			try {
				TransferDisplay transferDisp = new TransferDisplay();
				transferDisp.setId(data.getId());
				transferDisp.setTruckName(userTruck.getCsUser());
				transferDisp.setCustomerName(customer.getCsCustomerName());
				transferDisp.setItemName(product.getCsItem());
				transferDisp.setNumberOfSale(data.getAmount());

				SimpleDateFormat sd = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", new Locale("th", "TH"));
				transferDisp.setDateCheckIn(sd.format(data.getCheckInDate()));
				ret.add(transferDisp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

}
