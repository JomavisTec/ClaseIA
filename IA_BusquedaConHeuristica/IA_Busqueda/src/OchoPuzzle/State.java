package OchoPuzzle;

public class State {
    private int[][] state;
    private int cost;
    private State parent;

    public State(int[][] state, int cost, State parent) {
        this.state = state;
        this.cost = cost;
        this.parent = parent;
    }

	public int[][] getState() {
		return state;
	}

	public int getCost() {
		return cost;
	}

	public State getParent() {
		return parent;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
