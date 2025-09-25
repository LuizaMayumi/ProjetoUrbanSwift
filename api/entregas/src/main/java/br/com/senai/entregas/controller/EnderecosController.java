package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Enderecos;
import br.com.senai.entregas.service.EnderecosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@RestController
@RequestMapping("api/enderecos")

@Tag(name = "Controller de Enderecos")
public class EnderecosController {

    private final EnderecosService enderecosService;

    public EnderecosController(EnderecosService endereco){
        enderecosService = endereco;
    }

    @GetMapping
    public ResponseEntity<List<Enderecos>> getAllEndereco(){
        List<Enderecos> endereco = enderecosService.getAllEnderecos();
        return ResponseEntity.ok().body(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enderecos> getEnderecoById(@PathVariable Integer id){
        Enderecos endereco = enderecosService.getByIdEnderecos(id);
        return ResponseEntity.ok().body(endereco);
    }

    @PostMapping
    public ResponseEntity<Enderecos> createEndereco(@RequestBody Enderecos endereco){
        Enderecos end = enderecosService.cadastraEnderecos(endereco);
        return ResponseEntity.ok().body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enderecos> updateEndereco(@PathVariable Integer id, @RequestBody Enderecos endereco){
        Enderecos end = enderecosService.editaEnderecos(endereco, id);
        return ResponseEntity.ok().body(end);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Enderecos> deleteEndereco(@PathVariable Integer id){
        Enderecos enderecos = enderecosService.deletaEnderecos(id);
        return ResponseEntity.ok().body(enderecos);
    }








}
