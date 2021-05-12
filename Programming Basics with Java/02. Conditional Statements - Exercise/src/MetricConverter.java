import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double value = Double.parseDouble(scan.nextLine());
        String initial = scan.nextLine();
        String toConvert = scan.nextLine();
        double result = 0;

        if(initial.equals("m")){
            if(toConvert.equals("cm")){
                result = value * 100;
            } else if (toConvert.equals("mm")){
                result = value * 1000;
            }
        } else if(initial.equals("cm")){
            if(toConvert.equals("m")){
                result = value / 100;
            } else if (toConvert.equals("mm")){
                result = value * 10;
            }
        } else if(initial.equals("mm")){
            if(toConvert.equals("m")){
                result = value / 1000;
            } else if (toConvert.equals("cm")){
                result = value / 10;
            }
        }

        System.out.printf("%.3f", result);
    }
}
