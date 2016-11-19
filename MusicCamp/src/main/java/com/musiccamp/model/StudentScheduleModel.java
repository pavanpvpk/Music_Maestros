package com.musiccamp.model;

public class StudentScheduleModel {

	private String username;
	private String courseName;//elective names
	private String timings;
	private String roomName;
	private String track;
	private String grade;
	private String primaryInstrument;
	private String secondaryInstrument;
	
	
	public StudentScheduleModel(String username, String courseName, String timings, String roomName, String track,
			String grade, String primaryInstrument, String secondaryInstrument) {
		this.username = username;
		this.courseName = courseName;
		this.timings = timings;
		this.roomName = roomName;
		this.track = track;
		this.grade = grade;
		this.primaryInstrument = primaryInstrument;
		this.secondaryInstrument = secondaryInstrument;
	}
	
	public StudentScheduleModel() {
		super();
	}
	
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPrimaryInstrument() {
		return primaryInstrument;
	}
	public void setPrimaryInstrument(String primaryInstrument) {
		this.primaryInstrument = primaryInstrument;
	}
	public String getSecondaryInstrument() {
		return secondaryInstrument;
	}
	public void setSecondaryInstrument(String secondaryInstrument) {
		this.secondaryInstrument = secondaryInstrument;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
}
