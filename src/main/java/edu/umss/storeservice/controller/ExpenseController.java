package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ExpenseDto;
import edu.umss.storeservice.dto.ExpenseInput;
import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.ExpenseType;
import edu.umss.storeservice.service.ExpenseService;
import edu.umss.storeservice.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author: Miguel A. Quispe Santos
 */

@RestController
@RequestMapping("/expense")
public class ExpenseController extends GenericController<Expense, ExpenseDto> {
    private ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @PutMapping(value = "/update/{id}")
    public ExpenseType updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseInput input) throws IOException {
        return service.uploadExpense(id, input);
    }
}