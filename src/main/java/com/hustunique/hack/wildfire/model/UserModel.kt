package com.hustunique.hack.wildfire.model

class UserModel(var id: Int,
				var wx_id: String,
				var wx_name: String,
				var nickname: String,
				var introduction: String
)

class UserAddModel(var wx_id: String,
				var wx_name: String)