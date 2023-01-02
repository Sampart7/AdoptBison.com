package pl.website.zuberek;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    public UserRepository userRepository;
    public Register getByEmail(String email) {
        Optional<Register> user = userRepository.findByEmail(email);

        if(!user.isPresent())
        {
            throw new IllegalStateException("user not found");
        }

        return user.get();
    }

    public boolean compare(String email, String password) {
        Optional<Register> user = userRepository.findByEmail(email);

        if(!user.isPresent())
        {
            throw new IllegalStateException("user not found");
        }

        String hashedPassword = user.get().getPassword();

        return Objects.equals(user.get().getPassword(), password);
    }
}
