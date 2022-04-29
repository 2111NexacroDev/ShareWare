package org.kh.shareware.project.service;

import java.util.List;

import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.report.domain.Daily;

public interface ProjectService {

	public int registerProject(Project project);  //프로젝트  등록
	public int registerParticipant(Participant participant); // 참여자 등록
	public List<Project> printAllProject(String memberNum);	//프로젝트 목록
	public Project printOneProject(int projectNo);  //프로젝트 메인페이지
	public Project printOneProjectDetail(int projectNo); //프로젝트 정보(상세)
	public int modifyProject(Project project);	//프로젝트 정보 수정
	public int removeProject(int projectNo);	//프로젝트 삭제
	public int removeParticipant(Participant participant); // 참여자 삭제
	public List<Member> printAllParticipant(int projectNo);// 참여자 목록

	

}