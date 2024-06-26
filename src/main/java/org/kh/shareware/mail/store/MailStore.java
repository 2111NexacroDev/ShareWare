package org.kh.shareware.mail.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailBmk;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;


public interface MailStore {

	
	public int insertMail(Mail mail, SqlSession sqlSession);

	public int insertMailFile(MailFile mailFile, SqlSession sqlSession);

	public int insertMailRec(MailRec mailRec, SqlSession sqlSession);

	public int insertMailRef(MailRef mailRef, SqlSession sqlSession);

	public int insertTemMail(Mail mail, SqlSession sqlSession);
	
	public int insertTemMailRec(MailRec mailRec, SqlSession sqlSession);

	public int insertTemMailRef(MailRef mailRef, SqlSession sqlSession);

	public int insertTemMailFile(MailFile mailFile, SqlSession sqlSession);

	public int updateTemMail(SqlSession sqlSession, Mail mail);

	public int updateTemMailRec(SqlSession sqlSession, MailRec mailRec);

	public int updateTemMailRef(SqlSession sqlSession, MailRef mailRef);

	public int updateTemMailFile(SqlSession sqlSession, MailFile mailFile);

	public int deleteChkMail(SqlSession sqlSession, int values);

	public int deleteChkMailRec(SqlSession sqlSession, int values);

	public int deleteChkMailRef(SqlSession sqlSession, int values);

	public int deleteChkMailFile(SqlSession sqlSession, int values);

	public Mail selectOneMail(SqlSession sqlSession, int mailNo);
	
	public List<MailRec> selectOneMailRec(SqlSession sqlSession, int mailNo);

	public List<MailRef> selectOneMailRef(SqlSession sqlSession, int mailNo);

	public List<MailFile> selectOneMailFile(SqlSession sqlSession, int mailNo);

	public List<Mail> selectTemMail(SqlSession sqlSession, Mail mail, PageInfo pi);
	
	public int selectTemListCount(SqlSession sqlSession, Mail mail);

	public Mail selectOneTemMail(SqlSession sqlSession, int mailNo);
	
	public List<MailRec> selectOneTemMailRec(SqlSession sqlSession, int mailNo);

	public List<MailRef> selectOneTemMailRef(SqlSession sqlSession, int mailNo);
	
	public List<MailFile> selectOneTemMailFile(SqlSession sqlSession, int mailNo);

	public int deleteMail(SqlSession sqlSession, int values);

	public int deleteMailRec(SqlSession sqlSession,  int values);

	public int deleteMailRef(SqlSession sqlSession,  int values);

//	public int deleteMailFile(SqlSession sqlSession,  Mail mail);

	public List<Mail> selectSearchMail(SqlSession sqlSession, Search search, PageInfo pi);

	public List<Mail> selectSearchRecMail(SqlSession sqlSession, Search search, PageInfo pi);

	public List<Mail> selectSearchMyMail(SqlSession sqlSession, Search search, PageInfo pi);

	public List<Mail> selectSearchFileMail(SqlSession sqlSession, Search search, PageInfo pi);

	//받은 메일함
	public List<Mail> selectMail(SqlSession sqlSession, Mail mail, PageInfo pi);
	public List<MailRec> selectMailRecList(SqlSession sqlSession, MailRec mailRec);
	public List<MailRef> selectMailRefList(SqlSession sqlSession, MailRef mailRef);
	public List<Mail> selectRecMail(SqlSession sqlSession, Mail mail, PageInfo pi);

	public List<Mail> selectMyMail(SqlSession sqlSession, Mail mail, PageInfo pi);

	public List<Mail> selectFileMail(SqlSession sqlSession, Mail mail, PageInfo pi);

	public int selectMailCount(SqlSession sqlSession, Mail mail);

	public int selectMailRecCount(SqlSession sqlSession, Mail mail);
	
	public int selectMailMyCount(SqlSession sqlSession, Mail mail);

	public int selectMailFileCount(SqlSession sqlSession, Mail mail);
	
	public int selectSearchListCount(SqlSession sqlSession, Search search );

	public int selectSearchListRecCount(SqlSession sqlSession, Search search);

	public int selectSearchListMyCount(SqlSession sqlSession, Search search);

	public int selectSearchListFileCount(SqlSession sqlSession, Search search);
	//읽은 메일 상태값
	public int updateICount(SqlSession sqlSession, Mail mail);
	
