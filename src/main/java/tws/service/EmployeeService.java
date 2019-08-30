package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto getEmployeeWithDesc(String id){
        Employee employee = employeeMapper.selectById(id);
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),employee.getName(),employee.getAge(),"姓名是："+employee.getName()+"年龄是："+employee.getAge());
        return employeeDto;
    }
}
