package net.restapi.sapringbootcrudrestfulwebservices.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.restapi.sapringbootcrudrestfulwebservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

}
