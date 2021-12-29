package com.example.task.logIn.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LogInResponse (

	@field:SerializedName("AccountId")
	val accountId: Int? = null,

	@field:SerializedName("Activation")
	val activation: Boolean? = null,

	@field:SerializedName("Token")
	val token: String? = null,

	@field:SerializedName("AccountRole")
	val accountRole: Any? = null,

	@field:SerializedName("Code")
	val code: Int? = null,

	@field:SerializedName("Success")
	val success: Boolean? = null,

	@field:SerializedName("VisitStatus")
	val visitStatus: Any? = null,

	@field:SerializedName("EnglishMessage")
	val englishMessage: String? = null,

	@field:SerializedName("PageCount")
	val pageCount: Int? = null,

	@field:SerializedName("ArabicMessage")
	val arabicMessage: String? = null,

	@field:SerializedName("CurrentPage")
	val currentPage: Int? = null,

	@field:SerializedName("UserRole")
	val userRole: Any? = null,

	@field:SerializedName("IsArabic")
	val isArabic: Any? = null,

	@field:SerializedName("UserType")
	val userType: Int? = null,

	@field:SerializedName("user")
	val user: User? = null
):Serializable

data class User(

	@field:SerializedName("Email")
	val email: String? = null,

	@field:SerializedName("PhoneNumberConfirmed")
	val phoneNumberConfirmed: Boolean? = null,

	@field:SerializedName("PatientImage")
	val patientImage: String? = null,

	@field:SerializedName("LicenseNumber")
	val licenseNumber: Any? = null,

	@field:SerializedName("HasInsurance")
	val hasInsurance: Boolean? = null,

	@field:SerializedName("ClassId")
	val classId: Int? = null,

	@field:SerializedName("ClassArabicName")
	val classArabicName: String? = null,

	@field:SerializedName("LastNameAr")
	val lastNameAr: String? = null,

	@field:SerializedName("Gender")
	val gender: Int? = null,

	@field:SerializedName("EmailConfirmed")
	val emailConfirmed: Boolean? = null,

	@field:SerializedName("Source")
	val source: Any? = null,

	@field:SerializedName("MobileNumber")
	val mobileNumber: String? = null,

	@field:SerializedName("FirstNameAr")
	val firstNameAr: String? = null,

	@field:SerializedName("LastNameEn")
	val lastNameEn: String? = null,

	@field:SerializedName("ClassEnglishName")
	val classEnglishName: String? = null,

	@field:SerializedName("AspNetUsersId")
	val aspNetUsersId: Int? = null,

	@field:SerializedName("Id")
	val id: Int? = null,

	@field:SerializedName("FirstNameEn")
	val firstNameEn: String? = null,

	@field:SerializedName("AmbulanceProfileId")
	val ambulanceProfileId: Any? = null,

	@field:SerializedName("BirthDate")
	val birthDate: String? = null
):Serializable
