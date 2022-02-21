package com.bilgeadam.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AuthServiceSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    JwtTokenFilter getJwtTokenfilter() {
        return new JwtTokenFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //Swagger kullanabilmek için gerekli izinlerin verilmesi gerçekleştirilir.
        http.authorizeRequests().antMatchers("/v3/api-docs/**",
                "/swagger-ui/**",
                "/v1/auth/dologin",
                "/v1/auth/validatetoken",
                "v1/auth/message").permitAll()
                .anyRequest().authenticated(); // Yukarıdaki urller haricindeki tüm istekler izne tabi tutulur.

        /*
        Configure metodu bizim tarafımızdan override edildiği için tüm işlemleri devralmış oluruz.
        bu nedenle gelen isteklerin yönetimini burada belirlemeliyiz.
         */
        http.addFilterBefore(getJwtTokenfilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
