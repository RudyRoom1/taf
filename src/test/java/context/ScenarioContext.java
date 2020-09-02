package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

  private final ThreadLocal<Map<String, Object>> scenarioContext = ThreadLocal.withInitial(HashMap::new);

  public <T> T setContext(String key, T value) {
    scenarioContext.get().put(key.toString(), value);
    return value;
  }

  public <T> T getContext(String key) {
    return (T) scenarioContext.get().get(key.toString());
  }

  public Boolean isContains(String key) {
    return scenarioContext.get().containsKey(key.toString());
  }

  public void reset() {
    scenarioContext.get()
        .clear();
  }

}
