package com.musiccamp.entities;
// Generated Sep 21, 2016 10:34:07 AM by Hibernate Tools 4.3.1.Final

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

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
@Entity
@Table(name = "elective_room_timings", catalog = "music_maestros")
public class ElectiveRoomTimings implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	@Override
	public String toString() {
		return  ertId.toString() + " " + electives.toString() + " " +
	roomTimings.toString();
				
	}

	
}