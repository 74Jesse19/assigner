package org.launchcode.assigner.models.data;


import org.launchcode.assigner.models.FileAssigner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FileAssignerDao extends CrudRepository<FileAssigner, Integer> {
}