package com.hustunique.hack.wildfire.dao;

import com.hustunique.hack.wildfire.model.ListModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ListDao {
	@Select("SELECT * FROM wildfire.activity")
	List<ListModel> getList();

	@Update("UPDATE wildfire.activity " +
			"set startTime=#{startTime}, " +
			"endTime=#{endTime}, " +
			"introduction=#{introduction}, " +
			"timeflow=#{timeflow} where id=#{id} and orgId=#{orgId}")
	boolean updateItem(ListModel model);

	@Insert("INSERT into wildfire.activity(orgId, startTime, endTime, introduction, timeFlow) values(#{orgId},#{startTime},#{endTime},#{introduction},#{timeFlow})")
	boolean addItem(ListModel model);

	@Delete("DELETE FROM wildfire.activity where id=#{id}")
	boolean deleteItem(String id);
}
