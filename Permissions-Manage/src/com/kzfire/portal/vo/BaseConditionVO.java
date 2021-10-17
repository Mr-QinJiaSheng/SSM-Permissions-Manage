/*
 * @(#) BaseConditionVO.java 2014-1-22 上午09:46:03
 *
 * Copyright 2014 Rockwell Automation, Inc. All rights reserved.
 * Rockwell Automation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */package com.kzfire.portal.vo;


public class BaseConditionVO 
{
	public final static int PAGE_SHOW_COUNT = 20;
	private int pageNum = 1;
	private int numPerPage = 0;
	private int totalCount = 0;
	
	/**
	 * 每页第一条记录创建时间
	 */
	private long pageFirstRecordID;
	
	/**
	 * 每页最后一条记录创建时间
	 */
	private long pageLastRecordID;
	
	/**
	 * 分页操作方向
	 * 取值分别有first,prev,next,last,""
	 */
	private String direction;
	
	private long key;
	
	public int getPageNum()
	{
		if(totalCount == 0)
		{
			pageNum = 0;
		}
		return pageNum;
	}
	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public int getNumPerPage()
	{
		return numPerPage > 0 ? numPerPage : PAGE_SHOW_COUNT;
	}
	public void setNumPerPage(int numPerPage)
	{
		this.numPerPage = numPerPage;
	}
	
	public int getOffset() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		long endIndex = (pageNum + 1)* this.getNumPerPage() ;
		if(endIndex <= getTotalCount())
		{
			return this.getNumPerPage();
		}
		else
		{
			return (int)(getTotalCount() - pageNum* this.getNumPerPage());
		}
	}
	
	
	@Override
	public String toString()
	{
		return "BaseConditionVO [numPerPage=" + numPerPage + ", pageFirstRecordID="
			+ pageFirstRecordID + ", pageLastRecordID=" + pageLastRecordID + ", pageNum=" + pageNum
			+ ", totalCount=" + totalCount  + ", direction="+ direction + ", offset=" + getOffset() + "]";
	}
	
	public long getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public long getPageFirstRecordID()
	{
		return pageFirstRecordID;
	}
	public void setPageFirstRecordID(long pageFirstRecordID)
	{
		this.pageFirstRecordID = pageFirstRecordID;
	}
	public long getPageLastRecordID()
	{
		return pageLastRecordID;
	}
	public void setPageLastRecordID(long pageLastRecordID)
	{
		this.pageLastRecordID = pageLastRecordID;
	}
	public String getDirection()
	{
		return direction;
	}
	public void setDirection(String direction)
	{
		this.direction = direction;
	}
	public long getKey()
	{
		return key;
	}
	public void setKey(long key)
	{
		this.key = key;
	}
	
	
}
