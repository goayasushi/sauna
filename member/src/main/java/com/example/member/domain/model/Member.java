package com.example.member.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "members")
@EntityListeners(AuditingEntityListener.class)
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	private Integer gender;

	private LocalDate birthDate;
	@Pattern(regexp = "^\\d{7}$")
	private String postCode;
	@ManyToOne
	@NotNull
	private Prefecture prefecture;
	@NotBlank
	private String address1;
	private String address2;
	@Pattern(regexp = "^\\d{9,11}$")
	private String phoneNumber;
	private LocalDate joinDate;
	private LocalDate doleteDate;
	private Integer status;
	@CreatedDate
	private Date registDatetime;
	private Integer registStaff;
	@LastModifiedDate
	private LocalDateTime updateDatetime;
	private Integer updateStaff;

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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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

	public Prefecture getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(Prefecture prefecture) {
		this.prefecture = prefecture;
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

	public Date getRegistDatetime() {
		return registDatetime;
	}

	public void setRegistDatetime(Date registDatetime) {
		this.registDatetime = registDatetime;
	}

	public Integer getRegistStaff() {
		return registStaff;
	}

	public void setRegistStaff(Integer registStaff) {
		this.registStaff = registStaff;
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
}