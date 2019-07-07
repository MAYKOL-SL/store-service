/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ExpenseDto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Expense extends ModelBase<ExpenseDto> {

    private Long value;
    private String description;

    @OneToOne
    private ItemInstance itemInstance;

    public ItemInstance getItemInstance() {
        return itemInstance;
    }

    public void setItemInstance(ItemInstance itemInstance) {
        this.itemInstance = itemInstance;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}