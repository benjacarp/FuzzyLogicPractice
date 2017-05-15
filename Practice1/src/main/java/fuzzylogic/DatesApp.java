package fuzzylogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class DatesApp {

    public static double calculate() throws Exception {
        // Load from 'FCL' file
        String fileName = "C:/Users/benjamin.salas/Downloads/dates.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return 0;
        }

        // Show
        FunctionBlock functionBlock = fis.getFunctionBlock("dates");
//        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("lastTime", 6);
        fis.setVariable("age", 25);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
//        Variable tip = functionBlock.getVariable("necessity");
//        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Obtain solution
        return fis.getVariable("necessity").getValue();
    }

}
