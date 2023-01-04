package ContantVariables;

import java.util.HashMap;
import Exceptions.Exceptions.EvaluationException;

public class CVars {
    private HashMap<String, Double> variables = new HashMap<String, Double>();
    public CVars() {
        variables.put("E", Math.exp(1));
        variables.put("PI", Math.PI);
        variables.put("C", 299792458.0);
        variables.put("PHI", (Math.sqrt(5) + 1) / 2);
        variables.put("NPHI", (-Math.sqrt(5) + 1) / 2);
    }

    public Double get(String key) throws EvaluationException {
        Double d =  variables.get(key);
        if (d == null) throw new EvaluationException("Variable " + key + " does not exist");
        return d;
    }
}
