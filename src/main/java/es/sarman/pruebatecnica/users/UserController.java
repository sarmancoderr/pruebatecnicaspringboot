package es.sarman.pruebatecnica.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserServiceImpl userService;

    @GetMapping
    public List<User> getUsers () {
        return userService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser (@RequestBody UserDTO userDTO) {
        return userService.createUsers(userDTO);
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserDTO update) {
        return userService.updateUser(id, update);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable int id) {
        return userService.removeUser(id);
    }

}
