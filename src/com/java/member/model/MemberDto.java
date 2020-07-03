package com.java.member.model;

import java.util.Date;

/**
 * @날짜 : 2020. 7. 2.
 * @author: 이다은
 */
public class MemberDto {

	private int num; // DB에서 시퀀스 처리 .nextval

	private String id;
	private String password;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String zipcode;
	private String address;
	private String job;
	private String mailing;
	private String interest;

	private String memberLevel; // 회원등급 : 3개(신규회원/BA, 정회원/AA, VIP)
	private Date registerDate; // Date, sysdate

	public MemberDto() {
	}

	public MemberDto(int num, String id, String password, String name, String jumin1, String jumin2, String email,
			String zipcode, String address, String job, String mailing, String interest, String memberLevel,
			Date registerDate) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.email = email;
		this.zipcode = zipcode;
		this.address = address;
		this.job = job;
		this.mailing = mailing;
		this.interest = interest;
		this.memberLevel = memberLevel;
		this.registerDate = registerDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getJumin2() {
		return jumin2;
	}

	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMailing() {
		return mailing;
	}

	public void setMailing(String mailing) {
		this.mailing = mailing;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", jumin1=" + jumin1 + ", jumin2="
				+ jumin2 + ", email=" + email + ", zipcode=" + zipcode + ", job=" + job + ", mailing=" + mailing
				+ ", interest=" + interest + ", registerDate=" + registerDate + ", num=" + num + ", memberLevel="
				+ memberLevel + "]";
	}

}