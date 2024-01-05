package ci.gs2e.Gestion_Incidents.Service.Auth;

import ci.gs2e.Gestion_Incidents.Dto.SignupDTO;
import ci.gs2e.Gestion_Incidents.Dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
