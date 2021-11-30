package com.ptit.service;

import java.util.List;

import com.ptit.model.NewModel;
import com.ptit.paging.Pageble;

public interface INewService {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryId(Long categoryId);

	NewModel save(NewModel newModel);

	NewModel update(NewModel newModel);

	void delete(long[] ids);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
