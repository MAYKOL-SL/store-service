/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ItemInstanceDto;
import edu.umss.storeservice.dto.ItemInstanceInput;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.ItemInstanceService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/iteminstances")
public class ItemInstanceController extends GenericController<ItemInstance, ItemInstanceDto> {
    private ItemInstanceService service;

    public ItemInstanceController(ItemInstanceService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @PutMapping(value = "/updateiteminstance/{id}")
    public ItemInstance updateItemInstance(@PathVariable("id") Long id,@RequestBody ItemInstanceInput input) throws IOException {
        return service.uploadItemInstance(id, input);
    }
}