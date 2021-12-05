import java.util.Arrays;
import java.util.List;

public class logRegressionSimple {

    List<Data> dataSet = dataSetSimple.readData("arrayD2.txt");
    int size = dataSet.size();

    private final double[][] input_x = new double [size][2];
    private final double[][] output_y = new double [size][1];
    double[] weights = new double [2];

    private void getDataSimple(){
        for (int i = 0; i < size; i++){
            Data aux = dataSet.get(i);
            input_x[i][0] = 1;
            input_x[i][1] = aux.getInput_x();
            output_y[i][0] = aux.getOutput_y();

        }
        System.out.println(Arrays.deepToString(input_x));
        Arrays.fill(weights, 0.0);
    }

    public double [] generateWeights(){
        getDataSimple();
        CostFunction calculator = new CostFunction(input_x,output_y,weights);
        return calculator.costFuncMin();
    }
}
