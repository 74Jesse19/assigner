package org.launchcode.assigner.models.data;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.launchcode.assigner.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}