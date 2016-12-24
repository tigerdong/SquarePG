// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SquarePG extends JFrame {
    private JButton playButton;
    private JButton optionsButton;
    private JButton aboutButton;
    //private GameFrame gameFrame;
    
    private boolean isRunning;
    private int FPS;
    private State state;
    
    public enum State {
        MENU,
        GAME,
        OPTIONS,
        ABOUT;
    }

    public static void main(String args[]) {
        SquarePG game = new SquarePG();
        game.run();
        System.exit(0);
    }
    
    // Constructor
    public SquarePG() {
        super("SquarePG");
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        playButton = new JButton("Play");
        optionsButton = new JButton("Options");
        aboutButton = new JButton("About");
        //gameFrame = new GameFrame();
        
        add(playButton);
        add(optionsButton);
        add(aboutButton);
        
        FPS = 30;
        isRunning = true;
        state = State.MENU;
        
        ActionHandler actionHandler = new ActionHandler();
        playButton.addActionListener(actionHandler);
        optionsButton.addActionListener(actionHandler);
        aboutButton.addActionListener(actionHandler);
    }
    
    // Runs game loop
    public void run(){
        
        initialize();
        
        while(isRunning){
            long time = System.currentTimeMillis();
            
            update();
            draw();
            
            // Delay for each frame
            time = (1000/FPS) - (System.currentTimeMillis()-time);
            
            if (time > 0){
                try{
                    Thread.sleep(time);
                }
                catch (Exception e){}
            }
        }
        setVisible(false);
    }
    
    // Initial setup
    void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setVisible(true);
    }
    
    // Input check, movement
    void update() {
        switch (state) {
            case MENU:
                break;
            case GAME:
                // gameFrame.update();
                
                break;
            case OPTIONS:
                break;
            case ABOUT:
                break;
            default:
                break;
        }
    }
    
    // Draws everything
    void draw() {
        switch (state) {
            case MENU:
                break;
            case GAME:
                // gameFrame.draw();
                
                break;
            case OPTIONS:
                break;
            case ABOUT:
                break;
            default:
                break;
        }
    }
    
    // private inner class for ActionListener event handling
    private class ActionHandler implements ActionListener {
        public void actionPerformed( ActionEvent event ) {
            if (event.getSource() == playButton) {
                state = State.GAME;
                removeAll();
            }
            if (event.getSource() == optionsButton) {
                state = State.OPTIONS;
                removeAll();
            }
            if (event.getSource() == aboutButton) {
                state = State.ABOUT;
                removeAll();
            }
        }
    }
            
}
