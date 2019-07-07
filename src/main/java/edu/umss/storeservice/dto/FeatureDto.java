package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Feature;
import edu.umss.storeservice.model.ItemInstance;

/**
 * @author: Miguel A. Quispe Santos
 */

public class FeatureDto extends DtoBase<Feature> {

    private String name;
    private ItemInstance itemInstance;

    public ItemInstance getItemInstance() {
        return itemInstance;
    }

    public void setItemInstance(ItemInstance itemInstance) {
        this.itemInstance = itemInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
