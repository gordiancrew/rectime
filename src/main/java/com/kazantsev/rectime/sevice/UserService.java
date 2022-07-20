package com.kazantsev.rectime.sevice;

import com.kazantsev.rectime.models.Clients;
import com.kazantsev.rectime.models.Role;
import com.kazantsev.rectime.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Clients user=userRepository.findByUsername(username);

        if(username==null){
            throw  new UsernameNotFoundException("User not found");
        }
        return  user;
    }

    public Clients findUserById(Integer userId) {
        Optional<Clients> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Clients());
    }

    public List<Clients> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(Clients user) {
        System.out.println("1");
        Clients userFromDB = userRepository.findByUsername(user.getUsername());
        System.out.println("2");
        if (userFromDB != null) {
            return false;
        }
        System.out.println("3");

        user.setRoles(Collections.singleton(new Role(1,"ROLE_USER")));
        System.out.println("4");
        user.setPassword(user.getPassword());
        userRepository.save(user);

        return true;
    }

    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Clients> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", Clients.class)
                .setParameter("paramId", idMin).getResultList();
    }



}
