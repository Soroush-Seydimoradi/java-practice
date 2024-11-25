package com.kurdestan.bootcamp;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.EmployeeRepository;
import com.kurdestan.bootcamp.employee.Gender;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EmployeeApplication implements ApplicationRunner {

    @Autowired
    EmployeeRepository repository;


    @Autowired
    IEmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (repository.count() == 0) {
            Employee emp1 = new Employee();
            emp1.setName("Soroush");
            emp1.setFamily("Seydimoradi");
            emp1.setGender(Gender.MALE);
            emp1.setIsMarried(false);
            emp1.setChildCount(0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd");
            String date = "2004-12-11";
            Date birthDay = simpleDateFormat.parse(date);
            emp1.setBirthDay(birthDay);
            emp1.setNationalCode("3777777777");

            Employee emp1Saved = repository.save(emp1);

            emp1Saved.setChildCount(5);
            repository.save(emp1Saved);
            //repository.delete(emp1Saved);

        }


        List<Employee> employeeList = (List<Employee>) repository.findAll();


        System.out.println("finish");

        List<Employee> all = service.getAll();
            System.out.println();

    }
}