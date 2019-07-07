/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.ExpenseInput;
import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.ExpenseType;
import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseServiceImpl extends GenericServiceImpl<Expense> implements ExpenseService {

    private final ItemRepository itemRepository;
    private final ItemInstanceRepository itemInstanceRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseServiceImpl(ItemInstanceRepository itemInstanceRepository,
                              ItemRepository itemRepository,
                              ExpenseRepository expenseRepository,
                              ExpenseTypeRepository expenseTypeRepository) {
        this.itemInstanceRepository = itemInstanceRepository;
        this.itemRepository = itemRepository;
        this.expenseRepository = expenseRepository;
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    protected GenericRepository<Expense> getRepository() {
        return expenseRepository;
    }

    public ExpenseType uploadExpense(Long id, ExpenseInput instance) {
        Optional<Item> item = itemRepository.findById(id);
        ItemInstance itemInstance = itemInstanceRepository.findItemInstance(item);
        Expense expense = expenseRepository.findExpense(itemInstance);
        ExpenseType expenseType = expenseTypeRepository.findExpenseType(expense);

        expense.setDescription(instance.getDescription());
        expense.setValue(instance.getValue());
        expenseRepository.save(expense);

        expenseType.setDescription(instance.getExpenseType());
        ExpenseType result = expenseTypeRepository.save(expenseType);

        return result;
    }
}
