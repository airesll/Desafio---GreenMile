package com.br.gm.service;

import java.util.List;

import com.br.gm.model.Rota;

public interface RotaService {
	public List<Rota> obterTodas();
	public Rota obterPorId(String idRota);
	public Rota criarRota(Rota rota);
	public Rota excluirRota(String idRota);
	public Rota concluirRota(String idRota);
}
