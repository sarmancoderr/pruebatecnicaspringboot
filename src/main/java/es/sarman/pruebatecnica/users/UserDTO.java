package es.sarman.pruebatecnica.users;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private String email;
    @NonNull private String password;

}
