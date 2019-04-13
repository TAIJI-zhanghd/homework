package com.zhd.service.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import com.zhd.domain.Permission;
import com.zhd.domain.Role;
import com.zhd.repository.PermissionRepository;
import com.zhd.service.PermissionService;

/**
 * Created by iandtop on 2018/12/11.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private Map<String, Collection<ConfigAttribute>> permissionMap = null;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Map<String, Collection<ConfigAttribute>> getPermissionMap() {
        if (permissionMap == null || permissionMap.size() == 0) {
            initPermissions();
        }

        return permissionMap;
    }

    @PostConstruct
    public void initPermissions() {
        //程序启动后，立即自动 执行
        //初始化permissionMap
        //key =  ulr
        //value = [role1,role2] ;
        permissionMap = new HashMap();
        List<Permission> permissions = permissionRepository.findAll();
        for (Permission p : permissions) {
            Collection<ConfigAttribute> collection = new ArrayList<ConfigAttribute>();
            for (Role role : p.getRoles()) {
                ConfigAttribute cfg = new SecurityConfig(role.getName());
                collection.add(cfg);
            }
            permissionMap.put(p.getUrl(), collection);
        }

    }
}
