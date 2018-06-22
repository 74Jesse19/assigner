package org.launchcode.assigner.models.data;

import org.launchcode.assigner.models.Employees;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface EmployeesDao  extends CrudRepository<Employees, Integer> {


}
