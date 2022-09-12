package com.erp.hrm.api;

import com.erp.hrm.api.dto.leaveManagement.*;
import com.erp.hrm.domain.*;
import com.erp.hrm.service.leave.*;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leave")
public class LeaveApi {
    private LeaveYearService leaveYearService;
    private LeavePolicyService leavePolicyService;
    private EmployeeLeaveTransactionService employeeLeaveTransactionService;
    private MaternityLeaveTransactionService maternityLeaveTransactionService;
    private EmployeeLeaveAllocationProcessService employeeLeaveAllocationProcessService;

    private LeaveProcessService leaveProcessService;

    public LeaveApi(LeaveYearService leaveYearService, LeavePolicyService leavePolicyService,
                    EmployeeLeaveTransactionService employeeLeaveTransactionService,
                    MaternityLeaveTransactionService maternityLeaveTransactionService,
                    EmployeeLeaveAllocationProcessService employeeLeaveAllocationProcessService,
                    LeaveProcessService leaveProcessService) {
        this.leaveYearService = leaveYearService;
        this.leavePolicyService = leavePolicyService;
        this.employeeLeaveTransactionService = employeeLeaveTransactionService;
        this.maternityLeaveTransactionService = maternityLeaveTransactionService;
        this.employeeLeaveAllocationProcessService = employeeLeaveAllocationProcessService;
        this.leaveProcessService = leaveProcessService;
    }

    @RequestMapping(value = "/leaveYear/save", method = RequestMethod.POST)
    public ActionResult saveLeaveYear(@RequestBody LeaveYear leaveYear){
        return leaveYearService.saveLeaveYear(leaveYear);
    }

    @RequestMapping(value = "/leaveYear/getAll", method = RequestMethod.GET)
    public List<LeaveYear> getLeaveYears(){
        return leaveYearService.getLeaveYears();
    }

    @RequestMapping(value = "/leaveYear/get", method = RequestMethod.GET)
    public LeaveYear getActiveLeaveYear(){
        return leaveYearService.getActiveLeaveYear();
    }

    @RequestMapping(value = "/leaveRule/save", method = RequestMethod.POST)
    public ActionResult saveLeaveRuleInfo(@RequestBody LeaveRuleInfoDTO dto){
        return leavePolicyService.saveLeaveRuleInfo(dto);
    }

    @RequestMapping(value = "/leaveRule/getAll", method = RequestMethod.GET)
    public List<LeaveRuleInfoDTO> getLeaveRuleInfos(){
        return leavePolicyService.getLeaveRuleInfos();
    }

    @RequestMapping(value = "/leaveRule/getAllLeaveRuleName", method = RequestMethod.GET)
    public List<LeaveRuleDTO> getAllLeaveRuleName(){
        return leavePolicyService.getAllLeaveRuleName();
    }

    @RequestMapping(value = "/leavePolicy/save", method = RequestMethod.POST)
    public ActionResult saveLeavePolicyInfo(@RequestBody LeavePolicyInfoDTO dto){
        return leavePolicyService.saveLeavePolicyInfo(dto);
    }

    @RequestMapping(value = "/leavePolicy/update", method = RequestMethod.POST)
    public ActionResult updateLeavePolicyInfo(@RequestBody LeavePolicyInfoDTO dto){
        return leavePolicyService.updateLeavePolicyInfo(dto);
    }

    @RequestMapping(value = "/leavePolicy/getAll", method = RequestMethod.GET)
    public List<LeavePolicyInfoDTO> getLeavePolicyInfos(){
        return leavePolicyService.getLeavePolicyInfos();
    }

    @RequestMapping(value = "/leavePolicy/get", method = RequestMethod.GET)
    public LeavePolicyInfoDTO getLeavePolicy(String LeavePolicyID){
        return leavePolicyService.getLeavePolicy(LeavePolicyID);
    }

    @RequestMapping(value = "/leaveType/get", method = RequestMethod.GET)
    public List<LeaveTypeDTO> getAllLeaveType(){
        return leavePolicyService.getAllLeaveType();
    }

    @RequestMapping(value = "/leaveCategory/get", method = RequestMethod.GET)
    public List<LeaveCategoryDTO> getAllLeaveCategory(){
        return leavePolicyService.getAllLeaveCategory();
    }

    @RequestMapping(value = "/leaveCredit/get", method = RequestMethod.GET)
    public List<LeaveCreditDTO> getAllLeaveCredit(){
        return leavePolicyService.getAllLeaveCredit();
    }

    @RequestMapping(value = "/maternityLeavePolicy/save", method = RequestMethod.POST)
    public ActionResult saveMaternityLeavePolicyInfo(@RequestBody MaternityLeavePolicyDTO dto){
        return leavePolicyService.saveMaternityLeavePolicyInfo(dto);
    }

    @RequestMapping(value = "/maternityLeavePolicy/update", method = RequestMethod.POST)
    public ActionResult updateMaternityLeavePolicyInfo(@RequestBody MaternityLeavePolicyDTO dto){
        return leavePolicyService.updateMaternityLeavePolicyInfo(dto);
    }

    @RequestMapping(value = "/maternityLeavePolicy/getAll", method = RequestMethod.GET)
    public List<MaternityLeavePolicyDTO> getMaternityLeavePolicyInfos(){
        return leavePolicyService.getMaternityLeavePolicyInfos();
    }

    @RequestMapping(value = "/maternityLeavePolicy/get", method = RequestMethod.GET)
    public MaternityLeavePolicyDTO getMaternityLeavePolicy(String pMaternityLeavePolicyID){
        return leavePolicyService.getMaternityLeavePolicy(pMaternityLeavePolicyID);
    }

