package com.app.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.dto.ModelDTO;
import com.app.todo.service.ServiceImpl;

@CrossOrigin
@RestController
public class TodoController {
	@Autowired
	private ServiceImpl service;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ModelDTO createTask(@RequestBody ModelDTO requestDto) {
		return service.createTask(requestDto);
	}

	@RequestMapping(path = "/update/{entryNumber}", method = RequestMethod.PUT)
	public Boolean updateTask(@PathVariable Integer entryNumber, @RequestBody ModelDTO requestDTO) {
		return service.updateTask(entryNumber, requestDTO);
	}

	@RequestMapping(path = "/delete/{entryNumber}", method = RequestMethod.DELETE)
	public Boolean deleteTask(@PathVariable Integer entryNumber) {
		return service.deleteTask(entryNumber);
	}

	@RequestMapping(path = "/retrieve", method = RequestMethod.GET)
	public List<ModelDTO> getTask() {
		return service.getTask();
	}

	@RequestMapping(path = "/getTaskByEntryNumber/{entryNumber}", method = RequestMethod.GET)
	public ModelDTO getTaskByEntryNumber(@PathVariable Integer entryNumber) {
		return service.getTaskByEntryNumber(entryNumber);
	}

}
