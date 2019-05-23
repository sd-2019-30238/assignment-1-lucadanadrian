package com.assignment2.demo;

import com.assignment2.demo.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableWebSecurity
public class DemoApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        User user= new User("email","name","first","pass",0);
//        System.out.println(user.getEmail());
    }
//    public static void main(String[] args) {
//        ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
//        UserDAO users= appContext.getBean("userDAO", UserDAO.class);
//        System.out.println(users.selectById(2));
//      users.insertTable(new User("user@email565","nume1","prenume1","asd",0));

//        User user= new User("email","name","first","pass",0);
//        System.out.println(user.getEmail());
//    }

    @Autowired
    private LogInService logInService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/signUp/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/checkCredentials")
                .permitAll()
                .defaultSuccessUrl("/booksU")
                .and()
                .logout();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(logInService);
        daoAuthenticationProvider.setPasswordEncoder(passwordencoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("adrianlucadan38@gmail.com");
        mailSender.setPassword("Adrianlucadan38.");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
