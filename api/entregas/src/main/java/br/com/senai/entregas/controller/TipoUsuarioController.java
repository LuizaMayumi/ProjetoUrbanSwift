package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.service.TipoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@RestController
@RequestMapping("/api/teste")

@Tag(name = "Controller de TipoUsuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuario){
        tipoUsuarioService = tipoUsuario;
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> getAllTipoUsuario(){
        List<TipoUsuario> tipoUsuario = tipoUsuarioService.getAllTipoUsuario();
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> getTipoUsuarioById(@PathVariable Integer id){
        TipoUsuario tipoUsuario = tipoUsuarioService.getByIdTipoUsuario(id);
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> createTipoUsuario(@RequestBody TipoUsuario tipoUsuarios){
        TipoUsuario tipoUsuario = tipoUsuarioService.createTipoUsuario(tipoUsuarios);
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> updateTipoUsuario(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuarios){
        TipoUsuario tipoUsuario = tipoUsuarioService.updateTipoUsuario(tipoUsuarios, id);
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoUsuario> deleteTipoUsuario(@PathVariable Integer id){
        TipoUsuario tipoUsuario = tipoUsuarioService.deleteTipoUsuario(id);
        return ResponseEntity.ok().body(tipoUsuario);
    }

}
