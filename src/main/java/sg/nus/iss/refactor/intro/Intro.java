package sg.nus.iss.refactor.intro;

public class Intro {
  public static void main(String[] args) {
//    method16();
    printOddNumberAndStars();
  }

  public static void printOddNumberAndStars() {
    for (int oddNumber = 1; oddNumber <= 5; oddNumber+=2) {
      System.out.print(oddNumber);
      for (int star = 0; star < oddNumber; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
public static void method16() {
  for (int ironMan = 1; ironMan <= 9; ironMan++) {
    if (ironMan == 1) {
      System.out.print(1);
      System.out.print("*");
      System.out.println();
    } else if (ironMan == 2) {
      // Do nothing when ironMan is 2
    }
    if (ironMan == 3) {
      System.out.print(3);
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.println();
    } else if (ironMan == 4) {
      // Do nothing when ironMan is 4
    }
    if (ironMan == 6) {
      // Do nothing when ironMan is 6
    }
    if (ironMan > 6) {
      // Do nothing, either
      break;
    } else if (ironMan == 5) {
      System.out.print(5);
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.println();
    }
  }
}
}
