import java.util.*;

class TestJEP286 {
  public static void main(String[] args) {
    var list = new ArrayList<String>();
    list = new ArrayList<Integer>();
    list.add("test");
    System.out.println(list.get(0).getClass());
    System.out.print(list);
  }
}