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
	 * 企业登录
	 *
	 * @return json
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody CompanyLoginModel listModel) {
		System.out.println("登录活动数据...");
		String ret;
		try {
			List<CompanyModel> list = companyDao.login(listModel);
			boolean b = !list.isEmpty();
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
	 * TODO
	 * 更改属性
	 *
	 * @return 请求结果
	 */
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public String update(@RequestBody CompanyModel companyModel) {
		System.out.println("开始修改活动数据...");
		boolean b = false;
		String ret;
		try {
			b = companyDao.update(companyModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ret = Helper.booleanToResult(b);
		return ret;
	}

	/**
	 * 企业添加
	 *
	 * @param model
	 * @return 请求结果
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String add(@RequestBody CompanyAddModel model) {
		System.out.println("添加活动数据...");
		boolean b = false;
		try {
			b = companyDao.insert(model);
			return Helper.booleanToResult(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Helper.booleanToResult(b);
	}

	/**
	 * 获取当前 company 的所有 Activity
	 *
	 * @param model 请求。只有一个参数 {"orgId":23333}
	 * @return 请求结果
	 */
	@RequestMapping(value = "/acts", method = RequestMethod.POST)
	public String getOwnActs(@RequestBody CompanyQueryModel model) {
		List<ListModel> list = companyDao.getActivities(model);
		return Helper.returnResult(list);
	}
}
