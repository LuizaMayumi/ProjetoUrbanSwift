package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Enderecos;
import br.com.senai.entregas.repository.EnderecosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecosService {
    private final EnderecosRepository enderecosRepository;

    public EnderecosService(EnderecosRepository enderecos) {
        enderecosRepository = enderecos;
    }

    public List<Enderecos> getAllEnderecos() {
        return enderecosRepository.findAll();
    }

    public Enderecos cadastraEnderecos(Enderecos enderecos) {
        return enderecosRepository.save(enderecos);
    }

    public Enderecos getByIdEnderecos(Integer id) {
        return enderecosRepository.findById(id).orElse(null);
    }

    public Enderecos editaEnderecos(Enderecos enderecos, Integer id) {
        Enderecos endereco = getByIdEnderecos(id);

        if (endereco == null) {
            return null;
        }
        endereco.setCidade(enderecos.getCidade());
        endereco.setLogradouro(enderecos.getLogradouro());
        endereco.setNumero(enderecos.getNumero());
        endereco.setCep(enderecos.getCep());
        endereco.setUsuario(enderecos.getUsuario());

        return enderecosRepository.save(endereco);
    }

    public Enderecos deletaEnderecos(Integer id) {
        Enderecos endereco = getByIdEnderecos(id);

        if (endereco == null) {
            return null;
        }

        enderecosRepository.delete(endereco);

        return endereco;
    }
}
