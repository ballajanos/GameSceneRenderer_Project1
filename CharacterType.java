package GameSceneRenderer;

public enum CharacterType {

	human(1), elf(2), giant(3), fairy(4);
	
	private int characterType;
	
	private CharacterType(int characterType) {
		this.characterType = characterType;
	}

	public int getCharacterType() {
		return characterType;
	}

}
