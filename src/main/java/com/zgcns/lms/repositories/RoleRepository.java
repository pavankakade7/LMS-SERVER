package com.zgcns.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zgcns.lms.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
