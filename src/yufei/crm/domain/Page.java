package yufei.crm.domain;

import java.util.List;

public class Page<T> {
	private Integer pageNum;
	private Integer everyNum;
	private Integer totalCount;
	private Integer maxPage;
	private List<T> list;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getEveryNum() {
		return everyNum;
	}
	public void setEveryNum(Integer everyNum) {
		this.everyNum = everyNum;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", everyNum=" + everyNum + ", totalCount=" + totalCount + ", maxPage="
				+ maxPage + ", list=" + list + ", getPageNum()=" + getPageNum() + ", getEveryNum()=" + getEveryNum()
				+ ", getTotalCount()=" + getTotalCount() + ", getMaxPage()=" + getMaxPage() + ", getList()=" + getList()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
