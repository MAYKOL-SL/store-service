package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.ExpenseType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: Miguel A. Quispe Santos
 */

public interface ExpenseTypeRepository extends GenericRepository<ExpenseType> {
    @Query("select item from ExpenseType item where item.expense = :expense")
    ExpenseType findExpenseType(@Param("expense") Expense expense);
}
  