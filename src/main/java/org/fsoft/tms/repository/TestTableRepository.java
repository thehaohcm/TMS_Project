package org.fsoft.tms.repository;

import org.fsoft.tms.entity.TestTable;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thehaohcm on 5/21/17.
 */
public interface TestTableRepository extends JpaRepository<TestTable,Integer> {

}
