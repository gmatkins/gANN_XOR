package gANN;

public class Driver {

	public static void main(String[] args) {
		int maxLoops = 1000;
		float[][] inputVals = 
			{{0f,0f,0f},{0f,1f,1f},{1f,0f,1f},{1f,1f,0f}};
		
		GNeuron output = new GNeuron();
		GNeuron hidden1 = new GNeuron();
		GNeuron hidden2 = new GNeuron();
		GInputNode input1 = new GInputNode();
		GInputNode input2 = new GInputNode();
		
		hidden1.addInput(input1);
		hidden1.addInput(input2);
		
		hidden2.addInput(input1);
		hidden2.addInput(input2);
		
		output.addInput(hidden1);
		output.addInput(hidden2);
		
		float currentOutput;
		
		for (int i = 0; i < maxLoops; i++){
			input1.setValue(inputVals[i%4][0]);
			input2.setValue(inputVals[i%4][1]);
			currentOutput = output.getOutput();
			System.out.print(input1.getOutput());
			System.out.print(" XOR ");
			System.out.print(input2.getOutput());
			System.out.print(" = ");
			System.out.print(currentOutput);
			System.out.print(" expected ");
			System.out.println(inputVals[i%4][2]);
			output.backProp(inputVals[i%4][2], currentOutput);
			if(i%4 == 3){
				System.out.println("------------------------");
				//try{System.in.read();}catch(Exception e){}
			}
			
		}

	}

}
