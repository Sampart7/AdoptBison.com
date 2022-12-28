package registerlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestBody Register newUser) {
        userRepository.save(newUser);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Register> getAllUsers() {
        return userRepository.findAll();
    }
}