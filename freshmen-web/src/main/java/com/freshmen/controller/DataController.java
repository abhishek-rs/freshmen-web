package com.freshmen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freshmen.model.Person;

@RestController
public class DataController {
	public static List<Person> staticList = new ArrayList<Person>();

	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public List<Person> listAll() {
		return staticList;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Boolean save(@RequestBody Person jsonString) throws Exception {
		Person model = new Person();
		model.setName(jsonString.getName());
		model.setOccupation(jsonString.getOccupation());
		model.setIndex(staticList.size());
		staticList.add(model);
		return true;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Boolean update(@RequestBody Person jsonString) throws Exception {
		staticList.get(jsonString.getIndex()).setName(jsonString.getName());
		staticList.get(jsonString.getIndex()).setOccupation(jsonString.getOccupation());
		return true;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Boolean delete(@RequestBody Person jsonString) throws Exception {
		staticList.remove(jsonString.getIndex());
		return true;
	}
}
