/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.ItemInstanceInput;
import edu.umss.storeservice.model.ItemInstance;

public interface ItemInstanceService extends GenericService<ItemInstance> {
    ItemInstance uploadItemInstance(Long id, ItemInstanceInput instance);
}

    