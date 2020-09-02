package randomuser_models;

import java.util.HashMap;
import java.util.Map;

public class Registered {

  private String date;
  private Integer age;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}