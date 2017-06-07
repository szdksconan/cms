package com.cms.iservice.manager.orderDic;


import com.cms.model.manager.OrderDicBean;
import com.cms.model.manager.Tree;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

import java.util.List;

public interface orderDicService {
	public OrderDicBean getInfo(OrderDicBean bean);
	
	public Grid dataGrid(OrderDicBean orderDicBean, PageFilter ph);

	public void add(OrderDicBean orderDicBean);

	public void delete(Long id);

	public OrderDicBean get(Long id);
	
	public void update(OrderDicBean orderDicBean);
	
	public List<OrderDicBean> treeGrid(Long pid);
	
	public List<Tree> allTree(boolean flag);
}
