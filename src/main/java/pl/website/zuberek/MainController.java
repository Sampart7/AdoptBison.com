package pl.website.zuberek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private ZubrRepository zubrRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewZubr(@RequestBody Zubr newZubr) {
        zubrRepository.save(newZubr);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Zubr> getAllZubr() {
        return zubrRepository.findAll();
    }
}