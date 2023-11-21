package com.api.projetointegrador.Repository;

import com.api.projetointegrador.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<User, Long> {

}
