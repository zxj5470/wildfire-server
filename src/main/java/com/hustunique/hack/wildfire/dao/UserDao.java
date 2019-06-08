package com.hustunique.hack.wildfire.dao;

import com.hustunique.hack.wildfire.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
//	@Update("UPDATE wildfire.activity " +
//			"set startTime=#{startTime}, " +
//			"endTime=#{endTime}, " +
//			"introduction=#{introduction}, " +
//			"timeflow=#{timeflow} where id=#{id} and orgId=#{orgId}")
//	boolean update(ListModel model);
//
//	@Insert("INSERT into wildfire.activity(orgId, startTime, endTime, introduction, timeFlow) values(#{orgId},#{startTime},#{endTime},#{introduction},#{timeFlow})")
//	boolean add(ListModel model);

	@Select("select * from personal_user where wx_id=#{openid} limit 1")
	List<UserModel> login(String openid);

	@Insert("insert into personal_user (wx_id, wx_name) values (#{wx_id},#{wx_name})")
	boolean add(UserAddModel openid);
//	@Delete("DELETE FROM wildfire.activity where id=#{id}")
//	boolean deleteItem(String id);
}
