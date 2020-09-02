package randomuser_models;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Location {

  private Street street;
  private String city;
  private String state;
  private String country;
  private String postcode;
  private Coordinates coordinates;
  private Timezone timezone;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}