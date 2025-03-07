package com.book.DAO;

import java.util.List;

import com.book.model.Genres;

public interface GenresDAO {

	void addGenres(Genres genres);
	Genres getGenres(int genresid);
	void updateGenres(Genres genres);
	void deleteGenres(int genresid);
	List<Genres>getAllGenres();
	
	
	
}
