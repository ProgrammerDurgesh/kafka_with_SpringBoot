package durgeshkafka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Component
public class CorsFilters {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //config.addAllowedOrigin("http://localhost:3000"); // Allow requests from http://localhost:3000
        //	config.addAllowedOrigin("http://localhost:3000/");
        //	config.addAllowedOrigin("http://192.168.24.196:8080");
        config.addAllowedOriginPattern("*");
        //config.setAllowedOrigins(List.of("http://localhost:3000","http://localhost:3000/"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new org.springframework.web.filter.CorsFilter(source);
    }
}
