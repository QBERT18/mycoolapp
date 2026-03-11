package com.learn.springboot.cruddemo.rest;

import com.learn.springboot.cruddemo.entity.Employee;
import com.learn.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    private final JsonMapper jsonMapper;

    public EmployeeRestController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public  Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee update(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee foundEmployee = employeeService.findById(employeeId);
        if (foundEmployee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " +  employeeId);
        }

        Employee updatedEmployee = jsonMapper.updateValue(foundEmployee, patchPayload);

        return employeeService.save(updatedEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable int employeeId) {
        Employee foundEmployee = employeeService.findById(employeeId);
        if (foundEmployee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }

        employeeService.deleteById(employeeId);
    }
}
