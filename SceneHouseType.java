package GameSceneRenderer;

public enum SceneHouseType {

	european(1), asian(2), african(3);
	
	private int sceneHouseType;

	private SceneHouseType(int sceneHouseType) {
		this.sceneHouseType = sceneHouseType;
	}

	public int getSceneHouseType() {
		return sceneHouseType;
	}
}
