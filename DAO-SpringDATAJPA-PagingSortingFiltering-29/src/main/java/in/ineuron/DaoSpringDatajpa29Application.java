package in.ineuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DaoSpringDatajpa29Application {

	public static void main(String[] args) {
		ApplicationContext factory= SpringApplication.run(DaoSpringDatajpa29Application.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		/*
		 * service.fetchDetails(true, "price", "name") .forEach((vaccine) ->
		 * System.out.println(vaccine.getPrice() + " == " + vaccine.getCountry()));
		 */

		/*
		 * service.fetchDetailsByPageNo(2, 3, true, "price", "name") .forEach((vaccine)
		 * -> System.out.println(vaccine.getName()+" "+vaccine.getPrice() + " " +
		 * vaccine.getCountry()));
		 */

		service.fetchDetailsByPagination(3);
		((ConfigurableApplicationContext) factory).close();
	
		 
				 
	}

}
