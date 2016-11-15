package com.musiccamp.model;

public class StudentScheduleModel {

	private String username;
	private String courseName;//elective names
	private String timings;
	private String roomName;
	public StudentScheduleModel(String username, String courseName, String timings, String roomName) {
		super();
		this.username = username;
		this.courseName = courseName;
		this.timings = timings;
		this.roomName = roomName;
	}
	public StudentScheduleModel() {
		super();
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
