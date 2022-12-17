package com.cloth.cloth4cause.service;

import com.cloth.cloth4cause.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsersService {

    @Autowired
    public UsersRepository usersRepository;
    public List<Map<String,Object>> getById(int id){
        return new ArrayList<>(usersRepository.getById(id));
    }

    public void addUser(String address, int contact,String first_name, String description,String img,boolean is_user_donor,boolean is_userngo, String password)
    {
        usersRepository.createuser(address,contact,first_name,description,img,is_user_donor,is_userngo,password);

    }


}
