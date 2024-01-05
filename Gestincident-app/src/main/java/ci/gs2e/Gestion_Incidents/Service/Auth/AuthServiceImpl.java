package ci.gs2e.Gestion_Incidents.Service.Auth;


import ci.gs2e.Gestion_Incidents.Dto.SignupDTO;
import ci.gs2e.Gestion_Incidents.Dto.UserDTO;
import ci.gs2e.Gestion_Incidents.Modele.User;
import ci.gs2e.Gestion_Incidents.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setNom(signupDTO.getNom());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(createdUser.getIdUser());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setNom(createdUser.getNom());
        return userDTO;
    }
}
