package tek.rscrew.samplitek.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<SampleJPA,Long>{

}
