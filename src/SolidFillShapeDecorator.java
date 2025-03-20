import java.util.Locale;

public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;
    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }
    public String toSvg(String additional){
        return super.toSvg(String.format(Locale.US, "fill=\"%s\" %s ", color, additional));
    }
}
