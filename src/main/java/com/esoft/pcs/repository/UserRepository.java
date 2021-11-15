package com.esoft.pcs.repository;

import com.esoft.pcs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
