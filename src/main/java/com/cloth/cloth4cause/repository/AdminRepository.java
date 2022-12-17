package com.cloth.cloth4cause.repository;

import com.cloth.cloth4cause.entites.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface AdminRepository extends JpaRepository <Admin,Integer>{
    @Modifying
    @Query(value = "delete from users u where u.id=?1",nativeQuery = true)
    void delUser(@Param("id") int id);

    @Modifying
    @Query(value = "select * from users",nativeQuery = true)
    List<Map<String,Object>> getUsers();



}
