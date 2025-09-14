package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayrollTest {

    private Payroll employee;

    @BeforeEach
    void setUp() {
        // Create a Payroll instance before each test
        employee = new Payroll("John Doe", 20.0, 40, 15.0, 25.0, 2, 2);
        // Set static tax rates for consistent testing not really needed
        Payroll.setFederalTaxRate(0.15);
        Payroll.setStateTaxRate(0.05);
        Payroll.setSocialSecurityRate(0.062);
    }

    @Test
    void testGrossPay() {
        double expectedGross = 20.0 * 40; // 800
        assertEquals(expectedGross, employee.calculateGrossPay(), 0.001);
    }

       @Test
    void testGrossPayOvertime() {
        employee.setHoursWorked(70);
        double Normal = 20.0 * 40; // 800
        double Overtime = 20.0 * 30 * 1.5; // 900
        double expectedGross = Normal + Overtime;
        assertEquals(expectedGross, employee.calculateGrossPay(), 0.001);
    }

    @Test
    void testDeductions() {
        double gross = employee.calculateGrossPay();
        double expectedDeductions = gross * 0.062 + gross * 0.15 + gross * 0.05 + 15.0 + 25.0;
        assertEquals(expectedDeductions, employee.calculateDeductions(), 0.001);
    }

    @Test
    void testNetPay() {
        double gross = employee.calculateGrossPay();
        double deductions = employee.calculateDeductions();
        double expectedNet = gross - deductions;
        assertEquals(expectedNet, employee.calculateNetPay(), 0.001);
    }

    @Test
    void testSettersAndGetters() {
        employee.setName("Jane Doe");
        employee.setHourlyRate(25.0);
        employee.setHoursWorked(35);
        employee.setUnionDues(20.0);
        employee.setInsurance(30.0);
        employee.setInsurancePlan(2);

        assertEquals("Jane Doe", employee.getName());
        assertEquals(25.0, employee.getHourlyRate(), 0.001);
        assertEquals(35, employee.getHoursWorked(), 0.001);
        assertEquals(20.0, employee.getUnionDues(), 0.001);
        assertEquals(30.0, employee.getInsurance(), 0.001);
        assertEquals(2, employee.getInsurancePlan(), 0.001);
    }

    @Test
    void testStaticTaxRateChange() {
        Payroll.setFederalTaxRate(0.18);
        Payroll.setStateTaxRate(0.06);
        Payroll.setSocialSecurityRate(0.07);

        double gross = employee.calculateGrossPay();
        double expectedDeductions = gross * 0.07 + gross * 0.18 + gross * 0.06 + 15.0 + 25.0;

        assertEquals(expectedDeductions, employee.calculateDeductions(), 0.001);
    }

}
