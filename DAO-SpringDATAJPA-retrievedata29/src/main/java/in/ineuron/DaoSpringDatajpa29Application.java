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
		
		 Optional<CoronaVaccine> optional = service.fecthVaccineById(3L);
		 if (optional.isPresent())
			 System.out.println(optional.get());
		 optional.orElseThrow(() -> new IllegalArgumentException("record not found"));
		  
		  System.out.println(service.fecthVaccineById(10L).orElse(new CoronaVaccine()));
		  System.out.println(service.fecthVaccineById(6L).orElseGet(()->new CoronaVaccine()));
		 
		
		
		 /*List<Long> ids = new ArrayList<Long>(); ids.add(1L); ids.add(2L);
		 ids.add(3L); Iterable<CoronaVaccine> records =
		 service.fetchAllDetailsByID(ids);
		 records.forEach(vaccine->System.out.println(vaccine));
		 */
		//service.fetchAllDetails().forEach(System.out::println);
		
		
		/*System.out.println("Checking for availability for the id::2 is =>  "+service.checkAvailablityByRegNo(3L));
				 
		System.out.println("Total no of vaccine count is :: "+service.getVaccineCount());
		
		*/
		
		
		
		 /*List<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();
		 vaccines.add(new CoronaVaccine(null, "sputnik", "russie", "Russia", 567.8, 2));
		 vaccines.add(new CoronaVaccine(null, "pyzer", "pyzwer", "USA", 678.8,2)); 
		 vaccines.add(new CoronaVaccine(null, "moderena", "moderena", "USA",455.8, 2));
		 Iterable<CoronaVaccine> listVaccines =service.registerInBatch(vaccines);
		 listVaccines.forEach(vaccine-> System.out.println(vaccine.getRegNo()));
		 */
		
	
		 /*CoronaVaccine vaccine = new CoronaVaccine(null, "covidshield", "serum", "IND", 750.0, 2);
		 System.out.println(service.registerVacine(vaccine));
		 */
		 ((ConfigurableApplicationContext) factory).close();
				 
	}

}
