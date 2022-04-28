package org.kh.shareware.approval.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.approval.store.ApprovalStore;
import org.kh.shareware.common.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalStoreLogic implements ApprovalStore{

	@Override
	public int insertDoc(SqlSession sqlSession, AppDocument appDoc) { // 기안서 등록
		int result = sqlSession.insert("ApprovalMapper.insertDoc", appDoc);
		return result;
	}

	@Override
	public int insertApp(SqlSession sqlSession, Approval app) { // 결재자 등록
		int result = sqlSession.insert("ApprovalMapper.insertApp", app);
		return result;
	}

	@Override
	public int insertRef(SqlSession sqlSession, AppReference ref) { // 참조자 등록
		int result = sqlSession.insert("ApprovalMapper.insertRef", ref);
		return result;
	}

	@Override
	public int insertFile(SqlSession sqlSession, AppFile file) { // 파일 등록
		int result = sqlSession.insert("ApprovalMapper.insertFile", file);
		return result;
	}

	@Override
	public AppForm selectForm(SqlSession sqlSession, int formNo) { // 문서 양식 조회
		AppForm form = sqlSession.selectOne("ApprovalMapper.selectForm", formNo);
		return form;
	}

	@Override
	public List<AppForm> selectAllForm(SqlSession sqlSession) { // 문서 양식 전체 조회
		List<AppForm> fList = sqlSession.selectList("ApprovalMapper.selectAllForm");
		return fList;
	}

	@Override
	public String selectOneLeaveDoc(SqlSession sqlSession, String memberNum) { // 휴가 신청서 조회(잔여 연차)
		String leaveLeft = sqlSession.selectOne("ApprovalMapper.selectOneLeaveDoc", memberNum);
		return leaveLeft;
	}

	@Override
	public List<AppDocument> selectAllDoc(SqlSession sqlSession, String memberNum, PageInfo pi) { // 기안 문서 조회(기안 문서함)
		int limit = pi.getDocLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<AppDocument> dList = sqlSession.selectList("ApprovalMapper.selectAllDoc", memberNum, rowBounds);
		return dList;
	}

	@Override
	public int selectListCount(SqlSession sqlSession, String memberNum) { // 기안 문서함 페이징 처리
		int totalCount = sqlSession.selectOne("ApprovalMapper.selectListCount", memberNum);
		return totalCount;
	}

}