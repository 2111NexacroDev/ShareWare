package org.kh.shareware.attendance.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.attendance.store.AttendanceStore;
import org.kh.shareware.member.common.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	//출퇴근 등록
	@Override
	public int insertAttendance(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.insert("AttendanceMapper.insertAttendance", attendance);
		return result;
	}
	@Override
	public int updateAttendance(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.update("AttendanceMapper.updateAttendance", attendance);
		return result;
	}

	//근태리스트
	@Override
	public List<Attendance> selectAll(SqlSession sqlSession, PageInfo pi, String memNum) {
		int limit = pi.getMemberLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Attendance> aList 
			= sqlSession.selectList("AttendanceMapper.selectAllList", memNum, rowBounds);
		return aList;
	}
	@Override
	public int selectListCount(SqlSession sqlSession, String memNum) {
		int totalCount = sqlSession.selectOne("AttendanceMapper.selectListCount",memNum);
		return totalCount;
	}
	
	//통계
	@Override
	public List<Stats> selectStats(SqlSession sqlSession, String memNum) {
		List<Stats> sList 
		= sqlSession.selectList("AttendanceMapper.selectStats", memNum);
	return sList;
	}
	
	// 홈 - 근태 관리
	@Override
	public Attendance selectOneAtt(SqlSession sqlSession, String memberNum) {
		Attendance attendance = sqlSession.selectOne("AttendanceMapper.selectOneAtt", memberNum);
		return attendance;
	}


}