package com.api.projetointegrador.Controller;

import com.api.projetointegrador.Model.User;
import com.api.projetointegrador.Repository.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UsuarioRepository usuarioRepository;

    public UserController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @NotNull User usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null) {
            return ResponseEntity.badRequest().body("Nome e Email são obrigatórios");
        }

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

}