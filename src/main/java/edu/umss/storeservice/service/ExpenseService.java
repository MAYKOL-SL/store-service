/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.ExpenseInput;
import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.ExpenseType;

public interface ExpenseService extends GenericService<Expense> {
    ExpenseType uploadExpense(Long id, ExpenseInput instance);
}

    