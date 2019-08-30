package tws;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @After
    public void teardown(){
        JdbcTestUtils.deleteFromTables(jdbcTemplate,"employee");
    }

    @Test
    public void shouldFetchList(){
        //given
        jdbcTemplate.execute("insert into employee values('1','xiongwei',18)");
        //when
        List<Employee> employees = employeeMapper.selectEmployees();

        //then
        assertEquals("1",employees.get(0).getId());
    }
}
