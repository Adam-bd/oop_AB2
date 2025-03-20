import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon triangle = new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        });

        Polygon rectangle = new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        });

        Polygon pentagon = new Polygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        });

        Ellipse ellipse = new Ellipse(new Vec2(500, 700), 400, 100);

        SolidFilledPolygon obj1 = new SolidFilledPolygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        }, "red");

        Shape shape1 = new SolidFillShapeDecorator(pentagon, "red");
        Shape shape2 = new SolidFillShapeDecorator(ellipse, "green");
        shape1 = new StrokeShapeDecorator(shape1, "blue", 5.0);
        shape2 = new StrokeShapeDecorator(shape2, "blue", 8.0);

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(pentagon);
        scene.addShape(ellipse);
        scene.addShape(obj1);
        scene.addShape(shape1);
        scene.addShape(shape2);
        scene.save("result.svg");
    }
}
