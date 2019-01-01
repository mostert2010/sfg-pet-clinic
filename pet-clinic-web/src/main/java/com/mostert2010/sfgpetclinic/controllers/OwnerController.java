package com.mostert2010.sfgpetclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mostert2010.sfgpetclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private final OwnerService ownerService;

	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/", "/index", "/index.html" })
	public String listOwners(Model model) {
		
		model.addAttribute("owners", ownerService.findAll());
		
		return "owners/index";
	}
}
