package com.erp.hrm.api.dto;

import java.util.Date;

/**
 * Created by Sohag on 29/05/2018.
 */
public class EmployeeDetailsDTO {

    private String EmployeeCode;
    private String DisplayEmployeeCode;
    private String Salutation;
    private String Fname;
    private String Mname;
    private String Lname;
    private String Nick;
    private String PunchCardNo;
    private String EMail;
    private Date DOJ;
    private Date DOC;
    private Date DOS;
    private Date ReDOJ;
    private String EmployeeStatus;
    private Integer DesignationID;
    private String StepCode;
    private String SalaryRuleCode;
    private boolean TransactionEffective;
    private Date SuspensionDate;
    private String DepartmentName;
    private String DesignationName;
    private String FloorName;
    private String LineName;

    public EmployeeDetailsDTO(){
    }

    public EmployeeDetailsDTO(
            String EmployeeCode, String DisplayEmployeeCode, String Salutation, String Fname, String Mname, String Lname,
            String Nick, String PunchCardNo, String EMail, Date DOJ, Date DOC, Date DOS, String EmployeeStatus,
            Integer DesignationID, String StepCode, String SalaryRuleCode, boolean TransactionEffective, Date SuspensionDate,
            Date ReDOJ,String DepartmentName,String DesignationName,String FloorName,String LineName
        )
    {
        this.EmployeeCode = EmployeeCode;
        this.DisplayEmployeeCode = DisplayEmployeeCode;
        this.Salutation = Salutation;
        this.Fname = Fname;
        this.Mname = Mname;
        this.Lname = Lname;
        this.Nick = Nick;
        this.PunchCardNo = PunchCardNo;
        this.EMail = EMail;
        this.DOJ = DOJ;
        this.DOC = DOC;
        this.DOS = DOS;
        this.ReDOJ = ReDOJ;
        this.EmployeeStatus = EmployeeStatus;
        this.DesignationID = DesignationID;
        this.StepCode = StepCode;
        this.SalaryRuleCode = SalaryRuleCode;
        this.TransactionEffective = TransactionEffective;
        this.SuspensionDate = SuspensionDate;
        this.DepartmentName = DepartmentName;
        this.DesignationName = DesignationName;
        this.FloorName = FloorName;
        this.LineName = LineName;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getDisplayEmployeeCode() {
        return DisplayEmployeeCode;
    }

    public void setDisplayEmployeeCode(String DisplayEmployeeCode) {
        this.DisplayEmployeeCode = DisplayEmployeeCode;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String Salutation) {
        this.Salutation = Salutation;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String Mname) {
        this.Mname = Mname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getPunchCardNo() {
        return PunchCardNo;
    }

    public void setPunchCardNo(String PunchCardNo) {
        this.PunchCardNo = PunchCardNo;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public Date getDOJ() {
        return DOJ;
    }

    public void setDOJ(Date DOJ) {
        this.DOJ = DOJ;
    }

    public Date getDOC(){
        return DOC;
    }

    public void setDOC(Date DOC){
        this.DOC = DOC;
    }

    public Date getDOS(){
        return DOS;
    }

    public void setReDOJ(Date RejDOJ){
        this.ReDOJ = RejDOJ;
    }

    public Date getReDOJ(){
        return ReDOJ;
    }

    public void setDOS(Date DOS){
        this.DOS = DOS;
    }

    public String getEmployeeStatus() {
        return EmployeeStatus;
    }

    public void setEmployeeStatus(String EmployeeStatus) {
        this.EmployeeStatus = EmployeeStatus;
    }

    public Integer getDesignationIDs() {
        return DesignationID;
    }

    public void setDesignationID(Integer DesignationID) {
        this.DesignationID = DesignationID;
    }

    public String getStepCode() {
        return StepCode;
    }

    public void setStepCode(String StepCode) {
        this.StepCode = StepCode;
    }

    public String getSalaryRuleCode() {
        return SalaryRuleCode;
    }

    public void setSalaryRuleCode(String SalaryRuleCode) {
        this.SalaryRuleCode = SalaryRuleCode;
    }

    public boolean getTransactionEffective() {
        return TransactionEffective;
    }

    public void setTransactionEffective(boolean TransactionEffective) {
        this.TransactionEffective = TransactionEffective;
    }

    public Date getSuspensionDate(){
        return SuspensionDate;
    }

    public void setSuspensionDate(Date SuspensionDate){
        this.SuspensionDate = SuspensionDate;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getDesignationName() {
        return DesignationName;
    }

    public void setDesignationName(String DesignationName) {
        this.DesignationName = DesignationName;
    }

    public String getFloorName() {
        return FloorName;
    }

    public void setFloorName(String FloorName) {
        this.FloorName = FloorName;
    }

    public String getLineName() {
        return LineName;
    }

    public void setLineName(String LineName) {
        this.LineName = LineName;
    }
}
