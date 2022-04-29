package org.kh.shareware.meetingRoom.domain;

import java.sql.Date;

public class MeetingRoom {
private String memberNum;
private String meetingNo;
private Date meetingDate;
private int meetingTime;
private String meetingReservation;

public MeetingRoom() {}

public MeetingRoom(String memberNum, String meetingNo, Date meetingDate, int meetingTime, String meetingReservation) {
	super();
	this.memberNum = memberNum;
	this.meetingNo = meetingNo;
	this.meetingDate = meetingDate;
	this.meetingTime = meetingTime;
	this.meetingReservation = meetingReservation;
}

public String getMemberNum() {
	return memberNum;
}

public void setMemberNum(String memberNum) {
	this.memberNum = memberNum;
}

public String getMeetingNo() {
	return meetingNo;
}

public void setMeetingNo(String meetingNo) {
	this.meetingNo = meetingNo;
}

public Date getMeetingDate() {
	return meetingDate;
}

public void setMeetingDate(Date meetingDate) {
	this.meetingDate = meetingDate;
}

public int getMeetingTime() {
	return meetingTime;
}

public void setMeetingTime(int meetingTime) {
	this.meetingTime = meetingTime;
}

public String getMeetingReservation() {
	return meetingReservation;
}

public void setMeetingReservation(String meetingReservation) {
	this.meetingReservation = meetingReservation;
}

@Override
public String toString() {
	return "MeetingRoom [memberNum=" + memberNum + ", meetingNo=" + meetingNo + ", meetingDate=" + meetingDate
			+ ", meetingTime=" + meetingTime + ", meetingReservation=" + meetingReservation + "]";
}


}