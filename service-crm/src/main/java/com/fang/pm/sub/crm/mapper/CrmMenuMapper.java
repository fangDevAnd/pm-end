package com.fang.pm.sub.crm.mapper;

import com.fang.pm.sub.crm.Bean.CrmMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CrmMenuMapper {

    @Select("select * from crm_menu where pid=#{pid}")
    List<CrmMenu> findAll(Integer pid);

    int insert(@Param("obj") CrmMenu menu);

    void update(CrmMenu menu);

    int del(CrmMenu menu);

    int count(CrmMenu menu);

}
