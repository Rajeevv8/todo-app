package com.app.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todo.dao.TodoDAO;
import com.app.todo.dto.ModelDTO;
import com.app.todo.model.Model;

@Service
public class ServiceImpl implements TodoService {

	@Autowired
	private TodoDAO dao;

	public ModelDTO createTask(ModelDTO dto) {
		Model model = new Model(dto.getCompletionDate(), dto.getTitle(), dto.getCompletionStatus());
		Model entity = dao.save(model);
		dto.setEntryNumber(model.getEntryNumber());
		return entity.getTitle().equals(dto.getTitle()) ? dto : null;
	}

	public Boolean updateTask(Integer entryNumber,ModelDTO dto) {

		Model entity = dao.findById(entryNumber).get();

		entity.setCompletionStatus(dto.getCompletionStatus());
		entity.setCreationDate(dto.getCompletionDate());
		entity.setTitle(dto.getTitle());

		return dao.save(entity).getTitle().equals(dto.getTitle());

	}
	
	public Boolean deleteTask(Integer entryNumber) {
		
		if(dao.findById(entryNumber).get()!=null) {
			dao.deleteById(entryNumber);
			return true;
		}
		return false;
	}
	public List<ModelDTO> getTask(){
		
		List<Model> modelList = dao.findAll();
		List<ModelDTO> list = new ArrayList<ModelDTO>();
		if(modelList.size()>0) {
			for (Model model: modelList) {
				ModelDTO dto = new ModelDTO();
				dto.setCompletionStatus(model.getCompletionStatus());
				dto.setCompletionDate(model.getCreationDate());
				dto.setTitle(model.getTitle());
				dto.setEntryNumber(model.getEntryNumber());
				list.add(dto);
			}
			return list;
		}
		return null;
	}
	public ModelDTO getTaskByEntryNumber(Integer entryNumber) {
		
		Model model= dao.findById(entryNumber).get();
		ModelDTO dto = new ModelDTO();
		dto.setCompletionStatus(model.getCompletionStatus());
		dto.setCompletionDate(model.getCreationDate());
		dto.setTitle(model.getTitle());
		dto.setEntryNumber(model.getEntryNumber());
		
		return dto;
		 
	}

}
