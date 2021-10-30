package trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrafficLight {
    private List<Light> colors;

    public TrafficLight(){
        this.colors = new ArrayList<>();
    }

    public void addLight(Light light){
        colors.add(light);
    }

    public void changeColor(int amountOfTimes){
        for (int i = 0; i < amountOfTimes; i++) {
            this.rotateColor();

            System.out.println(this.toString());
        }
    }

    private void rotateColor(){
        this.colors = this.colors.stream().map(color -> {
            if (color.equals(Light.GREEN)) {
                return Light.YELLOW;
            } else if (color.equals(Light.RED)) {
                return Light.GREEN;
            }

            return Light.RED;

        }).collect(Collectors.toList());
    }

    @Override
    public String toString(){
        List<String> colorNames = new ArrayList<>();
        this.colors.forEach(color -> colorNames.add(color.name()));

        return String.join(" ", colorNames);
    }
}
