package com.musiccamp.model;

import java.util.ArrayList;
/**
 * 
 * @author Pushkar Kumar Kanikicherla
 *
 */
public class StudentDataModel {

	ArrayList<String> studentName;
	ArrayList<Double> studentGrade;
	ArrayList<String> track;
	ArrayList<String> primaryInstrument;
	ArrayList<String> secondaryInstrument;
	ArrayList<String> elective1;
	ArrayList<String> elective2;
	ArrayList<String> elective3;
	ArrayList<String> elective4;
	
	
	public StudentDataModel() {
		
	}


	public StudentDataModel(ArrayList<String> studentName, ArrayList<Double> studentGrade, ArrayList<String> track,
			ArrayList<String> primaryInstrument, ArrayList<String> secondaryInstrument, ArrayList<String> elective1,
			ArrayList<String> elective2, ArrayList<String> elective3, ArrayList<String> elective4) {
		
		this.studentName = studentName;
		this.studentGrade = studentGrade;
		this.track = track;
		this.primaryInstrument = primaryInstrument;
		this.secondaryInstrument = secondaryInstrument;
		this.elective1 = elective1;
		this.elective2 = elective2;
		this.elective3 = elective3;
		this.elective4 = elective4;
	}


	public ArrayList<String> getStudentName() {
		return studentName;
	}


	public void setStudentName(ArrayList<String> studentName) {
		this.studentName = studentName;
	}


	public ArrayList<Double> getStudentGrade() {
		return studentGrade;
	}


	public void setStudentGrade(ArrayList<Double> studentGrade) {
		this.studentGrade = studentGrade;
	}


	public ArrayList<String> getTrack() {
		return track;
	}


	public void setTrack(ArrayList<String> track) {
		this.track = track;
	}


	public ArrayList<String> getPrimaryInstrument() {
		return primaryInstrument;
	}


	public void setPrimaryInstrument(ArrayList<String> primaryInstrument) {
		this.primaryInstrument = primaryInstrument;
	}


	public ArrayList<String> getSecondaryInstrument() {
		return secondaryInstrument;
	}


	public void setSecondaryInstrument(ArrayList<String> secondaryInstrument) {
		this.secondaryInstrument = secondaryInstrument;
	}


	public ArrayList<String> getElective1() {
		return elective1;
	}


	public void setElective1(ArrayList<String> elective1) {
		this.elective1 = elective1;
	}


	public ArrayList<String> getElective2() {
		return elective2;
	}


	public void setElective2(ArrayList<String> elective2) {
		this.elective2 = elective2;
	}


	public ArrayList<String> getElective3() {
		return elective3;
	}


	public void setElective3(ArrayList<String> elective3) {
		this.elective3 = elective3;
	}


	public ArrayList<String> getElective4() {
		return elective4;
	}


	public void setElective4(ArrayList<String> elective4) {
		this.elective4 = elective4;
	}


	@Override
	public String toString() {
		return "StudentDataModel [studentName=" + studentName + ", studentGrade=" + studentGrade + ", track=" + track
				+ ", primaryInstrument=" + primaryInstrument + ", secondaryInstrument=" + secondaryInstrument
				+ ", elective1=" + elective1 + ", elective2=" + elective2 + ", elective3=" + elective3 + ", elective4="
				+ elective4 + "]";
	}
	
	
	
}
