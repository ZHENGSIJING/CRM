package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.SaleVisitDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao svd;
	
	@Override
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);

	}
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		Integer totalCount = svd.getTotalCount(dc);
		
		PageBean pb=new PageBean(currentPage, totalCount, pageSize);
		
		List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		
		pb.setList(list);
		return pb;
	}

	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	@Override
	public SaleVisit getById(Integer visit_id) {
		return svd.getById(visit_id);
	}

}
