package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.UserDTO;
import com.erp.hrm.domain.CustomUserDetails;
import com.erp.hrm.domain.User;
import com.erp.hrm.repository.UserRepository;
import com.erp.hrm.service.UserInfoService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.ErpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserRepository userRepository;

    public UserInfoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUser(String pEmail){
        //Object []data  = userRepository.getUserDetails(pEmail);
       // Object[] user = (Object[]) data[0];
    	//User user= userRepository.getUserDetails(pEmail);
    	
    	UserDTO userDTO= userRepository.getUserDetails(pEmail);
    	System.out.println("User on HRM==>"+userDTO);
    	
//        UserDTO userDTO = new UserDTO();

//        userDTO.setName(user[0].toString() + user[1].toString()+ " " + user[3] +" " +user[2]);
//        userDTO.setUserRole(user[4].toString());
//        userDTO.setUserName(user[5].toString());
//        userDTO.setEmail(user[7].toString());
//        userDTO.setAdmin(user[8].toString() == "1"? true : false);
//        userDTO.setActive(user[9].toString() == "1"? true: false);
//        userDTO.setEmployeeCode(user[10].toString());
//        userDTO.setPassword(null);

        //userDTO.setName(userDTO.getName().trim());
        //userDTO.setName(user.getUserName().trim());
//        System.out.println("User Get Email==>"+user.getEmail());

        return userDTO;
    }

    @Override
    public ActionResult saveUser(UserDTO dto) {

        ActionResult actionResult = new ActionResult();
        try {
            User  user  = userRepository.checkExists(dto.getEmployeeCode(),dto.getEmail(),dto.getUserName());
            if (user != null){
                if(user.getEmail().equalsIgnoreCase(dto.getEmail()))
                    throw new RuntimeException("Email Address already exists");
//                else if(user.getEmployeeCode().equalsIgnoreCase(dto.getEmployeeCode()))
//                    throw new RuntimeException("This Ussr already has an account");
                else if(user.getUserName().equalsIgnoreCase(dto.getUserName()))
                    throw new RuntimeException("User Name already exists");
            }

            user = new User();

            user.setEmail(dto.getEmail());
            user.setEmployeeCode(dto.getEmployeeCode());
            user.setUserName(dto.getUserName());
            user.setUserRole(dto.getUserRole());
            user.setPassword(ErpUtils.encoded(dto.getPassword()));
            user.setIsActive(1);
            user.setIsAdmin(dto.isAdmin() == true? 1 : 0);

            userRepository.save(user);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("User successfully saved");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }
}
