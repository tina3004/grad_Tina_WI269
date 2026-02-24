package com.springrestjpa.controllers;

import com.springrestjpa.entities.Employee;
import com.springrestjpa.repos.EmpRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmpControllerTest
{

    @Mock
    private EmpRepo repo;

    @InjectMocks
    private EmpController controller;

    @Test
    void testEmployeeFound()
    {
        // Arrange
        Employee emp = new Employee(1, "John",23,30000,"Tester");

        Mockito.when(repo.findById(1))
                .thenReturn(Optional.of(emp));

        // Act
        ResponseEntity<Employee> response = controller.getEmployee(1);

        // Assert
        Assertions.assertEquals(HttpStatus.valueOf(200), response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getEid());
        Assertions.assertEquals("John", response.getBody().getName());
    }

    @Test
    void testEmployeeNotFound()
    {
        // Arrange
        Mockito.when(repo.findById(2))
                .thenReturn(Optional.empty());

        // Act
        ResponseEntity<Employee> response = controller.getEmployee(2);

        // Assert
        Assertions.assertEquals(HttpStatus.valueOf(204), response.getStatusCode());
        Assertions.assertNull(response.getBody());
    }
}