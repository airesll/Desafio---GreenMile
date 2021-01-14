package com.br.gm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gm.model.Rota;
import com.br.gm.service.RotaService;

@RestController
@RequestMapping("/rotas")
public class RotasController {
	
	@Autowired
	private RotaService rotaService;
	
	@GetMapping
	public List<Rota> obterTodas() {
		return this.rotaService.obterTodas();
	}
	
	@GetMapping("/{routerKey}")
	public Rota obterPorId(@PathVariable String routerKey) {
		return this.rotaService.obterPorId(routerKey);
	}
	
	@PostMapping
	public Rota criarRota(@RequestBody Rota rota) {
		return this.rotaService.criarRota(rota);
	}
	
	@DeleteMapping("/excluir/{id}")
	public Rota deleteRota(@PathVariable String id){
		return this.rotaService.excluirRota(id);
	}
	
	@PutMapping("/concluir/{id}")
	public Rota concluirRota(@PathVariable String id) {
		return this.rotaService.concluirRota(id);
	}
}
