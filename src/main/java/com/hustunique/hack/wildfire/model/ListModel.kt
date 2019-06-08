package com.hustunique.hack.wildfire.model

import java.sql.Timestamp

class ListModel(var id: Int = 0,
				var orgId: Int = 0,
				var startTime: Timestamp,
				var endTime: Timestamp,
				var introduction: String = "",
				var timeflow: String = "")