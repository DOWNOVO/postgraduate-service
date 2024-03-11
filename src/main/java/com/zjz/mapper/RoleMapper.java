package com.zjz.mapper;




import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    String getByName(String name);
}
