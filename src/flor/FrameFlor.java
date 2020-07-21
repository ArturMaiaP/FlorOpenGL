package flor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
 
public class FrameFlor 
{
    public static void main(String[] args) 
    {
    	Flor f1 =new Flor();
    	
    	GLProfile profile = GLProfile.get(GLProfile.GL2);
    	GLCapabilities capabilities = new GLCapabilities(profile);
 
    	GLCanvas glcanvas = new GLCanvas(capabilities);
    	glcanvas.addGLEventListener(f1);
    	glcanvas.setSize( 500, 500 );
 
        JFrame frame = new JFrame( "Flor De Abril" );
        frame.getContentPane().add( glcanvas);
 
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        
        glcanvas.addKeyListener(f1);
        frame.setFocusable(true);  // To receive key event
        glcanvas.requestFocus();
 
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
    }
}