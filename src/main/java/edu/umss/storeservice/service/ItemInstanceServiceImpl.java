/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.ItemInstanceInput;
import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemInstanceRepository;
import edu.umss.storeservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ItemInstanceServiceImpl extends GenericServiceImpl<ItemInstance> implements ItemInstanceService {
    private final ItemInstanceRepository repository;
    private final ItemRepository itemRepository;

    public ItemInstanceServiceImpl(ItemInstanceRepository repository, ItemRepository itemRepository) {
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    @Override
    protected GenericRepository<ItemInstance> getRepository() {
        return repository;
    }


    public ItemInstance uploadItemInstance(Long id, ItemInstanceInput instance){
        Optional<Item> item = itemRepository.findById(id);
        ItemInstance itemInstance = repository.findItemInstance(item);

        itemInstance.setIdentifier(instance.getIdentifier());
        itemInstance.setPrice(instance.getPrice());
        itemInstance.setUpdatedAt(new Date());
        itemInstance.setVersion(instance.getVersion());

        ItemInstance result = repository.save(itemInstance);
        return result;
    }
}
