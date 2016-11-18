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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.musiccamp.entities.Electives;
import com.musiccamp.entities.Room;
import com.musiccamp.entities.RoomTimings;
import com.musiccamp.entities.Timings;
import com.musiccamp.model.ElectiveRoomTimeModel;
import com.musiccamp.repositories.ERTRepository;
import com.musiccamp.repositories.ElectiveRepository;
import com.musiccamp.repositories.RTRepository;
import com.musiccamp.repositories.RoomRepository;
import com.musiccamp.repositories.TimingRepository;
import com.musiccamp.services.MasterDataService;


/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
@Controller
@Scope(value="session")
@SessionAttributes({"tablerooms","roomMap","dropdowndata"})

public class MasterDataController {
	
	@Autowired
	private ERTRepository erts;
	
	@Autowired
	private TimingRepository trts;
	
	@Autowired
	private RoomRepository rrts;

	@Autowired
	private ElectiveRepository ers;
	
	@Autowired
	private RTRepository rts;
	
	private final MasterDataService masterdataservice;
	
	@Autowired
	public MasterDataController(MasterDataService msd){
		
		this.masterdataservice=msd;
	}
	
	@RequestMapping(value={"/viewMasterData"},method=RequestMethod.GET)
	public String viewMasterData(ModelMap model,HttpSession session){
	
		
		
		if(!(session.getAttribute("validuser")==null)){
		
			masterdataservice.MasterLogic(model,session);
			
			return "viewMasterSchedule";
		}
		
		else{
			
			return "login";
		}
		

	}
	

	@RequestMapping(value="/editMasterSchedule",method=RequestMethod.GET)
	public String editMasterData(ModelMap model,HttpSession session){
		
		session.getAttribute("username");
		
		if(!(session.getAttribute("validuser")==null)){
			
			masterdataservice.MasterLogic(model,session);
			
			return "editMasterSchedule";
			
		}
		else{
			return "login";
		}

	}
	
	@RequestMapping(value="/editTable",method=RequestMethod.POST)
	public String getData(@RequestParam("oldelective") String oldelective,
						  @RequestParam("elective") String electiveName,
						  @RequestParam("timing") String timeslot,
						  @RequestParam("room") String roomNo){
		System.out.println(oldelective);
		System.out.println(electiveName);
		System.out.println(roomNo);
		System.out.println(timeslot);
		
		
		int roomID=rrts.findbyroomName(roomNo);
		int timeId=trts.findbytimeslot(timeslot);
		int rtId=rts.findrtID(roomID, timeId);
		if(!(oldelective.isEmpty()||oldelective.equals("---"))){
			
			int oldelectiveID=ers.findbyelectiveID(oldelective);
			int newelectiveID=ers.findbyelectiveID(electiveName);
			
			Integer ertIdFinal=erts.findElectivertID(oldelectiveID, rtId);
			if(!(ertIdFinal==null)){
				
				erts.UpdatertID(newelectiveID,ertIdFinal);
				
			}
			
			System.out.println(roomID);
			System.out.println(timeId);
			System.out.println(rtId);
			System.out.println(ertIdFinal);
		}
		
		else{
			
			int oldelectiveID=ers.findbyelectiveID(oldelective);
			int newelectiveID=ers.findbyelectiveID(electiveName);
			
			System.out.println(rtId);
			System.out.println(oldelectiveID);
			System.out.println(newelectiveID);

			erts.InsertertID(newelectiveID, rtId);
			
		}
		
		return "editMasterSchedule";
	}
}
