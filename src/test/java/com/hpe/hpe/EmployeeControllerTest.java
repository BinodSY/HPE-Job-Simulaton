package com.hpe.hpe;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpe.hpe.controller.EmployeeController;
import com.hpe.hpe.model.Employees;
import com.hpe.hpe.service.EmployeeService;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllEmployees() throws Exception {
        Employees employee1 = new Employees("101", "John", "doe", "doe@gmail.com", "developer1");

        when(employeeService.getallEmployee()).thenReturn(List.of(employee1));

        mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employee_id").value("101"))
                .andExpect(jsonPath("$[0].first_name").value("John"));
    }

    @Test
    void getEmployeeById() throws Exception {
        Employees employee = new Employees("202", "Alice", "Smith", "alice@ex.com", "manager");

        when(employeeService.getEmployeeById("202")).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/202")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("202"))
                .andExpect(jsonPath("$.first_name").value("Alice"))
                .andExpect(jsonPath("$.title").value("manager"));
    }

    @Test
    void createEmployee() throws Exception {
        Employees request = new Employees("303", "Bob", "Jones", "bob@ex.com", "tester");
        Employees created = new Employees("303", "Bob", "Jones", "bob@ex.com", "tester");

        when(employeeService.createEmployee(org.mockito.ArgumentMatchers.any(Employees.class))).thenReturn(created);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("303"))
                .andExpect(jsonPath("$.email").value("bob@ex.com"));
    }

    @Test
    void updateEmployee() throws Exception {
        Employees updateDetails = new Employees(null, "Carol", "White", "carol@ex.com", "lead");
        Employees updated = new Employees("404", "Carol", "White", "carol@ex.com", "lead");

        when(employeeService.updateEmployee(org.mockito.ArgumentMatchers.eq("404"), org.mockito.ArgumentMatchers.any(Employees.class))).thenReturn(updated);

        mockMvc.perform(MockMvcRequestBuilders.put("/employees/404")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDetails)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employee_id").value("404"))
                .andExpect(jsonPath("$.first_name").value("Carol"));
    }

    @Test
    void deleteEmployee() throws Exception {
        when(employeeService.deleteEmployee("505")).thenReturn("Deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/505")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Deleted successfully"));
    }
}
