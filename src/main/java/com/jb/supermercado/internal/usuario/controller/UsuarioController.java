package com.jb.supermercado.internal.usuario.controller;

import com.jb.supermercado.internal.usuario.dto.UsuarioRequest;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponse;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponseRecord;
import com.jb.supermercado.internal.usuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar(){
        return ResponseEntity.ok(this.usuarioService.listaUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseRecord> buscar(@PathVariable Long id){
        return ResponseEntity.ok(this.usuarioService.buscarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody UsuarioRequest usuarioRequest){
        this.usuarioService.cadastrarusuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
