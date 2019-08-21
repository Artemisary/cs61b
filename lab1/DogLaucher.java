public class DogLaucher {
    public static void main(String[] args) {
        Dog[] manydogs = new Dog[4];
        Dog smallDog = new Dog(5);
        Dog mediumDog = new Dog(25);
        Dog bigDog = new Dog(100);
        manydogs[0] = smallDog;
        manydogs[1] = mediumDog;
        manydogs[2] = bigDog;
        manydogs[3] = new Dog(130);
        int i=0;
        while(i < manydogs.length){
            Dog.maxdog(manydogs[i],mediumDog).makeNoise();
            i=i+1;
        }

    }
}
