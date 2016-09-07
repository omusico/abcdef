package com.lvmama.vst.search.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 分页实体类
 * @author zhuchao
 * @param <T>
 */
public  class PageConfigVo<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8077287002435877146L;
	private static final int DEFAULT_PAGE_SIZE = 10;
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	/**
	 * 每页数
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	/**
	 * 记录总数
	 */
	private int totalResultSize = 0;
	/**
	 * 当前页的结束行行数
	 */
	private int currentRowNum = 0;
	/**
	 * 结果集
	 */
	private List<T> allItems = new ArrayList<T>();
	/**
	 * 结果集
	 */
	private List<T> items;
	/**
	 * 总页数
	 */
	private int totalPageNum;
	
	private String url;
	
	private List<T> recommenditems;
	
//	public boolean hasPrev() {
//		return currentPage > 1;
//	}
//	
//	public boolean hasNext() {
//		return currentPage < totalPageNum;
//	}

	
	public PageConfigVo(int totalResultSize)
	{
		this.totalResultSize = totalResultSize;
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.currentPage = 1;
	}
	public PageConfigVo(int pageSize,int currentPage)
	{
		if(pageSize<1)
			this.pageSize = DEFAULT_PAGE_SIZE;
		else
			this.pageSize = pageSize;
		this.currentPage = currentPage;
	}	
	public PageConfigVo(int totalResultSize,int pageSize,int currentPage)
	{
		init(totalResultSize, pageSize, currentPage);
	}
	/**
	 * 初始化分页对象
	 * @param totalResultSize
	 * @param pageSize
	 * @param currentPage
	 */
	private void init(int totalResultSize, int pageSize, int currentPage) {
		this.totalResultSize = totalResultSize;
		this.pageSize = pageSize;
		if(currentPage<1) 
			this.currentPage = 1;
		else if(currentPage > this.getTotalPages()) 
			this.currentPage = this.getTotalPages();
		else 
			this.currentPage = currentPage;
		totalPageNum = getTotalPages();
	}
	
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		if(currentPage<1) this.currentPage = 1;
		else if(currentPage > this.getTotalPages()) this.currentPage = this.getTotalPages();
		else this.currentPage = currentPage;
	}
	
	public void setTotalResultSize(int totalResultSize)
	{
		this.totalResultSize = totalResultSize;
		this.init(this.totalResultSize, this.pageSize, this.currentPage);
	}	
	
	/**
	 * 当前页的第一条行数，第一页第一条为0开始
	 * @return
	 */
	public int getStartResult()
	{
		return (int)(currentPage - 1)* pageSize;
	}
	
	public int getTotalPages()
	{
		if(this.totalResultSize%this.pageSize > 0) return (int)this.totalResultSize/this.pageSize + 1;
		else return (int)this.totalResultSize/this.pageSize;
	}
	
	public static PageConfigVo top(int totalResultSize,int currentPage)
	{
		PageConfigVo pageConfig = new PageConfigVo(totalResultSize,DEFAULT_PAGE_SIZE,currentPage);
		return pageConfig;
	}
	
	/**
	 * 设置PageConfig
	 * @param totalResultSize 记录总数
	 * @param pageSize 每页数
	 * @param currentPage 当前页
	 * @return
	 */
	public static PageConfigVo page(int totalResultSize,int pageSize,int currentPage)
	{
		return new PageConfigVo(totalResultSize,pageSize,currentPage);
	}
	
	public static PageConfigVo page(int pageSize,int currentPage)
	{
		return new PageConfigVo(pageSize,currentPage);
	}
	/**
	 * 重置记录数量总数
	 * @param page 每页数
	 * @param totalResultSize 当前页
	 * @return
	 */
	public void resetTotalResultSize(PageConfigVo<T> pageConfig,int totalResultSize)
	{
		if(totalResultSize<=0)
			return;
		pageConfig.setTotalResultSize(totalResultSize);
		int totoalNumCount = getTotalPages();
		pageConfig.setTotalPageNum(totoalNumCount);
		if(this.currentPage<1) this.currentPage = 1;
		else if(this.currentPage > totoalNumCount) this.currentPage = totoalNumCount;
	}
	/**
	 * 当前页的结束行
	 * @return
	 */
	public int getCurrentRowNum() {
		int num = 0;
		if(this.currentPage==this.totalPageNum){
			num = this.getTotalResultSize();
		}else {
			num = this.getStartResult()+this.getPageSize();
		}
		return num;
	}
	
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public void setCurrentRowNum(int currentRowNum) {
		this.currentRowNum = currentRowNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 每页数显示数量，默认10
	 * @return
	 */
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getTotalResultSize()
	{
		return totalResultSize;
	}
	public void initItems(){
		this.getItems();
		this.allItems = null;
	}
	public List<T> getItems()
	{
		if(items == null){
			items = new ArrayList<T>();
				if(allItems.size()>0){
				int i = this.getStartResult();
				int end = this.getCurrentRowNum();
				for (; i < end; i++) {
					items.add(this.allItems.get(i));
				}
			}
		}
		return items;
	}

	public void setItems(List<T> items)
	{
		this.items = items;
	}
	public List<T> getAllItems() {
		return allItems;
	}
	public void setAllItems(List<T> allItems) {
		this.allItems = allItems;
	}
	public List<T> getRecommenditems() {
		return recommenditems;
	}
	public void setRecommenditems(List<T> recommenditems) {
		this.recommenditems = recommenditems;
	}
	
}
