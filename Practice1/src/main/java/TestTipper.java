import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class TestTipper {

    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "C:/Users/benjamin.salas/Downloads/tipper.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show
        FunctionBlock functionBlock = fis.getFunctionBlock("tipper");
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("service", 3);
        fis.setVariable("food", 7);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = functionBlock.getVariable("tip");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Obtain solution
        System.out.println("Output value:" + fis.getVariable("tip").getValue());

        // Print ruleSet
        System.out.println(fis);
    }
}
