package edson.utils;

import java.util.List;
//分页实体
public class PageBean <T>{
	
	private int currentPage;//当前页面
	private int totalPage;//总页数
	private int totalRecord;//总记录数
	private List<T> pageData;//需查询的数据
	private String path;//记住分页提交的路径
	
	
	
	public PageBean(Integer currentPage,
			Integer totalRecord, List<T> pageData) {
		super();
		this.currentPage = currentPage;
		this.totalPage = (int) Math.ceil(totalRecord/6.0);//每页显示6条记录
		this.totalRecord = totalRecord;
		this.pageData = pageData;
		
	}
	
	
	
	public final Integer getCurrentPage() {
		return currentPage;
	}
	public final void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public final Integer getTotalPage() {
		return totalPage;
	}
	public final void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public final Integer getTotalRecord() {
		return totalRecord;
	}
	public final void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public final List<T> getPageData() {
		return pageData;
	}
	public final void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public final String getPath() {
		return path;
	}



	public final void setPath(String path) {
		this.path = path;
	}
	
	
	

}
