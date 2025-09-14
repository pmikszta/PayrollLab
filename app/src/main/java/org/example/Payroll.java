package org.example;

public class Payroll {

    // Instance Fields
    private String Name;
    private double HourlyRate;
    private double HoursWorked;
    private double UnionDues;
    private double Insurance;
    private int Dependants;
    private int InsurancePlan;

    // Static Fields (shared across all employees)
    private static double FederalTaxRate = 0.15;     // 15%
    private static double StateTaxRate = 0.05;       // 5%
    private static double SocialSecurityRate = 0.062; // 6.2%

    // Constructor
    public Payroll(String Name, double HourlyRate, double HoursWorked,
                   double UnionDues, double Insurance, int Dependants, int InsurancePlan) {
        this.Name = Name;
        this.HourlyRate = HourlyRate;
        this.HoursWorked = HoursWorked;
        this.UnionDues = UnionDues;
        this.Insurance = Insurance;
        this.Dependants = Dependants;
        this.InsurancePlan = InsurancePlan;
    }

    // Getters and Setters
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }

    public double getHourlyRate() { return HourlyRate; }
    public void setHourlyRate(double HourlyRate) { this.HourlyRate = HourlyRate; }

    public double getHoursWorked() { return HoursWorked; }
    public void setHoursWorked(double HoursWorked) { this.HoursWorked = HoursWorked; }

    public double getUnionDues() { return UnionDues; }
    public void setUnionDues(double UnionDues) { this.UnionDues = UnionDues; }

    public double getInsurance() { return Insurance; }
    public void setInsurance(double Insurance) { this.Insurance = Insurance; }

    public int getDependants() { return Dependants; }
    public void setDependants(int Dependants) { this.Dependants = Dependants; }

    public int getInsurancePlan() { return InsurancePlan; }
    public void setInsurancePlan(int InsurancePlan) { this.InsurancePlan = InsurancePlan; }

    // Static getters and setters for tax rates
    public static double getFederalTaxRate() { return FederalTaxRate; }
    public static void setFederalTaxRate(double rate) { FederalTaxRate = rate; }

    public static double getStateTaxRate() { return StateTaxRate; }
    public static void setStateTaxRate(double rate) { StateTaxRate = rate; }

    public static double getSocialSecurityRate() { return SocialSecurityRate; }
    public static void setSocialSecurityRate(double rate) { SocialSecurityRate = rate; }


    // Method to calculate gross pay accounts for overtime with If statement
    public double calculateGrossPay() { 
        if (HoursWorked > 40) {
            double Remainder = HoursWorked - 40;
            double NormalPay = 40 * HourlyRate;
            double OvertimePay = Remainder * HourlyRate * 1.5;
            return OvertimePay + NormalPay;
        } else {
            return HoursWorked * HourlyRate;
        }    
    }

    // Method to calculate deductions
    public double calculateDeductions() {
        double grossPay = calculateGrossPay();
        double socialSecurity = grossPay * SocialSecurityRate;
        double federalTax = grossPay * FederalTaxRate;
        double stateTax = grossPay * StateTaxRate;

        return socialSecurity + federalTax + stateTax + UnionDues + Insurance;
    }

    // Method to for getting inscurance 
    public String calculateInsurancePlan() {
     if (InsurancePlan == 1) {
            return "no plan";
        } else if (InsurancePlan == 2) {
            return "single plan";
        } else if (InsurancePlan == 3) {
            return "married plan";
        } else if (InsurancePlan == 4) {
            return "married with children plan";
        } else {
            return "Error: unknown plan";
    }


    }

    // Method to calculate net pay
    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeductions();
    }

    // Method to display payroll info with breakdown
    public void displayPayroll() {
        
        double grossPay = calculateGrossPay();
        double socialSecurity = grossPay * SocialSecurityRate;
        double federalTax = grossPay * FederalTaxRate;
        double stateTax = grossPay * StateTaxRate;
        double totalDeductions = calculateDeductions();


        System.out.println("Payroll File");
        System.out.println("Employee Name: " + Name);
        System.out.println("Number Of Depenants: " + Dependants);
        System.out.println("Hours Worked: " + HoursWorked);
        System.out.println("Hourly Rate: $" + HourlyRate);
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Deductions:");
        System.out.println("  Social Security: $" + socialSecurity);
        System.out.println("  Federal Tax: $" + federalTax);
        System.out.println("  State Tax: $" + stateTax);
        System.out.println("  Union Dues: $" + UnionDues);
        System.out.println("  Insurance: $" + Insurance);
        System.out.println("Total Deductions: $" + totalDeductions);
        System.out.println("Net Pay: $" + calculateNetPay() );
        System.out.println("Insurance Plan: " + calculateInsurancePlan());


    }
}
