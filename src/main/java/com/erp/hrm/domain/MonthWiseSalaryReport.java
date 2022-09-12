package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table( name = "MonthWiseSalaryReport", uniqueConstraints = { @UniqueConstraint( name="UK_MonthWiseSalaryReport",columnNames = { "EmployeeCode", "SalaryProcID" } ) } )
public class MonthWiseSalaryReport  extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryProcID",nullable = false)
    private String salaryProcID;

    @Column(name = "FromDate")
    private Date fromDate;

    @Column(name = "ToDate")
    private Date toDate;

    @Column(name = "ProcDate")
    private Date procDate;

    @Column(name = "MonthNo")
    private int monthNo;

    @Column(name = "YearNo")
    private int yearNo;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Column(name = "DateApproved")
    private Date dateApproved;

    @Column(name = "OrgGross")
    private double orgGross;

    @Column(name = "OrgBasic")
    private double orgBasic;

    @Column(name = "OrgHouseRent")
    private double orgHouseRent;

    @Column(name = "OrgMedical")
    private double orgMedical;

    @Column(name = "OrgConvence")
    private double orgConvence;

    @Column(name = "ARREAR")
    private double arrear;

    @Column(name = "AttendanceBonus")
    private double attendanceBonus;

    @Column(name = "BASIC")
    private double basic;

    @Column(name = "Bonus")
    private double bonus;

    @Column(name = "ConvenceAllowance")
    private double convenceAllowance;

    @Column(name = "EOT")
    private double eot;

    @Column(name = "FoodAllowance")
    private double foodAllowance;

    @Column(name = "GROSS")
    private double gross;

    @Column(name = "HouseRent")
    private double houseRent;

    @Column(name = "Incentive")
    private double incentive;

    @Column(name = "MEDICAL")
    private double medical;

    @Column(name = "MobileAllowance")
    private double mobileAllowance;

    @Column(name = "NonWorkingAmount")
    private double nonWorkingAmount;

    @Column(name = "OT")
    private double ot;

    @Column(name = "OthersAll")
    private double othersAll;

    @Column(name = "OthersAllowance")
    private double othersAllowance;

    @Column(name = "PfAllowance")
    private double pfAllowance;

    @Column(name = "PieceRate")
    private double pieceRate;

    @Column(name = "ProductionAmount")
    private double productionAmount;

    @Column(name = "SA")
    private double sa;

    @Column(name = "SYSNETPAYMENT")
    private double sysnetpayment;

    @Column(name = "Absenteeism")
    private double absenteeism;

    @Column(name = "ADVANCE")
    private double advance;

    @Column(name = "Allowance")
    private double allowance;

    @Column(name = "ConveyanceDeduction")
    private double conveyanceDeduction;

    @Column(name = "FoodDeduction")
    private double foodDeduction;

    @Column(name = "IncomeTax")
    private double incomeTax;

    @Column(name = "Mobile")
    private double mobile;

    @Column(name = "OthersDeduction")
    private double othersDeduction;

    @Column(name = "PF")
    private double pf;

    @Column(name = "PhotoDeduction")
    private double photoDeduction;

    @Column(name = "PIMS_Utility")
    private double pims_Utility;

    @Column(name = "SlDeduct")
    private double slDeduct;

    @Column(name = "Utility")
    private double utility;

    @Column(name = "SADeduction")
    private double sadeduction;

    @Column(name = "PFDeduction")
    private double pfDeduction;

    @Column(name = "IncomeTaxDeduction")
    private double incomeTaxDeduction;

    @Column(name = "BASICDeduction")
    private double bASICDeduction;

    @Column(name = "FoodAllowanceDeduction")
    private double foodAllowanceDeduction;

    @Column(name = "ConvenceAllowanceDeduction")
    private double convenceAllowanceDeduction;

    @Column(name = "HouseRentDeduction")
    private double houseRentDeduction;

    @Column(name = "GROSSDeduction")
    private double gROSSDeduction;

    @Column(name = "MobileAllowanceDeduction")
    private double mobileAllowanceDeduction;

    @Column(name = "PfAllowanceDeduction")
    private double pfAllowanceDeduction;

    @Column(name = "FoodDeductionDeduction")
    private double foodDeductionDeduction;

    @Column(name = "MedicalDeduction")
    private double medicalDeduction;

    @Column(name = "OthersDeductionArrear")
    private double othersDeductionArrear;

    @Column(name = "ConveyanceDeductionArrear")
    private double conveyanceDeductionArrear;

    @Column(name = "SAArrear")
    private double saArrear;

    @Column(name = "PFArrear")
    private double pfArrear;

    @Column(name = "IncomeTaxArrear")
    private double incomeTaxArrear;

    @Column(name = "BASICArrear")
    private double basicArrear;

    @Column(name = "FoodAllowanceArrear")
    private double foodAllowanceArrear;

    @Column(name = "ConvenceAllowanceArrear")
    private double convenceAllowanceArrear;

    @Column(name = "HouseRentArrear")
    private double houseRentArrear;

    @Column(name = "GrossArrear")
    private double grossArrear;

    @Column(name = "MobileAllowanceArrear")
    private double mobileAllowanceArrear;

    @Column(name = "PFAllowanceArrear")
    private double pfAllowanceArrear;

    @Column(name = "FoodDeductionArrear")
    private double foodDeductionArrear;

    @Column(name = "MedicalArrear")
    private double medicalArrear;

    @Column(name = "Fifty")
    private double fifty;

    @Column(name = "FiveHundred")
    private double fiveHundred;

    @Column(name = "Hundred")
    private double hundred;

    @Column(name = "Ten")
    private double ten;

    @Column(name = "Twenty")
    private double twenty;

    @Column(name = "MedicalAllowance")
    private double medicalAllowance;

    @Column(name = "STAMP")
    private double stamp;

    @Column(name = "NightAllowance")
    private double nightAllowance;

    @Column(name = "STAMPArrear")
    private double stampArrear;

    @Column(name = "LunchBill")
    private double lunchBill;

    @Column(name = "OTArrear")
    private double otArrear;

    @Column(name = "EOTArrear")
    private double eotArrear;

    @Column(name = "ABSENTEEISMArrear")
    private double absenteeismArrear;

    @Column(name = "CONVEYANCE")
    private double conveyance;

    @Column(name = "CONVEYANCEArrear")
    private double conveyanceArrear;

    @Column(name = "LunchbillArrear")
    private double lunchbillArrear;

    @Column(name = "EncashAmount",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_EncashAmount DEFAULT 0")
    private double encashAmount;

    @Column(name = "EncashAmountDeduction",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_EncashAmountDeduction DEFAULT 0")
    private double encashAmountDeduction;

    @Column(name = "EncashAmountDeductionArrear",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_EncashAmountDeductionArrear DEFAULT 0")
    private double encashAmountDeductionArrear;

    @Column(name = "LunchDeduction",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_LunchDeduction DEFAULT 0")
    private double lunchDeduction;

    @Column(name = "OtherDeduction",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_OtherDeduction DEFAULT 0")
    private double otherDeduction;

    @Column(name = "InvestmentAllow",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_InvestmentAllow DEFAULT 0")
    private double investmentAllow;

    @Column(name = "InvestmentCredit",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_InvestmentCredit DEFAULT 0")
    private double investmentCredit;

    @Column(name = "TotalTaxableIncome",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_TotalTaxableIncome DEFAULT 0")
    private double totalTaxableIncome;

    @Column(name = "ServiceCharge",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_ServiceCharge DEFAULT 0")
    private double serviceCharge;

    @Column(name = "ESI")
    private double esi;

    @Column(name = "HourlyLeaveDeduct",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_HourlyLeaveDeduct DEFAULT 0")
    private double hourlyLeaveDeduct;

    @Column(name = "LEFTEDLOANADJUST")
    private double leftedLOANADJUST;

    @Column(name = "ProfessionalTax")
    private double professionalTax;

    @Column(name = "AdditionalAttendanceBonus")
    private double additionalAttendanceBonus;

    @Column(name = "SalaryAdjust",nullable = false, columnDefinition = "double CONSTRAdouble DF_MonthWiseSalaryReport_SalaryAdjust DEFAULT 0")
    private double salaryAdjust;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getSalaryProcID() {
        return salaryProcID;
    }

    public void setSalaryProcID(String salaryProcID) {
        this.salaryProcID = salaryProcID;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getProcDate() {
        return procDate;
    }

    public void setProcDate(Date procDate) {
        this.procDate = procDate;
    }

    public int getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(int monthNo) {
        this.monthNo = monthNo;
    }

    public int getYearNo() {
        return yearNo;
    }

    public void setYearNo(int yearNo) {
        this.yearNo = yearNo;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public double getOrgGross() {
        return orgGross;
    }

    public void setOrgGross(double orgGross) {
        this.orgGross = orgGross;
    }

    public double getOrgBasic() {
        return orgBasic;
    }

    public void setOrgBasic(double orgBasic) {
        this.orgBasic = orgBasic;
    }

    public double getOrgHouseRent() {
        return orgHouseRent;
    }

    public void setOrgHouseRent(double orgHouseRent) {
        this.orgHouseRent = orgHouseRent;
    }

    public double getOrgMedical() {
        return orgMedical;
    }

    public void setOrgMedical(double orgMedical) {
        this.orgMedical = orgMedical;
    }

    public double getOrgConvence() {
        return orgConvence;
    }

    public void setOrgConvence(double orgConvence) {
        this.orgConvence = orgConvence;
    }

    public double getArrear() {
        return arrear;
    }

    public void setArrear(double arrear) {
        this.arrear = arrear;
    }

    public double getAttendanceBonus() {
        return attendanceBonus;
    }

    public void setAttendanceBonus(double attendanceBonus) {
        this.attendanceBonus = attendanceBonus;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getConvenceAllowance() {
        return convenceAllowance;
    }

    public void setConvenceAllowance(double convenceAllowance) {
        this.convenceAllowance = convenceAllowance;
    }

    public double getEot() {
        return eot;
    }

    public void setEot(double eot) {
        this.eot = eot;
    }

    public double getFoodAllowance() {
        return foodAllowance;
    }

    public void setFoodAllowance(double foodAllowance) {
        this.foodAllowance = foodAllowance;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(double houseRent) {
        this.houseRent = houseRent;
    }

    public double getIncentive() {
        return incentive;
    }

    public void setIncentive(double incentive) {
        this.incentive = incentive;
    }

    public double getMedical() {
        return medical;
    }

    public void setMedical(double medical) {
        this.medical = medical;
    }

    public double getMobileAllowance() {
        return mobileAllowance;
    }

    public void setMobileAllowance(double mobileAllowance) {
        this.mobileAllowance = mobileAllowance;
    }

    public double getNonWorkingAmount() {
        return nonWorkingAmount;
    }

    public void setNonWorkingAmount(double nonWorkingAmount) {
        this.nonWorkingAmount = nonWorkingAmount;
    }

    public double getOt() {
        return ot;
    }

    public void setOt(double ot) {
        this.ot = ot;
    }

    public double getOthersAll() {
        return othersAll;
    }

    public void setOthersAll(double othersAll) {
        this.othersAll = othersAll;
    }

    public double getOthersAllowance() {
        return othersAllowance;
    }

    public void setOthersAllowance(double othersAllowance) {
        this.othersAllowance = othersAllowance;
    }

    public double getPfAllowance() {
        return pfAllowance;
    }

    public void setPfAllowance(double pfAllowance) {
        this.pfAllowance = pfAllowance;
    }

    public double getPieceRate() {
        return pieceRate;
    }

    public void setPieceRate(double pieceRate) {
        this.pieceRate = pieceRate;
    }

    public double getProductionAmount() {
        return productionAmount;
    }

    public void setProductionAmount(double productionAmount) {
        this.productionAmount = productionAmount;
    }

    public double getSa() {
        return sa;
    }

    public void setSa(double sa) {
        this.sa = sa;
    }

    public double getSysnetpayment() {
        return sysnetpayment;
    }

    public void setSysnetpayment(double sysnetpayment) {
        this.sysnetpayment = sysnetpayment;
    }

    public double getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(double absenteeism) {
        this.absenteeism = absenteeism;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getConveyanceDeduction() {
        return conveyanceDeduction;
    }

    public void setConveyanceDeduction(double conveyanceDeduction) {
        this.conveyanceDeduction = conveyanceDeduction;
    }

    public double getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(double foodDeduction) {
        this.foodDeduction = foodDeduction;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getMobile() {
        return mobile;
    }

    public void setMobile(double mobile) {
        this.mobile = mobile;
    }

    public double getOthersDeduction() {
        return othersDeduction;
    }

    public void setOthersDeduction(double othersDeduction) {
        this.othersDeduction = othersDeduction;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getPhotoDeduction() {
        return photoDeduction;
    }

    public void setPhotoDeduction(double photoDeduction) {
        this.photoDeduction = photoDeduction;
    }

    public double getPims_Utility() {
        return pims_Utility;
    }

    public void setPims_Utility(double pims_Utility) {
        this.pims_Utility = pims_Utility;
    }

    public double getSlDeduct() {
        return slDeduct;
    }

    public void setSlDeduct(double slDeduct) {
        this.slDeduct = slDeduct;
    }

    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) {
        this.utility = utility;
    }

    public double getSadeduction() {
        return sadeduction;
    }

    public void setSadeduction(double sadeduction) {
        this.sadeduction = sadeduction;
    }

    public double getPfDeduction() {
        return pfDeduction;
    }

    public void setPfDeduction(double pfDeduction) {
        this.pfDeduction = pfDeduction;
    }

    public double getIncomeTaxDeduction() {
        return incomeTaxDeduction;
    }

    public void setIncomeTaxDeduction(double incomeTaxDeduction) {
        this.incomeTaxDeduction = incomeTaxDeduction;
    }

    public double getbASICDeduction() {
        return bASICDeduction;
    }

    public void setbASICDeduction(double bASICDeduction) {
        this.bASICDeduction = bASICDeduction;
    }

    public double getFoodAllowanceDeduction() {
        return foodAllowanceDeduction;
    }

    public void setFoodAllowanceDeduction(double foodAllowanceDeduction) {
        this.foodAllowanceDeduction = foodAllowanceDeduction;
    }

    public double getConvenceAllowanceDeduction() {
        return convenceAllowanceDeduction;
    }

    public void setConvenceAllowanceDeduction(double convenceAllowanceDeduction) {
        this.convenceAllowanceDeduction = convenceAllowanceDeduction;
    }

    public double getHouseRentDeduction() {
        return houseRentDeduction;
    }

    public void setHouseRentDeduction(double houseRentDeduction) {
        this.houseRentDeduction = houseRentDeduction;
    }

    public double getgROSSDeduction() {
        return gROSSDeduction;
    }

    public void setgROSSDeduction(double gROSSDeduction) {
        this.gROSSDeduction = gROSSDeduction;
    }

    public double getMobileAllowanceDeduction() {
        return mobileAllowanceDeduction;
    }

    public void setMobileAllowanceDeduction(double mobileAllowanceDeduction) {
        this.mobileAllowanceDeduction = mobileAllowanceDeduction;
    }

    public double getPfAllowanceDeduction() {
        return pfAllowanceDeduction;
    }

    public void setPfAllowanceDeduction(double pfAllowanceDeduction) {
        this.pfAllowanceDeduction = pfAllowanceDeduction;
    }

    public double getFoodDeductionDeduction() {
        return foodDeductionDeduction;
    }

    public void setFoodDeductionDeduction(double foodDeductionDeduction) {
        this.foodDeductionDeduction = foodDeductionDeduction;
    }

    public double getMedicalDeduction() {
        return medicalDeduction;
    }

    public void setMedicalDeduction(double medicalDeduction) {
        this.medicalDeduction = medicalDeduction;
    }

    public double getOthersDeductionArrear() {
        return othersDeductionArrear;
    }

    public void setOthersDeductionArrear(double othersDeductionArrear) {
        this.othersDeductionArrear = othersDeductionArrear;
    }

    public double getConveyanceDeductionArrear() {
        return conveyanceDeductionArrear;
    }

    public void setConveyanceDeductionArrear(double conveyanceDeductionArrear) {
        this.conveyanceDeductionArrear = conveyanceDeductionArrear;
    }

    public double getSaArrear() {
        return saArrear;
    }

    public void setSaArrear(double saArrear) {
        this.saArrear = saArrear;
    }

    public double getPfArrear() {
        return pfArrear;
    }

    public void setPfArrear(double pfArrear) {
        this.pfArrear = pfArrear;
    }

    public double getIncomeTaxArrear() {
        return incomeTaxArrear;
    }

    public void setIncomeTaxArrear(double incomeTaxArrear) {
        this.incomeTaxArrear = incomeTaxArrear;
    }

    public double getBasicArrear() {
        return basicArrear;
    }

    public void setBasicArrear(double basicArrear) {
        this.basicArrear = basicArrear;
    }

    public double getFoodAllowanceArrear() {
        return foodAllowanceArrear;
    }

    public void setFoodAllowanceArrear(double foodAllowanceArrear) {
        this.foodAllowanceArrear = foodAllowanceArrear;
    }

    public double getConvenceAllowanceArrear() {
        return convenceAllowanceArrear;
    }

    public void setConvenceAllowanceArrear(double convenceAllowanceArrear) {
        this.convenceAllowanceArrear = convenceAllowanceArrear;
    }

    public double getHouseRentArrear() {
        return houseRentArrear;
    }

    public void setHouseRentArrear(double houseRentArrear) {
        this.houseRentArrear = houseRentArrear;
    }

    public double getGrossArrear() {
        return grossArrear;
    }

    public void setGrossArrear(double grossArrear) {
        this.grossArrear = grossArrear;
    }

    public double getMobileAllowanceArrear() {
        return mobileAllowanceArrear;
    }

    public void setMobileAllowanceArrear(double mobileAllowanceArrear) {
        this.mobileAllowanceArrear = mobileAllowanceArrear;
    }

    public double getPfAllowanceArrear() {
        return pfAllowanceArrear;
    }

    public void setPfAllowanceArrear(double pfAllowanceArrear) {
        this.pfAllowanceArrear = pfAllowanceArrear;
    }

    public double getFoodDeductionArrear() {
        return foodDeductionArrear;
    }

    public void setFoodDeductionArrear(double foodDeductionArrear) {
        this.foodDeductionArrear = foodDeductionArrear;
    }

    public double getMedicalArrear() {
        return medicalArrear;
    }

    public void setMedicalArrear(double medicalArrear) {
        this.medicalArrear = medicalArrear;
    }

    public double getFifty() {
        return fifty;
    }

    public void setFifty(double fifty) {
        this.fifty = fifty;
    }

    public double getFiveHundred() {
        return fiveHundred;
    }

    public void setFiveHundred(double fiveHundred) {
        this.fiveHundred = fiveHundred;
    }

    public double getHundred() {
        return hundred;
    }

    public void setHundred(double hundred) {
        this.hundred = hundred;
    }

    public double getTen() {
        return ten;
    }

    public void setTen(double ten) {
        this.ten = ten;
    }

    public double getTwenty() {
        return twenty;
    }

    public void setTwenty(double twenty) {
        this.twenty = twenty;
    }

    public double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(double medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }

    public double getStamp() {
        return stamp;
    }

    public void setStamp(double stamp) {
        this.stamp = stamp;
    }

    public double getNightAllowance() {
        return nightAllowance;
    }

    public void setNightAllowance(double nightAllowance) {
        this.nightAllowance = nightAllowance;
    }

    public double getStampArrear() {
        return stampArrear;
    }

    public void setStampArrear(double stampArrear) {
        this.stampArrear = stampArrear;
    }

    public double getLunchBill() {
        return lunchBill;
    }

    public void setLunchBill(double lunchBill) {
        this.lunchBill = lunchBill;
    }

    public double getOtArrear() {
        return otArrear;
    }

    public void setOtArrear(double otArrear) {
        this.otArrear = otArrear;
    }

    public double getEotArrear() {
        return eotArrear;
    }

    public void setEotArrear(double eotArrear) {
        this.eotArrear = eotArrear;
    }

    public double getAbsenteeismArrear() {
        return absenteeismArrear;
    }

    public void setAbsenteeismArrear(double absenteeismArrear) {
        this.absenteeismArrear = absenteeismArrear;
    }

    public double getConveyance() {
        return conveyance;
    }

    public void setConveyance(double conveyance) {
        this.conveyance = conveyance;
    }

    public double getConveyanceArrear() {
        return conveyanceArrear;
    }

    public void setConveyanceArrear(double conveyanceArrear) {
        this.conveyanceArrear = conveyanceArrear;
    }

    public double getLunchbillArrear() {
        return lunchbillArrear;
    }

    public void setLunchbillArrear(double lunchbillArrear) {
        this.lunchbillArrear = lunchbillArrear;
    }

    public double getEncashAmount() {
        return encashAmount;
    }

    public void setEncashAmount(double encashAmount) {
        this.encashAmount = encashAmount;
    }

    public double getEncashAmountDeduction() {
        return encashAmountDeduction;
    }

    public void setEncashAmountDeduction(double encashAmountDeduction) {
        this.encashAmountDeduction = encashAmountDeduction;
    }

    public double getEncashAmountDeductionArrear() {
        return encashAmountDeductionArrear;
    }

    public void setEncashAmountDeductionArrear(double encashAmountDeductionArrear) {
        this.encashAmountDeductionArrear = encashAmountDeductionArrear;
    }

    public double getLunchDeduction() {
        return lunchDeduction;
    }

    public void setLunchDeduction(double lunchDeduction) {
        this.lunchDeduction = lunchDeduction;
    }

    public double getOtherDeduction() {
        return otherDeduction;
    }

    public void setOtherDeduction(double otherDeduction) {
        this.otherDeduction = otherDeduction;
    }

    public double getInvestmentAllow() {
        return investmentAllow;
    }

    public void setInvestmentAllow(double investmentAllow) {
        this.investmentAllow = investmentAllow;
    }

    public double getInvestmentCredit() {
        return investmentCredit;
    }

    public void setInvestmentCredit(double investmentCredit) {
        this.investmentCredit = investmentCredit;
    }

    public double getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public void setTotalTaxableIncome(double totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getEsi() {
        return esi;
    }

    public void setEsi(double esi) {
        this.esi = esi;
    }

    public double getHourlyLeaveDeduct() {
        return hourlyLeaveDeduct;
    }

    public void setHourlyLeaveDeduct(double hourlyLeaveDeduct) {
        this.hourlyLeaveDeduct = hourlyLeaveDeduct;
    }

    public double getLeftedLOANADJUST() {
        return leftedLOANADJUST;
    }

    public void setLeftedLOANADJUST(double leftedLOANADJUST) {
        this.leftedLOANADJUST = leftedLOANADJUST;
    }

    public double getProfessionalTax() {
        return professionalTax;
    }

    public void setProfessionalTax(double professionalTax) {
        this.professionalTax = professionalTax;
    }

    public double getAdditionalAttendanceBonus() {
        return additionalAttendanceBonus;
    }

    public void setAdditionalAttendanceBonus(double additionalAttendanceBonus) {
        this.additionalAttendanceBonus = additionalAttendanceBonus;
    }

    public double getSalaryAdjust() {
        return salaryAdjust;
    }

    public void setSalaryAdjust(double salaryAdjust) {
        this.salaryAdjust = salaryAdjust;
    }

    public MonthWiseSalaryReport() {
    }

    public MonthWiseSalaryReport(
            @NotNull String employeeCode, @NotNull String salaryProcID, Date fromDate, Date toDate, Date procDate,
            int monthNo, int yearNo, BigDecimal attendanceBonus, BigDecimal basic, BigDecimal bonus, BigDecimal eot, BigDecimal gross,
            BigDecimal houseRent, BigDecimal medical, BigDecimal ot, BigDecimal absenteeism, BigDecimal advance, BigDecimal conveyance, BigDecimal incomeTax,
            BigDecimal stamp, BigDecimal encashAmount, BigDecimal lunchBill, BigDecimal lunchDeduction, BigDecimal otherDeduction) {
        this.employeeCode = employeeCode;
        this.salaryProcID = salaryProcID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.procDate = procDate;
        this.monthNo = monthNo;
        this.yearNo = yearNo;
        this.orgGross = 0;
        this.orgBasic = 0;
        this.orgHouseRent = 0;
        this.orgMedical = 0;
        this.orgConvence = 0;
        this.arrear = 0;
        this.attendanceBonus = attendanceBonus.doubleValue();
        this.basic = basic.doubleValue();
        this.bonus = bonus.doubleValue();
        this.convenceAllowance = 0;
        this.eot = eot.doubleValue();
        this.foodAllowance = 0;
        this.gross = gross.doubleValue();
        this.houseRent = houseRent.doubleValue();
        this.incentive = 0;
        this.medical = medical.doubleValue();
        this.mobileAllowance = 0;
        this.nonWorkingAmount = 0;
        this.ot = ot.doubleValue();
        this.othersAll = 0;
        this.othersAllowance = 0;
        this.pfAllowance = 0;
        this.pieceRate = 0;
        this.productionAmount = 0;
        this.sa = 0;
        this.sysnetpayment = 0;
        this.absenteeism = absenteeism.doubleValue();
        this.advance = advance.doubleValue();
        this.allowance = 0;
        this.conveyanceDeduction = 0;
        this.foodDeduction = 0;
        this.incomeTax = incomeTax.doubleValue();
        this.mobile = 0;
        this.othersDeduction = 0;
        this.pf = 0;
        this.photoDeduction = 0;
        this.pims_Utility = 0;
        this.slDeduct = 0;
        this.utility = 0;
        this.sadeduction = 0;
        this.pfDeduction = 0;
        this.incomeTaxDeduction = 0;
        this.bASICDeduction = 0;
        this.foodAllowanceDeduction = 0;
        this.convenceAllowanceDeduction = 0;
        this.houseRentDeduction = 0;
        this.gROSSDeduction = 0;
        this.mobileAllowanceDeduction = 0;
        this.pfAllowanceDeduction = 0;
        this.foodDeductionDeduction = 0;
        this.medicalDeduction = 0;
        this.othersDeductionArrear = 0;
        this.conveyanceDeductionArrear = 0;
        this.saArrear = 0;
        this.pfArrear = 0;
        this.incomeTaxArrear = 0;
        this.basicArrear = 0;
        this.foodAllowanceArrear = 0;
        this.convenceAllowanceArrear = 0;
        this.houseRentArrear = 0;
        this.grossArrear = 0;
        this.mobileAllowanceArrear = 0;
        this.pfAllowanceArrear = 0;
        this.foodDeductionArrear = 0;
        this.medicalArrear = 0;
        this.fifty = 0;
        this.fiveHundred = 0;
        this.hundred = 0;
        this.ten = 0;
        this.twenty = 0;
        this.medicalAllowance = 0;
        this.stamp = stamp.doubleValue();
        this.nightAllowance = 0;
        this.stampArrear = 0;
        this.lunchBill = lunchBill.doubleValue();
        this.otArrear = 0;
        this.eotArrear = 0;
        this.absenteeismArrear = 0;
        this.conveyance = conveyance.doubleValue();
        this.conveyanceArrear = 0;
        this.lunchbillArrear = 0;
        this.encashAmount = encashAmount.doubleValue();
        this.encashAmountDeduction = 0;
        this.encashAmountDeductionArrear = 0;
        this.lunchDeduction = lunchDeduction.doubleValue();
        this.otherDeduction = otherDeduction.doubleValue();
        this.investmentAllow = 0;
        this.investmentCredit = 0;
        this.totalTaxableIncome = 0;
        this.serviceCharge = 0;
        this.esi = 0;
        this.hourlyLeaveDeduct = 0;
        this.leftedLOANADJUST = 0;
        this.professionalTax = 0;
        this.additionalAttendanceBonus = 0;
        this.salaryAdjust = 0;
    }
}

