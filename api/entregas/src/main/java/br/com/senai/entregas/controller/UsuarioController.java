package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@RestController
@RequestMapping("api/usuario")

@Tag(name = "Controller de Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuario){
        usuarioService = usuario;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        List<Usuario> usuario = usuarioService.getAllUsuarios();
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuarios){
        Usuario usuario = usuarioService.createUsuario(usuarios);
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarios){
        Usuario usuario = usuarioService.updateUsuario(usuarios, id);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Integer id){
        Usuario usuario = usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().body(usuario);
    }








}
