package com.d288.zacbaileyd288.BootStrapData;

import com.d288.zacbaileyd288.dao.CustomerRepository;
import com.d288.zacbaileyd288.dao.DivisionRepository;
import com.d288.zacbaileyd288.entities.Customer;
import com.d288.zacbaileyd288.entities.Division;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Define sample customers
        List<Customer> sampleCustomers = new ArrayList<>();

        sampleCustomers.add(new Customer("Zac", "Bailey", "487 West Street", "12345", "(123)555-8888", divisionRepository.findById(22L).orElse(null)));
        sampleCustomers.add(new Customer("Kylie", "Copeland", "852 East Street", "67899", "(111)222-9878", divisionRepository.findById(33L).orElse(null)));
        sampleCustomers.add(new Customer("Travis", "Hayes", "22 North Dr", "85214", "(457)874-5214", divisionRepository.findById(44L).orElse(null)));
        sampleCustomers.add(new Customer("Rollo", "Shepherd", "33 South Ln", "22335", "(999)777-3256", divisionRepository.findById(55L).orElse(null)));
        sampleCustomers.add(new Customer("Luna", "Shepherd", "777 Las Vegas Blvd", "87451", "(333)777-6666", divisionRepository.findById(66L).orElse(null)));

        // Add only missing customers
        for (Customer customer : sampleCustomers) {
            boolean exists = customerRepository.existsByFirstNameAndLastName(customer.getFirstName(), customer.getLastName());
            if (!exists) {
                customerRepository.save(customer);
            }
        }

        System.out.println("Bootstrapping completed. Total customers in DB: " + customerRepository.count());
    }
}