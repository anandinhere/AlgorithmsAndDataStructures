package string.CharCountBased;

public class Power {


    static int power(int x, int y){
        if(y==0){
            return 1;
        }

        int power = x;
      while(y >1){

          power = x * x;
          y--;
      }

      return power;

    }
}



