package constant;


/**
 * 구분자 모음
 */
public enum Delimiter {
  ITEM_SEPARATOR(";"),
  DETAIL_SEPARATOR(",");

  private final String symbol;

  Delimiter(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}
