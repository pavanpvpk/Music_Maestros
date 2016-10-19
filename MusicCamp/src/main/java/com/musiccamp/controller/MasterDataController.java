package com.musiccamp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.musiccamp.entities.Room;
import com.musiccamp.model.ElectiveRoomTimeModel;
import com.musiccamp.repositories.ERTRepository;
import com.musiccamp.repositories.RoomRepository;


/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
@Controller
public class MasterDataController {
	
	@Autowired
	private ERTRepository erts;
	
	@Autowired
	private RoomRepository rrts;

	@RequestMapping(value="/viewMasterData",method=RequestMethod.POST)
	public String viewMasterData(ModelMap model, HttpSession session){
	
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
	
	session.setAttribute("roomNames", roomMap);

		model.put("tablerooms", crsRmTmng1);
		
		session.setAttribute("mastermap",crsRmTmng1);


		return "viewMasterSchedule";

	}
}
