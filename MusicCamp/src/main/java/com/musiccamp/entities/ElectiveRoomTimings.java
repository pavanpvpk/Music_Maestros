package com.musiccamp.entities;
// Generated Oct 17, 2016 2:14:25 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ElectiveRoomTimings generated by hbm2java
 */
@Entity
@Table(name = "elective_room_timings", catalog = "music_maestros")
public class ElectiveRoomTimings implements java.io.Serializable {

	private Integer ertId;
	private Electives electives;
	private RoomTimings roomTimings;

	public ElectiveRoomTimings() {
	}

	public ElectiveRoomTimings(Electives electives, RoomTimings roomTimings) {
		this.electives = electives;
		this.roomTimings = roomTimings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ert_id", unique = true, nullable = false)
	public Integer getErtId() {
		return this.ertId;
	}

	public void setErtId(Integer ertId) {
		this.ertId = ertId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "elective_id")
	public Electives getElectives() {
		return this.electives;
	}

	public void setElectives(Electives electives) {
		this.electives = electives;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rt_id")
	public RoomTimings getRoomTimings() {
		return this.roomTimings;
	}

	public void setRoomTimings(RoomTimings roomTimings) {
		this.roomTimings = roomTimings;
	}

}
