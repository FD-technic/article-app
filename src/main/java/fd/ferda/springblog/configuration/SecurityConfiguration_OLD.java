package fd.ferda.springblog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfiguration_OLD {

    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/articles/create", "/articles/edit/**", "/articles/delete/**"
                    )
                    .authenticated()

                    .requestMatchers(
                            "/articles/**", "/styles/**", "/images/**", "/scripts/**", "/fonts/**",
                            "/", "/skills", "/references", "/contact",
                            "/account/register"
                    ).permitAll()

                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/account/login")
                        .defaultSuccessUrl("/")
                        .usernameParameter("email") // Chceme se přihlašovat pomocí emailu
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/account/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
