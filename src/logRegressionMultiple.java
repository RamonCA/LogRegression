import java.util.Arrays;
import java.util.List;

public class logRegressionMultiple {

    List<Data> dataSet = dataSetSimple.readData("inputs.txt");
    int size = dataSet.size();

    int sizeInner = dataSet.get(0).inputs.size();

    private final double[][] input_x = new double [size][sizeInner + 1];
    private final double[][] output_y = new double [size][1];
    double[] weights = new double [sizeInner + 1];

    private void getDataMultiple(){
        for (int i = 0; i < size; i++){
            Data aux = dataSet.get(i);
            input_x[i][0] = 1;
            for (int j = 1; j < sizeInner + 1; j++) {
                input_x[i][j] = aux.getInputs().get(j - 1);
            }
            output_y[i][0] = aux.getOutput_y();

        }
        //System.out.println(Arrays.deepToString(input_x));
        Arrays.fill(weights, 0.0);
    }

    public double [] generateWeights(){
        getDataMultiple();
        CostFunction calculator = new CostFunction(input_x,output_y,weights);
        return calculator.costFuncMin();
    }
}
