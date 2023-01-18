package pl.website.zuberek;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    public UserRepository userRepository;

    /**
     * @param email
     * @return
     *we create a user by e-mail
     */
    public Register getByEmail(String email) {
        Optional<Register> user = userRepository.findByEmail(email);

        if(!user.isPresent())
        {
            throw new IllegalStateException("user not found");
        }

        return user.get();
    }

    /**
     * @param email
     * @param password
     * @return
     *we combine the email with the user's password
     */
    public boolean compare(String email, String password) {
        Optional<Register> user = userRepository.findByEmail(email);

        if(!user.isPresent())
        {
            throw new IllegalStateException("user not found");
        }

        return Objects.equals(user.get().getPassword(), password);
    }
}
