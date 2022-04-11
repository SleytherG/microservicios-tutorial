package com.usuario.service.controller;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.getAll();

        if ( usuarios.isEmpty() ) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok( usuarios );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id")Integer id) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        if ( usuario == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( usuario );
    }

    @PostMapping("/addUsuario")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save( usuario );
        return ResponseEntity.ok( nuevoUsuario );
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> getCarros(@PathVariable("usuarioId") Integer usuarioId) {
        Usuario usuario = usuarioService.getUsuarioById( usuarioId );
        if ( usuario == null ) {
            return ResponseEntity.notFound().build();
        }

        List<Carro> carros = usuarioService.getCarros( usuarioId );
        return ResponseEntity.ok( carros );
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable("usuarioId")Integer usuarioId) {
        Usuario usuario = usuarioService.getUsuarioById( usuarioId );
        if ( usuario == null ) {
            return ResponseEntity.notFound().build();
        }

        List<Moto> motos = usuarioService.getMotos( usuarioId );
        return ResponseEntity.ok( motos );
    }

    @PostMapping("/carro/{usuarioId}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") Integer usuarioId, @RequestBody Carro carro) {
        Carro nuevoCarro = usuarioService.saveCarro( usuarioId, carro);
        return ResponseEntity.ok( nuevoCarro );
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") Integer usuarioId, @RequestBody Moto moto) {
        Moto nuevaMoto = usuarioService.saveMoto( usuarioId, moto );
        return ResponseEntity.ok( nuevaMoto );
    }

    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> listarTodosLosVehiculos(@PathVariable("usuarioId") Integer usuarioId) {
        Map<String, Object> resultado = usuarioService.getUsuarioAndVehiculos( usuarioId );
        return ResponseEntity.ok( resultado );
    }
}
