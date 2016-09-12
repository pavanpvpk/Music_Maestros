package com.musiccamp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="room_timings")
public class RoomTimings implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="room_num")
	private Room roomnum;
	
	@Id
	@ManyToOne
	@JoinColumn(name="course_name")
	private Elective coursenum;
	
	@Column(name="timings")
	private String timings;
	
	
	
	public Room getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(Room roomnum) {
		this.roomnum = roomnum;
	}
	
	
	public Elective getCoursenum() {
		return coursenum;
	}
	public void setCoursenum(Elective coursenum) {
		this.coursenum = coursenum;
	}
	
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	

}
