public class Dog{
  public int weight;
  public Dog(int w){
    weight = w;
  }
  public static Dog maxdog(Dog d1,Dog d2){
    if(d1.weight > d2.weight){
      return d1;
    }
    return d2;
  }
  public void makeNoise(){
    if(weight < 10){
      System.out.println("Yip!");
    }
    else if(weight < 30){
      System.out.println("Bark!");
    }
    else{
      System.out.println("Aoooooo!");
    }
  }
}
