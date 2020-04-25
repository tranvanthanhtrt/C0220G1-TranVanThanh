package Bai6.AbstractVaInterface.ThucHanh.LopAnimalVaInterfaceEdiblle;

public class Chicken extends Animal implements Edible {
    public Chicken() {
    }

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
