package randomuser_models;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RandomUser {

  private String gender;
  private Name name;
  private Location location;
  private String email;
  private Login login;
  private Dob dob;
  private Registered registered;
  private String phone;
  private String cell;
  private Id id;
  private Picture picture;
  private String nat;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
