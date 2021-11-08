package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();

        this.urls.forEach(url -> {
            if(isValidUrl(url)){
                result.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                result.append("Invalid URL!").append(System.lineSeparator());
            }
        });

        return result.toString();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        this.numbers.forEach(number -> {
            if(isValidNumber(number)){
                result.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                result.append("Invalid number!").append(System.lineSeparator());
            }
        });

        return result.toString();
    }

    private boolean isValidNumber(String phoneNumber){
        boolean result = true;

        for(char character : phoneNumber.toCharArray()) {
            if(!Character.isDigit(character)) {
                result = false;
                break;
            }
        }

        return result;
    }

    private boolean isValidUrl(String url) {
        boolean result = true;

        for(char character : url.toCharArray()) {
            if(Character.isDigit(character)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
