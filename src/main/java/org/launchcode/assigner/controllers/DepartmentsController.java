package org.launchcode.assigner.controllers;

import org.launchcode.assigner.models.Departments;
import org.launchcode.assigner.models.data.DepartmentsDao;
import org.launchcode.assigner.models.data.EmployeesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("departments")
public class DepartmentsController {
    @Autowired
    private DepartmentsDao departmentsDao;

    @Autowired
    private EmployeesDao employeesDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("departments", departmentsDao.findAll());
        model.addAttribute("title", "Departments");
        return "departments/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Departments());
        model.addAttribute("title", "Add Department");

        return "departments/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Departments departments, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Department");
            return "departments/add";
        }

        departmentsDao.save(departments);
        return "redirect:";
    }
}