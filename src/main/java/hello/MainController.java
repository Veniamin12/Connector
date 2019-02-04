package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String secondname,
                                            @RequestParam String adres, @RequestParam String phone, @RequestParam String profesion){
         User Admin = new User();
         Admin.setName(name);
         Admin.setEmail(email);
         Admin.setAdres(adres);
         Admin.setSecondname(secondname);
         Admin.setPhone(phone);
         Admin.setProfesion(profesion);
//         log.debug("Save User: %n", n);
         userRepository.save(Admin);
         return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();

    }
}
