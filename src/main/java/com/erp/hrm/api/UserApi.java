package com.erp.hrm.api;

import com.erp.hrm.api.dto.UserDTO;
import com.erp.hrm.service.UserInfoService;
import com.erp.hrm.util.ActionResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Williyam on 5/13/2017.
 */

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    private UserInfoService userInfoService;

//    public UserApi(UserInfoService userInfoService) {
//        this.userInfoService = userInfoService;
//    }
//
//
//    @RequestMapping(value = "/get/{pEmail}", method = RequestMethod.GET)
//    public UserDTO getUserByEmail(@PathVariable("pEmail")String pEmail){
//        return userInfoService.getUser(pEmail);
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult saveUserByEmail(@RequestBody UserDTO dto){
        return userInfoService.saveUser(dto);
    }

}
