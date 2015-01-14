package retaurant;
import java.util.ArrayList;
public class Carte {
private static ArrayList<Achetable> carte = new ArrayList<Achetable>();

public static void addElement(Achetable element){// on ajoute un elment à la carte en vérifiant qu'il est disponible ou pas déjà présent
	for(Achetable elementalacarte : carte){
	if(elementalacarte != element && element.Disponible())
	carte.add(element);
	}
}
public static void removeElement(Achetable element) throws Exception{
	if(carte == null)
		throw new Exception("la carte est vide");
    carte.remove(element);
}
public static void gestionCarte(){// on enleve les elements de la carte qui ne sont plus disponible
	for(Achetable element : carte){
		if(element.Disponible()==false)
			carte.remove(element);
	}
}
public static ArrayList<Achetable> getCarte(){
	return carte;
}
}
