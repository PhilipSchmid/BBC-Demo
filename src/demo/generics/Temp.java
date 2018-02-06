package demo.generics;

public class Temp {

       public <T> T majority(T x, T y, T z) {
              if (x.equals(y)) { return x; }
              if (x.equals(z)) { return x; }
              if (y.equals(z)) { return y; }
              return null;
       }

       public static void main(String[] args) {
              Temp temp = new Temp();
              System.out.println(temp.majority(11, 22, 11));
       }
}
