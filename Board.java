package GameSceneRenderer;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private int width;
	private int length;
	private List<GameElement> elements;
	private List<Character> characters;
	
	public Board(int width, int length) {
		this.width = width;
		this.length = length;
		this.elements = new ArrayList<>();
		this.characters=new ArrayList<>();
	}
	
	
	public int getWidth() {
		return width;
	}


	public int getLength() {
		return length;
	}


	public int calculateGroupSize(Group group) {
		return group.sizeCalculation();
	}
	
	public void addNewElement(GameElement elem) {
		elements.add(elem);
	}
	
	public void addNewCharacter(Character charac) {
		characters.add(charac);
	}

	public List<GameElement> getElements() {
		return elements;
	}
	
	public List<Character> getCharacters() {
		return characters;
	}
	
	public void render() {
		elements.forEach(element -> System.out.println(element));
		characters.forEach(character -> System.out.println(character));
	}
}
