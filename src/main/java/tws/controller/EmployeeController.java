package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<Employee>> getAll(
            @RequestParam(required = false) int page,
            @RequestParam(required = false) int pageSize
    ) {
        return ResponseEntity.ok(employeeService.getEmployees(page,pageSize));
    }
    @GetMapping("key")
    public ResponseEntity<List<Employee>> getEmployeesByKey(
            @RequestParam(required = false) String key
    ) {
        return ResponseEntity.ok(employeeService.getEmployeesByKey(key));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployees(@PathVariable String id) {
        EmployeeDto employeeDto = employeeService.getEmployeeWithDesc(id);
        return ResponseEntity.ok(employeeDto);
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
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id) {
        employeeMapper.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
