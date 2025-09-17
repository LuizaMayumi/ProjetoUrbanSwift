package br.com.senai.entregas.repository;

import br.com.senai.entregas.model.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Integer> {
}
