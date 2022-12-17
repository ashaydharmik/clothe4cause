package com.cloth.cloth4cause.repository;

import com.cloth.cloth4cause.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


public interface UsersRepository extends JpaRepository<Users,Integer> {

    @Query(value = "select * from users u where u.id=?1", nativeQuery = true)
    List<Map<String, Object>> getById(@Param("id") int id);

    @Modifying
    @Query(value = "insert into users(address,contact,first_name,description,img,is_user_donor,is_userngo,password) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)",nativeQuery = true)

    void createuser(@Param("address") String address, @Param("contact") int contact ,@Param("first_name") String first_name,@Param("description") String description,@Param("img") String img,@Param("is_userngo") boolean is_userngo,@Param("is_user_donor") boolean is_user_donor,@Param("password") String password);
}