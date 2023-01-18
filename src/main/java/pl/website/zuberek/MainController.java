package pl.website.zuberek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private ZubrRepository zubrRepository;
    @Autowired
    private AdoptedZubrRepository adoptedZubrRepository;

    /**
     * @param newZubr
     * @return
     * adding a new object to the repository
     */
    @PostMapping(path="/add")
    public @ResponseBody String addNewZubr(@RequestBody Zubr newZubr) {
        zubrRepository.save(newZubr);
        return "Saved";
    }

    /**
     * @return
     * displaying all objects from the repository
     */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Zubr> getAllZubr() {
        return zubrRepository.findAll();
    }

    /**
     * @param newAdoptedZubr
     * @return
     * the same only in the category of adopted
     */
    @PostMapping(path="/adopt")
    public @ResponseBody String addAdoptedZubr(@RequestBody AdoptedZubr newAdoptedZubr) {
        adoptedZubrRepository.save(newAdoptedZubr);
        return "Saved";
    }

    /**
     * @return
     * the same only in the category of adopted
     */
    @GetMapping(path="/adopted")
    public @ResponseBody Iterable<AdoptedZubr> getAllAdoptedZubr() {
        return adoptedZubrRepository.findAll();
    }
}