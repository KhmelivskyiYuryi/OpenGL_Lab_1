import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL2ES3;
import com.jogamp.opengl.glu.GLU;

public class Figures {
    protected static void setup( GL2 gl2, int width, int height ) {
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // Початок системи координат в центрі вікна
        GLU glu = new GLU();
        glu.gluOrtho2D( -width, width, -height, height );

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
    }

    protected static void render( GL2 gl2, int width, int height ) {

        gl2.glClear( GL.GL_COLOR_BUFFER_BIT );

//        // Вісі координат
//        gl2.glLoadIdentity();
//        gl2.glColor3f(1,0,0);
//        gl2.glBegin(GL2ES3.GL_LINES);
//        gl2.glVertex2f(0,height);
//        gl2.glVertex2f(0, -height);
//        gl2.glEnd();
//        gl2.glBegin(GL2ES3.GL_LINES);
//        gl2.glVertex2f(width,0);
//        gl2.glVertex2f(-width, 0);
//        gl2.glEnd();



        // Горизонтальна лінія з точками без зглажування
        gl2.glLineWidth(3);
        gl2.glColor3f(1f,1f,1f);
        gl2.glEnable(gl2.GL_LINE_STIPPLE);
        gl2.glLineStipple(1, (short)0x00E3);
        gl2.glBegin( GL2ES3.GL_LINE_STRIP );
        gl2.glVertex2f(-width/4,-height/4);
        gl2.glVertex2f(width/4, -height/4);
        gl2.glEnd();


        for(float i = 0, size = 1; i <= width/2; i=i+(width/2)/10, size++){

            gl2.glColor3f(0.5f,0.5f,0);
            gl2.glPointSize(size);
            gl2.glBegin(GL2ES3.GL_POINTS);
            gl2.glVertex2f(-width/4+i,-height/4);
            gl2.glEnd();

        }

        // Вертикальна лінія з точками, які зглажуються
        gl2.glLineWidth(2);
        gl2.glColor3f(1f,1f,1f);
        gl2.glEnable(gl2.GL_LINE_STIPPLE);
        gl2.glLineStipple(1, (short)0x008C);
        gl2.glBegin( GL2ES3.GL_LINE_STRIP );
        gl2.glVertex2f(width/5,-height/(2.5f));
        gl2.glVertex2f(width/5, height/(2.5f));
        gl2.glEnd();

        for(float i = 0, size = 1; i <= 2*height/(2.5f); i=i+((2*height/(2.5f))/10), size++){

            gl2.glEnable(gl2.GL_POINT_SMOOTH);
            gl2.glColor3f(0.5f,0.5f,0.5f);
            gl2.glPointSize(size);
            gl2.glBegin(GL2ES3.GL_POINTS);
            gl2.glVertex2f(width/5,-height/(2.5f)+i);
            gl2.glEnd();
            gl2.glDisable(gl2.GL_POINT_SMOOTH);
        }
    }
}
