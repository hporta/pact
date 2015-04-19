package audio.mfcc;

public class Cepstre {

	private double[][] cepstre;
	
	public Cepstre(String fileName) {
		
		Signal signal = new Signal(fileName);
		cepstre = signal.getCepstres();
	}
	
	public Cepstre(double[][] cepstre) {
		
		this.cepstre = cepstre;
	}
	
	public double[][] getCepstre() {
		
		return cepstre;
		
	}
}
