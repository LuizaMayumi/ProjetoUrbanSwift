package br.com.senai.entregas.Controller;

import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.service.VeiculosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@RestController
@RequestMapping("api/veiculos")

@Tag(name = "Controller de Veiculos")
public class VeiculosController {

    private final VeiculosService veiculosService;

    public VeiculosController(VeiculosService veiculos){
        veiculosService = veiculos;
    }

    @GetMapping
    public ResponseEntity<List<Veiculos>> getAllVeiculos(){
        List<Veiculos> veiculos = veiculosService.findAllVeiculos();
        return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculos> getVeiculosById(@PathVariable Integer id){
        Veiculos veiculos = veiculosService.findVeiculosById(id);
        return ResponseEntity.ok().body(veiculos);
    }

    @PostMapping
    public ResponseEntity<Veiculos> createVeiculos(@RequestBody Veiculos veiculos){
        Veiculos veiculo = veiculosService.postVeiculos(veiculos);
        return ResponseEntity.ok().body(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculos> updateVeiculos(@PathVariable Integer id, @RequestBody Veiculos veiculos){
        Veiculos veiculo = veiculosService.updateVeiculosById(id, veiculos);
        return ResponseEntity.ok().body(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculos> deleteVeiculo(@PathVariable Integer id){
        Veiculos veiculo = veiculosService.deleteVeiculosById(id);
        return ResponseEntity.ok().body(veiculo);
    }


    public String verificaTipo(String descricao){
        descricao = descricao.toUpperCase();

        if(!descricao.equals("Motocicleta") || !descricao.equals("Bicicleta")){
            return "Descricao deve ser Motocicleta ou Bicicleta";
        }
        return null;
    }

}
