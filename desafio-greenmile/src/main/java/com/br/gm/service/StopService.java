package com.br.gm.service;

import java.util.List;

import com.br.gm.model.Stop;

public interface StopService {
	public List<Stop> obterTodos();
	public Stop obterPorId(String idStop);
	public Stop criarStop(Stop stop);
	public Stop deletarStop(String idStop);
}
