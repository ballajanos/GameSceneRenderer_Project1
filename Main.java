package GameSceneRenderer;

import java.util.List;

public class Main {


	public static void main(String[] args) {

		Board board = new Board(20,20);
		
		House europeanHouse = House.builder().setPosition(new int[] { 1, 3 }).setSize(new int[] { 3, 4 })
                .setSceneHouseType(SceneHouseType.european).setMaterial("Concrete").build();
        House asianHouse = House.builder().setPosition(new int[] { 5, 5 }).setSize(new int[] { 4, 3 })
                .setSceneHouseType(SceneHouseType.asian).setMaterial("Bamboo").build();
        House africanHouse = House.builder().setPosition(new int[] { 12, 10 }).setSize(new int[] { 4, 6 })
                .setSceneHouseType(SceneHouseType.african).setMaterial("Wail and Cane").build();
		
		board.addNewElement(europeanHouse);
		board.addNewElement(asianHouse);
		board.addNewElement(africanHouse);
		
		Character character1=new Character(CharacterType.fairy, 254,new int[] {0,0}, new int[] {2,2}, "fly");
		board.addNewCharacter(character1);
		character1.characterMoveTo(new int[] {51,4},board);
		character1.characterMoveTo(new int[] {19,18},board);
		character1.characterMoveTo(new int[] {2,17},board);
		
		Character character2=new Character(CharacterType.elf, 91,new int[] {0,0}, new int[] {1,1}, "hide");
		board.addNewCharacter(character2);
		character2.characterMoveTo(new int[] {2,16},board);
		character2.characterMoveTo(new int[] {12,16},board);
		character2.characterMoveTo(new int[] {12,17},board);
		
		Character character3=new Character(CharacterType.giant, 74,new int[] {0,0}, new int[] {7,7}, "tread on");
		board.addNewCharacter(character3);
		character3.characterMoveTo(new int[] {6,4},board);
		character3.characterMoveTo(new int[] {5,2}, board);
		
		Character character4=new Character(CharacterType.human, 35,new int[] {0,0}, new int[] {2,2}, "friendly");
		board.addNewCharacter(character4);
		character4.characterMoveTo(new int[] {18,18}, board);
		
		
		Group group=new Group(List.of(character1, character4));
		group.groupMoveTo(new int[] {6,14}, board);
		
		System.out.println("\n");
		board.render();
	}

}
