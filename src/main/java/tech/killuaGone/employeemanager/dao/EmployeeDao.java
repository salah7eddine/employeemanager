package tech.killuaGone.employeemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.killuaGone.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
