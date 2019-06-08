package com.hustunique.hack.wildfire.dao;

import com.hustunique.hack.wildfire.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyDao {
//	@Update("UPDATE wildfire.activity " +
//			"set startTime=#{startTime}, " +
//			"endTime=#{endTime}, " +
//			"introduction=#{introduction}, " +
//			"timeflow=#{timeflow} where id=#{id} and orgId=#{orgId}")
//	boolean update(ListModel model);
//
//	@Insert("INSERT into wildfire.activity(orgId, startTime, endTime, introduction, timeFlow) values(#{orgId},#{startTime},#{endTime},#{introduction},#{timeFlow})")
//	boolean add(ListModel model);

	@Select("select * from company_user where username=#{username} and passwdmd5=#{passwdmd5} limit 1")
	List<CompanyModel> login(CompanyLoginModel model);

	@Select("select * from activity where orgId=#{orgId}")
	List<ListModel> getActivities(CompanyQueryModel model);

	@Insert("insert into company_user (username, company_name, passwdmd5, introduction) values (#{username},#{company_name},#{passwdmd5},#{introduction})")
	boolean insert(CompanyAddModel model);
//	@Delete("DELETE FROM wildfire.activity where id=#{id}")
//	boolean deleteItem(String id);
}
