/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.ExpenseInput;
import edu.umss.storeservice.model.Expense;

public interface ExpenseService extends GenericService<Expense> {
    Expense uploadExpense(Long id, ExpenseInput instance);
}

    