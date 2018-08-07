package org.launchcode.assigner.models.data;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.launchcode.assigner.models.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByRole(String role);

}