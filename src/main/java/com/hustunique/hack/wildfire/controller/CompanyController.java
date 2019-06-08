package com.hustunique.hack.wildfire.controller;

import com.hustunique.hack.wildfire.dao.CompanyDao;
import com.hustunique.hack.wildfire.model.*;
import com.hustunique.hack.wildfire.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/company", produces = "application/json;charset=UTF-8")
public class CompanyController {
	@Autowired
	private CompanyDao companyDao;

	/**
	 * 更改属性
	 *
	 * @return json
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String putItemById(@RequestBody CompanyLoginModel listModel) {
		System.out.println("开始修改活动数据...");
		boolean b = false;
		String ret;
		try {
			List<CompanyModel> list = companyDao.login(listModel);
			b = !list.isEmpty();
			if (b) {
				ret = Helper.returnResultWithNull(list.get(0));
			} else {
				ret = Helper.returnFailedWithNull("登录失败，请检查用户名");
			}
			return ret;
		} catch (Exception e) {
			ret = Helper.returnFailedWithNull("登录失败");
			e.printStackTrace();
			return ret;
		}
	}

	/**
	 * 更改属性
	 *
	 * @return json
	 */
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public String update(@RequestBody ListModel listModel) {
		System.out.println("开始修改活动数据...");
		boolean b = false;
		String ret = "";
//		try {
//			b = companyDao.updateItem(listModel);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (b) {
//			ret = Helper.returnResult(listModel);
//		} else {
//			ret = Helper.returnResult(null);
//		}
		return ret;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String add(@RequestBody ListModel listModel) {
		System.out.println("添加活动数据...");
		boolean b = false;
//		try {
//			b = companyDao.addItem(listModel);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return retBooleanJsonResult(b);
	}

	private String retBooleanJsonResult(boolean b) {
		String ret;
		if (b) {
			ret = Helper.returnResult(true);
		} else {
			ret = Helper.returnResult(false);
		}
		return ret;
	}

}
