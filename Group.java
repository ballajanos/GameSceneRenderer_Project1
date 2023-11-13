package GameSceneRenderer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {

	private List<Character> characters;
	private int size;
	
	public Group(List<Character> characters) {
		this.characters = characters;
		this.size = sizeCalculation();
	}
	
	public int sizeCalculation() {
		return characters.stream().mapToInt(character -> character.getSize()[0]*character.getSize()[1]).sum();
	}
	
	public void groupMoveTo(int[] newPosition, Board board) {
		characters.forEach(character -> character.characterMoveTo(newPosition, board));
	}
	
	@Override
	public String toString() {
		String characterTypes=characters.stream().map(character -> character.getCharacterType().toString()).collect(Collectors.joining(", "));
		return "The group size is: " + sizeCalculation() + ", which contains " + characterTypes + "characters";
	}
}