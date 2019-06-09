package com.hustunique.hack.wildfire.dao;

import com.hustunique.hack.wildfire.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyDao {
	@Update("UPDATE wildfire.company_user " +
			"set teamName=#{teamName}, " +
			"teamBelong=#{teamBelong}, " +
			"teamLeader=#{teamLeader}, " +
			"teamIntro=#{teamIntro} where id=#{id}")
	boolean update(CompanyModel model);

	@Select("select * from company_user where account=#{username} and passwdmd5=#{passwdmd5} limit 1")
	List<CompanyModel> login(CompanyLoginModel model);

	@Select("select * from activity where orgId=#{orgId}")
	List<ListModel> getActivities(CompanyQueryModel model);

	@Insert("insert into company_user (account, teamName, passwdmd5, teamBelong, teamLeader, teamIntro) " +
			"values (#{account},#{teamName},#{passwdmd5},#{teamBelong},#{teamLeader},#{teamIntro})")
	boolean insert(CompanyAddModel model);
//	@Delete("DELETE FROM wildfire.activity where id=#{id}")
//	boolean deleteItem(String id);
}
