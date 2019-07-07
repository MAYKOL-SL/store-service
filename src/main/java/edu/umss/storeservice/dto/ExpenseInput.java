package edu.umss.storeservice.dto;

/**
 * @author: Miguel A. Quispe Santos
 */

public class ExpenseInput {

    private String expenseType;
    private Long value;
    private String description;

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
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
}
