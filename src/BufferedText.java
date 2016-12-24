//package graphics;

public class BufferedText {

    private int width, height;
    private Pixel[] image; // See, I could use a 2d array but this is faster

    private Graphics graphics;

    public BufferedText(int width, int height) {
        this.width = width;
        this.height = height;
        image = new Pixel[width * height];
        for(int i = 0; i < image.length; i++) {
            image[i] = new Pixel(' ', ShellColor.NONE);
        }

        graphics = new Graphics(this);
    }

    // gets pixel at a position
    public Pixel getPixel(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) throw new IllegalArgumentException("coordinate out of range: (" + x + "," + y + ").");
        return image[x + (y*width)];
    }

    // sets pixel at a position. Prefferably only used by Graphics
    public void setPixel(int x, int y, Pixel pixel) {
        if (x < 0 || x >= width || y < 0 || y >= height) throw new IllegalArgumentException("coordinate out of range: (" + x + "," + y + ").");
        image[x + (y*width)] = pixel;
    }

    /// Accessors and modifiers
    
    public Pixel[] getImageArray() {
        return image;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
