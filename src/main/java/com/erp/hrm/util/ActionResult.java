package com.erp.hrm.util;

/**
 * Created by SOHAG on 5/16/2018.
 */
public class ActionResult {
    private boolean isSuccess;
    private String successMessage;
    private String errorMessage;
    private String employeeCode;

    public ActionResult(){
    }

    public ActionResult(boolean isSuccess,String successMessage,String errorMessage,String employeeCode){
        this.isSuccess = isSuccess;
        this.successMessage = successMessage;
        this.errorMessage = errorMessage;
        this.employeeCode = employeeCode;
    }

    public boolean getIsSuccess(){
        return isSuccess;
    }
    public void setIsSuccess(boolean isSuccess){
        this.isSuccess = isSuccess;
    }

    public String getSuccessMessage(){
        return successMessage;
    }
    public void setSuccessMessage(String successMessage){
        this.successMessage = successMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getEmployeeCode(){
        return employeeCode;
    }
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = employeeCode;
    }
}
