/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.ItemInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends GenericRepository<Expense> {
    @Query("select item from Expense item where item.itemInstance = :itemInstance")
    Expense findExpense(@Param("itemInstance") ItemInstance itemInstance);
}
  