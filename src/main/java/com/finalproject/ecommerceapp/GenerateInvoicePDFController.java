package com.finalproject.ecommerceapp;

import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.OrderBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Locale;



@Controller
public class GenerateInvoicePDFController {

	@RequestMapping(value = "/invoice.htm", method = RequestMethod.GET)
	public ModelAndView doProcess(@RequestParam("orderID") long id,Locale locale, ModelMap model, HttpSession session) {
		
		OrderBean orderBean = (OrderBean) session.getAttribute("orderBean");
		CustomerBean customerBean = (CustomerBean) session.getAttribute("customer");
		
		session.removeAttribute("order");
		model.addAttribute("orderBean", orderBean);
		model.addAttribute("customer", customerBean);
		
		return new ModelAndView(new InvoicePDF(), model);
	}
}