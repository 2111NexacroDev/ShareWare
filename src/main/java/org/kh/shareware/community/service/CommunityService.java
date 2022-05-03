package org.kh.shareware.community.service;

import java.util.List;
import java.util.Map;

import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;

public interface CommunityService {

	int resisterCommunity(Community community);
	int searchComNo();
	List<Community> listCommunity();
	Community detailCommunity(Integer comNo);
	int removeCommunity(int comNo);
	int viewCountCommunity(Integer comNo);
	
	
	
	
	
	int registerCommunityVote(CommunityVote communityVote);
	int removeCommunityVote(Integer comNo);
	CommunityVote detailCommunityVote(Integer comNo);
	CommunityVoteSelect viewCommunityVote(Integer comNo);
	int endCommunityVote(Integer comNo);
	int registerCVoteSelect(CommunityVoteSelect cVoteSelect);
	int countCVoteSelect(Map<String, Object> map);
	int removeCVoteMember(Integer comNo);
	int modifyCommunity(Community community);
	void modifyCommunityVote(CommunityVote communityVote);
	
	
	

}
