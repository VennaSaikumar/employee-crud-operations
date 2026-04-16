package com.nit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtServcie;

@Controller
public class EmployeeOperationsController {

    @Autowired
    private IEmployeeMgmtServcie empService;

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/report")
    public String showEmployeeReport(@PageableDefault(size = 5, sort = "empno") Pageable pageable,
                                     Map<String, Object> map) {
        Page<Employee> page = empService.getAllActiveEmployees(pageable);
        map.put("empsPage", page);
        return "show_employee_report";
    }

    @GetMapping("/emp_add")
    public String showFormForsaveEmployee(@ModelAttribute("emp") Employee emp) {
        return "register_employee";
    }

    @PostMapping("/emp_add")
    public String saveEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
        String msg = empService.registerEmployee(emp);
        attrs.addFlashAttribute("resultMsg", msg);
        return "redirect:/report";
    }

    @GetMapping("/emp_edit")
    public String showEditEmployeeFprmPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
        Employee emp1 = empService.getEmployeeByNo(no);
        if (emp1 != null)
            org.springframework.beans.BeanUtils.copyProperties(emp1, emp);
        return "update_employee";
    }

    @PostMapping("/emp_edit")
    public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {
        String msg = empService.updateEmployee(emp);
        attrs.addFlashAttribute("resultMsg", msg);
        return "redirect:/report";
    }

    @GetMapping("/emp_delete")
    public String deleteEmployee(RedirectAttributes attrs, @RequestParam int no) {
        String msg = empService.deleteEmployeeById(no);
        attrs.addFlashAttribute("resultMsg", msg);
        return "redirect:/report";
    }
}
