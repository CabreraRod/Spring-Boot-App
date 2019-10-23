package com.rodrigo.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.app.entity.Role;
import com.rodrigo.app.entity.User;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	public Role findByName(String role);
}
