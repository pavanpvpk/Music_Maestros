package com.musiccamp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musiccamp.entities.Room;
import com.musiccamp.entities.RoomTimings;
import com.musiccamp.entities.Timings;
import com.musiccamp.repositories.RoomRepository;
import com.musiccamp.repositories.RoomTimingsRepository;
import com.musiccamp.repositories.TimingRepository;

@Controller
public class MasterDataController {
	
	@Autowired
	private RoomTimingsRepository rtr;
	
	@Autowired
	private RoomRepository rrp;
	
	@Autowired
	private TimingRepository tr;
	
	@RequestMapping("/viewMasterData")
	public String viewMasterData(ModelMap model, HttpSession session){
		
		List<RoomTimings> rtg=rtr.findAll();
		List<Room> rl=rrp.findAll();
		
		List<Timings> time= tr.findAll();
		
		model.put("alltimes", time);
		model.put("allrooms", rl);
		model.put("rtk", rtg);	
		session.setAttribute("alltimes", time);
		session.setAttribute("rtk", rtg);
		
		return "viewMasterSchedule";
	}
	

}
