package com.ptit.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.ptit.dao.ICategoryDAO;
import com.ptit.dao.INewDAO;
import com.ptit.model.NewModel;
import com.ptit.paging.Pageble;
import com.ptit.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;

	@Inject
	ICategoryDAO categoryDAO;

	@Override
	public NewModel findOne(Long id) {
		NewModel newModel = newDAO.findOne(id);
		newModel.setCategoryCode(categoryDAO.findOne(newModel.getCategoryId()).getCode());
		return newModel;
	}

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		//newModel.setCreatedBy("");
		newModel.setCategoryId(categoryDAO.findOneByCode(newModel.getCategoryCode()).getId());
		Long id = newDAO.save(newModel);
		return newDAO.findOne(id);
	}

	@Override
	public NewModel update(NewModel newModel) {
		Long id = newModel.getId();
		NewModel model = newDAO.findOne(id);
		newModel.setCreatedDate(model.getCreatedDate());
		newModel.setCreatedBy(model.getCreatedBy());
		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		//newModel.setModifiBy("");
		newModel.setCategoryId(categoryDAO.findOneByCode(newModel.getCategoryCode()).getId());
		newDAO.update(newModel);
		return newDAO.findOne(id);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDAO.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}

}
