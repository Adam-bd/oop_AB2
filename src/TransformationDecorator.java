public class TransformationDecorator extends ShapeDecorator{
    private String transform;
    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public String toSvg(String additional){
        return super.toSvg(additional);
    }

    public class Builder {
        private Vec2 translation;
        private Vec2 center;
        private float angle;
        private Vec2 scaleFactor;
        private boolean translate = false;
        private boolean rotate = false;
        private boolean scale = false;

        Builder translate(Vec2 translation){
            this.translation = translation;
            translate = true;
            return this;
        }
        Builder rotate(float angle, Vec2 center){
            this.angle = angle;
            this.center = center;
            rotate = true;
            return this;
        }
        Builder scale(Vec2 scaleFactor){
            this.scaleFactor = scaleFactor;
            scale = true;
            return this;
        }
        TransformationDecorator build(Shape shape){
            TransformationDecorator helper = new TransformationDecorator(shape);
            helper.transform = "";
            if(translate){
                helper.transform += "translate(" + this.translation.x() + " " + this.translation.y() + ") ";
            }else if(rotate){
                helper.transform += "rotate(" + this.center.x() + " " + this.center.y() + ") ";
            }else if(scale){
                helper.transform += "scale(" + this.scaleFactor.x() + " " + this.scaleFactor.y() + ") ";
            }
            return helper;
        }
    }
}
