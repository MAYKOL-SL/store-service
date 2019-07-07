/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.ExpenseType;
import edu.umss.storeservice.model.ItemInstance;

public class ExpenseDto extends DtoBase<Expense> {

    private Long value;
    private String description;
    private ItemInstance itemInstance;
    private ExpenseType expenseType;

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
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

    public ItemInstance getItemInstance() {
        return itemInstance;
    }

    public void setItemInstance(ItemInstance itemInstance) {
        this.itemInstance = itemInstance;
    }
}
