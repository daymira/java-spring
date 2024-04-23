package conta.banco.service;

import conta.banco.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create (User userCreate);
}
