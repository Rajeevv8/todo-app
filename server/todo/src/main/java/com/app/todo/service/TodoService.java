package com.app.todo.service;

import java.util.List;

import com.app.todo.dto.ModelDTO;


public interface TodoService {
	public ModelDTO createTask(ModelDTO dto);
	public Boolean updateTask(Integer entryNumber,ModelDTO dto);
	public Boolean deleteTask(Integer entryNumber);
	public List<ModelDTO> getTask();
	public ModelDTO getTaskByEntryNumber(Integer entryNumber);
}
