package org.launchcode.assigner.controllers;




import org.launchcode.assigner.models.Departments;
import org.launchcode.assigner.models.Employees;
import org.launchcode.assigner.models.data.DepartmentsDao;
import org.launchcode.assigner.models.data.EmployeesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    private EmployeesDao employeesDao;

    @Autowired
    private DepartmentsDao departmentsDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("Employees", employeesDao.findAll());
        model.addAttribute("title", "Employees" );
        return "employees/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddEmployees(Model model){
        model.addAttribute("title", "Add Employee");
        model.addAttribute(new Employees());
        model.addAttribute("departments", departmentsDao.findAll());
        return "employees/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddEmployees(@ModelAttribute @Valid Employees newEmployee,
                                   Errors errors, @RequestParam int departmentsId, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Employee");
            model.addAttribute(new Employees());
            model.addAttribute("departments", departmentsDao.findAll());
            return "employees/add";
        }
        Departments dep = departmentsDao.findOne(departmentsId);
        newEmployee.setDepartment(dep);
        employeesDao.save(newEmployee);
        return "redirect:";


    }

}
