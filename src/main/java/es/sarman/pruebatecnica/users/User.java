package es.sarman.pruebatecnica.users;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private String email;
    @NonNull private String password;


    public static User fromDTO(UserDTO userDTO) {
        User user = new User();

        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public void updateFromDTO(UserDTO update) {
        setName(update.getName());
        setSurname(update.getSurname());
        setEmail(update.getEmail());
        setPassword(update.getPassword());
    }
}
