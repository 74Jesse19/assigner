package org.launchcode.assigner.controllers;




import org.launchcode.assigner.models.Departments;
import org.launchcode.assigner.models.Employees;
import org.launchcode.assigner.models.data.DepartmentsDao;
import org.launchcode.assigner.models.data.EmployeesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "employees")
public class   EmployeeController {

    @Autowired
    private EmployeesDao employeesDao;

    @Autowired
    private DepartmentsDao departmentsDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("employees", employeesDao.findAll());
        model.addAttribute("title", "Employees" );
        return "employees/index";
    }

    @RequestMapping(value="addEmployees", method = RequestMethod.GET)
    public String displayAddEmployees(Model model){
        model.addAttribute("title", "Add Employee");
        model.addAttribute(new Employees());
        model.addAttribute("departments", departmentsDao.findAll());
        return "employees/addEmployees";
    }

    @RequestMapping(value="addEmployees", method = RequestMethod.POST)
    public String processAddEmployees(@ModelAttribute @Valid Employees newEmployee,
                                   Errors errors, @RequestParam int departmentsId, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Employee");
            model.addAttribute(new Employees());
            model.addAttribute("departments", departmentsDao.findAll());
            return "employees/addEmployees";
        }
        Departments dep = departmentsDao.findById(departmentsId).orElse(null);
        newEmployee.setDepartment(dep);
        employeesDao.save(newEmployee);
        return "redirect:";
    }

    @RequestMapping(value = "departments/{id}", method = RequestMethod.GET)
    public String departments(Model model, @PathVariable int id){

        Departments dep = departmentsDao.findById(id).orElse(null);
        List<Employees> employees = dep.getEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("id", dep.getId());
        model.addAttribute("title", "Employees in Department: " + dep.getName());
        return "employees/index";
    }




}
