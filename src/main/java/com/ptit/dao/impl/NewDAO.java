package com.ptit.dao.impl;

import java.util.List;

import com.ptit.dao.INewDAO;
import com.ptit.mapper.impl.CategoryMapper;
import com.ptit.mapper.impl.NewMapper;
import com.ptit.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM new WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM new WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT into new(title, thumbnail, shortdescription, ");
		sql.append("content, categoryid, createddate, createdby) values(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getShortdescription(),
				newModel.getContent(), newModel.getCategoryId(), newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public void update(NewModel newModel) {
		StringBuilder sql = new StringBuilder("UPDATE new SET title = ?, thumbnail = ?, ");
		sql.append("shortdescription = ?, content = ?, categoryid = ?, createddate = ?, ");
		sql.append("createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getShortdescription(),
				newModel.getContent(), newModel.getCategoryId(), newModel.getCreatedDate(), newModel.getCreatedBy(),
				newModel.getModifiedDate(), newModel.getModifiBy(), newModel.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM new WHERE id = ?";
		update(sql, id);
	}

}
