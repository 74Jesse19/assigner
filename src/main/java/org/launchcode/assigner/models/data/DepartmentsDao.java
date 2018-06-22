package org.launchcode.assigner.models.data;

import org.launchcode.assigner.models.Departments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface DepartmentsDao extends CrudRepository<Departments,Integer> {

}
