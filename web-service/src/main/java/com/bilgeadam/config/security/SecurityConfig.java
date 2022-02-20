//package com.bilgeadam.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    MvcTokenFilter mvcTokenFilter(){
//        return new MvcTokenFilter();
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception{
//        /**
//         * Eğer, RestApi izinlere takılmadan kullanmak için etkinleştiriyoruz.
//         * Web, csrf etkin kalmalı.
//         * Post isterklerini alırken sıkıntı oluyor. post ları reddediyor.
//         * Get isterkleri alınır.
//         */
//        http.csrf();
//        http.authorizeRequests()
//                .antMatchers("/register", "login").permitAll() // http://localhost/register adresine gitmek isterse izin ver.
//                .anyRequest().authenticated(); // diğer bütün istekleri izine tabi tut.
//
//        /**
//         * Eğer özellikle belirtilmemiş ise login formu spring tarafından sağlanır ve yönetilir. => http.formLogin();
//         * Artık, yetkisiz alanlara girişte kendi tanımladığımız formu kullanır.
//         */
//        http.formLogin().loginPage("/login").loginProcessingUrl("/login");
//
//
//    }
//
//
//
//}
