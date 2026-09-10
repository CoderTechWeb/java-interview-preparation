package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(29, "def", 32, 646, "M", "IT", "Bengaluru", 2011, 14, "Manager"));
        empList.add(new Employee(11, "kyl", 33, 433, "M", "HR", "Hyderabad", 2022, 3, "Manager"));
        empList.add(new Employee(12, "gfh", 34, 120, "F", "Sales", "Bengaluru", 2017, 8, "Sales"));
        empList.add(new Employee(13, "whj", 35, 323, "M", "Sales", "Chennai", 2013, 12, "HR"));
        empList.add(new Employee(14, "wej", 36, 233, "M", "HR", "Coimbatore", 2014, 11, "HR"));

        empList.add(new Employee(5, "web", 21, 323, "M", "IT", "Pune", 2011, 14, "SDE-3"));
        empList.add(new Employee(3, "fbw", 20, 332, "M", "IT", "Trivandam", 2022,3, "SDE-2"));
        empList.add(new Employee(2, "weh", 22, 900, "F", "IT", "Pune", 2016, 9, "SDE-3"));
        empList.add(new Employee(19, "ehw", 28, 222, "F", "IT", "Trivandam", 2011,14,"DevOps Engineer"));

        List<Employee> employeeByCityAndGender = getEmployeeByCityAndGender(empList, "bengaluru", "m");
        findDuplicateChar();
    }

    public static List<Employee> getEmployeeByCityAndGender(List<Employee> empList, String city, String gender){
        return empList.stream().filter(e -> (e.getGender().equalsIgnoreCase(gender)
                && e.getCity().equalsIgnoreCase(city))).collect(Collectors.toList());
    }

    //Given a list of integers, separate the odd and even numbers from the list
    public static void getOddAndEvenNumber(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> even = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());

        List<Integer> odd = numbers.stream().filter(n->n%2 != 0).collect(Collectors.toList());

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    //Find Average age of Male and Female Employees from Employee List.
    public static Map<String, Double> AvgAgeOfEmp(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
    }

    //Sort an Employee List by age and name.
    public static List<Employee> sortEmpByAgeAndName(List<Employee> empList) {
        return empList.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName)).collect(Collectors.toList());
    }

    //Find the number of employees in the organization
    public static long getNumberEmployee(List<Employee> empList) {
        return empList.stream().count();
    }

    //Find the youngest female employee in the organization
    public static Employee getYoungestFemailEmp(List<Employee> empList) {
       return empList.stream().filter(e->e.getGender().equalsIgnoreCase("F"))
               .min(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    //Find second highest paid salary Employee based on department.
    public static Map<String, Employee> findSecondHighestSalaryEmployeeByDepartment(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list-> list.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().orElse(null))));
    }


    //Find highest salaried employee based on department.
    public static Map<String, Optional<Employee>> findHighestSalaryEmployeeByDepartment(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
    }

    //Find highest paid salary Employee in the organization based on gender
    public static Map<String, Optional<Employee>> findHighestPaidEmployeeByGender(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
    }

    //Sort the employees by salary in each department in ascending order
    public static Map<String, List<Employee>> sortEmpBySal(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparing(Employee::getSalary)).toList())));
    }

    //Find names of all the departments in the organization
    public static List<String> getAllDeptName(List<Employee> empList) {
        return empList.stream().map(Employee::getDeptName).distinct().toList();
    }

    //Find oldest Employee by age from the Employee List.
    public static Employee oldestEmp(List<Employee> empList) {
        return empList.stream().min(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    //Group Employees by city from the Employee List
    public static Map<String,List<Employee>> groupByCity(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getCity));
    }

    //find out all the duplicates characters from a string.
    public static void findDuplicateChar(){
        String inputString = "java is a awesome programming language";
        Set<Character> set = new HashSet<>();
        Set<Character> collect = inputString.chars().mapToObj(c -> (char) c).filter(c -> !set.add(c)).collect(Collectors.toSet());
        collect.forEach(System.out::println);

    }

    //check if two strings are anagrams or not
    public static void checkAnagram(){
        String s1 = "saurav";
        String s2 = "vauras1";

        List<String> list = Arrays.stream(s1.split("")).sorted().toList();
        List<String> list1 = Arrays.stream(s2.split("")).sorted().toList();
        System.out.println(list.equals(list1));
    }

    //find max and min
    public static void findMaxAndMin(){
        List<Integer> listOfIntegers = Arrays.asList(89,212,11,10,21,12,34,90);
        listOfIntegers.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);
        listOfIntegers.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

    }

    //Given a list of strings, find out those strings which start with a number
    public static List<String> startWithNumber(){
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "6ix","45ro,'7ko");
        return listOfStrings.stream().filter(ch->Character.isDigit(ch.charAt(0))).toList();
    }

    //Sum of all digits of a number
    public static long sumOfNumber() {
        int n = 6786567;
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
    }

    //Find first non-repeating character in a string
    public static Character firstNonRepeatedCharacter(){
        String str = "java is a just a awesome programming language and it's platform independent";
        LinkedHashMap<Character, Long> map = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        return map.entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    //Find the last element from a list
    public static String lastElement(){
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");
        return list.stream().skip(list.size() - 1).findFirst().get();
    }

    //Find frequency of each element in a list?
    public static Map<String, Long> findFreqOfElement(){
        List<String> list= Arrays.asList("Java", "Ruby", "C#", "Java", "Kotlin", "Ruby", "C++", "COBOL", "C#");

        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    //Remove duplicate elements from a list using Java 8 streams
    public static List<String> removeDuplicateElement(){
        List<String> list= Arrays.asList("Java", "Ruby", "C#", "Java", "Kotlin", "Ruby", "C++", "COBOL", "C#");

        return list.stream().distinct().toList();

    }

    //sort the given list in the reverse order
    public static List<Double> reverseList(){
        List<Double> decimalList = Arrays.asList(12.45,9.81,45.9,12.7,89.90,34.56,11.3);
        return decimalList.stream().sorted().toList();
    }

    //Given a list of integers, separate the odd and even numbers from the list
    public static void getOddAndEven(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(number -> number % 2 == 0));
        List<Integer> even = collect.get(true);
        List<Integer> odd = collect.get(false);

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    //find frequency of each character in a string
    public static Map<Character, Long> getFreq() {
        String str = "Java ";

        Stream<Character> charStream = str.chars().mapToObj(c -> (char) c);
        return charStream.filter(c->!Character.isWhitespace(c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //Group employees by department and city, then find average salary and max salary in each group
    public static void getSalaryStatsByDeptAndCity(List<Employee> empList) {
        Map<String, Map<String, DoubleSummaryStatistics>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.groupingBy(Employee::getCity, Collectors.summarizingDouble(Employee::getSalary))));

        collect.forEach((dept, stats)->{
            System.out.println("Dept: " + dept);

            stats.forEach((city, summary)->{
                System.out.println("City: " + city);
                System.out.println("Average salary is : " + summary.getAverage());
                System.out.println("Max salary is: " + summary.getMax());
                System.out.println("----------------");
            });
        });

    }

    //Find a list of employees from each department whose salary is higher than the average salary of that department
    public static Map<String, List<Employee>> getEmployeesAboveDeptAverageSalary(List<Employee> empList) {
        Map<String, Double> avgSalaryByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.averagingDouble(Employee::getSalary)));

        Map<String, List<Employee>> result = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptName,
                        Collectors.filtering(
                                emp -> emp.getSalary() > avgSalaryByDept.get(emp.getDeptName()),
                                Collectors.toList()
                        )
                ));

        return result;

    }

    //Find the total salary of the paid in the organization where salary paid > 400
    public static long findTotalSalGrtThan(List<Employee> empList, int n) {
        return empList.stream().map(Employee::getSalary)
                .filter(salary -> salary > n).reduce(0L,(a, b) -> a + b);
    }


    //Find the nth Highest salary of the organization
    public static long FindNHighestSalary(List<Employee> empList, int n) {
        return empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(n - 1).findFirst().get().getSalary();
    }


    //Find average salary of each department
    public static Map<String, Double>  findAvgSalaryOfDept(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Fnd the number of Male and Female employees in each department.
    public static  Map<String, Map<String, Long>>  findNumberOfMaleAndFemailinEachDept(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.groupingBy(Employee::getGender, Collectors.counting())));
    }

    //Find average and total salary of the organization.
    public static List<Double> findAvgAndTotalSalOfOrg(List<Employee> empList) {
        double sum = empList.stream().mapToDouble(Employee::getSalary).sum();
        double average = empList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        return List.of(sum, average);
    }

    //Find if there are any employees from IT Department.
    public static List<Employee> findEmployeesFromITDepartment(List<Employee> empList) {
        return empList.stream().filter(e->e.getDeptName().equalsIgnoreCase("IT")).toList();
    }

    //Find all employees who lives in ‘Bengaluru’ city, sort them by their name and return the names of the employees.
    public static List<String> findEmployeeNamesByCitySorted(List<Employee> empList) {
       return empList.stream().filter(e->e.getCity().equalsIgnoreCase("Bengaluru"))
               .sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).toList();
    }

    //Find Highest experienced employee in the organization.
    public static Employee getHigeshtExp(List<Employee> empList) {
        return empList.stream().max(Comparator.comparing(Employee::getTotalExp)).orElse(null);
    }

    //Find the names of the departments that have more than three employees
    public static List<String> getNameofDepartMoreThanThreeEmp(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>3).map(Map.Entry::getKey).toList();
    }

    //Find maximum age of an Employee from Employee List
    public static int getMaximumAgeOfEmployee(List<Employee> empList) {
         return empList.stream().max(Comparator.comparing(Employee::getAge)).get().getAge();
    }

    //Find the department name which has the highest number of employees.
    public static Map.Entry<String, Long> getDepartWithHighestNumberOfEmp(List<Employee> empList) {
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

}