//package core;

//import graphics.TerminalBuffer;
//import graphics.Graphics;
//import graphics.ShellColor;

public class Core implements Runnable {

    // a buffer for terminal display
    private TerminalBuffer buffer;
    
    // whether the game is running
    private boolean running;

    private double x=0, y=0;
    private double vx=0.5, vy=0.5;

    public Core() {
        buffer = new TerminalBuffer(80,20);
        running = false;
    }

    public void start() {
        
        running = true;
        new Thread(this).start();
        /*buffer.setup();
        Graphics g = buffer.getImage().getGraphics();
        g.setColor(ShellColor.GREEN);
        g.fillRect(1,1,5,5);
        buffer.show();
        //buffer.close();
        */
    }

    public void run() {
        buffer.setup();

        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000.0 / 30.0; // billion divided by target ups
        double delta = 0;
        
        long secondTimer = System.currentTimeMillis();
        int ticks = 0;
        int frames = 0;

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            boolean shouldRender = true;
            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;

                shouldRender = true; // Only render after ticking
            }

            if (shouldRender) {
                frames++;
                render();
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace(); // this is bad, but eh what can you do
            }
        }
    }

    private void tick() {
        x += vx;
        y += vy;
        if (x + 5 > buffer.getWidth()) {
            x = buffer.getWidth() - 5;
            vx *= -1;
        } else if (x < 0) {
            x = 0;
            vx *= -1;
        }

        if (y + 5 > buffer.getHeight()) {
            y = buffer.getHeight() - 5;
            vy *= -1;
        } else if (y < 0) {
            y = 0;
            vy *= -1;
        }
    }

    private void render() { 
        Graphics g = buffer.getImage().getGraphics();
        g.setCharacter(' ');
        g.setColor(ShellColor.BLACK);
        g.fillRect(0,0,buffer.getWidth(), buffer.getHeight());
        g.setCharacter('B');
        g.setColor(ShellColor.GREEN);
        g.fillRect((int)x,(int)y,5,5);
        buffer.show();
    }

    public static void main(String[] args) {
        Core core = new Core();
        core.start();
    }
}
