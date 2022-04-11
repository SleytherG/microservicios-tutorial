package com.moto.service.controllers;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping()
    public ResponseEntity<List<Moto>> listarMotos() {
        List<Moto> motos = motoService.getAll();

        if ( motos.isEmpty() ) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok( motos );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id")Integer id) {
        Moto moto = motoService.getMotoById(id);

        if ( moto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( moto );
    }

    @PostMapping("/addMoto")
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
        Moto nuevaMoto = motoService.save( moto );
        return ResponseEntity.ok( nuevaMoto );
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") Integer id) {
        List<Moto> motos = motoService.byUsuarioId( id );
        if ( motos.isEmpty() ) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok( motos );
    }
}
