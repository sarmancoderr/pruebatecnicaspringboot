package es.sarman.pruebatecnica.users;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User createUsers(UserDTO userDTO);

    User getUser(int id);

    User updateUser(int id, UserDTO update);

    boolean removeUser(int id);
}
