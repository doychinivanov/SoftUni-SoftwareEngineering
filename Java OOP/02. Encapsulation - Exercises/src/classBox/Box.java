package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box (double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength (double length) {
        if(isLessOrEqualToZero(length)){
            throw new IllegalArgumentException(buildExceptionMessage("Length"));
        }

        this.length = length;
    }

    public void setWidth (double width) {
        if(isLessOrEqualToZero(width)){
            throw new IllegalArgumentException(buildExceptionMessage("Width"));
        }

        this.width = width;
    }

    public void setHeight(double height) {
        if(isLessOrEqualToZero(height)){
            throw new IllegalArgumentException(buildExceptionMessage("Height"));
        }

        this.height = height;
    }

    public double calculateSurfaceArea () {
        return (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea () {
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    public double calculateVolume () {
        return this.length * this.width * this.height;
    }

    private boolean isLessOrEqualToZero(double value) {
        return !(value > 0);
    }

    private String buildExceptionMessage (String type){
        return String.format("%s cannot be zero or negative.", type);
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Surface Area - %.2f", calculateSurfaceArea())).append(System.lineSeparator());
        result.append(String.format("Lateral Surface Area - %.2f", calculateLateralSurfaceArea())).append(System.lineSeparator());
        result.append(String.format("Volume – %.2f", calculateVolume()));

        return result.toString();
    }
}
