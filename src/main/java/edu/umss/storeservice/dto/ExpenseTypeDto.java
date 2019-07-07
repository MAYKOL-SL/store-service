package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.ExpenseType;

/**
 * @author: Miguel A. Quispe Santos
 */

public class ExpenseTypeDto extends DtoBase<ExpenseType> {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
