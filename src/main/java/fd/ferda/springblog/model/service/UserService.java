package fd.ferda.springblog.model.service;

import fd.ferda.springblog.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {

    void create(UserDTO user, boolean isAdmin);
}
