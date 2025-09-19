package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Entregas;
import br.com.senai.entregas.repository.EntregasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregasService {
    private final EntregasRepository entregasRepository;

    public EntregasService(EntregasRepository entregas) {
        entregasRepository = entregas;
    }

    public List<Entregas> getAllEntregas() {
        return entregasRepository.findAll();
    }

    public Entregas getEntregasById(Integer id) {
        return entregasRepository.findById(id).orElse(null);
    }

    public Entregas createEntregas(Entregas entregas) {
        verificaStatus(entregas.getStatus());
        return entregasRepository.save(entregas);
    }

    public Entregas updateEntregas(Entregas entregas, Integer id) {
        verificaStatus(entregas.getStatus());

        Entregas ent = getEntregasById(id);

        if (ent == null) {
            return null;
        }

        ent.setEndereco(entregas.getEndereco());
        ent.setDataPedido(entregas.getDataPedido());
        ent.setStatus(entregas.getStatus());
        ent.setDescricaoProduto(entregas.getDescricaoProduto());
        ent.setUsuario(entregas.getUsuario());

        return entregasRepository.save(entregas);
    }

    public Entregas deleteEntregas(Integer id) {
        Entregas ent = getEntregasById(id);

        if (ent == null) {
            return null;
        }
         entregasRepository.delete(ent);

        return ent;
    }

    public String verificaStatus(String status){
            status = status.toLowerCase();

        if(!status.equals("pendente") || !status.equals("em rota") || !status.equals("entregue")){
            return "Status deve ser Pendente, Em Rota ou Entregue";
        }
        return null;
    }

}
