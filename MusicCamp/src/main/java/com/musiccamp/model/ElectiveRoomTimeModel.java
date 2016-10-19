package com.musiccamp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.musiccamp.entities.Electives;
import com.musiccamp.entities.Room;
import com.musiccamp.entities.Timings;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
public class ElectiveRoomTimeModel {

	
	
	private ArrayList<String> RoomNum;
	private ArrayList<String> ElectiveName;
	private String timeslots;
	

	
	public ElectiveRoomTimeModel() {
		
	}
	
	

	public ElectiveRoomTimeModel(ArrayList<String> roomNum, ArrayList<String> electiveName, String timeslots) {
		RoomNum = roomNum;
		ElectiveName = electiveName;
		this.timeslots = timeslots;
	}



	public String getTimeslots() {
		return timeslots;
	}



	public void setTimeslots(String timeslots) {
		this.timeslots = timeslots;
	}



	public ArrayList<String> getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(ArrayList<String> roomNum) {
		RoomNum = roomNum;
	}
	public ArrayList<String> getElectiveName() {
		return ElectiveName;
	}
	public void setElectiveName(ArrayList<String> electiveName) {
		ElectiveName = electiveName;
	}



	@Override
	public String toString() {
		return "RoomNum=" + RoomNum + ", ElectiveName=" + ElectiveName + "]";
	}



	
	
	
}