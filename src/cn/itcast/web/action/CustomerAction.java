package cn.itcast.web.action;



import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.User;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private CustomerService customerService;
	private Customer customer= new Customer();
	private Integer currentPage;
	private Integer pageSize;
	
	private File photo;
	private String photoFileName;
	private String photoContentType;

	public String list() throws Exception {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		PageBean pb = customerService.getPageBean(dc,currentPage,pageSize);

		ActionContext.getContext().put("pageBean", pb);
		
		return "list";
	}




	public String add() throws Exception {
		if(photo!=null){
		System.out.println("文件名称:"+photoFileName);
		System.out.println("文件类型:"+photoContentType);
		//将上传文件保存到指定位置
		photo.renameTo(new File("E:/upload/haha.jpg"));
		}
		customerService.save(customer);
		return "toList";
	}

	public String toEdit() throws Exception{
		Customer c=customerService.getById(customer.getCust_id());
		
		ActionContext.getContext().put("customer", c);
		
		return "edit";
		
	}
	
	public String industryCount() throws Exception {
		
		List<Object[]> list = customerService.getIndustryCount();
		
		ActionContext.getContext().put("list", list);
		
		return "industryCount";
		
		}

	@Override
	public Customer getModel() {
		
		return customer;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	
	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}




	public File getPhoto() {
		return photo;
	}




	public void setPhoto(File photo) {
		this.photo = photo;
	}




	public String getPhotoFileName() {
		return photoFileName;
	}




	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}




	public String getPhotoContentType() {
		return photoContentType;
	}




	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	
}
