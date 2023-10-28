package com.portfolio.api.services;

import com.portfolio.api.entities.User;
import com.portfolio.api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.api.repositories.IUserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Transactional
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum usuário encontrado.");
        }
        return users;
    }

    @Transactional
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    @Transactional
    public void insert(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void delete(long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível excluir. Usuário não encontrado com o ID: " + id);
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new ResourceNotFoundException("Não é possível atualizar. Usuário não encontrado com o ID: " + user.getId());
        }
        return userRepository.save(user);
    }
}
