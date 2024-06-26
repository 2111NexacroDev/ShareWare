package org.kh.shareware.mail.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailBmk;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.service.MailService;
import org.kh.shareware.mail.store.MailStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MailServiceImpl implements MailService{
	@Autowired
	MailStore mStore;
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int registerMail(Mail mail) {
		int result = mStore.insertMail( mail,sqlSession);
		return result;
	}


	@Override
	public int registerMailFile(MailFile mailFile) {
		int result = mStore.insertMailFile(mailFile,sqlSession);
		return result;
	}


	@Override
	public int registerMailRec(MailRec mailRec) {
		int result = mStore.insertMailRec(mailRec, sqlSession);
		return result;
	}


	@Override
	public int registerMailRef(MailRef mailRef) {
		int result = mStore.insertMailRef(mailRef, sqlSession);
		return result;
	}


	@Override
	public int registerTemMail(Mail mail) {
		int result = mStore.insertTemMail(mail,sqlSession);
		return result;
	}


	@Override
	public int registerTemMailRec(MailRec mailRec) {
		int result = mStore.insertTemMailRec(mailRec,sqlSession);
		return result;
	}


	@Override
	public int registerTemMailRef(MailRef mailRef) {
		int result = mStore.insertTemMailRef(mailRef, sqlSession);
		return result;
	}


	@Override
	public int registerTemMailMyFile(MailFile mailFile) {
		int result = mStore.insertTemMailFile(mailFile, sqlSession);
		return result;
	}


	


	@Override
	public int removeChkMail( int values) {
		int result = mStore.deleteChkMail(sqlSession, values);
		return result;
	}


	@Override
	public int removeChkMailRec(int values) {
		int result = mStore.deleteChkMailRec(sqlSession, values);
		return result;
	}
	


	@Override
	public int removeChkMailRef(int values) {
		int result = mStore.deleteChkMailRef(sqlSession, values);
		return result;
	}


	@Override
	public int removeChkMailFile(int values) {
		int result = mStore.deleteChkMailFile(sqlSession, values);
		return result;
	}
	// 보낸 메일
	@Override
	public Mail printOneMail(int mailNo) {
		Mail mail = mStore.selectOneMail(sqlSession, mailNo);
		return mail;
	}
	//받은 메일
	@Override
	public List<MailRec> printOneMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneMailFile(sqlSession, mailNo);
		return mailFile;
	}
	@Override
	public List<Mail> printTemMail(Mail mail, PageInfo pi) {
		List<Mail> tList = mStore.selectTemMail(sqlSession, mail, pi);
		return tList;
	}
	
	@Override
	public int getTemMailCount(Mail mail) {
		int totalCount = mStore.selectTemListCount(sqlSession, mail);
		return totalCount;
	}


	@Override
	public Mail printOneTemMail(int mailNo) {
		Mail mail = mStore.selectOneTemMail(sqlSession, mailNo);
		return mail;
	}

	@Override
	public List<MailRec> printOneTemMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneTemMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneTemMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneTemMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneTemMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneTemMailFile(sqlSession, mailNo);
		return mailFile;
	}
	


	@Override
	public int removeMail(int values) {
		int result = mStore.deleteMail(sqlSession, values);
		return result;
	}


	@Override
	public int removeMailRec(int values) {
		int result = mStore.deleteMailRec(sqlSession, values);
		return result;
	}


	@Override
	public int removeMailRef(int values) {
		int result = mStore.deleteMailRef(sqlSession, values);
		return result;
	}

	@Override
	public int modifyTemMail(Mail mail) {
		int result = mStore.updateTemMail(sqlSession, mail);
		return result;
	}


	@Override
	public int modifyTemMailRec(MailRec mailRec) {
		int result = mStore.updateTemMailRec(sqlSession, mailRec);
		return result;
	}


	@Override
	public int modifyTemMailRef(MailRef mailRef) {
		int result = mStore.updateTemMailRef(sqlSession, mailRef);
		return result;
	}


	@Override
	public int modifyTemMailFile(MailFile mailFile) {
		int result = mStore.updateTemMailFile(sqlSession, mailFile);
		return result;
	}


	@Override
	public List<Mail> printSearchMail(Search search, PageInfo pi) {
		List<Mail> searchList = mStore.selectSearchMail(sqlSession, search, pi);
		return searchList;
	}


	@Override
	public List<Mail> printSearchMailRec(Search search, PageInfo pi) {
		List<Mail> searchRecList = mStore.selectSearchRecMail(sqlSession, search, pi);
		return searchRecList;
	}


	@Override
	public List<Mail> printSearchMailMy(Search search, PageInfo pi) {
		List<Mail> searchMyList = mStore.selectSearchMyMail(sqlSession, search, pi);
		return searchMyList;
	}


	@Override
	public List<Mail> printSearchMailFile(Search search, PageInfo pi) {
		List<Mail> searchFileList = mStore.selectSearchFileMail(sqlSession, search, pi);
		return searchFileList;
	}

	//보낸메일
	@Override
	public List<Mail> printMail(Mail mail, PageInfo pi) {
		List<Mail> mList = mStore.selectMail(sqlSession, mail, pi);
		return mList;
	}
	//수신인 리스트
	@Override
	public List<MailRec> printMailRecList(MailRec mailRec) {
		List<MailRec> cList = mStore.selectMailRecList(sqlSession, mailRec);
		return cList;
	}
	//참조인 리스트
	@Override
	public List<MailRef> printMailRefList(MailRef mailRef) {
		List<MailRef> refList = mStore.selectMailRefList(sqlSession, mailRef);
		return refList;
	}
	

	@Override
	public List<Mail> printMailRec(Mail mail, PageInfo pi) {
		List<Mail> mRecList = mStore.selectRecMail(sqlSession, mail, pi);
		return mRecList;
	}


	@Override
	public List<Mail> printMailMy(Mail mail, PageInfo pi) {
		List<Mail> mMyList = mStore.selectMyMail(sqlSession, mail, pi);
		return mMyList;
	}


	@Override
	public List<Mail> printMailFile(Mail mail, PageInfo pi) {
		List<Mail> mFileList = mStore.selectFileMail(sqlSession, mail, pi);
		return mFileList;
	}


	@Override
	public int getMailCount(Mail mail) {
		int totalmCount = mStore.selectMailCount(sqlSession, mail);
		return totalmCount;
	}


	@Override
	public int getMailRecCount(Mail mail) {
		int totalmRecCount = mStore.selectMailRecCount(sqlSession, mail);
		return totalmRecCount;
	}


	@Override
	public int getMailMyCount(Mail mail) {
		int totalmMyCount = mStore.selectMailMyCount(sqlSession, mail);
		return totalmMyCount;
	}


	@Override
	public int getMailFileCount(Mail mail) {
		int totalmFileCount = mStore.selectMailFileCount(sqlSession, mail);
		return totalmFileCount;
	}

	@Override
	public int getSearchMailCount(Search search) { //메일함 검색 페이징
		int totalmCount = mStore.selectSearchListCount(sqlSession, search);
		return totalmCount;
	}

	@Override
	public int getSearchMailRecCount(Search search) {
		int totalmRecCount = mStore.selectSearchListRecCount(sqlSession, search);
		return totalmRecCount;
	}


	@Override
	public int getSearchMailMyCount(Search search) {
		int totalmMyCount = mStore.selectSearchListMyCount(sqlSession, search);
		return totalmMyCount;
	}


	@Override
	public int getSearchMailFileCount(Search search) {
		int totalmFileCount = mStore.selectSearchListFileCount(sqlSession, search);
		return totalmFileCount;
	}

	//읽은 메일 카운트
	@Override
	public int viewCountMail(Mail mail) {
		int count = mStore.updateICount(sqlSession, mail);
		return count;
	}
	
	@Override
	public int viewRecCountMail(Mail mail) {
		int recCount = mStore.updateRecCount(sqlSession, mail);
		return recCount;
	}


	@Override
	public int viewRefCountMail(Mail mail) {
		int refCount = mStore.updateRefCount(sqlSession, mail);
		return refCount;
	}

	@Override
	public int registerMailBmk(MailBmk mailBmk) {
		int result = mStore.insertBmk(sqlSession, mailBmk);
		return result;
	}

	//중요메일 등록
	@Override
	public int regiesteriMailRec(int values) {
		int mRecResult = mStore.insertiMailRec(values, sqlSession);
		return mRecResult;
	}

	@Override
	public int regiesteriMail(int values){
		int mResult = mStore.insertiMail(values, sqlSession);
		return mResult;
		
	}
	@Override
	public int regiesteriMailRef(int values) {
		int mRefResult = mStore.insertiMailRef(values, sqlSession);
		return mRefResult;
	}
	
	@Override
	public int registerAppMail(Mail mail) {
		int mResult = mStore.insertAppMail(mail, sqlSession);
		return mResult;
	}


	@Override
	public int registerAppMailRec(MailRec mailRec) {
		int mRecResult = mStore.insertAppMailRec(mailRec, sqlSession);
		return mRecResult;
	}


	@Override
	public int registerAppMailRef(MailRef mailRef) {
		int mRefResult = mStore.insertAppMailRef(mailRef, sqlSession);
		return mRefResult;
	}


	@Override
	public int registerAppMailFile(MailFile mailFile) {
		int mFileResult = mStore.insertAppMailFile(mailFile, sqlSession);
		return mFileResult;
	}


	@Override
	public List<Mail> printAppMail(Mail mail, PageInfo pi) {
		List<Mail> aList = mStore.selectAppMail(mail, sqlSession);
		return aList;
	}


	@Override
	public List<Mail> printSearchTemMail(Search search, PageInfo pi) {
		List<Mail> searchTemList = mStore.selectSearchTemMail(sqlSession, search, pi);
		return searchTemList;
	}


	@Override
	public List<Mail> printSearchAppMail(Search search, PageInfo pi) {
		List<Mail> searchAppList = mStore.selectSearchAppMail(sqlSession, search, pi);
		return searchAppList;
	}


	@Override
	public int getSearchTemMailCount(Search search) {
		int totalTemCount = mStore.selectSearchListTemCount(sqlSession,search );
		return totalTemCount;
	}


	@Override
	public int getSearchAppMailCount(Search search) {
		int totalAppCount = mStore.selectSearchListAppCount(sqlSession,search );
		return totalAppCount;
	}


	@Override
	public Mail printOneAppMail(int mailNo) {
		Mail mail = mStore.selectOneAppMail(sqlSession, mailNo);
		return mail;
	}


	@Override
	public List<MailRec> printOneAppMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneAppMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneAppMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneAppMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneAppMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneAppMailFile(sqlSession, mailNo);
		return mailFile;
	}


	@Override
	public int getAppMailCount(Mail mail) {
		int totalAppCount = mStore.selectAppListCount(sqlSession, mail);
		return totalAppCount;
	}


	@Override
	public int getMailReadCount(Mail mail) {
		int readTypeNCount = mStore.selectReadListCount(sqlSession,mail);
		return readTypeNCount;
	}


	@Override
	public int getIMailCount(Mail mail) {
		int totalICount = mStore.selectIListCount(sqlSession, mail);
		return totalICount;
	}


	@Override
	public List<Mail> printIMail(Mail mail, PageInfo pi) {
		List<Mail> iList = mStore.selectIMail(sqlSession, mail, pi);
		return iList;
	}


	@Override
	public Mail printOneIMail(int mailNo) {
		Mail mail = mStore.selectOneIMail(sqlSession, mailNo);
		return mail;
	}


	@Override
	public List<MailRec> printOneIMailRec(int mailNo) {
		List<MailRec> mailRec = mStore.selectOneIMailRec(sqlSession, mailNo);
		return mailRec;
	}


	@Override
	public List<MailRef> printOneIMailRef(int mailNo) {
		List<MailRef> mailRef = mStore.selectOneIMailRef(sqlSession, mailNo);
		return mailRef;
	}


	@Override
	public List<MailFile> printOneIMailFile(int mailNo) {
		List<MailFile> mailFile = mStore.selectOneIMailFile(sqlSession, mailNo);
		return mailFile;
	}


	@Override
	public List<MailBmk> printBmk(MailBmk mailBmk) {
		List<MailBmk> bList = mStore.selectBmk(sqlSession, mailBmk);
		return bList;
	}


	@Override
	public int removeiMail(int values) {
		int result = mStore.deleteiMail(sqlSession, values);
		return result;
	}

	@Override
	public int removeiMailRec(int values) {
		int result = mStore.deleteiMailRec(sqlSession, values);
		return result;
	}


	@Override
	public int removeiMailRef(int values) {
		int result = mStore.deleteiMailRef(sqlSession, values);
		return result;
	}
	

	//모달 즐겨찾는 그룹 목록 
	@Override
	public List<MailBmk> printModalBmk(MailBmk mailBmk) {
		List<MailBmk> bList = mStore.selectModalBmk(sqlSession, mailBmk);
		return bList;
	}


	@Override
	public int getReceiverCount(Mail mail) {
		int cTotalCount = mStore.selectReceiverCount(sqlSession, mail);
		return cTotalCount;
	}
	@Override
	public int getRefereeCount(Mail mail) {
		int fTotalCount = mStore.selectRefereeCount(sqlSession, mail);
		return fTotalCount;
	}


	@Override
	public int deleteMailBmk(MailBmk mailBmk) {
		int result = mStore.deleteMailBmk(sqlSession, mailBmk);
		return result;
	}


	@Override
	public List<MailBmk> printBmkList(MailBmk mailBmk) {
		List<MailBmk> bmkList = mStore.selectBmkList(sqlSession, mailBmk);
		return bmkList;
	}


	@Override
	public int printMailNo(Mail mail) {
		int noResult = mStore.selectMailNo(sqlSession, mail);
		return noResult;
	}

	// 넥사크로 - 승인 메일 관리
	@Override
	public List<Mail> printAllAppMail() { // 전체 승인 메일 조회
		List<Mail> mList = mStore.selectListAppMail(sqlSession);
		return mList;
	}


	@Override
	public int printAppCount() { // 승인 대기 메일 개수
		int count = mStore.selectOneAppCount(sqlSession);
		return count;
	}


	@Override
	public List<Mail> printSearchAppMail(String searchValue) { // 승인 메일 검색
		List<Mail> mList = mStore.selectListSearchAppMail(sqlSession, searchValue);
		return mList;
	}


	@Override
	public int printAppAllCount() { // 전체 승인 메일 개수
		int allCount = mStore.selectOneAppAllCount(sqlSession);
		return allCount;
	}


	@Override
	public Mail adminPrintOneAppMail(int mailNo) { // 승인 메일 상세 조회
		Mail mail = mStore.selectOneAdminAppMail(sqlSession, mailNo);
		return mail;
	}


	@Override
	public List<Mail> printFilterAppMail(String aStatus) { // 승인 상태 필터 조회
		List<Mail> mList = mStore.selectListFilterAppMail(sqlSession, aStatus);
		return mList;
	}


	@Override
	public int deleteAppMail(String mailNo) { // 승인 메일 삭제
		int result = mStore.updateRStatusAppMail(sqlSession, mailNo);
		return result;
	}


	@Override
	public int modifyAppMailStatus(Mail mail) { // 승인 상태 변경
		int result = mStore.updateAStatusAppMail(sqlSession, mail);
		return result;
	}


	@Override
	public List<MailBmk> printOneMailBmk(MailBmk mailBmk) {
		List<MailBmk> bList = mStore.selectOneMailBmk(sqlSession, mailBmk);
		return bList;
	}	

	
}
