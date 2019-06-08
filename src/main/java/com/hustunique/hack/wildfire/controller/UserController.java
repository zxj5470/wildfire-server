package com.hustunique.hack.wildfire.controller;

import com.hustunique.hack.wildfire.model.ServerResponse;
import com.hustunique.hack.wildfire.util.*;
import org.springframework.web.bind.annotation.*;

import static com.hustunique.hack.wildfire.util.Helper.jsonParser;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json;charset=UTF-8")
public class UserController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("code") String code) {
		String appid = WFConstants.WX_APPID;
		String secret = WFConstants.WX_SECRET;
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
			return Helper.returnResult(openid);
		} catch (Exception e) {
			e.printStackTrace();
			return Helper.returnResult(e.getMessage());
		}
//		return ;
	}
}
