package com.zjz.service;


import com.zjz.untils.Result;


import java.util.List;

public interface RoleService {
//    Role getByRoleName(String users);


    Result getByUsers(String token, String path);

    Boolean getByAuthorization(String token, List<String> authorization);

    Result getByAdminOrUsers(String token, String path);

    Result getByAdmin(String token, String path);
}
