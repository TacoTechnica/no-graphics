//package graphics;

// meant to mimick java.awt.graphics
public class Graphics {

    private BufferedText image;

    private ShellColor color;
    private char character;

    public Graphics(BufferedText image) {
        this.image = image;
        this.color = ShellColor.BLACK;
        this.character = 'B';
    
    }

    // draws image to our image
    public void drawImage(BufferedText image, int x, int y) {
        for(int xx = x; 
                xx < (this.image.getWidth()) && (xx - x) < image.getWidth(); 
                xx++) {
            for(int yy = y; 
                    yy < (this.image.getHeight()) && (yy - y) < image.getHeight(); 
                    yy++) {
                this.image.setPixel(xx,yy, image.getPixel(xx - x, yy - y));
        
            }
        }
    }

    // sets current draw character for drawing shapes
    public void setCharacter(char character) {
        this.character = character;
    }

    // sets current draw color for drawing shapes
    public void setColor(ShellColor color) {
        this.color = color;
    }

    // draws rectangle using our color and our character
    public void fillRect(int x, int y, int width, int height) {
        for(int xx = x; xx < image.getWidth() && (xx - x) < width; xx++) {
            for(int yy = y; yy < image.getHeight() && (yy - y) < height; yy++) {
                image.setPixel(xx,yy, new Pixel(character, color));
            }
        }
    }

}
