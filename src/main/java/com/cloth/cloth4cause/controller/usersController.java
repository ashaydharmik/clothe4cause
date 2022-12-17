package com.cloth.cloth4cause.controller;

import com.cloth.cloth4cause.exceptionhandler.GetResponseHandler;
import com.cloth.cloth4cause.exceptionhandler.PostResponseHandler;
import com.cloth.cloth4cause.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class usersController {
    @Autowired
    public UsersService usersService;
    @GetMapping("/by-id")
    public ResponseEntity<Object> getById(@RequestParam Integer id){
        try{
            List<Map<String,Object>> getId= usersService.getById(id);
            boolean bool=true;
            return GetResponseHandler.generateCustomGetResponse("success",HttpStatus.OK,getId,bool);
        }catch(Exception e){
            boolean bool=false;
            return GetResponseHandler.generateCustomGetResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,bool);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> saveUser(@RequestBody Map<String,Object> ls){
        try{
             String first_name= (String) ls.get("first_name");
             String address= (String) ls.get("address");
             int contact= (int) ls.get("contact");
             boolean is_userngo= (boolean) ls.get("is_userngo");
             boolean is_user_donor= (boolean) ls.get("is_user_donor");
             String password= (String) ls.get("password");
             String img= (String) ls.get("img");
             String description= (String) ls.get("description");
             usersService.addUser(address,contact,first_name,description,img,is_user_donor,is_userngo,password);
             boolean bool=true;
             return PostResponseHandler.getPostResponse("success",HttpStatus.OK,bool);
    }catch(Exception e) {
            boolean bool = false;
            return PostResponseHandler.getPostResponse(e.getMessage(), HttpStatus.MULTI_STATUS, bool);
        }
    }


}
