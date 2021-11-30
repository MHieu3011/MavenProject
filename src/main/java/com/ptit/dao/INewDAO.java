package com.ptit.dao;

import java.util.List;

import com.ptit.model.NewModel;
import com.ptit.paging.Pageble;

public interface INewDAO {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel newModel);

	void delete(Long id);

	List<NewModel> findAll(Pageble pageble);

	int getTotalItem();
}
