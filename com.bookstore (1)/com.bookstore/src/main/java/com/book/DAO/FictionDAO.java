package com.book.DAO;

import java.util.List;

import com.book.model.Fiction;

public interface FictionDAO {
	
		void addfictionn(Fiction fiction);
		Fiction getFiction(int fictionid);
		void updateFiction(Fiction fiction);
		void deleteFiction(int fictionid);
		List<Fiction>getALLFictions();
}
