package conta.banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application-dev.yml"),
        @PropertySource("classpath:application-psg.yml")
})
@OpenAPIDefinition(servers = {@Server(url ="/", description ="Default Server URL")})
public class Applicattion implements CommandLineRunner{

	@Autowired
	private Environment enviroment;
	public static void main(String[] args) {
		SpringApplication.run(Applicattion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String activeProfile = enviroment.getProperty("SPRING_PROFILES_ACTIVE");
		System.out.println("Active profile: " + activeProfile);
	}

}
/* "env":{
                "SPRING_PROFILES_ACTIVE": "dev"
            } */
