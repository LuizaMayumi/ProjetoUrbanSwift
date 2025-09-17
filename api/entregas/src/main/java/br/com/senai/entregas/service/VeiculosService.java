package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.repository.VeiculosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    private final VeiculosRepository veiculosRepository;

    public VeiculosService(VeiculosRepository veiculos) {
        veiculosRepository = veiculos;
    }

    public List<Veiculos> findAllVeiculos(){
        return veiculosRepository.findAll();
    }

    public Veiculos findVeiculosById(Integer id){
        return veiculosRepository.findById(id).orElse(null);
    }

    public Veiculos updateVeiculosById(Integer id, Veiculos veiculos){
        Veiculos newVeiculos = findVeiculosById(id);

        newVeiculos.setEntregadorId(veiculos.getEntregadorId());
        newVeiculos.setModelo(veiculos.getModelo());
        newVeiculos.setPlaca(veiculos.getPlaca());
        newVeiculos.setTipo(veiculos.getTipo());

        return veiculosRepository.save(newVeiculos);
    }

    public void deleteVeiculosById(Integer id){
        Veiculos veiculos = findVeiculosById(id);
        
        veiculosRepository.delete(veiculos);
    }
}
