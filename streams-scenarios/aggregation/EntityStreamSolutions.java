package aggregation;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityStreamSolutions {

    // --- Domain Entities ---
    public record Student(int id, String name, int age, String gender, String dept, double marks, int rank) {}
    public record Employee(int id, String name, int age, String gender, String dept, double salary, LocalDate joiningDate) {}
    public record City(String name, String state, String country, long population) {}

    // ==========================================
    // STREAMS 26-35: STUDENT DATA SCENARIOS
    // ==========================================

    // 26. Find all students scoring above 75%
    public static List<Student> studentsWithMarksAbove75(List<Student> students) {
        return students.stream()
                .filter(s -> s.marks() > 75.0)
                .toList();
    }

    // 27. Group students by department
    public static Map<String, List<Student>> groupStudentsByDept(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::dept));
    }

    // 28. Find highest rank (rank = 1) in each department
    public static Map<String, Optional<Student>> highestRankPerDept(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::dept,
                        Collectors.minBy(Comparator.comparingInt(Student::rank))
                ));
    }

    // 29. Average marks by gender
    public static Map<String, Double> averageMarksByGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::gender,
                        Collectors.averagingDouble(Student::marks)
                ));
    }

    // 30. Count students in each department
    public static Map<String, Long> countStudentsByDept(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::dept, Collectors.counting()));
    }

    // 31. Find students younger than 20
    public static List<Student> studentsYoungerThan20(List<Student> students) {
        return students.stream()
                .filter(s -> s.age() < 20)
                .toList();
    }

    // 32. Sort students by rank ascending, then by name
    public static List<Student> sortStudentsByRankAndName(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::rank)
                        .thenComparing(Student::name))
                .toList();
    }

    // 33. Partition students into pass (marks >= 40) and fail
    public static Map<Boolean, List<Student>> partitionPassFail(List<Student> students) {
        return students.stream()
                .collect(Collectors.partitioningBy(s -> s.marks() >= 40.0));
    }

    // 34. Student with highest marks overall
    public static Optional<Student> topStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(Student::marks));
    }

    // 35. Comma-separated student names
    public static String studentNamesSeparatedByComma(List<Student> students) {
        return students.stream()
                .map(Student::name)
                .collect(Collectors.joining(", "));
    }

    // ==========================================
    // STREAMS 36-45: EMPLOYEE DATA SCENARIOS
    // ==========================================

    // 36. Find the highest-paid employee overall
    public static Optional<Employee> highestPaidEmployee(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::salary));
    }

    // 37. Average salary of Male vs Female employees
    public static Map<String, Double> averageSalaryByGender(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::gender,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    // 38. Count number of employees in each department
    public static Map<String, Long> countEmployeesByDept(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()));
    }

    // 39. Highest-paid employee in each department
    public static Map<String, Optional<Employee>> topEarnerPerDept(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary))
                ));
    }

    // 40. Find the second highest salary employee overall
    public static Optional<Employee> secondHighestPaidEmployee(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .skip(1)
                .findFirst();
    }

    // 41. Senior-most employee by joining date
    public static Optional<Employee> seniorMostEmployee(List<Employee> employees) {
        return employees.stream()
                .min(Comparator.comparing(Employee::joiningDate));
    }

    // 42. Department with the maximum number of employees
    public static String departmentWithMostEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
    }

    // 43. Partition employees by Age > 30
    public static Map<Boolean, List<Employee>> partitionEmployeesByAge(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.partitioningBy(e -> e.age() > 30));
    }

    // 44. Salary statistics (sum, avg, min, max) across company
    public static DoubleSummaryStatistics employeeSalaryStats(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
    }

    // 45. Department to List of employee names map
    public static Map<String, List<String>> employeeNamesByDept(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::dept,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
    }

    // ==========================================
    // STREAMS 46-50: CITY DATA SCENARIOS
    // ==========================================

    // 46. Group cities by State
    public static Map<String, List<City>> groupCitiesByState(List<City> cities) {
        return cities.stream()
                .collect(Collectors.groupingBy(City::state));
    }

    // 47. City with the highest population
    public static Optional<City> mostPopulatedCity(List<City> cities) {
        return cities.stream()
                .max(Comparator.comparingLong(City::population));
    }

    // 48. Average population per State
    public static Map<String, Double> averagePopulationPerState(List<City> cities) {
        return cities.stream()
                .collect(Collectors.groupingBy(
                        City::state,
                        Collectors.averagingLong(City::population)
                ));
    }

    // 49. Filter cities starting with a prefix and sort by population descending
    public static List<City> searchCitiesByPrefix(List<City> cities, String prefix) {
        return cities.stream()
                .filter(c -> c.name().toLowerCase().startsWith(prefix.toLowerCase()))
                .sorted(Comparator.comparingLong(City::population).reversed())
                .toList();
    }

    // 50. Top 3 most populated cities overall
    public static List<City> topThreePopulatedCities(List<City> cities) {
        return cities.stream()
                .sorted(Comparator.comparingLong(City::population).reversed())
                .limit(3)
                .toList();
    }
}
