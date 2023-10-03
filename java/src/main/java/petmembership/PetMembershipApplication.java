package petmembership;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"petmembership"})
@MapperScan(basePackages = {"petmembership.mapper"})
public class PetMembershipApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetMembershipApplication.class, args);
	}

}
