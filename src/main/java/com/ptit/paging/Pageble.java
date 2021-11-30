package com.ptit.paging;

import com.ptit.sort.Sorter;

public interface Pageble {
	Integer getPage();

	Integer getOffset();

	Integer getLimit();

	Sorter getSorter();
}
