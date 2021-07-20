import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nameRegex = "(?<name>[A-Za-z])";
        String kmRegex = "(?<km>\\d)";

        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern kmPattern = Pattern.compile(kmRegex);

        List<String> participants = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> participantsData = new LinkedHashMap<>();
        participants.forEach(participant -> participantsData.put(participant, 0));

        String input = scan.nextLine();

        while(input.equals("end of race") == false){
            Matcher matcherName = namePattern.matcher(input);
            Matcher matcherDistance = kmPattern.matcher(input);

            StringBuilder name = new StringBuilder();
            int distance = 0;

            while(matcherName.find()){
                name.append(matcherName.group("name"));
            }

            while (matcherDistance.find()){
                distance += Integer.parseInt(matcherDistance.group("km"));
            }

            if(participantsData.containsKey(name.toString())){
                participantsData.put(name.toString(), participantsData.get(name.toString()) + distance);
            }

            input = scan.nextLine();
        }

        List<String> topParticipantsName = participantsData
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.printf("1st place: %s\n", topParticipantsName.get(0));
        System.out.printf("2nd place: %s\n", topParticipantsName.get(1));
        System.out.printf("3rd place: %s", topParticipantsName.get(2));
    }
}
