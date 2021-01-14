package com.br.gm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gm.model.Rota;
import com.br.gm.model.Stop;
import com.br.gm.repository.RotaRepository;
import com.br.gm.repository.StopRepository;
import com.br.gm.service.StopService;

@Service
public class StopServiceImpl implements StopService{

	@Autowired
	private StopRepository stopRepository;
	
	@Autowired
	private RotaRepository rotaRepository;
	
	@Override
	public List<Stop> obterTodos() {
		return this.stopRepository.findAll();
	}

	@Override
	public Stop obterPorId(String id) {
		return this.stopRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Ponto de parada inexistente!"));
	}

	@Override
	public Stop criarStop(Stop stop) {
		return this.stopRepository.save(stop);
	}

	@Override
	public Stop deletarStop(String idStop) {
		//buscando o stop
		Stop stop = this.obterPorId(idStop);		
		
		//buscar todas as rotas
		List<Rota> rotas = this.rotaRepository.findAll();
		for(Rota rota : rotas) {
			//nova lista de stop
			List<Stop> stops = new ArrayList<>();
			for(Stop stop2 : rota.getPlannedStops()) {
				if(!stop2.getStopKey().equals(idStop)) {
					stops.add(stop2);
				}
			}
			if(stops.isEmpty()) {
				this.rotaRepository.delete(rota);
			} else {
				rota.setPlannedStops(stops);
				this.rotaRepository.save(rota);
			}
			this.stopRepository.delete(stop);
		}
		return stop;
	}
}
