package Bai6.AbstractVaInterface.ThucHanh.LopAnimalVaInterfaceEdiblle;

public class LopAnimalVaInterfaceEdiblle {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
        Fruit []fruits=new Fruit[]{new Orange(),new Apple()};
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}

