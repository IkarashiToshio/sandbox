import java.util.*;

class TestJEP286_2 {
  public static void main(String[] args) {
    var list = new ArrayList<SuperInteface>();
    list.add(new SubInterface1());
    list.add(new SubInterface2());
  }
}

interface SuperInteface {
}

class SubInterface1 implements SuperInteface {

}

class SubInterface2 {

}