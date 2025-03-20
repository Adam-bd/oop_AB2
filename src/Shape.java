public interface Shape {
    BoundingBox boundingBox();
    String toSvg(String additional);
}
