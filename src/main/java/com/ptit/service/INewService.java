package com.ptit.service;

import java.util.List;

import com.ptit.model.NewModel;

public interface INewService {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryId(Long categoryId);

	NewModel save(NewModel newModel);

	NewModel update(NewModel newModel);

	void delete(long[] ids);
}
