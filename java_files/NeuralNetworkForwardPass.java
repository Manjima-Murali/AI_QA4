public class NeuralNetworkForwardPass {

    static double relu(double x) {
        return Math.max(0, x);
    }

    static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static void main(String[] args) {

        double[] inputs = {1.5, 2.0};

        double[][] weightsInputHidden = {
                {0.8, 0.4},
                {0.3, 0.9}
        };

        double[] biasHidden = {0.2, 0.1};
        double[] weightsHiddenOutput = {0.5, 0.7};
        double biasOutput = 0.3;

        double[] hiddenOutput = new double[2];

        for (int i = 0; i < 2; i++) {
            double sum = inputs[0] * weightsInputHidden[i][0]
                       + inputs[1] * weightsInputHidden[i][1]
                       + biasHidden[i];

            hiddenOutput[i] = relu(sum);
        }

        double outputSum = hiddenOutput[0] * weightsHiddenOutput[0]
                         + hiddenOutput[1] * weightsHiddenOutput[1]
                         + biasOutput;

        double finalOutput = sigmoid(outputSum);

        System.out.println("Hidden Layer Output:");
        System.out.println("Neuron 1: " + hiddenOutput[0]);
        System.out.println("Neuron 2: " + hiddenOutput[1]);
        System.out.println("Final Output:");
        System.out.println(finalOutput);
    }
}
