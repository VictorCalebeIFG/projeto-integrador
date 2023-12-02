package com.api.projetointegrador.Controller;

import com.api.projetointegrador.Model.User;
import com.api.projetointegrador.Repository.UserRepository;
import com.api.projetointegrador.Repository.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    UserRepository rep = new UserRepository();

    public UserController(UsuarioRepository usuarioRepository) throws SQLException {
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @NotNull User usuario) throws SQLException {
        if (usuario.getLogin() == null || usuario.getEmail() == null) {
            return ResponseEntity.badRequest().body("Nome e Email são obrigatórios");
        }

        System.out.println(usuario.getLogin());

        rep.saveUser(usuario);

        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }

    @GetMapping("/{login}")
    public User getUsuariosPorLogin(@PathVariable("login") String login) throws SQLException {

        return rep.getuser(login);
    }

}