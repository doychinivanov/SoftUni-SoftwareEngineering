import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
        String input = scan.nextLine();

        while(!input.equals("end")){
            String[] userData = input.split("\\s+");

            String ip = userData[0].split("=")[1];
            String username = userData[2].split("=")[1];

            userLogs.putIfAbsent(username, new LinkedHashMap<>());
            LinkedHashMap<String, Integer> currentUserIps = userLogs.get(username);
            currentUserIps.putIfAbsent(ip, 0);
            currentUserIps.put(ip, currentUserIps.get(ip) + 1);

            input = scan.nextLine();
        }

        userLogs.forEach((username, ips) -> {
            System.out.println(username + ":");
            System.out.println(parseIpOutput(ips));
        });
    }

    public static String parseIpOutput(LinkedHashMap<String, Integer> ips){
        List<String> result = new ArrayList<>();

        ips.forEach((ip, count) ->{
            result.add(String.format("%s => %d", ip, count));
        });

        result.set(result.size()-1, result.get(result.size()-1) + ".");

        return String.join(", ", result);
    }
}