	public int updateRecCount(SqlSession sqlSession, Mail mail);

	public int updateRefCount(SqlSession sqlSession, Mail mail);

	public int insertiMail(int values, SqlSession sqlSession);
	
	public int insertiMailRec(int values, SqlSession sqlSession);

	public int insertiMailRef(int values, SqlSession sqlSession);

	public int insertBmk(SqlSession sqlSession, MailBmk mailBmk);

	public int insertAppMail(Mail mail, SqlSession sqlSession);

	public int insertAppMailRec(MailRec mailRec, SqlSession sqlSession);

	public int insertAppMailRef(MailRef mailRef, SqlSession sqlSession);

	public int insertAppMailFile(MailFile mailFile, SqlSession sqlSession);

	public List<Mail> selectAppMail(Mail mail, SqlSession sqlSession);

	public List<Mail> selectSearchTemMail(SqlSession sqlSession, Search search, PageInfo pi);

	public List<Mail> selectSearchAppMail(SqlSession sqlSession, Search search, PageInfo pi);

	public int selectSearchListTemCount(SqlSession sqlSession, Search search);

	public int selectSearchListAppCount(SqlSession sqlSession, Search search);

	public Mail selectOneAppMail(SqlSession sqlSession, int mailNo);

	public List<MailRec> selectOneAppMailRec(SqlSession sqlSession, int mailNo);

	public List<MailRef> selectOneAppMailRef(SqlSession sqlSession, int mailNo);

	public List<MailFile> selectOneAppMailFile(SqlSession sqlSession, int mailNo);

	public int selectAppListCount(SqlSession sqlSession, Mail mail);

	public int selectReadListCount(SqlSession sqlSession, Mail mail);

	public int selectIListCount(SqlSession sqlSession, Mail mail);

	public List<Mail> selectIMail(SqlSession sqlSession, Mail mail, PageInfo pi);

	public Mail selectOneIMail(SqlSession sqlSession, int mailNo);

	public List<MailRec> selectOneIMailRec(SqlSession sqlSession, int mailNo);

	public List<MailRef> selectOneIMailRef(SqlSession sqlSession, int mailNo);

	public List<MailFile> selectOneIMailFile(SqlSession sqlSession, int mailNo);

	public List<MailBmk> selectBmk(SqlSession sqlSession, MailBmk mailBmk);

	public List<MailBmk> selectModalBmk(SqlSession sqlSession, MailBmk mailBmk);

	//수신인 카운트
	public int selectReceiverCount(SqlSession sqlSession, Mail mail);
	//참조인 카운트
	public int selectRefereeCount(SqlSession sqlSession, Mail mail);
	//즐겨찾는 메일취소
	public int deleteiMail(SqlSession sqlSession, int values);
	
	public int deleteiMailRec(SqlSession sqlSession, int values);

	public int deleteiMailRef(SqlSession sqlSession, int values);

	public int deleteMailBmk(SqlSession sqlSession, MailBmk mailBmk);

	public List<MailBmk> selectBmkList(SqlSession sqlSession, MailBmk mailBmk);

	public int selectMailNo(SqlSession sqlSession, Mail mail);
	
	// 넥사크로 - 승인 메일 관리
	public List<Mail> selectListAppMail(SqlSession sqlSession); // 전체 승인 메일 조회

	public int selectOneAppCount(SqlSession sqlSession); // 승인 대기 메일 개수

	public List<Mail> selectListSearchAppMail(SqlSession sqlSession, String searchValue); // 승인 메일 검색

	public int selectOneAppAllCount(SqlSession sqlSession); // 전체 승인 메일 개수

	public Mail selectOneAdminAppMail(SqlSession sqlSession, int mailNo); // 승인 메일 상세 조회

	public List<Mail> selectListFilterAppMail(SqlSession sqlSession, String aStatus); // 승인 상태 필터 조회

	public int updateRStatusAppMail(SqlSession sqlSession, String mailNo); // 승인 메일 삭제

	public int updateAStatusAppMail(SqlSession sqlSession, Mail mail); // 승인 상태 변경
	// 메일 발송시 즐겨찾는 그룹 선택 그룹원
	public List<MailBmk> selectOneMailBmk(SqlSession sqlSession, MailBmk mailBmk);

	
	

	

	

	

	

	

	


	
	

	

	
	
}
