package trafficLights;


public class Main {
    public static void main(String[] args) {

        String[] colors = Reader.readStringArrFromConsole("\\s+");
        int changeColorCounter = Integer.parseInt(Reader.readLineFromConsole());

        TrafficLight trafficLight = new TrafficLight();

        for (String color: colors) {
            trafficLight.addLight(Light.valueOf(color));
        }

        trafficLight.changeColor(changeColorCounter);
    }
}
