package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable String id) {
        Employee employee = employeeMapper.selectById(id);
        return ResponseEntity.ok(employee);
    }
    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employeeMapper.addEmployee(employee);
        return ResponseEntity.created(URI.create("/employees"+id)).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable String id) {
        employeeMapper.updateEmployee(employee,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id) {
        employeeMapper.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
