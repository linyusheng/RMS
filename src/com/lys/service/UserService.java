package com.lys.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.model.DataGrid;
import com.lys.model.MUser;
import com.lys.model.Page;
import com.lys.util.PageBean;
import com.lys.util.PageBean;
import com.lys.util.Tool;
import com.lys.dao.UserDAO;
import com.lys.entity.User;

/**
 * 用户业务处理类
 * 
 * @author 林玉生
 * 
 * @since 2014-08-27
 * 
 * @version 1.0
 *
 */
@Service
public class UserService implements BaseService<User,MUser> {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User get(Integer id) {
		return userDAO.get(User.class, id);
	}
	@Override
	public Serializable save(User o) {
		return userDAO.save(o);
	}
	@Override
	public void update(User o) {
		userDAO.update(o);
	}
	@Override
	public void delete(Integer id) {
		userDAO.delete(get(id));
	}
	@Override
	public List<User> findAll() {
		return userDAO.find("from User"); 
	}
	@Override
	public MUser copyObject(User o) {
		MUser m = new MUser();
		String[] ignores = {"createTime","loginTime","lastLoginTime"};
		BeanUtils.copyProperties(o, m, ignores);
		m.setCreateTime(Tool.timestampToString(o.getCreateTime()));
		m.setLoginTime(Tool.timestampToString(o.getLoginTime()));
		m.setLastLoginTime(Tool.timestampToString(o.getLastLoginTime()));
		return m;
	}
	@Override
	public List<MUser> copyList(List<User> list){
		List<MUser> mList = new ArrayList<MUser>();
		for (User user : list) {
			mList.add(copyObject(user));
		}
		return mList;
	}
	/**
	 * 修改用户密码
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public boolean savePassword(Integer userId,String oldPassword,String newPassword){
		User user = get(userId);
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			update(user);
			return true;
		}
		return false;
	}
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public User get(String userName){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		String hql ="from User where userName= :userName";
		return userDAO.get(hql, params);
	}
	/**
	 * 根据用户名和密码查找用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public User get(String userName,String password){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("password", password);
		String hql ="from User where userName=:userName and password=:password";
		return userDAO.get(hql, params);
	}
	
	/**
	 * 获取指定用户信息
	 */
	public List<User> find(Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sort", page.getSort());
		params.put("order", page.getOrder());
		String hql = "from User order by :sort :order";
		return userDAO.find(hql, params, page.getPage(), page.getRows());
	}
	/**
	 * 根据用户名执行模糊匹配查找，执行分页查找
	 * @param q
	 * @param page
	 * @return
	 */
	public List<User> find(String q) {
		q = (q == null ? "" : q);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("q", "%%" + q.trim() + "%%");
		String hql = "from User where userName like :q";
		return userDAO.find(hql, params, 1, 10);
	}
	/**
	 * 查找所有用户，执行分页查找,按字段排序
	 * @param page
	 * @return
	 */
	public DataGrid dataGrid(Page page) {
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from User order by "+page.getSort()+" "+page.getOrder();
		List<User> list =userDAO.find(hql, params, page.getPage(), page.getRows());
		dg.setRows(copyList(list));
		dg.setTotal(userDAO.count("select count(*) from User", params));
		return dg;
	}
	/**
	 * 根据用户名执行模糊匹配查找，执行分页查找,按字段排序
	 * @param q
	 * @param page
	 * @return
	 */
	public DataGrid dataGrid(String q,Page page) {
		q = (q == null ? "" : q);
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("q", "%%" + q.trim() + "%%");
		String hql = "from User where userName like :q order by "+page.getSort()+" "+page.getOrder();
		List<User> list =userDAO.find(hql, params, page.getPage(), page.getRows());
		dg.setRows(copyList(list));
		dg.setTotal(userDAO.count("select count(*) from User where userName like :q", params));
		return dg;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
