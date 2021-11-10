package shapes;

public class Rectangle extends Shape{
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    public Double calculatePerimeter() {
        if(super.getPerimeter() == null){
            super.setPerimeter(2 * this.height + 2 * this.width);
        }
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if(super.getArea() == null){
            super.setArea(this.width * this.height);
        }

        return super.getArea();
    }
}
