package jan29.queue_with_objects;

import datatypes.Queue;

public class PatientsQueue {

    private int nextNumberInLine = 1;

    private int size = 0;

    private Queue<Patient> queue;

    public PatientsQueue() {
        this.queue = new Queue<Patient>();
    }

    public void insert(Patient patient) {
        // O(1)
        this.size += 1;
        patient.setNumberInLine(this.nextNumberInLine);
        this.nextNumberInLine += 1;
        this.queue.insert(patient);
    }

    public boolean remove(Patient patient) {

        // n is the number of patients in the queue
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        Queue<Patient> temp = new Queue<>();

        while (!this.queue.isEmpty()) {
            temp.insert(this.queue.remove());
        }

        boolean removed = false;

        while (!temp.isEmpty()) {
            Patient current = temp.remove();
            if (!removed && current.equals(patient)) {
                removed = true;
                continue;
            }
            this.queue.insert(patient);
        }

        if (removed) {
            this.size -= 1;
        }

        return removed;
    }

    public int size() {
        // O(1)
        return this.size;
    }

    public void insertUrgentPatient(Patient urgentPatient) {

        // n is the number of patients
        // Time Complexity: O(n)
        // Space Complexity: O(n)

        Queue<Patient> temp = new Queue<>();

        int firstNumberInLine = -1;

        boolean first = true;

        while (!this.queue.isEmpty()) {
            Patient current = this.queue.remove();
            if (first) {
                first = false;
                firstNumberInLine = current.getNumberInLine();
            }
            current.setNumberInLine(current.getNumberInLine() + 1);
            temp.insert(current);
        }

        urgentPatient.setNumberInLine(firstNumberInLine);

        this.queue.insert(urgentPatient);

        while (!temp.isEmpty()) {
            this.queue.insert(temp.remove());
        }

        this.size += 1;
        this.nextNumberInLine += 1;
    }

    @Override
    public String toString() {
        return this.queue.toString();
    }

}
