package com.messages.controller;

import com.messages.entity.Employee;
import com.messages.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/employee")
    public String view(Model model){
        model.addAttribute("listEmp", iEmployeeService.getAllEmployee());
        return "home";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee  = new Employee();
        model.addAttribute("employee", employee);
        return "add";
    }

    @PostMapping("/employee")
    public String save(@ModelAttribute("employee") Employee employee){
        iEmployeeService.saveEmp(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable (value = "id") long id, Model model){
        Employee employee  = iEmployeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") long id){
        this.iEmployeeService.delteEmpById(id);
        return "redirect:/employee";
    }

}
