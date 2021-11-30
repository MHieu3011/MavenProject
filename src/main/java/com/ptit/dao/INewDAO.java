package com.ptit.dao;

import java.util.List;

import com.ptit.model.NewModel;

public interface INewDAO {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel newModel);

	void delete(Long id);
}
