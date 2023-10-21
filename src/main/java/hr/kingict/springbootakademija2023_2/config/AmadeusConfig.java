package hr.kingict.springbootakademija2023_2.config;

import com.amadeus.Amadeus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmadeusConfig {

    @Bean
    public Amadeus getAmadeus(){
        return Amadeus
                .builder("nQwWHL7t3rwLmgYqgdPwoaT5wgRsiBSr", "ZiDQkugzA9RlukgP")
                .build();
    }
}
