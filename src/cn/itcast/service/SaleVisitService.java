package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.SaleVisit;
import cn.itcast.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	SaleVisit getById(Integer visit_id);

}
