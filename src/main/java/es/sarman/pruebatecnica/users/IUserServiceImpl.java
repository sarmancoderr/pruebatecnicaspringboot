package es.sarman.pruebatecnica.users;

import es.sarman.pruebatecnica.users.exceptions.ExistingUserException;
import es.sarman.pruebatecnica.users.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IUserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public User createUsers(UserDTO userDTO) {
        Optional<User> userByEmail = userRepository.findUserByEmail(userDTO.getEmail());
        if (userByEmail.isPresent()) {
            throw new ExistingUserException();
        }

        // TODO: encriptar contraseña
        return userRepository.save(User.fromDTO(userDTO));
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User updateUser(int id, UserDTO update) {
        Optional<User> userByEmail = userRepository.findUserByEmail(update.getEmail());
        if (userByEmail.isPresent()) {
            throw new ExistingUserException();
        }

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        // TODO: encriptar contraseña
        user.updateFromDTO(update);
        return userRepository.save(user);
    }

    @Override
    public boolean removeUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(user);
        return true;
    }

}
