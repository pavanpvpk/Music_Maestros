package com.musiccamp.entities;
// Generated Oct 17, 2016 2:14:25 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Room generated by hbm2java
 */
@Entity
@Table(name = "room")
public class Room implements java.io.Serializable {

	private Integer roomId;
	private String roomName;
	private Set<RoomTimings> roomTimingses = new HashSet<RoomTimings>(0);

	public Room() {
	}

	public Room(String roomName) {
		this.roomName = roomName;
	}

	public Room(String roomName, Set<RoomTimings> roomTimingses) {
		this.roomName = roomName;
		this.roomTimingses = roomTimingses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "room_id", unique = true, nullable = false)
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "room_name", nullable = false)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	public Set<RoomTimings> getRoomTimingses() {
		return this.roomTimingses;
	}

	public void setRoomTimingses(Set<RoomTimings> roomTimingses) {
		this.roomTimingses = roomTimingses;
	}

}
