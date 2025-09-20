package br.com.senai.entregas.repository;

import br.com.senai.entregas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

//    Criando metodo para buscar usuario pelo email
    Optional<Usuario> findByEmail(String email);

}
