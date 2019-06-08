package com.hustunique.hack.wildfire.model

class CompanyModel(var id: Int,
				   var username: String,
				   var company_name: String,
				   var passwdmd5: String,
				   var introduction: String?
)

class CompanyAddModel(var username: String,
				   var company_name: String,
				   var passwdmd5: String,
				   var introduction: String?
)

class CompanyLoginModel(var username: String,
						var passwdmd5: String)

class CompanyQueryModel(var orgId: Int = 0)