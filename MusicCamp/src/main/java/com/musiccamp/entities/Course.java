package com.musiccamp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {
	
	
	public Course() {
	}


	@Id
	@Column(name="course_name")
	private String coursename;
	
	@OneToMany(mappedBy = "coursenum", cascade = CascadeType.ALL)
	private Set<RoomTimings> roomtime=new HashSet<RoomTimings>();


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	
	public Set<RoomTimings> getRoomtime() {
		return roomtime;
	}


	public void setRoomtime(Set<RoomTimings> roomtime) {
		this.roomtime = roomtime;
	}
	

}
