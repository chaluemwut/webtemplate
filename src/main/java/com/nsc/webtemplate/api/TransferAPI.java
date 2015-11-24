package com.nsc.webtemplate.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nsc.webtemplate.Config;
import com.nsc.webtemplate.model.TransferRepository;
import com.nsc.webtemplate.model.table.TransferData;

@Controller
@RequestMapping(Config.apiBaseName+"/transferapi")
public class TransferAPI extends BaseAPI {
	private int errorStatus;
	private String errorMessage;

	@Autowired
	private TransferRepository transferRepository;

	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData userLogin(@RequestParam(value = "truckid") String truckid,
			@RequestParam(value = "customerid") String customerid, @RequestParam(value = "productid") String productid,
			@RequestParam(value = "amount") int amount, @RequestParam(value = "datetime") String datetime) {
		ResponseData res = new ResponseData();
		if (isValidation()) {
			TransferData transferData = new TransferData();
			transferData.setTruckid(truckid);
			transferData.setCustomerid(customerid);
			transferData.setProductid(productid);
			transferData.setProductid(productid);
			transferData.setAmount(amount);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy||hh:mm:ss||aa");
			try {
				Date dataDate = format.parse(datetime);
				transferData.setCheckInDate(dataDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			transferRepository.save(transferData);
			res.setStatusCode(0);
			res.setDescription("Status OK");
		} else {
			res.setStatusCode(errorStatus);
			res.setDescription(errorMessage);
		}
		return res;
	}

	public boolean isValidation() {
		return true;
	}
}
