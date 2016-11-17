package com.musiccamp.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.musiccamp.entities.ElectiveRoomTimings;
import com.musiccamp.entities.RoomTimings;
import com.musiccamp.entities.Timings;
import com.musiccamp.entities.Electives;
import com.musiccamp.entities.Room;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
public interface ERTRepository extends JpaRepository<ElectiveRoomTimings, Integer> {

	
@Query(value="select t.timeId,t.timeSlot,r.roomName,e.electiveName from "
		+ "Timings t,Electives e,Room r,RoomTimings rt, ElectiveRoomTimings ert where t.timeId=rt.timings "
		+ "and rt.room=r.roomId and rt.timings=t.timeId and e.electiveId=ert.electives "
		+ "and rt.rtId=ert.roomTimings order by t.timeId") 

List<Object[]> findAllTimings();

@Query(value="select ert.rt_id from elective_room_timings ert where ert.elective_id=?1 and "
		+ "ert.rt_id=?2",nativeQuery=true)
boolean findElectivertID(int electiveID, int rtId);


	
}

