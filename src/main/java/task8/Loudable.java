package task8;

public interface Loudable {
  default String giveVoice() {
    return "!!!";
  }
}
