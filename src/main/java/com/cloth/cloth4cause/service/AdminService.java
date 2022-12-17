package com.cloth.cloth4cause.service;

import com.cloth.cloth4cause.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminService {
    @Autowired
    public AdminRepository adminRepository;

    public void deleteUser(int id){
        adminRepository.delUser(id);
    }

    public List<Map<String,Object>> getUsers(){
        return new ArrayList<>(adminRepository.getUsers());
    }
}
