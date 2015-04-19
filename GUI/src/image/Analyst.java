package image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Analyst 
{
	public static boolean isLibre(String pathName)
	{
		System.out.println("----Debut du traitement de l'image----");
		//Creer les objets
		SobelEdgeDetectorLive detector = new SobelEdgeDetectorLive();
		//FilesManager manager = new FilesManager();
		ImageProcessor imageProcessor = new ImageProcessor();

		//Choix des parametres
		//Distance au cercle pour être inliner
		imageProcessor.setThresholdInlier(50);

		//Nombre d'inliners suffisant pour arrêter
		imageProcessor.setEnoughInliers((int)(100000));
		imageProcessor.setNumberOfLoops(10000);

		//Niveau de gradient
		detector.setGradientLevel(200);

		//Nombre de points permettant de dire qu'il y a un objet sur la table
		int nbMaximal = 2000;

		//Selection du dossier des images selon le systeme d'exploitation
		//manager.SystemChoice();
		//String dossierImages = manager.getDossierImages();

		//Choix du format de sortie
		//String format = new String(".png");

		//String imageACharger = pathName;
		//String imageContours = new String("imageContours_1");
		//String imageDetectionObjTable = new String("imageContours_2");
		//String imageTraceCercle = new String("imageTraceCercle");

		ImageProcessor image = new ImageProcessor();

		//Charge l'image
		image.loadImage(pathName);
		BufferedImage frame = image.getInputfile();

		//S'applique a l'image
		detector.setSourceImage(frame);
		detector.process("Optimisation");
		//BufferedImage edges = detector.getEdgesImage();

		//Enregistre l'image des contours
		//image.saveImage(edges, dossierImages + imageACharger + "_" + imageContours + format);		 		

		//Application de RANSAC
		ArrayList<Point> listeDePoints = new ArrayList<Point>();
		listeDePoints=SobelEdgeDetectorLive.getListPoints();
		long start = System.currentTimeMillis();
		imageProcessor.ransac(listeDePoints, "Optimise");
		long duree = System.currentTimeMillis() - start;
		System.out.println("Execution time of RANSAC:" + duree/1000 + "s");

		//Cercle detecte
		detector.setCercleTrace(true);

		//Nouvelle application de SOBEL dans le cercle detecte plus haut afin de detecter la presence ou non d'objets
		detector.process("Optimisation");
		//BufferedImage edges2 = detector.getEdgesImage();

		//Enregistre l'image des contours à l'intérieur du cercle
		//image.saveImage(edges2, dossierImages + imageACharger + "_" + imageDetectionObjTable + format);

		//Examen du nombre de points
		int nbPoints = detector.getNbPoints();

		return nbPoints > nbMaximal;

		/*
		//Definir le meilleur cercle
		Circle bestCircle = ImageProcessor.getBestCircle();
		int x = bestCircle.circleCenter().getX();
		int y = bestCircle.circleCenter().getY();
		int r = (int) bestCircle.radius();

		//Dessine le cercle obtenu
		image.drawCircle(frame, x, y, r);

		//Enregistre l'image avec trac� du cercle
		image.saveImage(frame, dossierImages + imageACharger + "_" + imageTraceCercle + format);
		*/
	}
}
