package com.features;

/**
 * give an enum, where each element has a parent-children relationship, and children's expression is the value of parent append an index, such as
 * enum vehicle {
 *          car = 1
 *              toyota = 11
 *                   camry = 111
 *                   corolla = 112
 *              honda = 12
 *         truck = 2
 *              GMC = 21
 * }
 *
 */
public class ParentChild {

    public enum Vehicle {
        CAR("1",null),
            TOYATA("1",CAR),
                CAMERY("1",TOYATA),
                CORALLA("2",TOYATA),
            HONDA("2",CAR),
        TRUCK("2",null),
            GMC("1",TRUCK)
        ;

        String value;
        Vehicle(String val, Vehicle parent) {
            if(parent!=null) {
                this.value = parent.value+val;
            } else {
                this.value = val;
            }

        }

        @Override
        public String toString() {
            return name()+":"+value;
        }
    }

    public static void main(String[] args) {
        System.out.println(Vehicle.TOYATA);
        System.out.println(Vehicle.CORALLA);
        System.out.println(Vehicle.GMC);
    }
}
