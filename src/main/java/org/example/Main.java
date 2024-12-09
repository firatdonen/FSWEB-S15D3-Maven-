package org.example;
import org.example.entity.Employee;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Done"));
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(3, "jin", "Beam"));
        employees.add(new Employee(2, "John", "Doe"));

        List<Employee>duplicates = findDuplicates(employees);
        System.out.println("Duplicates= "+duplicates);

        Map<Integer, Employee>uniques= findUniques(employees);
        System.out.println("Uniques: "+uniques);

        List<Employee>removeDuplicates= removeDuplicates(employees);
        System.out.println("Removed Dublicates: "+ removeDuplicates);

        }



        public static List<Employee>findDuplicates(List<Employee> employees){
            Set<Employee>seen= new HashSet<>();
            List<Employee>dublicates=new ArrayList<>();
            for(Employee employee :employees){
                if(!seen.add(employee)){
                    dublicates.add(employee);
                }
        }
            return dublicates;
    }

    public static Map<Integer, Employee>findUniques(List<Employee> employees){
    Map<Integer,Employee>uniqueMap=new HashMap<>();
    Set<Integer>dublicateIds=new HashSet<>();
    for(Employee employee:employees){
        if(uniqueMap.containsKey(employee.getId())){
            dublicateIds.add(employee.getId());
            }else{
            uniqueMap.put(employee.getId(),employee);
        }
    }
    for (Integer id:dublicateIds){
        uniqueMap.remove(id);
    }
    return uniqueMap;
    }

    public static List<Employee>removeDuplicates(List<Employee>employees){
            Map<Integer,Employee>uniqueMap=new HashMap<>();
            List<Employee>result= new ArrayList<>();

            for (Employee employee:employees){
                if(uniqueMap.containsKey((employee.getId()))){
                    uniqueMap.remove(employee.getId());
                }else{
                    uniqueMap.put(employee.getId(),employee);
                }
                 }
            result.addAll(uniqueMap.values());
            return result;
    }

}