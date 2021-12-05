import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Agent_Main extends Agent {

    private AgentGUI myGUI;
    protected void setup() {
        myGUI=new AgentGUI(this);
        myGUI.showGui();
    }

    public void getMultiple(final String vals ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                String [] arrValues;
                arrValues = vals.split(",");
                logRegressionMultiple test2 = new logRegressionMultiple();
                double [] inputs = new double [arrValues.length];

                for (int i = 0; i < arrValues.length; i++) {
                    inputs[i] = Double.parseDouble(arrValues[i]);
                }
                //System.out.println("Calculando");
                Clasification cls = new Clasification(test2.generateWeights(), inputs);
                System.out.println(cls.clasification());
            }
        } );
    }
    public void getSimple(final String x_simple ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                logRegressionSimple test = new logRegressionSimple();
                double [] inputs = new double [1];

                inputs[0] = Double.parseDouble(x_simple);
                //System.out.println("Calculando");
                Clasification cls = new Clasification(test.generateWeights(), inputs);
                System.out.println(cls.clasification());
            }
        } );
    }
}