    @RequestMapping(value = "/leaveRule/getAllMaternityLeaveRule", method = RequestMethod.GET)
    public List<MaternityLeaveRuleDTO> getAllMaternityLeaveRule(){
        return leavePolicyService.getAllMaternityLeaveRule();
    }

    /*Leave Transaction Api*/
    @RequestMapping(value = "/LeaveTransInfo/save", method = RequestMethod.POST)
    public ActionResult saveLeaveTransInfo(@RequestBody EmployeeLeaveTransactionDTO dto) {
        return employeeLeaveTransactionService.saveEmployeeLeaveTransaction(dto);
    }

    @RequestMapping(value = "/LeaveTransInfo/getByEmployeeCode", method = RequestMethod.GET)
    public List<EmployeeLeaveTransactionDTO> getLeaveTransInfo(String pEmployeeCode) {
        return employeeLeaveTransactionService.getEmployeeLeaveTransactions(pEmployeeCode);
    }
    /* End Leave Transaction Api*/

    /* Maternity Leave Transaction Api*/
    @RequestMapping(value = "/MaternityLeaveTransInfo/save", method = RequestMethod.POST)
    public ActionResult saveMaternityLeaveTransInfo(@RequestBody MaternityLeaveTransSaveDTO dto) {
        return maternityLeaveTransactionService.saveMaternityLeaveTransInfo(dto);
    }

    @RequestMapping(value = "/MaternityLeaveTransInfo/getAll", method = RequestMethod.GET)
    public List<MaternityLeaveTransInfoDTO> getMaternityLeaveTransInfos(String pEmployeeCode) {
        return maternityLeaveTransactionService.getMaternityLeaveTransInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/MaternityLeaveTransInfo/getByEmployeeCode", method = RequestMethod.GET)
    public List<MaternityLeaveTransInfoDTO> getMaternityLeaveTransInfo(String pEmployeeCode) {
        return maternityLeaveTransactionService.getMaternityLeaveTransInfo(pEmployeeCode);
    }
    /* End Maternity Leave Transaction Api*/

    /* Employee Leave Allocation Api*/
    @RequestMapping(value = "/allocation/getByEmployeeCode", method = RequestMethod.GET)
    public List<EmployeeLeaveAllocationDTO> getAllLeaveAllocationByEmployeeCode(String pEmployeeCode) {
        return employeeLeaveAllocationProcessService.getAllLeaveAllocationByEmployeeCode(pEmployeeCode);
    }
    /* Employee Leave Allocation Api*/


    @RequestMapping(value = "/LeaveEndYear/leaveProcess", method = RequestMethod.POST)
    public ActionResult leaveProcess(@RequestBody LeaveProcessDTO dto) {
        return employeeLeaveAllocationProcessService.leaveProcess(dto);
    }


    @RequestMapping(value = "/processLeave", method = RequestMethod.POST)
    public ActionResult processLeave() {
        return leaveProcessService.processLeave();
    }


    /*
    @RequestMapping(value = "/LeaveHourlyTransaction/save", method = RequestMethod.GET)
    public ActionResult saveLeaveHourlyTransactionInfo(@RequestBody LeaveHourlyTransactionDTO dto) {
        return leaveInfoService.saveLeaveHourlyTransactioInfo(dto);
    }

    @RequestMapping(value = "/LeaveHourlyTransaction/getAll", method = RequestMethod.GET)
    public List<LeaveHourlyTransactionDTO> getLeaveHourlyTransactionInfos() {
        return  leaveInfoService.getLeaveHourlyTransactionInfos();
    }

    @RequestMapping(value = "/LeaveHourlyTransaction/get", method = RequestMethod.GET)
    public LeaveHourlyTransactionDTO getLeaveHourlyTransactionInfo(String EmployeeCode) {
        return  leaveInfoService.getLeaveHourlyTransactionInfo(EmployeeCode);
    }
    */



    /*

    @RequestMapping(value = "/leaveDeduction/save", method = RequestMethod.GET)
    public ActionResult saveLeaveDeductionInfo(@RequestBody LeaveDeductionEncashmentDTO dto) {
        return leaveInfoService.saveLeaveDeductionInfo(dto);
    }

    @RequestMapping(value = "/leaveDeduction/getAll", method = RequestMethod.GET)
    public List<LeaveDeductionEncashmentDTO> getLeaveDeductionInfos() {
        return leaveInfoService.getLeaveDeductionInfos();
    }

    @RequestMapping(value = "/leaveDeduction/get", method = RequestMethod.GET)
    public LeaveDeductionEncashmentDTO getLeaveDeduction(String LeavePolicyID) {
        return leaveInfoService.getLeaveDeduction(LeavePolicyID);
    }

    @RequestMapping(value = "/leaveEncashment/save", method = RequestMethod.GET)
    public ActionResult saveLeaveEncashment(@RequestBody LeaveDeductionEncashmentDTO dto) {
        return leaveInfoService.saveLeaveEncashment(dto);
    }

    @RequestMapping(value = "/leaveEncashment/getAll", method = RequestMethod.GET)
    public List<LeaveDeductionEncashmentDTO> getLeaveEncashmentInfos() {
        return leaveInfoService.getLeaveEncashmentInfos();
    }

    @RequestMapping(value = "/leaveEncashment/get", method = RequestMethod.GET)
    public LeaveDeductionEncashmentDTO getLeaveEncashment(String LeavePolicyID) {
        return leaveInfoService.getLeaveEncashment(LeavePolicyID);
    }
    */
}
