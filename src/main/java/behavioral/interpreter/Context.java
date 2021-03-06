package behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Context
 */
public class Context {
    private Map<String, Boolean> values = new HashMap<String, Boolean>();

    public Boolean lookup(String variable) {
        Boolean result = values.get(variable);

        if (Objects.isNull(result)) {
            return false;
        }
        return values.get(variable);
    }

    public void assign(VariableExp variable, boolean value) {
        System.out.println("Przypisanie " + variable.getName() + " = " + value);
        values.put(variable.getName(), value);
    }
}
