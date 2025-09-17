package br.com.senai.entregas.service;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService (TipoUsuarioRepository tipoUsuario) {
        tipoUsuarioRepository = tipoUsuario;
    }


    public List<TipoUsuario> getAllTipoUsuario(){
        return  tipoUsuarioRepository.findAll();
    }

    public TipoUsuario getByIdTipoUsuario(Integer id){
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario, Integer id){
        TipoUsuario tipo = getByIdTipoUsuario(id);

        if(tipo == null){
            return null;
        }

        tipo.setDescricao(tipoUsuario.getDescricao());

        return  tipoUsuarioRepository.save(tipo);
    }

    public TipoUsuario deleteTipoUsuario(Integer id){
        TipoUsuario tipo = getByIdTipoUsuario(id);

        if (tipo == null){
            return null;
        }

        tipoUsuarioRepository.delete(tipo);
        return tipo;
    }


}
