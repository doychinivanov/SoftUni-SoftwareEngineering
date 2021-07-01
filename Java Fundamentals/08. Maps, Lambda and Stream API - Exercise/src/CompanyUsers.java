import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Map<String, List<String>> companiesData = new LinkedHashMap<>();
        String input = scan.nextLine();

        while(input.equals("End") == false){
            String[] inputData = input.split(" -> ");
            String companyName = inputData[0];
            String employeeId = inputData[1];

            companiesData.putIfAbsent(companyName, new ArrayList<>());

            if(companiesData.get(companyName).contains(employeeId) == false){
                companiesData.get(companyName).add(employeeId);
            }

            input = scan.nextLine();
        }

        companiesData
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(company -> {
                    System.out.println(company.getKey());
                    company.getValue().forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
