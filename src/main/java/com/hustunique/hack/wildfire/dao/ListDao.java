package com.hustunique.hack.wildfire.dao;

import com.hustunique.hack.wildfire.model.ListModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ListDao {
	@Select("SELECT * FROM wildfire.activity")
	List<ListModel> getList();
}
