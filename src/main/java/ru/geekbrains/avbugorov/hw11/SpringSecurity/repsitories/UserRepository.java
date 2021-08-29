package ru.geekbrains.avbugorov.hw11.SpringSecurity.repsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
