package com.kenedygondim.expense_manager.controller;

import com.kenedygondim.expense_manager.model.ExpenseRegister;
import com.kenedygondim.expense_manager.service.ExpenseManagerService;
import com.kenedygondim.expense_manager.service.XmlConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ExpenseManagerController {
    private final XmlConverterService xmlConverterService;
    private final ExpenseManagerService expenseManagerService;

    @Autowired
    public ExpenseManagerController(XmlConverterService xmlConverterService, ExpenseManagerService expenseManagerService) {
        this.xmlConverterService = xmlConverterService;
        this.expenseManagerService = expenseManagerService;
    }

    @GetMapping("/hello")
    public void printHello () {
        System.out.println("Hello");
    }

    @PostMapping("/file")
    public ResponseEntity<ExpenseRegister> postXmlInfo(@RequestParam("file") MultipartFile xmlFile)  {
        ExpenseRegister response = xmlConverterService.convertXmlToObject(xmlFile);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseRegister>> getAllXmls() {
        return ResponseEntity.ok().body(expenseManagerService.getAllRegisters());
    }
}