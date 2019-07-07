/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.FeatureInstance;
import edu.umss.storeservice.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FeatureInstanceRepository extends GenericRepository<FeatureInstance> {
    @Query("select item from FeatureInstance item where item.item = :item")
    FeatureInstance findFeatureInstance(@Param("item") Optional<Item> item);
}
  