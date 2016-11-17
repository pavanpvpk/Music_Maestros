package com.musiccamp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.musiccamp.entities.UserLogin;


/**
 * Spring Data Interface. Fetches all the column names and data from table user_login
 * @author Pavan Kumar Pedda Vakkalam and Manasa Bojja
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserLogin, Integer>{

	<S extends UserLogin> S save(S entity);

}
