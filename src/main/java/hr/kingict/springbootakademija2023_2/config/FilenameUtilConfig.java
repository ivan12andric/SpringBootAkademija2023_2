package hr.kingict.springbootakademija2023_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.FilenameUtil;

@Configuration
public class FilenameUtilConfig {

   @Bean
    public FilenameUtil getFilenameUtil(){
        return new FilenameUtil();
    }
}
