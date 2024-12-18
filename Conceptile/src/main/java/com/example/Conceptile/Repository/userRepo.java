package com.example.Conceptile.Repository;

import com.example.Conceptile.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Long> {
}
