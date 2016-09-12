package com.musiccamp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="room_timings")
public class RoomTimings implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@ManyToOne
	@JoinColumn(name="roomNum",foreignKey=@ForeignKey(name="room_num"),referencedColumnName="room_num")
	private Room roomnum;
	
	@Id
	@ManyToOne
	@JoinColumn(name="electiveName",foreignKey=@ForeignKey(name="elective_name"),referencedColumnName="elective_name")
	private Elective electivename;
	
	@Column(name="timings")
	private String timings;
	
	
	
	public Room getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(Room roomnum) {
		this.roomnum = roomnum;
	}
	
	
	public Elective getElectivename() {
		return electivename;
	}
	public void setElectivename(Elective electivename) {
		this.electivename = electivename;
	}
	
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	

}
