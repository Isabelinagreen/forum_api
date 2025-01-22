package com.forumhub.api.controller;

import com.forumhub.api.model.Topico;
import com.forumhub.api.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody Topico topico) {
        return ResponseEntity.ok(topicoRepository.save(topico));
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico datosActualizados) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(datosActualizados.getTitulo());
            topico.setMensaje(datosActualizados.getMensaje());
            topico.setStatus(datosActualizados.getStatus());
            topico.setAutor(datosActualizados.getAutor());
            topico.setCurso(datosActualizados.getCurso());
            return ResponseEntity.ok(topicoRepository.save(topico));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        return topicoRepository.findById(id).map(topico -> {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
