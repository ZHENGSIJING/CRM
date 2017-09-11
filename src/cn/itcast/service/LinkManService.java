package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;
import cn.itcast.utils.PageBean;

public interface LinkManService {
	

	void save(LinkMan linkman);
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//根据id获得LinkMan对象
	LinkMan getById(Long lkm_id);

}
