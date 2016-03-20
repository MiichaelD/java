package graficas;
/*******************************************************
 * @author:  Diego Fernando Carvajal
 *			 Juan Guillermo Rozo
 * @fecha:   12-10-05
 * @version: v1.2
 ******************************************************/
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Grafico3D extends Canvas
{

	/* Los puntos y angulos del cubo originales */
	float fPuntoX[] = new float[25];
	float fPuntoY[] = new float[25];
	float fPuntoZ[] = new float[25];

    /* Los puntos y angulos del cubo transformados */
    float fAngXY;
    float fAngYZ;
    float fAngZX;
    int iCambia;

	float fPuntoXT[] = new float[25];
	float fPuntoYT[] = new float[25];
	float fPuntoZT[] = new float[25];

    /* Constantes para pasar de 3D a 2D */
    private int iDisPantUser;
    private int iDisPantUser2;


    /* Puntos extremos de la gráfica generada por la ecuación */
    private float fMinPantX;
    private float fMaxPantX;
    private float fMinPantY;
    private float fMaxPantY;

    /* Constantes para cuadrar el gráfico en la ventana */
    float fConstanteX;
    float fConstanteY;

    int iNumPuntos;

	/* Constructor */
	Grafico3D()
	{
		iNumPuntos = 24;

        this.iDisPantUser = 60;  /* Distancia de la pantalla al usuario (centímetros) */

		/* Creo un cubo en 3D, son ocho(10) puntos */
		fPuntoX[0]=-2;  fPuntoY[0]=2;  fPuntoZ[0]=-2;
		fPuntoX[1]=2;   fPuntoY[1]=2;  fPuntoZ[1]=-2;
		fPuntoX[2]=2; 	 fPuntoY[2]=-5;   fPuntoZ[2]=-2;
		fPuntoX[3]=-2;  fPuntoY[3]=-5;   fPuntoZ[3]=-2;

		fPuntoX[4]=-2;  fPuntoY[4]=2;  fPuntoZ[4]=2;
		fPuntoX[5]=2;   fPuntoY[5]=2;  fPuntoZ[5]=2;
		fPuntoX[6]=2;   fPuntoY[6]=-5;   fPuntoZ[6]=2;
		fPuntoX[7]=-2;  fPuntoY[7]=-5;   fPuntoZ[7]=2;

		fPuntoX[8]=-2;  fPuntoY[8]=2;  fPuntoZ[8]=-2;
		fPuntoX[9]=2;   fPuntoY[9]=2;  fPuntoZ[9]=-2;
		fPuntoX[10]=0; fPuntoY[10]=4;   fPuntoZ[10]=-0;
		fPuntoX[11]=-0;  fPuntoY[11]=4;   fPuntoZ[11]=-0;

		fPuntoX[12]=-0;  fPuntoY[12]=4;  fPuntoZ[12]=0;
		fPuntoX[13]=0;   fPuntoY[13]=4;  fPuntoZ[13]=0;
		fPuntoX[14]=2;   fPuntoY[14]=2;   fPuntoZ[14]=2;
		fPuntoX[15]=-2;  fPuntoY[15]=2;   fPuntoZ[15]=2;

		fPuntoX[16]=-2;  fPuntoY[16]=-5;  fPuntoZ[16]=-2;
		fPuntoX[17]=2;   fPuntoY[17]=-5;  fPuntoZ[17]=-2;
		fPuntoX[18]=0; fPuntoY[18]=-7;   fPuntoZ[18]=-0;
		fPuntoX[19]=-0;  fPuntoY[19]=-7;   fPuntoZ[19]=-0;

		fPuntoX[20]=-0;  fPuntoY[20]=-7;  fPuntoZ[20]=0;
		fPuntoX[21]=0;   fPuntoY[21]=-7;  fPuntoZ[21]=0;
		fPuntoX[22]=2;   fPuntoY[22]=-5;   fPuntoZ[22]=2;
		fPuntoX[23]=-2;  fPuntoY[23]=-5;   fPuntoZ[23]=2;

        fAngXY=0;
        fAngYZ=0;
        fAngZX=0;
        iCambia = 1;

        /* Copia los puntos en los puntos de transformación */
		for (int iCont=0; iCont<iNumPuntos; iCont++)
		{
			fPuntoXT[iCont] = fPuntoX[iCont];
			fPuntoYT[iCont] = fPuntoY[iCont];
			fPuntoZT[iCont] = fPuntoZ[iCont];
		}

	}

	public void vPlanoXY_Derecha()
    {
    	fAngXY++;
    	iCambia = 1;
    	if (fAngXY==360) fAngXY=0;
    	repaint();
    }

    public void vPlanoYZ_Derecha()
    {
    	fAngYZ++;
    	iCambia = 2;
    	if (fAngYZ==360) fAngYZ=0;
    	repaint();
    }

    public void vPlanoXZ_Derecha()
    {
    	fAngZX++;
    	iCambia = 3;
    	if (fAngZX==360) fAngZX=0;
    	repaint();
    }

	public void vPlanoXY_Izquierda()
    {
    	fAngXY--;
    	iCambia = 4;
    	if (fAngXY==360) fAngXY=0;
    	repaint();
    }

    public void vPlanoYZ_Izquierda()
    {
    	fAngYZ--;
    	iCambia = 5;
    	if (fAngYZ==360) fAngYZ=0;
    	repaint();
    }

    public void vPlanoXZ_Izquierda()
    {
    	fAngZX--;
    	iCambia = 6;
    	if (fAngZX==360) fAngZX=0;
    	repaint();
    }

	public void update(Graphics objGrafico)
    {
        paint( objGrafico );
    }

    public void paint( Graphics objGrafico )
    {
  		/* Inicia el fondo de la pantalla */
      	objGrafico.setColor(Color.black);
      	objGrafico.fillRect(0,0,size().width, size().height);

      	//Rotacion a la derecha
		for (int iCont=0; iCont<iNumPuntos; iCont++)
		{
              /* Transforma las coordenadas: rotación eje X-Y */
              if (iCambia==1)
              {
	      	      fPuntoXT[iCont] = fPuntoX[iCont] * (float) Math.cos(fAngXY/57.29578) - fPuntoY[iCont] * (float) Math.sin(fAngXY/57.29578);
	              fPuntoYT[iCont] = fPuntoX[iCont] * (float) Math.sin(fAngXY/57.29578) + fPuntoY[iCont] * (float) Math.cos(fAngXY/57.29578);
	              fPuntoZT[iCont] = fPuntoZ[iCont];
	          }

	          /* Transforma las coordenadas: rotación eje Y-Z */
              if (iCambia==2)
              {
	              fPuntoXT[iCont] = fPuntoX[iCont];
	              fPuntoYT[iCont] = fPuntoY[iCont] * (float) Math.cos(fAngYZ/57.29578) - fPuntoZ[iCont] * (float) Math.sin(fAngYZ/57.29578);
	              fPuntoZT[iCont] = fPuntoY[iCont] * (float) Math.sin(fAngYZ/57.29578) + fPuntoZ[iCont] * (float) Math.cos(fAngYZ/57.29578);
	          }

	          /* Transforma las coordenadas: rotación eje Z-X */
	          if (iCambia==3)
	          {
	              fPuntoXT[iCont] = fPuntoZ[iCont] * (float) Math.cos(fAngZX/57.29578) - fPuntoX[iCont] * (float) Math.sin(fAngZX/57.29578);
	              fPuntoYT[iCont] = fPuntoY[iCont];
	              fPuntoZT[iCont] = fPuntoZ[iCont] * (float) Math.sin(fAngZX/57.29578) + fPuntoX[iCont] * (float) Math.cos(fAngZX/57.29578);
	          }

	    }

      	//Rotacion a la izquierda
      	for (int iCont=0; iCont<iNumPuntos; iCont++)
		{
              /* Transforma las coordenadas: rotación eje X-Y */
              if (iCambia==4)
              {
	      	      fPuntoXT[iCont] = fPuntoX[iCont] * (float) Math.cos(fAngXY/57.29578) - fPuntoY[iCont] * (float) Math.sin(fAngXY/57.29578);
	              fPuntoYT[iCont] = fPuntoX[iCont] * (float) Math.sin(fAngXY/57.29578) + fPuntoY[iCont] * (float) Math.cos(fAngXY/57.29578);
	              fPuntoZT[iCont] = fPuntoZ[iCont];
	          }

	          /* Transforma las coordenadas: rotación eje Y-Z */
              if (iCambia==5)
              {
	              fPuntoXT[iCont] = fPuntoX[iCont];
	              fPuntoYT[iCont] = fPuntoY[iCont] * (float) Math.cos(fAngYZ/57.29578) - fPuntoZ[iCont] * (float) Math.sin(fAngYZ/57.29578);
	              fPuntoZT[iCont] = fPuntoY[iCont] * (float) Math.sin(fAngYZ/57.29578) + fPuntoZ[iCont] * (float) Math.cos(fAngYZ/57.29578);
	          }

	          /* Transforma las coordenadas: rotación eje Z-X */
	          if (iCambia==6)
	          {
	              fPuntoXT[iCont] = fPuntoZ[iCont] * (float) Math.cos(fAngZX/57.29578) - fPuntoX[iCont] * (float) Math.sin(fAngZX/57.29578);
	              fPuntoYT[iCont] = fPuntoY[iCont];
	              fPuntoZT[iCont] = fPuntoZ[iCont] * (float) Math.sin(fAngZX/57.29578) + fPuntoX[iCont] * (float) Math.cos(fAngZX/57.29578);
	          }
	    }

      	/* Extremos de la gráfica */
      	fMinPantX = (float) 999999;
      	fMaxPantX = (float) -999999;
      	fMinPantY = (float) 999999;
      	fMaxPantY = (float) -999999;

		for (int iCont=0; iCont<iNumPuntos; iCont++)
		{
	    	float fPuntoX2D = (float) (iDisPantUser2*fPuntoXT[iCont] ) / (iDisPantUser2 - fPuntoZT[iCont]);
	    	float fPuntoY2D = (float) (iDisPantUser2*fPuntoYT[iCont] ) / (iDisPantUser2 - fPuntoZT[iCont]);

		    if (fPuntoX2D < fMinPantX) fMinPantX = fPuntoX2D;
        	if (fPuntoX2D > fMaxPantX) fMaxPantX = fPuntoX2D;
	        if (fPuntoY2D < fMinPantY) fMinPantY = fPuntoY2D;
    	    if (fPuntoY2D > fMaxPantY) fMaxPantY = fPuntoY2D;

		}

      	/* Constantes para cuadrar el gráfico en la ventana */
        fMaxPantX = 8;
        fMinPantX = -8;
        fMaxPantY = 9;
        fMinPantY = -9;

        fConstanteX = (float) size().width / (fMaxPantX-fMinPantX);
        fConstanteY = (float) size().height / (fMaxPantY-fMinPantY);

        vDibujar(objGrafico, fPuntoXT[0], fPuntoYT[0], fPuntoZT[0], fPuntoXT[1], fPuntoYT[1], fPuntoZT[1]);
        vDibujar(objGrafico, fPuntoXT[1], fPuntoYT[1], fPuntoZT[1], fPuntoXT[2], fPuntoYT[2], fPuntoZT[2]);
        vDibujar(objGrafico, fPuntoXT[2], fPuntoYT[2], fPuntoZT[2], fPuntoXT[3], fPuntoYT[3], fPuntoZT[3]);
        vDibujar(objGrafico, fPuntoXT[3], fPuntoYT[3], fPuntoZT[3], fPuntoXT[0], fPuntoYT[0], fPuntoZT[0]);

        vDibujar(objGrafico, fPuntoXT[4], fPuntoYT[4], fPuntoZT[4], fPuntoXT[5], fPuntoYT[5], fPuntoZT[5]);
        vDibujar(objGrafico, fPuntoXT[5], fPuntoYT[5], fPuntoZT[5], fPuntoXT[6], fPuntoYT[6], fPuntoZT[6]);
        vDibujar(objGrafico, fPuntoXT[6], fPuntoYT[6], fPuntoZT[6], fPuntoXT[7], fPuntoYT[7], fPuntoZT[7]);
        vDibujar(objGrafico, fPuntoXT[7], fPuntoYT[7], fPuntoZT[7], fPuntoXT[4], fPuntoYT[4], fPuntoZT[4]);

        vDibujar(objGrafico, fPuntoXT[0], fPuntoYT[0], fPuntoZT[0], fPuntoXT[4], fPuntoYT[4], fPuntoZT[4]);
        vDibujar(objGrafico, fPuntoXT[1], fPuntoYT[1], fPuntoZT[1], fPuntoXT[5], fPuntoYT[5], fPuntoZT[5]);
        vDibujar(objGrafico, fPuntoXT[2], fPuntoYT[2], fPuntoZT[2], fPuntoXT[6], fPuntoYT[6], fPuntoZT[6]);
        vDibujar(objGrafico, fPuntoXT[3], fPuntoYT[3], fPuntoZT[3], fPuntoXT[7], fPuntoYT[7], fPuntoZT[7]);

        vDibujar(objGrafico, fPuntoXT[8], fPuntoYT[8], fPuntoZT[8], fPuntoXT[8], fPuntoYT[8], fPuntoZT[8]);
        vDibujar(objGrafico, fPuntoXT[9], fPuntoYT[9], fPuntoZT[9], fPuntoXT[9], fPuntoYT[9], fPuntoZT[9]);
        vDibujar(objGrafico, fPuntoXT[10], fPuntoYT[10], fPuntoZT[10], fPuntoXT[10], fPuntoYT[10], fPuntoZT[10]);
        vDibujar(objGrafico, fPuntoXT[11], fPuntoYT[11], fPuntoZT[11], fPuntoXT[11], fPuntoYT[11], fPuntoZT[11]);

        vDibujar(objGrafico, fPuntoXT[12], fPuntoYT[12], fPuntoZT[12], fPuntoXT[12], fPuntoYT[12], fPuntoZT[12]);
        vDibujar(objGrafico, fPuntoXT[13], fPuntoYT[13], fPuntoZT[13], fPuntoXT[13], fPuntoYT[13], fPuntoZT[13]);
        vDibujar(objGrafico, fPuntoXT[14], fPuntoYT[14], fPuntoZT[14], fPuntoXT[14], fPuntoYT[14], fPuntoZT[14]);
        vDibujar(objGrafico, fPuntoXT[15], fPuntoYT[15], fPuntoZT[15], fPuntoXT[15], fPuntoYT[15], fPuntoZT[15]);

        vDibujar(objGrafico, fPuntoXT[8], fPuntoYT[8], fPuntoZT[8], fPuntoXT[12], fPuntoYT[12], fPuntoZT[12]);
        vDibujar(objGrafico, fPuntoXT[9], fPuntoYT[9], fPuntoZT[9], fPuntoXT[13], fPuntoYT[13], fPuntoZT[13]);
        vDibujar(objGrafico, fPuntoXT[10], fPuntoYT[10], fPuntoZT[10], fPuntoXT[14], fPuntoYT[14], fPuntoZT[14]);
        vDibujar(objGrafico, fPuntoXT[11], fPuntoYT[11], fPuntoZT[11], fPuntoXT[15], fPuntoYT[15], fPuntoZT[15]);

        vDibujar(objGrafico, fPuntoXT[16], fPuntoYT[16], fPuntoZT[16], fPuntoXT[16], fPuntoYT[16], fPuntoZT[16]);
        vDibujar(objGrafico, fPuntoXT[17], fPuntoYT[17], fPuntoZT[17], fPuntoXT[17], fPuntoYT[17], fPuntoZT[17]);
        vDibujar(objGrafico, fPuntoXT[18], fPuntoYT[18], fPuntoZT[18], fPuntoXT[18], fPuntoYT[18], fPuntoZT[18]);
        vDibujar(objGrafico, fPuntoXT[19], fPuntoYT[19], fPuntoZT[19], fPuntoXT[19], fPuntoYT[19], fPuntoZT[19]);

        vDibujar(objGrafico, fPuntoXT[20], fPuntoYT[20], fPuntoZT[20], fPuntoXT[20], fPuntoYT[20], fPuntoZT[20]);
        vDibujar(objGrafico, fPuntoXT[21], fPuntoYT[21], fPuntoZT[21], fPuntoXT[21], fPuntoYT[21], fPuntoZT[21]);
        vDibujar(objGrafico, fPuntoXT[22], fPuntoYT[22], fPuntoZT[22], fPuntoXT[22], fPuntoYT[22], fPuntoZT[22]);
        vDibujar(objGrafico, fPuntoXT[23], fPuntoYT[23], fPuntoZT[23], fPuntoXT[23], fPuntoYT[23], fPuntoZT[23]);

        vDibujar(objGrafico, fPuntoXT[16], fPuntoYT[16], fPuntoZT[16], fPuntoXT[20], fPuntoYT[20], fPuntoZT[20]);
        vDibujar(objGrafico, fPuntoXT[17], fPuntoYT[17], fPuntoZT[17], fPuntoXT[21], fPuntoYT[21], fPuntoZT[21]);
        vDibujar(objGrafico, fPuntoXT[18], fPuntoYT[18], fPuntoZT[18], fPuntoXT[22], fPuntoYT[22], fPuntoZT[22]);
        vDibujar(objGrafico, fPuntoXT[19], fPuntoYT[19], fPuntoZT[19], fPuntoXT[23], fPuntoYT[23], fPuntoZT[23]);
    }

    public void vDibujar( Graphics objGrafico, float fXini, float fYini, float fZini, float fXfin, float fYfin, float fZfin)
    {
    	float fPuntoXini = (float) (iDisPantUser*fXini) / (iDisPantUser - fZini);
	    float fPuntoYini = (float) (iDisPantUser*fYini) / (iDisPantUser - fZini);

    	float fPuntoXfin = (float) (iDisPantUser*fXfin) / (iDisPantUser - fZfin);
	    float fPuntoYfin = (float) (iDisPantUser*fYfin) / (iDisPantUser - fZfin);

    	int iPuntoXini = (int) (fConstanteX * (fPuntoXini - fMinPantX));
   	    int iPuntoXfin = (int) (fConstanteX * (fPuntoXfin - fMinPantX));
   	    int iPuntoYini = (int) (fConstanteY * (fPuntoYini - fMinPantY));
   	    int iPuntoYfin = (int) (fConstanteY * (fPuntoYfin - fMinPantY));

    	objGrafico.setColor(Color.red);
    	objGrafico.drawLine(iPuntoXini, iPuntoYini, iPuntoXfin, iPuntoYfin);
    }
}