package com.musiccamp.entities;
// Generated Oct 17, 2016 2:14:25 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "student", catalog = "music_maestros")
public class Student implements java.io.Serializable {

	private Integer studentId;
	private String sname;
	private String grade;
	private String track;
	private String status;
	private String primaryInstrument;
	private String secondaryInstrument;
	private String elective1;
	private String elective2;
	private String elective3;
	private String elective4;

	public Student() {
	}

	public Student(String sname, String grade, String track, String status, String primaryInstrument) {
		this.sname = sname;
		this.grade = grade;
		this.track = track;
		this.status = status;
		this.primaryInstrument = primaryInstrument;
	}

	public Student(String sname, String grade, String track, String status, String primaryInstrument,
			String secondaryInstrument, String elective1, String elective2, String elective3, String elective4) {
		this.sname = sname;
		this.grade = grade;
		this.track = track;
		this.status = status;
		this.primaryInstrument = primaryInstrument;
		this.secondaryInstrument = secondaryInstrument;
		this.elective1 = elective1;
		this.elective2 = elective2;
		this.elective3 = elective3;
		this.elective4 = elective4;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "student_id", unique = true, nullable = false)
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(name = "sname", nullable = false)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "grade", nullable = false)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "track", nullable = false)
	public String getTrack() {
		return this.track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "primary_instrument", nullable = false)
	public String getPrimaryInstrument() {
		return this.primaryInstrument;
	}

	public void setPrimaryInstrument(String primaryInstrument) {
		this.primaryInstrument = primaryInstrument;
	}

	@Column(name = "secondary_instrument")
	public String getSecondaryInstrument() {
		return this.secondaryInstrument;
	}

	public void setSecondaryInstrument(String secondaryInstrument) {
		this.secondaryInstrument = secondaryInstrument;
	}

	@Column(name = "elective1")
	public String getElective1() {
		return this.elective1;
	}

	public void setElective1(String elective1) {
		this.elective1 = elective1;
	}

	@Column(name = "elective2")
	public String getElective2() {
		return this.elective2;
	}

	public void setElective2(String elective2) {
		this.elective2 = elective2;
	}

	@Column(name = "elective3")
	public String getElective3() {
		return this.elective3;
	}

	public void setElective3(String elective3) {
		this.elective3 = elective3;
	}

	@Column(name = "elective4")
	public String getElective4() {
		return this.elective4;
	}

	public void setElective4(String elective4) {
		this.elective4 = elective4;
	}

}