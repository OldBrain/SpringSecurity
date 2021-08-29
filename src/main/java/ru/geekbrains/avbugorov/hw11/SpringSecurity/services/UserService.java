package ru.geekbrains.avbugorov.hw11.SpringSecurity.services;

import javafx.print.Collation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.entities.Role;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.entities.User;
import ru.geekbrains.avbugorov.hw11.SpringSecurity.repsitories.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    public final UserRepository userRepository;

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNameRole())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("user " + userName + " not found."));
        return new org.springframework.security.core.userdetails.User
                (user.getUserName(),
                        user.getPassword(),
                        mapRolesToAuthorities(user.getRoles()));
    }
}
