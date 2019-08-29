package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();

    void addEmployee(@Param("employee") Employee employee );

    Employee selectById(@Param("id") String id);

    void updateEmployee(@Param("employee") Employee employee ,@Param("id") String id);

    void delete(@Param("id") String id);

    List<Employee> selectByKey(@Param("key") String key);
}
