package com.bjy.myapp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjy.myapp.sep.StanderDataBasePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StanderDataBaseDao extends BaseMapper<StanderDataBasePojo> {
    @Select("SELECT * FROM myapp.stander_data_base_pojo order by date_time desc limit 20")
    public List<StanderDataBasePojo> mainPageLoad();

}
