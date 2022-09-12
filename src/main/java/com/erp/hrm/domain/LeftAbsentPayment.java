package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeftAbsentPayment" )
public class LeftAbsentPayment extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @NotNull
    @Column(name = "MonthNo")
    private Integer MonthNo;

    @NotNull
    @Column(name = "YearNo")
    private Integer YearNo;

    @NotNull
    @Column(name = "PaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date PaymentDate;

    @NotNull
    @Column(name = "IsCash")
    private double IsCash;

    @Column(name = "Bonus")
    private double Bonus;

    @Column(name = "Salary")
    private double Salary;

    @Column(name = "OT")
    private double OT;

    @Column(name = "EL")
    private double EL;

    @Column(name = "Fraction")
    private double Fraction;

    @Column(name = "IDCardD")
    private double IDCardD;

    @Column(name = "UniformD")
    private double UniformD;

    @Column(name = "NoticePayD")
    private double NoticePayD;

    @Column(name = "OthersD")
    private double OthersD;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public Integer getMonthNo() {
        return MonthNo;
    }

    public void setMonthNo(Integer MonthNo) {
        this.MonthNo = MonthNo;
    }

    public Integer getYearNo() {
        return YearNo;
    }

    public void setYearNo(Integer YearNo) {
        this.YearNo = YearNo;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public double getIsCash() {
        return IsCash;
    }

    public void setIsCash(double IsCash) {
        this.IsCash = IsCash;
    }

    public double getBonus() {
        return Bonus;
    }

    public void setBonus(double Bonus) {
        this.Bonus = Bonus;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public double getOT() {
        return OT;
    }

    public void setOT(double OT) {
        this.OT = OT;
    }

    public double getEL() {
        return EL;
    }

    public void setEL(double EL) {
        this.EL = EL;
    }

    public double getFraction() {
        return Fraction;
    }

    public void setFraction(double Fraction) {
        this.Fraction = Fraction;
    }

    public double getIDCardD() {
        return IDCardD;
    }

    public void setIDCardD(double IDCardD) {
        this.IDCardD = IDCardD;
    }

    public double getUniformD() {
        return UniformD;
    }

    public void setUniformD(double UniformD) {
        this.UniformD = UniformD;
    }

    public double getNoticePayD() {
        return NoticePayD;
    }

    public void setNoticePayD(double NoticePayD) {
        this.NoticePayD = NoticePayD;
    }

    public double getOthersD() {
        return OthersD;
    }

    public void setOthersD(double OthersD) {
        this.OthersD = OthersD;
    }
}
