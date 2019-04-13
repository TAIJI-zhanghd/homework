package com.zhd.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zhd.domain.Role;

/**
 * Created by iandtop on 2018/12/11.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
