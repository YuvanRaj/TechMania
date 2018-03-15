package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
       // System.out.println( "Hello World!" );
    	GenUtil util = new GenUtil();
    	ArrayList<Employee> empList = new ArrayList<Employee>();
    	Employee emp1 = new Employee(1,"Empl");
    	Employee emp2 = new Employee(2,"Empl2");
    	Employee emp3 = new Employee(3,"Empl3");
    	empList.add(emp1);
    	empList.add(emp2);
    	empList.add(emp3);
    	
    	util.performSort("getEmpId", "DESC", empList);
    	
    	for(Employee emp : empList){
    		System.out.println("EmpId "+emp.getEmpId() +"Emp Name "+emp.getEmpName());
    	}
    	
    }
}
