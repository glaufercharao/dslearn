package br.com.dslearn.services;

import br.com.dslearn.entities.User;
import br.com.dslearn.repositories.UserRepository;
import br.com.dslearn.services.exceptions.ForbiddenException;
import br.com.dslearn.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        }catch (Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user = authenticated();
        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }

    }
}
