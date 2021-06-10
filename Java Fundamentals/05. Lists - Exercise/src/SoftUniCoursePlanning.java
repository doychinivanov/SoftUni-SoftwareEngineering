import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<String> courses = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while(input.equals("course start") == false){
            String[] tokens = input.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];

                if(command.equals("Insert")){
                    if(isInList(lessonTitle, courses) == false){
                        int index = Integer.parseInt(tokens[2]);
                        courses.add(index, lessonTitle);
                    }
                } else if(command.equals("Add")){
                    if(isInList(lessonTitle, courses) == false){
                        courses.add(lessonTitle);
                    }
                } else if(command.equals("Remove")){
                    if(isInList(lessonTitle, courses)){
                        courses.remove(lessonTitle);
                    }
                } else if(command.equals("Swap")){
                    if(isInList(lessonTitle, courses) && isInList(tokens[2], courses)){
                        int firstIndex = courses.indexOf(lessonTitle);
                        int secondIndex = courses.indexOf(tokens[2]);

                        courses.set(firstIndex, tokens[2]);
                        courses.set(secondIndex, lessonTitle);

                        if(courses.contains(tokens[2] + "-Exercise")){
                            int exerciseIndex = courses.indexOf(tokens[2] + "-Exercise");
                            courses.remove(exerciseIndex);
                            courses.add(courses.indexOf(tokens[2]) + 1, tokens[2] + "-Exercise");
                        }
                    }
                } else if(command.equals("Exercise")){
                    if(isInList(lessonTitle, courses) && isInList(lessonTitle+"-Exercise", courses) == false){
                        int index = courses.indexOf(lessonTitle);
                        courses.add(index+1, lessonTitle + "-Exercise");
                    } else if(isInList(lessonTitle, courses) == false){
                        courses.add(lessonTitle);
                        courses.add(lessonTitle + "-Exercise");
                    }
                }


            input = scan.nextLine();
        }

        printList(courses);
    }

    public static boolean isInList(String value, List<String> someList){
        if (someList.contains(value)){
            return true;
        }
        return false;
    }

    public static void printList(List<String> elements){
        int count = 1;
        for(String element: elements){
            System.out.println(count + "." + element);
            count++;
        }
    }
}
