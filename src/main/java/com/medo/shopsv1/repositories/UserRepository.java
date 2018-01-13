package com.medo.shopsv1.repositories;

import com.medo.shopsv1.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
     Optional<User> findByEmail(String email);
}
