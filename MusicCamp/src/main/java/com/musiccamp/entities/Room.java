package com.musiccamp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.HashSet;


@Entity
@Table(name="room")
public class Room {

	
	
	public Room() {
	}

	@Id
	@Column(name="room_num")
	private String roomnum;

	@OneToMany(mappedBy = "roomnum", cascade = CascadeType.ALL)
	private Set<RoomTimings> roomtime=new HashSet<RoomTimings>();

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public Set<RoomTimings> getCoursetime() {
		return roomtime;
	}

	public void setCoursetime(Set<RoomTimings> roomtime) {
		this.roomtime = roomtime;
	}
	
	
}
