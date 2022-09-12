package com.erp.hrm.repository;

import com.erp.hrm.api.dto.UserDTO;
import com.erp.hrm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);
    
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email= :searchKey OR u.userName = :searchKey")
    Optional<User> findUserByEmailOrUserName(@Param("searchKey")String searchKey);

    @Query("SELECT u FROM User u WHERE u.email= :pEmail")
    User findOneByEmail(@Param("pEmail")String pEmail);

    @Query("SELECT  emp.salutation,emp.firstName,emp.middleName,emp.lastName, " +
            "u.userRole, u.userName,u.password, u.email, u.isAdmin, u.isActive, u.employeeCode " +
            "FROM User u " +
            "JOIN EmployeeInfo emp ON u.employeeCode = emp.employeeCode " +
            "and u.email= :pEmail")
//    Object[] getUserDetails(@Param("pEmail")String pEmail);
    UserDTO getUserDetails(@Param("pEmail")String pEmail);

    @Query("SELECT emp.salutation,emp.firstName,emp.middleName,emp.lastName, " +
            "u.userRole, u.userName,u.password, u.email, u.isAdmin, u.isActive, u.employeeCode " +
            "FROM User u " +
            "JOIN EmployeeInfo emp ON u.employeeCode = emp.employeeCode " +
            "WHERE u.userName= :pUserName")
    Object[] getUserDetailsByUserName(@Param("pUserName")String pUserName);

    @Query("SELECT u FROM User u WHERE u.employeeCode = :pEmpCode or u.email= :pEmail or u.userName= :pUserName")
    User checkExists(@Param("pEmpCode")String pEmpCode, @Param("pEmail")String pEmail, @Param("pUserName")String pUserName);

}
