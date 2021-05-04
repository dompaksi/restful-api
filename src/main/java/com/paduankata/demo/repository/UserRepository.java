package com.paduankata.demo.repository;

import com.paduankata.demo.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query("select u from User u")
  public List<User> getAllUsers();

  Optional<User> findByEmail(String email);
}
