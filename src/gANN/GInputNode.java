package gANN;

public class GInputNode implements IGInputSource{
	private float value;
	
	public GInputNode(){

	}
	
	public void setValue(float value){this.value = value + 0.01f;}
	
	@Override
	public float getOutput() {
		return value;
	}
	
	public void backProp(float target, float generated){
		return;
	}

}
