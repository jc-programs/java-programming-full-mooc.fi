/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class Cat extends Animal implements NoiseCapable {

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        this("Dog");
    }

    public void purr() {
        System.out.println(this.getName() + " purrs");
    }

    public void makeNoise() {
        this.purr();
    }
}
