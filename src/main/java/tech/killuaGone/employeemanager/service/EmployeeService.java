package tech.killuaGone.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.killuaGone.employeemanager.dao.EmployeeDao;
import tech.killuaGone.employeemanager.exception.UserNotFoundException;
import tech.killuaGone.employeemanager.model.Employee;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeDao.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeDao.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployeeById(id);
    }
}
