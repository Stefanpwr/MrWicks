package configuration;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method= RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }
    @RequestMapping(value = { "/signup"}, method= RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/signup");

        return modelAndView;
    }

    @RequestMapping(value = { "/signup"}, method= RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult){

        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists!=null){
            bindingResult.reject("email","This email already exists");
        }
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("user/signup");
        }else {

            userService.saveUser(user);
            modelAndView.addObject("msg", "User has ben added");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("user/signup");
        }
        return modelAndView;
        }
        @RequestMapping(value = { "/home/home"}, method= RequestMethod.GET)
        public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user  = userService.findUserByEmail(authentication.getName());


            modelAndView.addObject("userName", user.getImie()+" " +user.getNazwisko());
            modelAndView.setViewName("home/home");
            return modelAndView;
        }

         @RequestMapping(value = { "/accessDenied"}, method= RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errors/access_denied");
        return modelAndView;
         }



    }


