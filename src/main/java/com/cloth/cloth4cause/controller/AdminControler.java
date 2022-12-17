package com.cloth.cloth4cause.controller;

import com.cloth.cloth4cause.exceptionhandler.GetResponseHandler;
import com.cloth.cloth4cause.exceptionhandler.PostResponseHandler;
import com.cloth.cloth4cause.repository.AdminRepository;
import com.cloth.cloth4cause.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AdminControler {

    @Autowired
    public AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/delUser")
    public ResponseEntity<Object> saveUser(@RequestParam int id){
        try{
            adminService.deleteUser(id);
            boolean bool=true;
            return PostResponseHandler.getPostResponse("success", HttpStatus.OK,bool);
        }catch(Exception e) {
            boolean bool = false;
            return PostResponseHandler.getPostResponse(e.getMessage(), HttpStatus.MULTI_STATUS, bool);
        }
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<Object> getUsers(){
        try{
            List<Map<String,Object>> getUsers= adminRepository.getUsers();
            boolean bool=true;
            return GetResponseHandler.generateCustomGetResponse("success",HttpStatus.OK,getUsers ,bool);
        }catch(Exception e){
            boolean bool=false;
            return GetResponseHandler.generateCustomGetResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null,bool);
        }
    }

}
