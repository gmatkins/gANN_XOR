package gANN;

import java.util.Vector;
import java.util.Random;
import java.lang.Math;

public class GNeuron implements IGInputSource{
	private class inputSource{
		private IGInputSource source;
		private float value;
		private float weight;
		
		public inputSource(IGInputSource source, float weight){
			this.source = source;
			this.weight = weight;
			value = 0.0f;
		}
	};
	private Vector<inputSource> inputs = new Vector<inputSource>();
	
	public GNeuron(){

	}

	@Override
	public float getOutput() {
		float weightedInput = 0.0f;
		
		for (inputSource input: inputs){
			input.value = input.source.getOutput();
			weightedInput += input.value * input.weight;
		}
		
		return (float)(weightedInput/Math.sqrt(1 + (weightedInput * weightedInput)));
	}
	
	public void backProp(float target, float generated){
		if (target == generated) return;
		for (inputSource input: inputs){
			//System.out.println(input.value);
			float error = (target - generated);
			input.weight += 0.1 * error * input.value;
			input.source.backProp(target, input.value);
		}
	}
	
	public void addInput(IGInputSource newInput){
		inputs.add(new inputSource(newInput, new Random().nextFloat()));
	}
}
