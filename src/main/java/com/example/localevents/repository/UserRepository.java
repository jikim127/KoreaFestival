package com.example.localevents.repository;

import com.example.localevents.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email); // 회원가입시 중복회원이 있는지 이메일로 회원검사


//    @EntityGraph(attributePaths = "roleSet")
//    @Query("select u from User u where u.id = :id and u.social = false ")
//    Optional<User> getWithRoles(String username);
}
