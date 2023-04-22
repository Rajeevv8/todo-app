package com.app.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.model.Model;

@Repository
public interface TodoDAO extends JpaRepository<Model, Integer>{
	public Boolean existsByEntryNumber(Integer entryNumber);
	public Model findByEntryNumber(Integer entryNumber);
}
