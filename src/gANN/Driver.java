package gANN;

public class Driver {

	public static void main(String[] args) {
		int maxLoops = 52;
		float[][] inputVals = 
			{{0f,0f,0f},{0f,1f,1f},{1f,0f,1f},{1f,1f,0f}};
		String func = " OR ";
		
		boolean trainIndividual = false;
		boolean trainSet = true;
		
		/********************3 Layer Network********************/
		GNeuron output = new GNeuron();
		
		GNeuron hidden1 = new GNeuron();
		GNeuron hidden2 = new GNeuron();
		GNeuron hidden3 = new GNeuron();
		
		GNeuron inputNode1 = new GNeuron();
		GNeuron inputNode2 = new GNeuron();
		
		GInputNode input1 = new GInputNode();
		GInputNode input2 = new GInputNode();
		
		inputNode1.addInput(input1);
		inputNode1.addInput(input2);
		
		inputNode2.addInput(input1);
		inputNode2.addInput(input2);
		
		hidden1.addInput(inputNode1);
		hidden1.addInput(inputNode2);
		
		hidden2.addInput(inputNode1);
		hidden2.addInput(inputNode2);
		
		hidden3.addInput(inputNode1);
		hidden3.addInput(inputNode2);
		
		output.addInput(hidden1);
		output.addInput(hidden2);
		output.addInput(hidden3);
		/*****************************************/
		
		/***************Buckland Style Fully Connected Network****
		
		GNeuron output = new GNeuron();
		GNeuron hidden = new GNeuron();	
		GInputNode input1 = new GInputNode();
		GInputNode input2 = new GInputNode();
		
		hidden.addInput(input1);
		hidden.addInput(input2);
		
		output.addInput(input1);
		output.addInput(input2);
		output.addInput(hidden);
		******************************************************/
		
		float currentOutput;
		
		if(trainIndividual){
			System.out.print("Train for 0");
			System.out.print(func);
			System.out.println("0");
			for (int i = 0; i < maxLoops; i++){
				input1.setValue(inputVals[0][0]);
				input2.setValue(inputVals[0][1]);
				currentOutput = output.getOutput();
				System.out.print(input1.getOutput());
				System.out.print(func);
				System.out.print(input2.getOutput());
				System.out.print(" = ");
				System.out.print(currentOutput);
				System.out.print(" expected ");
				System.out.println(inputVals[0][2]);
				output.backProp(inputVals[0][2], currentOutput);
				if(i%4 == 3){
					System.out.println("------------------------");
					//try{System.in.read();}catch(Exception e){}
				}
				
			}
			
			System.out.print("Train for 0");
			System.out.print(func);
			System.out.println("1");
			for (int i = 0; i < maxLoops; i++){
				input1.setValue(inputVals[1][0]);
				input2.setValue(inputVals[1][1]);
				currentOutput = output.getOutput();
				System.out.print(input1.getOutput());
				System.out.print(func);
				System.out.print(input2.getOutput());
				System.out.print(" = ");
				System.out.print(currentOutput);
				System.out.print(" expected ");
				System.out.println(inputVals[1][2]);
				output.backProp(inputVals[1][2], currentOutput);
				if(i%4 == 3){
					System.out.println("------------------------");
					//try{System.in.read();}catch(Exception e){}
				}
				
			}
			
			System.out.print("Train for 1");
			System.out.print(func);
			System.out.println("0");
			for (int i = 0; i < maxLoops; i++){
				input1.setValue(inputVals[2][0]);
				input2.setValue(inputVals[2][1]);
				currentOutput = output.getOutput();
				System.out.print(input1.getOutput());
				System.out.print(func);
				System.out.print(input2.getOutput());
				System.out.print(" = ");
				System.out.print(currentOutput);
				System.out.print(" expected ");
				System.out.println(inputVals[2][2]);
				output.backProp(inputVals[2][2], currentOutput);
				if(i%4 == 3){
					System.out.println("------------------------");
					//try{System.in.read();}catch(Exception e){}
				}
				
			}
			
			System.out.print("Train for 1");
			System.out.print(func);
			System.out.println("1");
			for (int i = 0; i < maxLoops; i++){
				input1.setValue(inputVals[3][0]);
				input2.setValue(inputVals[3][1]);
				currentOutput = output.getOutput();
				System.out.print(input1.getOutput());
				System.out.print(func);
				System.out.print(input2.getOutput());
				System.out.print(" = ");
				System.out.print(currentOutput);
				System.out.print(" expected ");
				System.out.println(inputVals[3][2]);
				output.backProp(inputVals[3][2], currentOutput);
				if(i%4 == 3){
					System.out.println("------------------------");
					//try{System.in.read();}catch(Exception e){}
				}
				
			}
		}
		
		if(trainSet){
			System.out.println("Train for whole set.");
			for (int i = 0; i < maxLoops; i++){
				input1.setValue(inputVals[i%4][0]);
				input2.setValue(inputVals[i%4][1]);
				currentOutput = output.getOutput();
				System.out.print(input1.getOutput());
				System.out.print(func);
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

}
