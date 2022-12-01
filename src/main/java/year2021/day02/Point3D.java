package year2021.day02;

public class Point3D {
    private Integer x;
    private Integer y;
    private Integer z;

    public Point3D() {
        this(0, 0, 0);
    }

    public Point3D(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public void translate(Integer x, Integer y, Integer z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void translate(Point3D point3D) {
        translate(point3D.getX(), point3D.getY(), point3D.getZ());
    }

    @Override
    public String toString() {
        return "Point3D[" +
                "x=" + x +
                ",y=" + y +
                ",z=" + z +
                ']';
    }
}
