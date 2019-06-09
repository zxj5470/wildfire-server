package com.hustunique.hack.wildfire.model

class CompanyModel(var id: Int,
				   var account: String,
				   var teamName: String,
				   var teamBelong: String,
				   var teamLeader: String,
				   var teamIntro: String?
)

class CompanyAddModel(var account: String,
					  var teamName: String,
					  var passwdmd5: String,
					  var teamBelong: String,
					  var teamLeader: String,
					  var teamIntro: String?
)

class CompanyLoginModel(var username: String,
						var passwdmd5: String)

class CompanyQueryModel(var orgId: Int = 0)