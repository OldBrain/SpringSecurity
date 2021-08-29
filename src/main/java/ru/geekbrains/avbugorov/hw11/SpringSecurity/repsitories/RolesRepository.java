package ru.geekbrains.avbugorov.hw11.SpringSecurity.repsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.entities.Role;

@Repository
public interface RolesRepository extends CrudRepository<Role,Long> {

}
