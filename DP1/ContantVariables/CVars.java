package ContantVariables;

import java.util.HashMap;

public class CVars {
    private HashMap<String, Double> variables = new HashMap<String, Double>();
    public CVars() {
        variables.put("E", Math.exp(1));
        variables.put("PI", Math.PI);
        variables.put("C", 299792458.0);
        variables.put("PHI", (Math.sqrt(5) + 1) / 2);
        variables.put("NPHI", (-Math.sqrt(5) + 1) / 2);
    }

    public Double get(String key) {
        return variables.get(key);
    }
}
