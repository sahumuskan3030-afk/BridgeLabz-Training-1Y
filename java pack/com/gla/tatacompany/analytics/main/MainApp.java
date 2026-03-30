package com.gla.tatacompany.analytics.main;



import com.gla.tatacompany.analytics.sales.SalesReport;
import com.gla.tatacompany.analytics.hr.EmployeeReport;

    public class MainApp {

        public static void main(String[] args) {

            SalesReport sales = new SalesReport();
            EmployeeReport hr = new EmployeeReport();

            System.out.println("===== Company Analytics Report =====\n");

            sales.showSalesData();
            hr.showEmployeeData();
        }
    }

