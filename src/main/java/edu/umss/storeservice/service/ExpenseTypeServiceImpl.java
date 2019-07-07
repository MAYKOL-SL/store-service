package edu.umss.storeservice.service;

import edu.umss.storeservice.model.ExpenseType;
import edu.umss.storeservice.repository.ExpenseTypeRepository;
import edu.umss.storeservice.repository.GenericRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Miguel A. Quispe Santos
 */

@Service
public class ExpenseTypeServiceImpl extends GenericServiceImpl<ExpenseType> implements ExpenseTypeService {
    private final ExpenseTypeRepository repository;

    public ExpenseTypeServiceImpl(ExpenseTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ExpenseType> getRepository() {
        return repository;
    }
}
