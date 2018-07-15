package org.launchcode.assigner.controllers;


import org.launchcode.assigner.models.Departments;
import org.launchcode.assigner.models.Employees;
import org.launchcode.assigner.models.FileAssigner;
import org.launchcode.assigner.models.data.EmployeesDao;
import org.launchcode.assigner.models.data.FileAssignerDao;
import org.launchcode.assigner.models.data.DepartmentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="fileAssigner")
public class FileAssignerController {

    @Autowired
    private FileAssignerDao fileAssignerDao;

    @Autowired
    private DepartmentsDao departmentsDao;

    @Autowired
    private EmployeesDao employeesDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("files", fileAssignerDao.findAll());
        model.addAttribute("title", "Files" );
        return "fileAssigner/index";
    }

    @RequestMapping(value="assign", method=RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Assign Files");
        model.addAttribute("departments", departmentsDao.findAll());
        model.addAttribute("employees", employeesDao.findAll());
        model.addAttribute(new FileAssigner());
        return "fileAssigner/assign";
    }

    @RequestMapping(value="assign", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid FileAssigner fileAssigner, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("title", "Assign Files");
            return "fileAssigner/assign";
        }
        fileAssignerDao.save(fileAssigner);
        return "redirect:assign/" + fileAssigner.getFileNumber();
    }




}
