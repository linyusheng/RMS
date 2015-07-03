package com.lys.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.dao.RightsDAO;
import com.lys.entity.Rights;
import com.lys.model.DataGrid;
import com.lys.model.MRights;
import com.lys.model.Page;
import com.lys.util.Tool;

@Service
public class RightsService implements BaseService<Rights,MRights>{
	
	@Autowired
	private RightsDAO rightsDAO;
	
	@Override
	public Rights get(Integer id) {
		return rightsDAO.get(Rights.class, id);
	}
	@Override
	public Serializable save(Rights o) {
		return rightsDAO.save(o);
	}
	@Override
	public void update(Rights o) {
		rightsDAO.update(o);
	}
	@Override
	public void delete(Integer id) {
		rightsDAO.delete(get(id));
	}
	@Override
	public List<Rights> findAll() {
		return rightsDAO.find("from Rights");
	}
	@Override
	public MRights copyObject(Rights o) {
		MRights m = new MRights();
		String[] ignoreProperties = {"createTime"};
		BeanUtils.copyProperties(o, m,ignoreProperties);
		m.setCreateTime(Tool.timestampToString(o.getCreateTime()));
		return m;
	}
	@Override
	public List<MRights> copyList(List<Rights> list) {
		List<MRights> mList = new ArrayList<MRights>();
		for (Rights rights : list) {
			mList.add(copyObject(rights));
		}
		return mList;
	}
	/**
	 * 获取权限列表
	 * @param page
	 * @return 
	 */
	public DataGrid dataGrid(Page page) {
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from Rights order by "+page.getSort()+" "+page.getOrder();
		List<Rights> list =rightsDAO.find(hql, params, page.getPage(), page.getRows());
		dg.setRows(copyList(list));
		dg.setTotal(rightsDAO.count("select count(*) from Rights", params));
		return dg;
	}
	

}
