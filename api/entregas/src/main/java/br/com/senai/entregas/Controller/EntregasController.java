package br.com.senai.entregas.Controller;

import br.com.senai.entregas.model.Entregas;
import br.com.senai.entregas.model.Entregas;
import br.com.senai.entregas.service.EntregasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("api/entregas")

@Tag(name = "Controller de Entregas")
public class EntregasController {

    private final EntregasService entregasService;

    public EntregasController(EntregasService entregas){
        entregasService = entregas;
    }

    @GetMapping
    public ResponseEntity<List<Entregas>> getAllEntrega(){
        List<Entregas> entregas = entregasService.getAllEntregas();
        return ResponseEntity.ok().body(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregas> getEntregasById(@PathVariable Integer id){
        Entregas entregas = entregasService.getEntregasById(id);
        return ResponseEntity.ok().body(entregas);
    }

    @PostMapping
    public ResponseEntity<Entregas> createEntrega(@RequestBody Entregas entregas){
        Entregas entrega = entregasService.createEntregas(entregas);
        return ResponseEntity.ok().body(entrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregas> updateEntrega(@PathVariable Integer id, @RequestBody Entregas entregas){
        Entregas entrega = entregasService.updateEntregas(entregas, id);
        return ResponseEntity.ok().body(entrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entregas> deleteEntrega(@PathVariable Integer id){
        Entregas entregas = entregasService.deleteEntregas(id);
        return ResponseEntity.ok().body(entregas);
    }

}
