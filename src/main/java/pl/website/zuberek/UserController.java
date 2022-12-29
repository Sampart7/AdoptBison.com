package pl.website.zuberek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(path="/addUser")
    public @ResponseBody String addNewUser(@RequestBody Register newUser) {
        userRepository.save(newUser);
        String token = UUID.randomUUID().toString();
        Token t1 = new Token(newUser, token);
        tokenRepository.save(t1);
        String link ="http://localhost:8080/demo/confirm?token=" + token;
        emailService.sendEmail(newUser.getEmail(), "Potwierdzenie", emailConfirm(link));
        return "Saved";
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
}