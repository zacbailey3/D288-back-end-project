package com.d288.zacbaileyd288.BootStrapData;

import com.d288.zacbaileyd288.dao.CustomerRepository;
import com.d288.zacbaileyd288.dao.DivisionRepository;
import com.d288.zacbaileyd288.entities.Customer;
import com.d288.zacbaileyd288.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) {

        // Only insert sample customers if DB is basically empty
        long count = customerRepository.count();

        // If FE added John Smith: count = 1
        // If DB empty: count = 0
        // In BOTH cases: we want to insert our sample customers.
        if (count <= 1) {

            Customer c1 = new Customer("Zac", "Bailey", "487 West Street", "12345",
                    "(123)555-8888", divisionRepository.findById(22L).orElse(null));

            Customer c2 = new Customer("Kylie", "Copeland", "852 East Street", "67899",
                    "(111)222-9878", divisionRepository.findById(33L).orElse(null));

            Customer c3 = new Customer("Travis", "Hayes", "22 North Dr", "85214",
                    "(457)874-5214", divisionRepository.findById(44L).orElse(null));

            Customer c4 = new Customer("Rollo", "Shepherd", "33 South Ln", "22335",
                    "(999)777-3256", divisionRepository.findById(55L).orElse(null));

            Customer c5 = new Customer("Luna", "Shepherd", "777 Las Vegas Blvd", "87451",
                    "(333)777-6666", divisionRepository.findById(66L).orElse(null));

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
            customerRepository.save(c4);
            customerRepository.save(c5);

            System.out.println("Sample customers added.");
        } else {
            System.out.println("Customers already exist. Skipping bootstrap.");
        }

        System.out.println("Total customers: " + customerRepository.count());
    }
}