package context;

public enum ContextKeyEnums {
  USER_LIST("user_list_from_API"),
  FULL_NAME("user_full_name");
  private final String description;

  private ContextKeyEnums(String description) {
    this.description = description;
  }
}
