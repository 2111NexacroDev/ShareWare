package org.kh.shareware.common;

public class PageInfo {
		// 페이지 네비를 만들기 위해 필요한 변수
		private int currentPage; 	// 현재 페이지
		private int boardLimit; 	// 한 페이지당 게시글 개수
		private int naviLimit; 		// 한 페이지당 pageNavi 개수
		private int startNavi; 		// pageNavi 시작값
		private int endNavi; 		// pageNavi 끝값
		private int totalCount; 	// 전체 게시글 개수
		private int maxPage; 		// 페이지의 마지막 번호
		
		public PageInfo() {}

		public PageInfo(int currentPage, int boardLimit, int naviLimit, int startNavi, int endNavi, int totalCount,
				int maxPage) {
			super();
			this.currentPage = currentPage;
			this.boardLimit = boardLimit;
			this.naviLimit = naviLimit;
			this.startNavi = startNavi;
			this.endNavi = endNavi;
			this.totalCount = totalCount;
			this.maxPage = maxPage;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getBoardLimit() {
			return boardLimit;
		}

		public void setBoardLimit(int boardLimit) {
			this.boardLimit = boardLimit;
		}

		public int getNaviLimit() {
			return naviLimit;
		}

		public void setNaviLimit(int naviLimit) {
			this.naviLimit = naviLimit;
		}

		public int getStartNavi() {
			return startNavi;
		}

		public void setStartNavi(int startNavi) {
			this.startNavi = startNavi;
		}

		public int getEndNavi() {
			return endNavi;
		}

		public void setEndNavi(int endNavi) {
			this.endNavi = endNavi;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getMaxPage() {
			return maxPage;
		}

		public void setMaxPage(int maxPage) {
			this.maxPage = maxPage;
		}

		@Override
		public String toString() {
			return "PageInfo [현재 페이지=" + currentPage + ", 게시글 개수=" + boardLimit + ", pageNvi 수=" + naviLimit
					+ ", 시작값=" + startNavi + ", 끝값=" + endNavi + ", 전체 게시글 개수=" + totalCount + ", 마지막 번호="
					+ maxPage + "]";
		}
		
}
