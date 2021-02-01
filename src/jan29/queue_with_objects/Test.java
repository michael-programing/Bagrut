package jan29.queue_with_objects;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        PatientsQueue patientsQueue = new PatientsQueue();
        patientsQueue.insert(new Patient("Bob", "123456789"));
        patientsQueue.insert(new Patient("Jhon", "13579111"));
        patientsQueue.insert(new Patient("David", "2468101"));

        System.out.println(patientsQueue);

        Scanner in = new Scanner(System.in);

        System.out.print("Enter patient's name: ");
        String name = in.next();
        System.out.print("Enter patients id number: ");
        String id = in.next();

        patientsQueue.insertUrgentPatient(new Patient(name, id));

        System.out.println(patientsQueue.size());
        System.out.println(patientsQueue);
        in.close();

    }

}
