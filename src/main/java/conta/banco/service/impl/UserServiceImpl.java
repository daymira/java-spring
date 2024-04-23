package conta.banco.service.impl;


import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import conta.banco.domain.model.User;
import conta.banco.domain.repository.UserRepository;
import conta.banco.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository; //interface de acesso a dados

    public UserServiceImpl(UserRepository userRepository){ //cria construtor para injetar o userRepository
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userCreate) {
        if (userRepository.existsByAccountNumber(userCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists.");
        }
        return userRepository.save(userCreate);
    }
    

}
