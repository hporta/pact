package retaurant;

public interface Achetable {
	public float getPrix();
	public String getNom();
	public boolean Disponible();
	public void diminution() throws Exception;

}
