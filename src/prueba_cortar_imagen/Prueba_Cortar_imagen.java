/**
 * @author Antonio José Tojín Silva 
 * @carne 1290-19-10010 
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class JigsawImage{

	public static void main(String[] args) {
	try {
			
		//número de filas y columnas.
		int row = 4;
		int col = 3;
		
		BufferedImage originalImgage = ImageIO.read(new File("C:/Users/ANTONY/Documents/TAREAS ANTONIO/PROGRA/NetBeansProjects/Prueba_Cortar_imagen/imagen1.jpg"));
		
		//ancho total y alto total de una imagen
		int tWidth = originalImgage.getWidth();
		int tHeight = originalImgage.getHeight();

		System.out.println("Image Dimension: " + tWidth + "x" + tHeight);
		
		//ancho y alto de cada pieza
		int eWidth = tWidth / col;
		int eHeight = tHeight / row;

		int x = 0;
		int y = 0;

		for (int i = 0; i < row; i++) {
			y = 0;
			for (int j = 0; j < col; j++) {
				try {
					System.out.println("creating piece: "+i+" "+j);
					
					BufferedImage SubImgage = originalImgage.getSubimage(y, x, eWidth, eHeight);
					File outputfile = new File("C:/Users/ANTONY/Documents/TAREAS ANTONIO/PROGRA/NetBeansProjects/Prueba_Cortar_imagen/imagen1.jpg"+i+j+".jpg");
					ImageIO.write(SubImgage, "jpg", outputfile);
					
					y += eWidth;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			x += eHeight;
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
}

