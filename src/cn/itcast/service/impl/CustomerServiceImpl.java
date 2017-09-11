package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd;

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		Integer totalCount = cd.getTotalCount(dc);
		
		PageBean pb=new PageBean(currentPage, totalCount, pageSize);
		
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		
		pb.setList(list);
		return pb;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public void save(Customer customer) {
		cd.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getById(Long cust_id) {
	
		return cd.getById(cust_id);
	}

	@Override
	public List<Object[]> getIndustryCount() {
		
		return cd.getIndustryCount();
	}
	
	

}
