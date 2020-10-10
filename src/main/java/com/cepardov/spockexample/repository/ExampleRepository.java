package com.cepardov.spockexample.repository;

import com.cepardov.spockexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<User, Long> {
}
