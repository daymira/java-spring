package conta.banco.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import conta.banco.domain.model.User;
import conta.banco.service.UserService;

@RestController
@RequestMapping("/users") //caminho para requisição dos endpoints
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}") //caminho para expor o endpoint
    public ResponseEntity<User> finById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    } //cria endpoint que recebe o id e busca o usuario pelo e id e devolve o usuario caso tenha

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        var userCreated = userService.create(userToCreate); // cria usuário
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() //cria localização
        .path("/{id}") //retorna a url do id do usuario criado
        .buildAndExpand(userCreated.getId()) //função que atribui o valor
        .toUri(); // cria de fato a localização
        return ResponseEntity.created(location).body(userCreated);
    }
}
