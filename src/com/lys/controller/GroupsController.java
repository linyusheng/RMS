package com.lys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lys.service.GroupsService;

@Controller
public class GroupsController {
	
	@Autowired
	private GroupsService groupsService;

	public void add() {
		
	}
}
