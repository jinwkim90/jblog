package com.bit2017.jblog.vo;

public class BlogVo {

	private String userId;
	private String title;
	private String logo;
	private String originalFileName;
	private String saveFileName;
	private Long catNo;
	private String catName;
	private String catDesc;
	private String pubDate;
	private Long postNo;
	private String postTitle;
	private String postContent;
	private String postPubDate;
	private int postMaxRownum;
	
	
	public int getPostMaxRownum() {
		return postMaxRownum;
	}
	public void setPostMaxRownum(int postMaxRownum) {
		this.postMaxRownum = postMaxRownum;
	}
	public String getPostPubDate() {
		return postPubDate;
	}
	public void setPostPubDate(String postPubDate) {
		this.postPubDate = postPubDate;
	}
	private int rownum;
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public Long getPostNo() {
		return postNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Long getCatNo() {
		return catNo;
	}
	public void setCatNo(Long catNo) {
		this.catNo = catNo;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	
	
	
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "BlogVo [userId=" + userId + ", title=" + title + ", logo=" + logo + ", originalFileName="
				+ originalFileName + ", saveFileName=" + saveFileName + ", catNo=" + catNo + ", catName=" + catName
				+ ", catDesc=" + catDesc + ", pubDate=" + pubDate + ", postNo=" + postNo + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + ", postPubDate=" + postPubDate + ", rownum=" + rownum + "]";
	}
	
}
