import java.util.Scanner;

public class Comissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String city = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());
        double commission = 0;
        boolean isWrong = false;

        if(city.equals("Sofia")){
            if(sales > 0 && sales <= 500){
                commission = sales * 0.05;
            } else if(sales > 500 && sales <= 1000){
                commission = sales * 0.07;
            } else if(sales > 1000 && sales <= 10000){
                commission = sales * 0.08;
            } else if(sales > 10000){
                commission = sales * 0.12;
            } else {
                isWrong = true;
            }
        } else if(city.equals("Varna")){
            if(sales > 0 && sales <= 500){
                commission = sales * 0.045;
            } else if(sales > 500 && sales <= 1000){
                commission = sales * 0.075;
            } else if(sales > 1000 && sales <= 10000){
                commission = sales * 0.1;
            } else if(sales > 10000){
                commission = sales * 0.13;
            } else {
                isWrong = true;
            }
        } else if (city.equals("Plovdiv")){
            if(sales > 0 && sales <= 500){
                commission = sales * 0.055;
            } else if(sales > 500 && sales <= 1000){
                commission = sales * 0.08;
            } else if(sales > 1000 && sales <= 10000){
                commission = sales * 0.12;
            } else if(sales > 10000){
                commission = sales * 0.145;
            } else {
                isWrong = true;
            }
        } else {
            isWrong = true;
        }

        if(isWrong == false){
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("error");
        }
    }
}
