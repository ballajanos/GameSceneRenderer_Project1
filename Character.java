package GameSceneRenderer;

import java.util.Arrays;

public class Character {
	
	private CharacterType characterType;
	private int age;
	private int[] position;
	private int[] size;
	private String abilities;
	
	public Character(CharacterType characterType, int age, int[] position, int[] size, String abilities) {
		this.characterType = characterType;
		this.age = age;
		this.position = position;
		this.size = size;
		this.abilities = abilities;
	}
	
	public int[] getPosition() {
		return position;
	}


	public void characterMoveTo(int[] newPosition, Board board) {
	    if (newPosition[0] < 0 || newPosition[0] >= board.getWidth() || newPosition[1] < 0 || newPosition[1] >= board.getLength()) {
	        System.out.println("Invalid move with " + characterType + "! The (" + newPosition[0] + ", " + newPosition[1] + ") position is outside the board bounds!");
	    } else if (newPosition[0] + size[0] >= board.getWidth() || newPosition[1] + size[1] >= board.getLength()) {
	        System.out.println("Invalid move with " + characterType + "! Because with the size: (" + size[0] + ", " + size[1] +"), with (" + newPosition[0] + ", " + newPosition[1] + ") position the character is outside the board bounds!");
	    } else {
	        if (canMoveTo(newPosition, board)) {
	            this.position = newPosition;
	            System.out.println("You can move there, " + characterType + " have occupied (" + position[0] + "," + position[1] + ") position!");
	        }
	    }
	}
	public boolean canMoveTo(int[] newPosition, Board board) {
	    for (Character charac : board.getCharacters()) {
	        if (!this.equals(charac) && Arrays.equals(charac.getPosition(), newPosition)) {
	        	 System.out.println("You can't move with " + characterType + " there, because in ("  + newPosition[0] + "," + newPosition[1] +  ") position is already a character!");
	            return false;
	        }
	    }
	    
	    for (Character charac : board.getCharacters()) {
	        if (!this.equals(charac) && isOverlap(newPosition, getSize(), charac.getPosition(), charac.getSize())) {
	            System.out.println("You can't move with " + characterType + " there, because in (" + newPosition[0] + "," + newPosition[1] + ") position you are going to uncover an other character!");
	            return false;
	        }
	    }
	    
	    for (GameElement elem : board.getElements()) {
	        if (elem instanceof House) {
	            House house = (House) elem;
	            if (house.isOccupiedPosition(newPosition,getSize()) || house.isInTheHouse(newPosition, house.getPosition(), house.getSize(), getSize())) {
	            	System.out.println("You can't move with " + characterType + " there, because in ("  + newPosition[0] + "," + newPosition[1] +  ") position is within a house!");
	                return false;
	            }
	        }
	    }
	    return true;
	}
								
	private boolean isOverlap(int[] pos1, int[] size1, int[] pos2, int[] size2) {
	    return (pos1[0] >= pos2[0] && pos1[0] <= pos2[0] + size2[0] && pos1[1] >= pos2[1] && pos1[1] <= pos2[1] + size2[1])
        || (pos1[0] + size1[0] >= pos2[0] && pos1[0] + size1[0] <= pos2[0] + size2[0] &&  pos1[1] + size1[1] >=pos2[1] && pos1[1] + size1[1] <= pos2[1] + size2[1]);
	}
	
	
	public int[] getSize() {
		return size;
	}

	public CharacterType getCharacterType() {
		return characterType;
	}
	
	@Override
	public String toString() {
		return characterType + " age is: " + age + ", which is in: (" + position[0] + ", " + position[1] + 
				") position, with (" + size[0] + ", " + size[1] + ") size, and with " + abilities + " abilities.";
	}
}
