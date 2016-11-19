package com.musiccamp.controller;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.musiccamp.entities.ElectiveRoomTimings;
import com.musiccamp.entities.Electives;
import com.musiccamp.entities.Room;
import com.musiccamp.entities.RoomTimings;
import com.musiccamp.entities.Student;
import com.musiccamp.entities.Timings;
import com.musiccamp.model.StudentScheduleModel;
import com.musiccamp.repositories.ERTRepository;
import com.musiccamp.repositories.ElectiveRepository;
import com.musiccamp.repositories.RTRepository;
import com.musiccamp.repositories.RoomRepository;
import com.musiccamp.repositories.StudentRepository;
import com.musiccamp.repositories.TimingRepository;


@Controller
@Scope(value="session")
public class StudentScheduleController {
	
	private static final Logger LOG=LoggerFactory.getLogger(StudentScheduleController.class);
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ElectiveRepository electivesRepo;
	
	@Autowired
	private ERTRepository ertRepository;
	
	
	@Autowired
	private RTRepository rtRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private TimingRepository timingRepository;
	
	List<StudentScheduleModel> studentScheduleList = new ArrayList<StudentScheduleModel>();
	@RequestMapping(value="/studentSchedule",method=RequestMethod.GET)
	
	public String Schedulegen(ModelMap model,HttpSession session){
		
		//System.out.println(session.getAttribute("sid"));
		//System.out.println(studentName);
		//Integer username =null;
//		if(session != null) {
//		 username = (Integer)session.getAttribute("sid");
//		}
		
		try{
			Student student = studentRepo.find((Integer)session.getAttribute("validuser")); 
			
		
			List<String> electiveNames = java.util.Collections.checkedList(new ArrayList<String>(), String.class);
			
			
			if(student.getElective1()!=null&&(!student.getElective1().isEmpty())) electiveNames.add(student.getElective1());
			
			if(student.getElective2()!=null&&(!student.getElective2().isEmpty())) electiveNames.add(student.getElective2());
			
			if(student.getElective3()!=null&&(!student.getElective3().isEmpty())) electiveNames.add(student.getElective3());
			
			if(student.getElective4()!=null&&(!student.getElective4().isEmpty())) electiveNames.add(student.getElective4());
			
			List<Electives> allElectives = electivesRepo.findAll();
			List<Electives> studentElectives = new ArrayList<Electives>(); 
			for (Electives elective	 : allElectives) {
				if(electiveNames.contains(elective.getElectiveName())) {
					studentElectives.add(elective);
				}
			}
			//ok till here
			System.out.println(studentElectives.size());
			List<ElectiveRoomTimings> allERTimings = ertRepository.findAll();
			List<ElectiveRoomTimings> studentERTimings = new ArrayList<ElectiveRoomTimings>(); 
			for (ElectiveRoomTimings erTimings : allERTimings) {
				if(studentElectives.contains(erTimings.getElectives()) ) {
					studentERTimings.add(erTimings);
				}
				
			}
			
			List<RoomTimings> allRoomTimings = rtRepository.findAll();
			List<RoomTimings> studentRTimings = new ArrayList<RoomTimings>(); 
			for (RoomTimings rTimings : allRoomTimings) {
				for(ElectiveRoomTimings studentERTiming : studentERTimings ) {
					if(studentERTiming.getRoomTimings().getRtId() == rTimings.getRtId()) {
						studentRTimings.add(rTimings);
					}
				}
				
			}
			
			List<Room> allRooms = roomRepository.findAll();
			List<Timings> allTimings = timingRepository.findAll();
			List<Room> studentRooms = new ArrayList<Room>(); 
			List<Timings> studentTimings = new ArrayList<Timings>(); 
			for(RoomTimings rt:studentRTimings) {
				for(Room r:allRooms ) {
					if(r.getRoomId() == rt.getRoom().getRoomId()) {
						studentRooms.add(r);
					}
				}
				for(Timings t:allTimings ) {
					if(t.getTimeId() == rt.getTimings().getTimeId()) {
						studentTimings.add(t);
					}
				}
			}
			
			for(int i=0;i<studentElectives.size();i++) {
				StudentScheduleModel ssm =new StudentScheduleModel();
				ssm.setCourseName(studentElectives.get(i).getElectiveName());
				ssm.setRoomName(studentRooms.get(i).getRoomName());
				ssm.setTimings(studentTimings.get(i).getTimeSlot());
				
				studentScheduleList.add(ssm);
				}
			
			StudentScheduleModel ssm =new StudentScheduleModel();
			ssm.setGrade(student.getGrade());
			ssm.setPrimaryInstrument(student.getPrimaryInstrument());
			ssm.setSecondaryInstrument(student.getSecondaryInstrument());
			ssm.setTrack(student.getTrack());
			
			session.setAttribute("Secondaryschedule", ssm);
			
			session.setAttribute("scheduleList", studentScheduleList);
			return "studentSchedule";
			
		}
		
		catch(NullPointerException ne){
			
			LOG.info("SessionTimeOut: ",(Integer)session.getAttribute("validuser") );
			session.setAttribute("loginexpired", "Unfortunately, your session has been expired. please login again!");
			return "login";
		}
		
	}
}
