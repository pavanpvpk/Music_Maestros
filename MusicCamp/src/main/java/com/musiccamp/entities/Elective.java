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
@Table(name="Electives")
public class Elective {
	
	
	public Elective() {
	}


	@Id
	@Column(name="elective_name")
	private String electivename;
	
	@OneToMany(mappedBy = "electivename", cascade = CascadeType.ALL)
	private Set<RoomTimings> roomtime=new HashSet<RoomTimings>();


	public String getElectivename() {
		return electivename;
	}


	public void setElectivename(String electivename) {
		this.electivename = electivename;
	}

	
	public Set<RoomTimings> getRoomtime() {
		return roomtime;
	}


	public void setRoomtime(Set<RoomTimings> roomtime) {
		this.roomtime = roomtime;
	}
	

}
