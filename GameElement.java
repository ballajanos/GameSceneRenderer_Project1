package GameSceneRenderer;

public abstract class GameElement {

		public int[] position;
		private int[] size;
		
		public GameElement(int[] position, int[] size) {
			this.position = position;
			this.size = size;
		}

		public int[] getPosition() {
			return position;
		}

		public int[] getSize() {
			return size;
		}
		
		protected boolean isInTheHouse(int[] targetPosition, int[] houseBase, int[] houseDimensions, int[] characterSize) {
		    return (targetPosition[0] >= houseBase[0] && targetPosition[0] <= houseBase[0] + houseDimensions[0] && targetPosition[1] >= houseBase[1] && targetPosition[1] <= houseBase[1] + houseDimensions[1])
		            || (targetPosition[0] + characterSize[0] >= houseBase[0] && targetPosition[0] + characterSize[0] <= houseBase[0] + houseDimensions[0] &&  targetPosition[1] + characterSize[1] >= houseBase[1] && targetPosition[1] + characterSize[1] <= houseBase[1] + houseDimensions[1]);
		}
		
	}
