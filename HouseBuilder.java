package GameSceneRenderer;

public class HouseBuilder {
	 private int[] position;
     private int[] size;
     private SceneHouseType sceneHouseType;
     private String material;

     public HouseBuilder setPosition(int[] position) {
         this.position = position;
         return this;
     }

     public HouseBuilder setSize(int[] size) {
         this.size = size;
         return this;
     }

     public HouseBuilder setSceneHouseType(SceneHouseType sceneHouseType) {
         this.sceneHouseType = sceneHouseType;
         return this;
     }

     public HouseBuilder setMaterial(String material) {
         this.material = material;
         return this;
     }

     public House build() {
         return new House(position, size, sceneHouseType, material);
     }
}
