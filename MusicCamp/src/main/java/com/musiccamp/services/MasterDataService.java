package com.musiccamp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.musiccamp.entities.Electives;
import com.musiccamp.entities.Room;
import com.musiccamp.model.ElectiveRoomTimeModel;
import com.musiccamp.repositories.ERTRepository;
import com.musiccamp.repositories.ElectiveRepository;
import com.musiccamp.repositories.RoomRepository;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 */

@Service
public class MasterDataService {
	
	@Autowired
	private ERTRepository erts;
	@Autowired
	private RoomRepository rrts;
	@Autowired
	private ElectiveRepository ers;
	
	
	public HttpSession MasterLogic(ModelMap model,HttpSession session){
		
		List<Object[]> tabview=erts.findAllTimings(); //invoke HQL -SpringDATA
		List<String> roomIds= new ArrayList<String>();
		TreeMap<String,ElectiveRoomTimeModel> timemappings=new TreeMap<>();
		ElectiveRoomTimeModel ertm=new ElectiveRoomTimeModel();
		for(Object[] tabledata:tabview ){

			
			ertm.setTimeslots((String)tabledata[1]);
			
			if((ertm=(ElectiveRoomTimeModel) timemappings.get(tabledata[1]))!=null){
				
				ertm.getRoomNum().add((String) tabledata[2]);
				ertm.getElectiveName().add((String) tabledata[3]);
				
			}
			
			
			else{
				ertm=new ElectiveRoomTimeModel();
				ertm.setRoomNum(new ArrayList<String>());
				ertm.setElectiveName(new ArrayList<String>());
				ertm.getRoomNum().add((String)tabledata[2]);
				ertm.getElectiveName().add((String) tabledata[3]);
				timemappings.put((String)tabledata[1], ertm);
			}
			
	}
		
		roomIds=rrts.findbyRoomName(); //invoke HQL of RoomRepository
		
		
	Map<String,ElectiveRoomTimeModel> crsRmTmng1 = new TreeMap<String,ElectiveRoomTimeModel>();
	Iterator<Entry<String, ElectiveRoomTimeModel>>  iterator= timemappings.entrySet().iterator();
		
	//Second Map for comparing the 2 maps and add ---, if electives aren't present in that slot
	while(iterator.hasNext()){
		Map.Entry<String, ElectiveRoomTimeModel> entry=iterator.next();
		String timing= entry.getKey();
		ElectiveRoomTimeModel courseRoomValue= entry.getValue();
		ElectiveRoomTimeModel tempCourseRoom= new ElectiveRoomTimeModel();
		tempCourseRoom.setRoomNum(new ArrayList<String>());
		tempCourseRoom.setElectiveName(new ArrayList<String>());
		for(String roomId:roomIds){				
			if(!courseRoomValue.getRoomNum().contains(roomId)){
				tempCourseRoom.getRoomNum().add(roomId);
				tempCourseRoom.getElectiveName().add("---");
				crsRmTmng1.put(timing, tempCourseRoom);
			}
			else{
				tempCourseRoom.getRoomNum().add(roomId);
				tempCourseRoom.getElectiveName().add(courseRoomValue.getElectiveName().get(courseRoomValue.getRoomNum().indexOf(roomId)));
				crsRmTmng1.put(timing, tempCourseRoom);
			}
			
		}
	}
	
	List<Room> roomMap=rrts.findAll();
	List<Electives> electivedropdown=ers.findAll();
	List<Electives> elect=new ArrayList<>();
	model.addAttribute("elect",elect);
	model.addAttribute("dropdowndata", electivedropdown);
	model.put("roomMap", roomMap);
	model.put("tablerooms", crsRmTmng1);
	
	session.setAttribute("tablerooms", model);
	
		return session;
		
	}

}
