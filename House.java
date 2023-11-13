package GameSceneRenderer;

public class House extends GameElement {

	private SceneHouseType sceneHouseType;
	private String material;


	public House(int[] position, int[] size, SceneHouseType sceneHouseType, String material) {
		super(position, size);
		this.sceneHouseType = sceneHouseType;
		this.material = material;
	}
	

	public String getMaterial() {
		return material;
	}


	public boolean isOccupiedPosition(int[] newPosition, int[] characterSize) {
	    return isInTheHouse(newPosition, getPosition(), getSize(), characterSize);
	}
	
	@Override
	public String toString() {
		return sceneHouseType + " house has (" + getPosition()[0] + ", " + getPosition()[1] + ") position, with (" + getSize()[0] + ", " + getSize()[1] + ") size";
	}
	
	public static HouseBuilder builder() {
	    return new HouseBuilder();
	}

}


