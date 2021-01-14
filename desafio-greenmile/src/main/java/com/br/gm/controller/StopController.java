package com.br.gm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gm.model.Stop;
import com.br.gm.service.StopService;

@RestController
@RequestMapping("/stops")
public class StopController {

	@Autowired
	private StopService stopService;
	
	@DeleteMapping("/excluir/{id}")
	public Stop deleteStop(@PathVariable String id){
		return this.stopService.deletarStop(id);
	}
}
