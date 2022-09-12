package com.erp.hrm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
//import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Users",  uniqueConstraints = { @UniqueConstraint( columnNames = { "UserName" } ) } )
public class User extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Size(max = 50)
    @Column(name = "UserRole", length = 20)
    private String userRole;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserName", length = 20)
    private String userName;

    @NotNull
    @Column(name = "Password", length = 512)
    private String password;

    @NotNull
    @Column(name = "Email", length = 50)
    private String email;

    @NotNull
    @Column(name = "IsAdmin")
    private int isAdmin;

    @NotNull
    @Column(name = "IsActive")
    private int isActive;

    @Column(name = "EmployeeCode", length = 20)
    private String employeeCode;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
        name = "UserWiseRole",
        joinColumns = {@JoinColumn(name="UserID", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name="roleId", referencedColumnName = "id")}
    )   
    private List<UserRole> roleList;

    public User() {
    }

//    public User(User user) {
//        this.setId(user.getId());
//        this.userRole  = user.getUserRole();
//        this.userName = user.getUserName();
//        this.password = user.getPassword();
//        this.email = user.getEmail();
//        this.employeeCode = user.getEmployeeCode();
//        this.isAdmin = user.getIsAdmin();
//        this.isActive = user.getIsActive();
//        
//        this.roleList= user.roleList;
//
//        this.setAddedBy(user.getAddedBy());
//        this.setUpdatedBy(user.getUpdatedBy());
//        this.setUpdatedDate(user.getUpdatedDate());
//    }
    
    
    public User(User user) {
    	
        this.setId(user.getId());
        this.userRole  = user.userRole;
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.employeeCode = user.employeeCode;
        this.isAdmin = user.isAdmin;
        this.isActive = user.isActive;
        
        this.roleList= user.roleList;

        this.setAddedBy(user.getAddedBy());
        this.setUpdatedBy(user.getUpdatedBy());
        this.setUpdatedDate(user.getUpdatedDate());
    }


    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole){
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int IsAdmin) {
        this.isAdmin = IsAdmin;
    }
    
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    
    
    
    public List<UserRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<UserRole> roleList) {
		this.roleList = roleList;
	}
    
    @Transient
	public String getRoleName() {
		String roleName="";
		List<UserRole> roles=getRoleList();
		for(UserRole role:roles) {
			
			roleName=role.getUserRoleName();
		}
		return roleName;
	}
	
	@Transient
	public Long getRoleId() {
		Long roleId=null;
		List<UserRole> roles=getRoleList();
		for(UserRole role:roles) {
			
			roleId=role.getId();
		}
		return roleId;
	}

}
