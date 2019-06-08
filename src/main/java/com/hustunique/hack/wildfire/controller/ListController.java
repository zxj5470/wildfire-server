package com.hustunique.hack.wildfire.controller;

import com.hustunique.hack.wildfire.dao.ListDao;
import com.hustunique.hack.wildfire.model.ListModel;
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
		System.out.println("开始查询所有列表数据...");
		String ret = Helper.returnResult(listDao.getList());
		return ret;
	}

	/**
	 * 更改属性
	 *
	 * @return json
	 */
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public String putItemById(@RequestBody ListModel listModel) {
		System.out.println("开始修改活动数据...");
		boolean b = false;
		try {
			b = listDao.updateItem(listModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret;
		if (b) {
			ret = Helper.returnResult(listModel);
		} else {
			ret = Helper.returnResult(null);
		}
		return ret;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addItemById(@RequestBody ListModel listModel) {
		System.out.println("开始修改活动数据...");
		boolean b = false;
		try {
			b = listDao.addItem(listModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret;
		if (b) {
			ret = Helper.returnResult(true);
		} else {
			ret = Helper.returnFailed("添加失败");
		}
		return ret;
	}
}
