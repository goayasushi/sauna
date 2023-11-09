package com.example.member.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "members")
@EntityListeners(AuditingEntityListener.class)
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	@NotNull
	@Column(name = "gender")
	private Integer gender;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@NotBlank
	@Pattern(regexp = "^\\d{7}$")
	@Column(name = "post_code")
	private String postCode;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "prefecture")
	private Prefecture prefecture;
	@NotBlank
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;
	@NotBlank
	@Pattern(regexp = "^\\d{9,11}$")
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "join_date")
	private LocalDate joinDate;
	@Column(name = "delete_date")
	private LocalDate deleteDate;
	@Column(name = "status")
	private Integer status;
	@CreatedDate
	@Column(name = "regist_datetime")
	private Date registDatetime;
	@Column(name = "regist_staff")
	private Integer registStaff;
	@LastModifiedDate
	@Column(name = "update_datetime")
	private LocalDateTime updateDatetime;
	@Column(name = "update_staff")
	private Integer updateStaff;
	@Version
	@Column(name = "version")
	private long version;

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

	public LocalDate getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(LocalDate deleteDate) {
		this.deleteDate = deleteDate;
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



	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}