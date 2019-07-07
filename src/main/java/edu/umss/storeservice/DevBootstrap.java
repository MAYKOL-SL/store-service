/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import edu.umss.storeservice.model.*;
import edu.umss.storeservice.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryService categoryService;
    private ContractService contractService;
    private EmployeeService employeeService;
    private ExpenseService expenseService;
    private FeatureInstanceService featureInstanceService;
    private FeatureService featureService;
    private ItemInstanceService itemInstanceService;
    private ItemService itemService;
    private PositionService positionService;
    private SaleService saleService;
    private SubCategoryService subCategoryService;
    private ExpenseTypeService expenseTypeService;

    public DevBootstrap(CategoryService categoryService, ContractService contractService,
                        EmployeeService employeeService, ExpenseService expenseService,
                        FeatureInstanceService featureInstanceService, FeatureService featureService,
                        ItemInstanceService itemInstanceService, ItemService itemService, PositionService positionService,
                        SaleService saleService, SubCategoryService subCategoryService,
                        ExpenseTypeService expenseTypeService) {
        this.categoryService = categoryService;
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.expenseService = expenseService;
        this.featureInstanceService = featureInstanceService;
        this.featureService = featureService;
        this.itemInstanceService = itemInstanceService;
        this.itemService = itemService;
        this.positionService = positionService;
        this.saleService = saleService;
        this.subCategoryService = subCategoryService;
        this.expenseTypeService = expenseTypeService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // MAQUINARIA category
        Category maquinariaCategory = new Category();
        maquinariaCategory.setCode("MAQ");
        maquinariaCategory.setName("MAQUINARIA");
        categoryService.save(maquinariaCategory);

        // TRACTOR subcategory
        SubCategory tractorSubCategory = new SubCategory();
        tractorSubCategory.setCategory(maquinariaCategory);
        tractorSubCategory.setCode("TRA");
        tractorSubCategory.setName("TRACTOR");
        subCategoryService.save(tractorSubCategory);

        // MOTOCULTOR subcategory
        SubCategory motocultorSubCategory = new SubCategory();
        motocultorSubCategory.setCategory(maquinariaCategory);
        motocultorSubCategory.setCode("MOT");
        motocultorSubCategory.setName("MOTOCULTOR");
        subCategoryService.save(motocultorSubCategory);

        // Taller category
        Category tallerCategory = new Category();
        tallerCategory.setCode("TAL");
        tallerCategory.setName("TALLER");
        categoryService.save(tallerCategory);


        // montacarga subcategory
        SubCategory montacargaSubCategory = new SubCategory();
        montacargaSubCategory.setCategory(maquinariaCategory);
        montacargaSubCategory.setCode("MON");
        montacargaSubCategory.setName("MONTACARGA");
        subCategoryService.save(montacargaSubCategory);

        //FEATURE
        Feature featureTractorKubota10 = new Feature();
        featureTractorKubota10.setName("Feature tractor Kubota 10");
        featureTractorKubota10.setCreatedAt(new Date());
        featureTractorKubota10.setVersion(0);
        featureService.save(featureTractorKubota10);

        Feature featureTractorKubota20 = new Feature();
        featureTractorKubota20.setName("Feature tractor Kubota 20");
        featureTractorKubota20.setCreatedAt(new Date());
        featureTractorKubota20.setVersion(0);
        featureService.save(featureTractorKubota20);

        Feature featureMotocultor = new Feature();
        featureMotocultor.setName("Feature motocultor");
        featureMotocultor.setCreatedAt(new Date());
        featureMotocultor.setVersion(0);
        featureService.save(featureMotocultor);

        Feature featureMontacargaMitsubishi2T = new Feature();
        featureMontacargaMitsubishi2T.setName("Feature Monta carga Mitsubishi 2T");
        featureMontacargaMitsubishi2T.setCreatedAt(new Date());
        featureMontacargaMitsubishi2T.setVersion(0);
        featureService.save(featureMontacargaMitsubishi2T);

        // tractorKubota10 Item
        Item tractorKubota10 = saveItem(tractorSubCategory, "TRACTOR-K-10", "Tractor Kubota 10.5 Hp",
                "Tractor útil para arado en superficies regulares sin pendientes pronunciadas. Modelo JB11XA, Con " +
                        "Rotocultor, Diesel, 4x4, 10,5 HP. Año 2015");
        saveItemInstance(tractorKubota10, true);

        // tractorKubota20 Item
        Item tractorKubota20 = saveItem(tractorSubCategory, "TRACTOR-K-20", "Tractor kubota con pala 20Hp",
                "Tractor útil para arado en superficies con pendientes pronunciadas, para situaciones de alto " +
                        "esfuerzo. Modelo L1-20DT, Con Rotocultor, Diesel 4x4, 20 HP, Con Pala.");
        saveItemInstance(tractorKubota20, false);


        // motocultor Item
        Item motocultor = saveItem(motocultorSubCategory, "MOT-M-3", "Motocultor yanmar 250",
                "Motocultor útil para arado en superficies de dificil acceso, con espacios reducidos, para " +
                        "situaciones de alto esfuerzo. Arado De Mano Modelo YC80, Diesel.");
        saveItemInstance(motocultor, false);

        // montacargaMitsubishi2T Item
        Item montacargaMitsubishi2T = saveItem(montacargaSubCategory, "MON-M-2T", "Montacarga",
                "Hechos pensados en la industria donde la exigencia del equipo es frecuente. Komatsu BOBLE, ALTURA " +
                        "ELEVANTE 3,0 MTS");
        saveItemInstance(montacargaMitsubishi2T, false);

        // Employee Employee
        Employee john = new Employee();
        john.setFirstName("Pepito");
        john.setLastName("Perez");

        // Position
        Position position = new Position();
        position.setName("CHAPERO");
        positionService.save(position);

        // contract
        Contract contract = new Contract();
        contract.setEmployee(john);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.MARCH, 10);
        contract.setInitDate(calendar.getTime());
        contract.setPosition(position);

        john.getContracts().add(contract);
        employeeService.save(john);
        //contractService.save(contract);

        //FEATURE INTANCE CREATE
        FeatureInstance featureInstance1 = new FeatureInstance();
        featureInstance1.setItem(tractorKubota10);
        featureInstance1.setFeature(featureTractorKubota10);
        featureInstance1.setValue("FEATURE NEW TRACTOR 10");
        featureInstance1.setCreatedAt(new Date());
        featureInstanceService.save(featureInstance1);

        FeatureInstance featureInstance2 = new FeatureInstance();
        featureInstance2.setItem(tractorKubota20);
        featureInstance2.setFeature(featureTractorKubota20);
        featureInstance2.setValue("FEATURE NEW TRACTO 20");
        featureInstance2.setCreatedAt(new Date());
        featureInstanceService.save(featureInstance2);

        FeatureInstance featureInstance3 = new FeatureInstance();
        featureInstance3.setItem(montacargaMitsubishi2T);
        featureInstance3.setFeature(featureMontacargaMitsubishi2T);
        featureInstance3.setValue("FEATURE NEW MONTACARGA");
        featureInstance3.setCreatedAt(new Date());
        featureInstanceService.save(featureInstance3);

        FeatureInstance featureInstance4 = new FeatureInstance();
        featureInstance4.setItem(motocultor);
        featureInstance4.setFeature(featureMotocultor);
        featureInstance4.setValue("FEATURE NEW MOTOCULTOR");
        featureInstance4.setCreatedAt(new Date());
        featureInstanceService.save(featureInstance4);
    }

    private void saveItemInstance(Item tractorKubota10, boolean featured) {
        ItemInstance itemInstance = new ItemInstance();
        itemInstance.setFeatured(featured);
        itemInstance.setItem(tractorKubota10);
        itemInstanceService.save(itemInstance);

        saveExpense(itemInstance);
    }

    private Item saveItem(SubCategory tractorSubCategory, String code, String name, String description) {
        Item item = new Item();
        item.setCode(code);
        item.setName(name);
        item.setDescription(description);
        item.setSubCategory(tractorSubCategory);

        return itemService.save(item);
    }

    private void saveExpense(ItemInstance instance) {
        Expense expenseInstance = new Expense();
        expenseInstance.setItemInstance(instance);
        expenseService.save(expenseInstance);

        saveExpenseType(expenseInstance);
    }

    private void saveExpenseType(Expense expense) {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setExpense(expense);
        expenseTypeService.save(expenseType);
    }
}
