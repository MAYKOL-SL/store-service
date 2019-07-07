/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends GenericRepository<Item> {
    @Query("select item from Item item where item.id = :id")
    Item findItem(@Param("id") Long id);
}
  