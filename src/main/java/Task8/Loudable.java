package Task8;

public interface Loudable {
  default String giveVoice() {
    return "!!!";
  }
}
