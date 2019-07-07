/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Feature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeatureRepository extends GenericRepository<Feature> {
    @Query("select item from Feature item where item.id = :id")
    Feature findFeature(@Param("id") Long id);
}
  