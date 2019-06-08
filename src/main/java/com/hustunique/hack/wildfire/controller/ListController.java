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

	/**
	 * 获取所有内容项
	 *
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getAllItems() {
		System.out.println("开始查询所有列表数据...");
		String ret = Helper.returnResult(listDao.getList());
		return ret;
	}

	/**
	 * 单个活动内容的属性
	 *
	 * @return json
	 */
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public String putItemById(@RequestBody ListModel listModel) {
		System.out.println("开始修改活动数据...");
		boolean b = false;
		String ret;
		try {
			b = listDao.updateItem(listModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (b) {
			ret = Helper.returnResult(listModel);
		} else {
			ret = Helper.returnResult(null);
		}
		return ret;
	}

	/**
	 * 添加活动内容项
	 * @param listModel
	 * @return
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String addItemById(@RequestBody ListModel listModel) {
		System.out.println("添加活动数据...");
		boolean b = false;
		try {
			b = listDao.addItem(listModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Helper.booleanToResult(b);
	}

	/**
	 * 删除单条活动内容
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteItemById(@RequestParam("id") String id) {
		System.out.println("删除活动数据...");
		boolean b = false;
		try {
			b = listDao.deleteItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Helper.booleanToResult(b);
	}
}
