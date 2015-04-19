package audio.dtw;

import java.lang.Math;

import audio.mfcc.*;

//reste � se d�merder pour renvoyer display

public class DTWLight {
	private double[][] seq1;
	private double[][] seq2;
	private int[][] chemin; // affiche le chemin le plus court
	private int pathLength = 0;
	private double GAMMA=2.0;
	private double coefNorm = 0.0;
	private int[][] ksi;
	private double[][] disp;

	private int n; // taille sample
	private int m; // taille template
	
	private double warpingDistance;
	
	private Cepstre moyenne;

	public DTWLight(Cepstre sample, Cepstre template) {

		seq1 = sample.getCepstre();
		seq2 = template.getCepstre();


		n = seq1.length;
		m = seq2.length;
		
		ksi = new int[n][m]; // sert � ranger les codes de paternit�
		chemin = new int [n][m];
		disp = new double[n][m];
		
		//initialisation de chemin
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				chemin[i][j] = 0;
			}
		}
		chemin[0][0] = 1;
		
		warpingDistance = 0.0;
		this.fill();
		moyenne=this.moyenneCepstre();

	}

	public void fill() { // remplit dl, DA, ksi et display
		double accumulatedDistance = 0.0;
		
		double[][] dl = new double[n][m]; // distances locales
		double[][] DA = new double[n][m]; // distances accumul�es
		//double[][] localDisplay = new double[n][m];

		// initialisation dl
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dl[i][j] = distanceVect(seq1[i], seq2[j]);
			}
		}

		// initialisation DA
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				DA[i][j] = Double.POSITIVE_INFINITY;
			}
		}

		// initialisation localDisplay
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//localDisplay[i][j] = -1.0;
			}
		}

		DA[0][0] = dl[0][0]; // initialisation de la premi�re case de DA

		for (int i = 1; i < n; i++) { // remplissage premi�re colonne
			DA[i][0] = dl[i][0] + DA[i - 1][0];
			ksi[i][0] = 3; // le père est la case du dessus
		}

		for (int j = 1; j < m; j++) { // remplissage premi�re ligne
			DA[0][j] = dl[0][j] + DA[0][j - 1];
			ksi[0][j] = 1; // le p�re est la case � gauche
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				double dloc = dl[i][j];
				double a = (DA[i][j - 1]) + dloc;
				double b = (DA[i - 1][j - 1]) + GAMMA * dloc;
				double c = (DA[i - 1][j]) + dloc;
				double v = tripleMin(a, b, c);

				DA[i][j] = v;
				accumulatedDistance = v;
				
				 //d�terminer le p�re (i, j) et le m�moriser dans ksi
				if (v == a) {
					ksi[i][j] = 1;
					
				} else if (v == b) {
					ksi[i][j] = 2;
					
				} else if (v == c) {
 					ksi[i][j] = 3;
 				 					
				}
			}

		}
		
		accumulatedDistance = DA[n-1][m-1];
		int i = n - 1;
		int j = m - 1;
		
		while (i != 0 || j != 0) {
			disp[i][j] = DA[i][j]/coefNorm ;
			chemin[i][j] = 1;
			pathLength += 1;
			
			if (ksi[i][j] == 1) {
				j--;
				coefNorm += 1;
			} else if (ksi[i][j] == 2) {
				i--;
				j--;
				coefNorm += GAMMA;
			} else if (ksi[i][j] == 3){
				i--;
				coefNorm += 1;
			}
			
		}
		
		warpingDistance = accumulatedDistance / coefNorm;
	}

	public double getWP() {
		return warpingDistance;
	}

	public int[][] getKsi() {
		return ksi;
	}
	
	public int[][] getChemin() {
		return chemin;
	}

	public double[][] getDisp() {
		return disp;
	}
	
	public double tripleMin(double a, double b, double c) {
		return Math.min(Math.min(a, b), c);
	}

	public int getN() { // longueur du premier signal, sample
		return n;
	}

	public int getM() { // longueur du deuxi�me signal, template
		return m;
	}


	public double distanceVect(double[] sig1, double[] sig2) {
		int l = sig1.length;
		double u0 = sig1[0] - sig2[0];
		double s = u0 * u0;

		for (int i = 1; i < l; i++) {
			double u = sig1[i] - sig2[i];
			s += u*u;
		}
		return Math.sqrt(s);
	}
	
	public double getCN(){
		return coefNorm;
	}
	
	public Cepstre moyenneCepstre() {
		
		double[][] result = new double[pathLength][seq1[0].length];
		int i = n-1;
		int j = m-1;
		int current = pathLength-1;
		while (current>=0 && (i>0 || j>0)) {
			result[current] = moyenneVect(seq1[i], seq2[j]);
			int next = ksi[i][j];
			switch(next) {
			case 1 :
				j--;
				break;
			case 2 :
				i--;
				j--;
				break;
			case 3 :
				i--;
				break;
			}
			current--;
		}
		return new Cepstre(result);
	}
	
	public double[] moyenneVect(double[] vect1, double[] vect2) {
		
		int length = vect1.length;
		double[] result = new double[length];
		for (int i=0; i<length; i++) {
			result[i] = (vect1[i]+vect2[i])/2;
		}
		return result;
	}
	
	public Cepstre getMoyenne() {
		
		return moyenne;
	}

}
