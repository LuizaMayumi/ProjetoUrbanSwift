package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuario) {
        usuarioRepository = usuario;
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario usuario, Integer id){
        Usuario user = getUsuarioById(id);

        if (user == null){
            return null;
        }

        user.setEmail(usuario.getEmail());
        user.setSenha(usuario.getSenha());
        user.setTipoUsuario(usuario.getTipoUsuario());
        user.setNomeCompleto(usuario.getNomeCompleto());

        return usuarioRepository.save(user);
    }

    public void deleteUsuario(Integer id){
        Usuario user = getUsuarioById(id);

        if (user == null) {
            return;
        }

        usuarioRepository.delete(user);
    }

}
