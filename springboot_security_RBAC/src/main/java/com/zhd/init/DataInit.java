package com.zhd.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zhd.domain.Permission;
import com.zhd.domain.Role;
import com.zhd.domain.UserInfo;
import com.zhd.repository.PermissionRepository;
import com.zhd.repository.RoleRepository;
import com.zhd.repository.UserInfoRepository;

/**
 * Created by iandtop on 2018/12/11.
 */
@Service
public class DataInit {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @PostConstruct
    public void dataInit() {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        adminRole.setDescription("管理员");
        roleRepository.save(adminRole);

        Role normalRole = new Role();
        normalRole.setName("ROLE_USER");
        normalRole.setDescription("普通用户");
        roleRepository.save(normalRole);


        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);
        roles.add(normalRole);
        UserInfo admin = new UserInfo();
        admin.setPassword(passwordEncoder.encode("1"));
        admin.setUsername("a");
        admin.setRoles(roles);
        userInfoRepository.save(admin);

        roles = new ArrayList<>();
        roles.add(normalRole);
        UserInfo user = new UserInfo();
        user.setPassword(passwordEncoder.encode("1"));
        user.setUsername("u");
        user.setRoles(roles);
        userInfoRepository.save(user);


        //permission.
        roles = new ArrayList<>();
        roles.add(normalRole);
        Permission permission1 = new Permission();
        permission1.setUrl("/helloUser");
        permission1.setName("普通用户URL");
        permission1.setDescription("普通用户的访问路径");
        permission1.setRoles(roles);
        permissionRepository.save(permission1);

        Permission permission2 = new Permission();
        permission2.setUrl("/helloAdmin");
        permission2.setName("管理员URL");
        permission2.setDescription("管理员的访问路径");
        List<Role> roles2 = new ArrayList<>();
        roles2.add(adminRole);
        permission2.setRoles(roles2);
        permissionRepository.save(permission2);
    }
}
