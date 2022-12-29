package pl.website.zuberek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path="/addUser")
    public @ResponseBody String addNewUser(@RequestBody Register newUser) {
        userRepository.save(newUser);
        return "Saved";
    }

    @GetMapping(path="/allUsers")
    public @ResponseBody Iterable<Register> getAllUsers() {
        return userRepository.findAll();
    }
}