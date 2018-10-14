


public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;

    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy, int bianju) {
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy, bianju);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy, int bianju) {
        if ((x - r - bianju) < minx) {
            x = r + bianju;
            vx = -vx;
        }
        if ((x + r + bianju) >= maxx) {
            x = maxx - r - bianju;
            vx = -vx;
        }
        if ((y - r - bianju) < miny) {
            y = r + bianju;
            vy = -vy;
        }
        if ((y + r + bianju) >= maxy) {
            y = maxy - r - bianju;
            vy = -vy;
        }
    }
}
