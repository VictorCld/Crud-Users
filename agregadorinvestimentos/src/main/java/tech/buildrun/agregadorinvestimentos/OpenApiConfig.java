package tech.buildrun.agregadorinvestimentos;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI userAgregadordeInvestimentos(){
        return new OpenAPI()
                .info(new Info()
                        .title("Agregador de investimentos")
                        .description("API para agregação de dados de investimentos")
                        .version("1.0.0"));


    }
}
