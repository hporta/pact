package audio;

import java.io.*;

import audio.dtw.DTWLight;
import audio.WavFile.*;
import audio.mfcc.*;

public class FinalCarte {

	private final int size = 11;
	private final int numberOfSpeakers = 8;
	private final int numberOfTemplates = 3;
	private String[] products;

	private Cepstre[][] carte;

	public FinalCarte() throws IOException, WavFileException {

		products = new String[size];
		products[0] = "bierebrune";
		products[1] = "cafeexpresso";
		products[2] = "cocacola";
		products[3] = "jusdorange";
		products[4] = "thealamenthe";
		products[5] = "eaugazeuse";
		products[6] = "menucarnivore";
		products[7] = "menuenfants";
		products[8] = "menugourmet";
		products[9] = "menumaritime";
		products[10] = "menuvegetarien";
		carte = new Cepstre[size][numberOfSpeakers];
		this.fill();

	}

	public void fill() throws IOException, WavFileException {

		for (int i = 0; i < size; i++) 
		{
			String product = products[i];

			for (int j = 0; j < numberOfSpeakers; j++) 
			{

				Cepstre current = new Cepstre("data/base/c_" + product + 1 + "."
						+ (j + 1) + ".wav");
				for (int k = 2; k <= numberOfTemplates; k++) {
					Cepstre other = new Cepstre("data/base/c_" + product + k
							+ "." + (j + 1) + ".wav");
					DTWLight dtw = new DTWLight(current, other);
					current = dtw.moyenneCepstre();
				}
				carte[i][j] = current;
			}

		}

	}

	public Cepstre[][] getCarte() {
		return carte;
	}

	public String result(int min) {
		
		switch (min) {
		case 0 : 
			return "bi�re brune";
		case 1 :
			return "caf� expresso";
		case 2 :
			return "Coca-Cola";
		case 3 :
			return "jus d'orange";
		case 4 :
			return "th� � la menthe";
		case 5 :
			return "eau gazeuse";
		case 6:
			return "Menu Carnivore";
		case 7:
			return "Menu Enfants";
		case 8:
			return "Menu Gourmet";
		case 9:
			return "Menu Maritime";
		case 10:
			return "Menu V�g�tarien";
		default : 
			return "nope";
		}
		
	}

	public String recognize(String recordName) {

		Cepstre sample = new Cepstre(recordName);
		double[][] warpingDistances = new double[size][numberOfTemplates];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < numberOfTemplates; j++) {
				DTWLight dtw = new DTWLight(sample, carte[i][j]);
				warpingDistances[i][j] = dtw.getWP();
			}
		}
		return result(minMatrice(warpingDistances));

	}

	public int minMatrice(double[][] m) {
		int nbLignes = m.length;
		int nbColonnes = m[0].length;
		double temp = Double.POSITIVE_INFINITY; // sert � m�moriser la plus
												// petite wp
		int elt = 0; // sert � m�moriser le produit correspondant

		for (int i = 0; i < nbLignes; i++) {

			for (int j = 0; j < nbColonnes; j++) {

				if (m[i][j] < temp) {
					temp = m[i][j];
					elt = i;
				}
			}
		}

		return elt;
	}

	public void writeCarte() {
		Cepstre[][] obj = getCarte();

		try {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < numberOfSpeakers; j++){
						File f = new File("data/base/cepstre" + i + j + ".txt");
						PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
						double[][] c = obj[i][j].getCepstre();
						int nbLignes = c.length;
						int nbColonnes = c[0].length;
						pw.println(nbLignes);
						pw.println(nbColonnes);
						for (int k = 0; k < nbLignes; k++) {
							for (int l = 0; l < nbColonnes; l++) {
								pw.println(c[k][l]);
							}
						}
						pw.close();
				}
			}
		} catch (IOException exception) {
			System.out.println("Erreur lors de la lecture : "+ exception.getMessage());
		}
	}

}