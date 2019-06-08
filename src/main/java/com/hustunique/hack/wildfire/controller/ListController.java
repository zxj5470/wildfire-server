package com.hustunique.hack.wildfire.controller;

import com.hustunique.hack.wildfire.dao.ListDao;
import com.hustunique.hack.wildfire.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/list", produces = "application/json;charset=UTF-8")
public class ListController {
	@Autowired
	private ListDao listDao;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getAllItems() {
		System.out.println("开始查询所有数据...");
		String ret = Helper.returnResult(listDao.getList());
		return ret;
	}
}
