/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ExpenseTypeDto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ExpenseType extends ModelBase<ExpenseTypeDto> {
    private String description;

    @OneToOne
    private Expense expense;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
