package com.hustunique.hack.wildfire.controller;

import com.google.gson.JsonObject;
import com.hustunique.hack.wildfire.dao.UserDao;
import com.hustunique.hack.wildfire.model.UserAddModel;
import com.hustunique.hack.wildfire.model.UserModel;
import com.hustunique.hack.wildfire.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hustunique.hack.wildfire.util.Helper.jsonParser;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json;charset=UTF-8")
public class UserController {
	@Autowired
	private UserDao userDao;

	/**
	 * 用户登录。如果用户表中没有就进行创建，并返回 id 属性。其中 id 属性应保存在小程序中。
	 * @param code
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("code") String code,@RequestParam("userInfo")String userInfo) {
		String appid = WFConstants.WX_APPID;
		String secret = WFConstants.WX_SECRET;
		System.out.println(userInfo);
		try {
			String ret = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?" +
					"appid=" + appid +
					"&secret=" + secret +
					"&js_code=" + code +
					"&grant_type=authorization_code", null);
			if (ret == null) {
				return Helper.returnFailed("服务器请求出错");
			}
			String openid = jsonParser.parse(ret).getAsJsonObject().get("openid").getAsString();
			List<UserModel> list = userDao.login(openid);
			JsonObject obj  = jsonParser.parse(userInfo).getAsJsonObject();
			String nickName = obj.get("nickName").getAsString();
			if(list.isEmpty()){
				boolean b = userDao.add(new UserAddModel(openid,nickName));
				if(b) {
					list = userDao.login(openid);
				}else{
					Helper.returnFailedWithNull("新建用户失败");
				}
			}
			return Helper.returnResult(list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			return Helper.returnFailedWithNull(e.getMessage());
		}
//		return ;
	}
}
