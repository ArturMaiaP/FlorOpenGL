package flor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;


public class Flor implements GLEventListener, KeyListener{
	
	private int indexGlobal=12;
	private GLAutoDrawable glDrawable;
	
	public float cores(int index){
		LinkedList<Float> c1 =new LinkedList<Float>();
		if(index >=12){
			index=index-12;
		}
		//cor Branca
		c1.addFirst(1f);
		c1.add(1f);
		c1.add(1f);
		
		//cor Vermelha
		c1.add(1f);
		c1.add(0f);
		c1.add(0f);
		
		//Cor Verde
		c1.add(0f);
		c1.add(1f);
		c1.add(0f);
		
		//Cor  Azul
		c1.add(0f);
		c1.add(0f);
		c1.addLast(1f);
		
		return c1.get(index);
	}
	@Override
	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();
		
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        
        //triangulo branco
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(cores(indexGlobal),cores(indexGlobal+1),cores(indexGlobal+2));
        gl.glVertex2f(0.0f, 0.10f);	
        gl.glVertex2f(-0.10f, -0.10f);	
        gl.glVertex2f(0.10f, -0.10f);	
        gl.glEnd();	
        
        //Triangulo Vermelho
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(cores(indexGlobal+3),cores(indexGlobal+4),cores(indexGlobal+5));
        gl.glVertex2f(0.0f, 0.10f);	
        gl.glVertex2f(-0.20f, 0.20f);	
        gl.glVertex2f(-0.20f, 0.00f);	
        gl.glEnd();	
        
        //triangulo Verde
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(cores(indexGlobal+6),cores(indexGlobal+7),cores(indexGlobal+8));
        gl.glVertex2f(0.0f, 0.10f);	
        gl.glVertex2f(-0.10f, 0.30f);	
        gl.glVertex2f(0.10f, 0.30f);	
        gl.glEnd();	
        
        //triangulo azul
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(cores(indexGlobal+9),cores(indexGlobal+10),cores(indexGlobal+11));
        gl.glVertex2f(0.0f, 0.10f);	
        gl.glVertex2f(0.20f, 0.20f);	
        gl.glVertex2f(0.20f, 0.00f);	
        gl.glEnd();	
        
        //retangulo amarelo
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1.0f,1.0f,0.0f);
        gl.glVertex2f(0.005f, -0.10f);	
        gl.glVertex2f(-0.005f, -0.10f);	
        gl.glVertex2f(0.005f, -1.0f);	
        gl.glVertex2f(-0.005f, -1.0f);	
        gl.glEnd();	
       		
        gl.glFlush();
		
	}


	@Override
	public void init(GLAutoDrawable gLDrawable) {
		this.glDrawable= gLDrawable;
		GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glOrtho(0.0f, 200.0f, 0.0f, 200.0f, -1.0f, 1.0f);  
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {  
        System.out.println("reshape " + width + " " + height);  
    }


	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			default:
				indexGlobal=indexGlobal-3;
					if(indexGlobal==0){
						indexGlobal=12;
					}
		}
		glDrawable.display();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
	
}

	