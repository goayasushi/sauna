package com.example.member;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String postCode;
	private Integer prefectures;
	private String address1;
	private String address2;
	private String phoneNumber;
	private boolean gender;
	private LocalDate joinDate;
	private LocalDate doleteDate;
	private Integer status;
	private LocalDateTime updateDatetime;
	private Integer updateStaff;
	private LocalDateTime registDatetime;
	private Integer registStaff;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Integer getPrefectures() {
		return prefectures;
	}

	public void setPrefectures(Integer prefectures) {
		this.prefectures = prefectures;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDate getDoleteDate() {
		return doleteDate;
	}

	public void setDoleteDate(LocalDate doleteDate) {
		this.doleteDate = doleteDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(LocalDateTime updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public Integer getUpdateStaff() {
		return updateStaff;
	}

	public void setUpdateStaff(Integer updateStaff) {
		this.updateStaff = updateStaff;
	}

	public LocalDateTime getRegistDatetime() {
		return registDatetime;
	}

	public void setRegistDatetime(LocalDateTime registDatetime) {
		this.registDatetime = registDatetime;
	}

	public Integer getRegistStaff() {
		return registStaff;
	}

	public void setRegistStaff(Integer registStaff) {
		this.registStaff = registStaff;
	}

}