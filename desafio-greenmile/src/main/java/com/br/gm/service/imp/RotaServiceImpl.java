package com.br.gm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gm.model.Rota;
import com.br.gm.model.Stop;
import com.br.gm.repository.RotaRepository;
import com.br.gm.repository.StopRepository;
import com.br.gm.service.RotaService;

@Service
public class RotaServiceImpl implements RotaService {

	@Autowired
	private RotaRepository rotaRepository;
	
	@Autowired
	private StopRepository stopRepository;
	
	
	@Override
	public List<Rota> obterTodas() {
		return this.rotaRepository.findAll();
	}

	@Override
	public Rota obterPorId(String id) {
		return this.rotaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Rota inexistente!"));
	}

	@Override
	public Rota criarRota(Rota rota) {
		//lista de stops da rota
		List<Stop> stops = rota.getPlannedStops();
		
		//lista de stops a ser salva
		List<Stop> plannedStops = new ArrayList<>();
		
		for (Stop stop : stops) {
			//verificar se o stop ja está persistido no banco
			Stop stopSaves = stopRepository.findByDescription(stop.getDescription());
			if(stopSaves == null) {
				plannedStops.add(stop);
				this.stopRepository.save(stop);
			} else {
				plannedStops.add(stopSaves);
			}
		}
		rota.setPlannedStops(plannedStops);
		rota.setStatus("Pendente");
		return this.rotaRepository.save(rota);
	}

	@Override
	public Rota excluirRota(String idRota) {
		Rota rota = this.obterPorId(idRota);
		List<Stop> stops = stopRepository.findAll();
		for (Stop stop : rota.getPlannedStops()) {
			for(Stop stop2 : stops) {
				if(stop.getStopKey().equals(stop2.getStopKey())) {
					this.stopRepository.deleteById(stop2.getStopKey());
				}
			}
		}
		this.rotaRepository.deleteById(idRota);
		return rota;
	}

	@Override
	public Rota concluirRota(String idRota) {
		Rota rota  = this.obterPorId(idRota);
		rota.setStatus("Conluida");
		this.rotaRepository.save(rota);
		return rota;
	}

}
