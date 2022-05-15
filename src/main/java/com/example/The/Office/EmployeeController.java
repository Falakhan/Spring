package com.example.The.Office;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    public class EmployeeController {

        // Create, Read, Update, Delete = HTTP POST, GET, PUT, DELETE

        // Our fake db - create a list of hobbits
        private List<Employee> employees;
        public EmployeeController() {
            employees = new ArrayList<>();
            employees.add( new Employee("Michael", "Scott"));
            employees.add( new Employee("Pam", "Beasley"));
            employees.add(  new Employee("Dwight", "Schrute"));
        }


        // Accept HTTP GET, localhost:8080/hobbits
        @GetMapping("/employees")
        List<Employee> getAll() {
            return employees;
        }

        // ############   Extra Part! ############# //


        // Accept HTTP POST, localhost:8080/hobbits
        @PostMapping("/employees")
        Employee post(@RequestBody Employee employee){
        /*
                Add a new Hobbit to the list.
         */
            employees.add(employee);
            // Return the last hobbit from the list
            return employees.get(employees.size()-1);
        }

        // Accept HTTP DELETE, localhost:8080/hobbits
        @DeleteMapping("/employees/{id}")
        void delete(@PathVariable int id){
            employees.remove(id);
        }

    }
