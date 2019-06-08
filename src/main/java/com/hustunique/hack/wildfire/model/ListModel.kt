package com.hustunique.hack.wildfire.model

import java.sql.Timestamp

class ListModel(var id: Int,
				var orgId: Int,
				var startTime: Timestamp,
				var endTime: Timestamp,
				var introduction: String,
				var timeFlow: String)