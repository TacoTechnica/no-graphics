//package graphics;

// color class. (like java.awt.Color)
public class ShellColor {

    // Code used in shell
    private String colorCode;

    public ShellColor(String colorCode) {
        this.colorCode = colorCode;
    }

    /// Accessors and modifiers

    public String getColorCode() {
        return colorCode;
    }

    /// Static colors for convenient access

    public static ShellColor NONE =     new ShellColor("0"); // no color
    public static ShellColor BLACK =    new ShellColor("0;30");
    public static ShellColor RED =      new ShellColor("0;31");
    public static ShellColor GREEN =    new ShellColor("0;32");
    public static ShellColor BROWN =    new ShellColor("0;33");
    public static ShellColor BLUE =     new ShellColor("0;34");
    public static ShellColor PURPLE =   new ShellColor("0;35");
    public static ShellColor CYAN =     new ShellColor("0;36");
    public static ShellColor LTGRAY =   new ShellColor("0;37");
    public static ShellColor DKGRAY =   new ShellColor("1;30");
    public static ShellColor LTRED =    new ShellColor("1;31");
    public static ShellColor LTGREEN =  new ShellColor("1;32");
    public static ShellColor YELLOW =   new ShellColor("1;33");
    public static ShellColor LTBLUE =   new ShellColor("1;34");
    public static ShellColor LTPURPLE = new ShellColor("1;35");
    public static ShellColor LTCYAN =   new ShellColor("1;36");
    public static ShellColor WHITE =    new ShellColor("1;37");
}
