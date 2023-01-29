package br.com.dslearn.services;

import java.util.Optional;

import br.com.dslearn.dto.UserDTO;
import br.com.dslearn.entities.User;
import br.com.dslearn.repositories.RoleRepository;
import br.com.dslearn.repositories.UserRepository;
import br.com.dslearn.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @Transactional(readOnly = true)
//    public Page<UserDTO> findAllPaged(Pageable pageable){
//        Page<User> list = userRepository.findAll(pageable);
//        return list.map(x -> new UserDTO(x));
//    }
//
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);

        Optional<User> obj = userRepository.findById(id);
        User entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }
//
//    @Transactional
//    public UserDTO insert(UserInsertDTO userDTO) {
//        User entity = new User();
//        copyDtoToEntity(userDTO, entity);
//        entity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        entity = userRepository.save(entity);
//        return  new UserDTO(entity);
//    }
//    @Transactional
//    public UserDTO update(Long id,UserDTO userDTO) {
//        try {
//            User entity = userRepository.getOne(id);
//            copyDtoToEntity(userDTO, entity);
//            entity = userRepository.save(entity);
//            return new UserDTO(entity);
//        }catch (EntityNotFoundException e){
//            throw new ResourceNotFoundException("Id not found "+ id);
//        }
//
//    }
//
//    public void delete(Long id) {
//        try {
//            userRepository.deleteById(id);
//        }catch (EmptyResultDataAccessException e){
//            throw new ResourceNotFoundException("Id not found "+id);
//        }catch (DataIntegrityViolationException e){
//            throw  new DatabaseException("Integrity violation");
//        }
//    }
//
//
//    private void copyDtoToEntity(UserDTO userDTO, User entity) {
//        entity.setFirstName(userDTO.getFirstName());
//        entity.setLastName(userDTO.getLastName());
//        entity.setEmail(userDTO.getEmail());
//
//        entity.getRoles().clear();
//
//        for(RoleDTO roleDTO: userDTO.getRoles()){
//            Role role = roleRepository.getOne(roleDTO.getId());
//            entity.getRoles().add(role);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("Email not found ");
        }
        return user;
    }
}
