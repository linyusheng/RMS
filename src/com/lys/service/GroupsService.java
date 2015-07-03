package com.lys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.dao.GroupsDAO;
import com.lys.entity.Groups;

@Service
public class GroupsService implements BaseService<Groups, Groups>{

	@Autowired
	private GroupsDAO groupsDAO;

	@Override
	public Groups get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Groups o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Groups o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Groups> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Groups copyObject(Groups o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> copyList(List<Groups> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
