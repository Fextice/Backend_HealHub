package com.example.healhub.Controller;

import com.example.healhub.Entity.User;
import com.example.healhub.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin/dashboard";
    }


    @GetMapping("/admin/users")
    public String viewAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/manage_users";
    }

    @GetMapping("/admin/users/{id}")
    public String viewUserDetails(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user_details";
    }

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/").permitAll() // Allow access to home page for everyone
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login") // Custom login page URL
                    .permitAll() // Allow access to login page for everyone
                    .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                    .permitAll(); // Allow access to logout URL for everyone
        }

        // Other security configurations, if needed
    }
}
