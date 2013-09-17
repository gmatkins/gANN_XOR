package gANN;

public class GInputNode implements IGInputSource{
	private float value;
	
	public GInputNode(){

	}
	
	public void setValue(float value){this.value = value;}
	
	@Override
	public float getOutput() {
		return value;
	}

}
