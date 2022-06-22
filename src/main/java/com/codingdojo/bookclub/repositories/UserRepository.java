package com.codingdojo.bookclub.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.bookclub.models.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // this method retrieves all the books from the database
	Optional<User> findByEmail(String email);
	List<User> findAll();
}
    
    

