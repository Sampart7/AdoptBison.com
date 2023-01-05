package pl.website.zuberek;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path="/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @PostMapping(path="/addUser")
    public @ResponseBody String addNewUser(@RequestBody Register newUser) {
        Optional<Register> foundUser = userRepository.findByEmail(newUser.getEmail());

        if(foundUser.isPresent()) {
            if(!newUser.isEnabled())
            {
                String token = UUID.randomUUID().toString();
                Token t1 = new Token(newUser, token);
                tokenRepository.save(t1);

                String link ="http://localhost:8080/demo/confirm?token=" + token;
                emailService.sendEmail(newUser.getEmail(), "Potwierdzenie", emailConfirm(link));

                return "Sprawdź Email";
            }
            return "Użytkownik jest już w bazie";
        }
        else {
            userRepository.save(newUser);
            String token = UUID.randomUUID().toString();
            Token t1 = new Token(newUser, token);
            tokenRepository.save(t1);

            String link ="http://localhost:8080/demo/confirm?token=" + token;
            emailService.sendEmail(newUser.getEmail(), "Potwierdzenie", emailConfirm(link));

            return "Saved";
        }
    }

    @GetMapping(path="/confirm")
    public String confirm(@RequestParam("token") String token) {
        Token t2 = tokenRepository.GetTokenByString(token);
        userRepository.enableUser(t2.getUser().getId());
        return "confirmed";
    }

    public String emailConfirm(String link){
        return link;
    }

    @GetMapping(path="/allUsers")
    public @ResponseBody Iterable<Register> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/getByEmail")
    public Register getByEmail(@RequestParam("email") String email)
    {
        return userService.getByEmail(email);
    }

    @GetMapping(path = "/compare")
    public boolean compare(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        return userService.compare(email, password);
    }

}