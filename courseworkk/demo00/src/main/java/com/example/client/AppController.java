package com.example.client;
import com.example.config.UserInfo;
import com.example.config.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AppController {

    private final ClientService clientService;

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public String addNewUser(@ModelAttribute UserInfo userInfo, @RequestParam String name, @RequestParam String roles, HttpSession session) {
        System.out.println("UserInfo object is: " + userInfo);
        userService.addUser(userInfo);
        session.setAttribute("username", name);
        session.setAttribute("roles", roles);
        return "redirect:/";
    }
    @GetMapping("/auth/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "register";
    }
    @GetMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Client> listClients = clientService.listAll(keyword);
        model.addAttribute("listClients", listClients);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @GetMapping("/new")
    public String showNewClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_client";
    }
    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditClientForm(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = clientService.get(id);
        mav.addObject("Client", client);
        return mav;
    }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        clientService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/login_page")
    public String showLogin() {// add any additional objects you want to pass to the HTML page
        return "login_page";
    }
    @GetMapping("/about_us")
    public String showAbout() {// add any additional objects you want to pass to the HTML page
        return "about_us";
    }
    @PostMapping("/login_page")
    public String SuccessLogin(@RequestParam String username, HttpSession session) {
        System.out.println("Username is: " + username);
        final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("username", currentUser);
        return "redirect:/";
    }
}


