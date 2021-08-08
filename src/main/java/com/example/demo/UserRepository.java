package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UserPk> {

    @Query("select u FROM User u WHERE u.userPk.id1 = :id1 AND u.userPk.id2 = :id2")
    User findByUserPkId1AndUserPkId2(@Param("id1") String id1, @Param("id2") String id2);
}