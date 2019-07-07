/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.ExpenseInput;
import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.repository.ExpenseRepository;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemInstanceRepository;
import edu.umss.storeservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseServiceImpl extends GenericServiceImpl<Expense> implements ExpenseService {

    private final ItemRepository itemRepository;
    private final ItemInstanceRepository itemInstanceRepository;
    private final ExpenseRepository expenseRepository;


    public ExpenseServiceImpl(ItemInstanceRepository itemInstanceRepository, ItemRepository itemRepository, ExpenseRepository expenseRepository) {
        this.itemInstanceRepository = itemInstanceRepository;
        this.itemRepository = itemRepository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    protected GenericRepository<Expense> getRepository() {
        return expenseRepository;
    }

    public Expense uploadExpense(Long id, ExpenseInput instance) {
        Optional<Item> item = itemRepository.findById(id);
        ItemInstance itemInstance = itemInstanceRepository.findItemInstance(item);
        Expense expense = expenseRepository.findExpense(itemInstance);

        expense.setDescription(instance.getDescription());
        expense.setValue(instance.getValue());
        expense.setExpenseType(instance.getExpenseType());

        Expense expenseInstance = expenseRepository.save(expense);

        return expenseInstance;
    }
}
