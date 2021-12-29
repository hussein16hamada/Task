package com.example.task.logIn.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("Payroll")
	val payroll: Payroll? = null,

	@field:SerializedName("EnglishMessage")
	val englishMessage: String? = null,

	@field:SerializedName("ArabicMessage")
	val arabicMessage: String? = null,

	@field:SerializedName("Activation")
	val activation: Boolean? = null,

	@field:SerializedName("Success")
	val success: Boolean? = null
)

data class EmployeeItem(

	@field:SerializedName("CONTRACTSTDATE")
	val cONTRACTSTDATE: String? = null,

	@field:SerializedName("SAL_VALUE_NET")
	val sALVALUENET: Double? = null,

	@field:SerializedName("SEC_NAME_AR")
	val sECNAMEAR: String? = null,

	@field:SerializedName("CUSTOM_ID")
	val cUSTOMID: Double? = null,

	@field:SerializedName("SAL_VALUE_D")
	val sALVALUED: Double? = null,

	@field:SerializedName("FRACTIONNAME_AR")
	val fRACTIONNAMEAR: String? = null,

	@field:SerializedName("EMP_PIC")
	val eMPPIC: Any? = null,

	@field:SerializedName("SEC_NAME_EN")
	val sECNAMEEN: String? = null,

	@field:SerializedName("JOBCODE")
	val jOBCODE: Double? = null,

	@field:SerializedName("SAL_VALUE_A")
	val sALVALUEA: Double? = null,

	@field:SerializedName("COMP_DESC_D_EN")
	val cOMPDESCDEN: String? = null,

	@field:SerializedName("SAL_COMP_CODE_D")
	val sALCOMPCODED: Double? = null,

	@field:SerializedName("CURRSYMBOL_EN")
	val cURRSYMBOLEN: String? = null,

	@field:SerializedName("COMP_DESC_D_AR")
	val cOMPDESCDAR: String? = null,

	@field:SerializedName("MAR_STATUS_AR")
	val mARSTATUSAR: String? = null,

	@field:SerializedName("SAL_COMP_CODE_A")
	val sALCOMPCODEA: Double? = null,

	@field:SerializedName("CURRSYMBOL_AR")
	val cURRSYMBOLAR: String? = null,

	@field:SerializedName("STATUS_EN")
	val sTATUSEN: String? = null,

	@field:SerializedName("ATM_ACCOUNT")
	val aTMACCOUNT: Any? = null,

	@field:SerializedName("FRACTIONNAME_EN")
	val fRACTIONNAMEEN: String? = null,

	@field:SerializedName("STATUSNAME_AR")
	val sTATUSNAMEAR: String? = null,

	@field:SerializedName("MAR_STATUS_EN")
	val mARSTATUSEN: String? = null,

	@field:SerializedName("STATUS_AR")
	val sTATUSAR: String? = null,

	@field:SerializedName("EMP_GENDUR")
	val eMPGENDUR: String? = null,

	@field:SerializedName("EMP_DATA_AR")
	val eMPDATAAR: String? = null,

	@field:SerializedName("COMP_DESC_A_EN")
	val cOMPDESCAEN: String? = null,

	@field:SerializedName("STATUSNAME_EN")
	val sTATUSNAMEEN: String? = null,

	@field:SerializedName("EMP_ID")
	val eMPID: Int? = null,

	@field:SerializedName("JOBNAME_EN")
	val jOBNAMEEN: String? = null,

	@field:SerializedName("EMP_DATA_EN")
	val eMPDATAEN: String? = null,

	@field:SerializedName("COMP_DESC_A_AR")
	val cOMPDESCAAR: String? = null,

	@field:SerializedName("JOBNAME_AR")
	val jOBNAMEAR: String? = null
)

data class Payroll(

	@field:SerializedName("Employee")
	val employee: List<EmployeeItem?>? = null,

	@field:SerializedName("Allowences")
	val allowences: List<AllowencesItem?>? = null,

	@field:SerializedName("Deduction")
	val deduction: List<DeductionItem?>? = null,

	@field:SerializedName("Date")
	val date: String? = null
)

data class DeductionItem(

	@field:SerializedName("EMP_ID")
	val eMPID: Int? = null,

	@field:SerializedName("SAL_COMP_CODE")
	val sALCOMPCODE: Int? = null,

	@field:SerializedName("COMP_DESC_EN")
	val cOMPDESCEN: String? = null,

	@field:SerializedName("SAL_VALUE")
	val sALVALUE: Double? = null,

	@field:SerializedName("COMP_DESC_AR")
	val cOMPDESCAR: String? = null,

	@field:SerializedName("SAL_COMP_TYPE")
	val sALCOMPTYPE: Int? = null
)

data class AllowencesItem(

	@field:SerializedName("EMP_ID")
	val eMPID: Int? = null,

	@field:SerializedName("SAL_COMP_CODE")
	val sALCOMPCODE: Int? = null,

	@field:SerializedName("COMP_DESC_EN")
	val cOMPDESCEN: String? = null,

	@field:SerializedName("SAL_VALUE")
	val sALVALUE: Double? = null,

	@field:SerializedName("COMP_DESC_AR")
	val cOMPDESCAR: String? = null,

	@field:SerializedName("SAL_COMP_TYPE")
	val sALCOMPTYPE: Int? = null
)
