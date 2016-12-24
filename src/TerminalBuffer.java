//package graphics;

public class TerminalBuffer {

    // dimensions
    private int width, height;

    // image to draw on and render/show
    private BufferedText image;

    // executes shell commands
    private ExecuteShellCommand shell;

    public TerminalBuffer(int width, int height) {
        this.width = width;
        this.height = height;
    
        image = new BufferedText(width,height);
        shell = new ExecuteShellCommand();
    }

    // Sets up terminal
    public void setup() {
        System.out.println(shell.executeCommand("stty", "-echo")); // disable echo
        System.out.println(shell.executeCommand("printf", "-e","\\e[8;" + height+ ";" + width));
    }

    // resets up terminal after done with everything
    public void close() {
        System.out.println(shell.executeCommand("stty", "echo")); // enable echo
    }

    // clears terminal screen, but does not clear the image
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Shows image to the terminal window
    public void show() {
        String output = "";
        for(int yy = 0; yy < image.getHeight(); yy++) {
            for(int xx = 0; xx < image.getWidth(); xx++) {
                String ch = image.getPixel(xx,yy).getFullCharacter(); 
                //System.out.println(ch);
                output += ch;
            }
            output += "\\n";
        }
        // clear screen then draw
        String result = shell.executeCommand("echo", "-e", output);
        clear();
        System.out.println(result);
    }

    /// Accessors and Modifiers

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedText getImage() {
        return image;
    }
}
