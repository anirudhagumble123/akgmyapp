package com.mphasis.akg.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.akg.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
