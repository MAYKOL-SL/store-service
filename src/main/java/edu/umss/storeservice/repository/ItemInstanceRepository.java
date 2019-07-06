/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.ItemInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemInstanceRepository extends GenericRepository<ItemInstance> {
    @Query("select item from ItemInstance item where item.item = :itemId")
    ItemInstance findItemInstance(@Param("itemId") Optional<Item> itemId);

}
  