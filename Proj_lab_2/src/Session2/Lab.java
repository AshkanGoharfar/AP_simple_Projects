package Session2;

public class Lab {

    private int avg;
    private String day;
    private int capacity;
    private int currentSize;
    private Student[] students;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param cap capacity of lab
     * @param d   day of enrolling
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
    }

    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * Print the lab’s student name and ID and the grade
     * output terminal.
     */
    public void print() {
        for (int i = 0; i < students.length; i++) {
            System.out.println("std fname: " + students[i].getFirstName() + " std id:" + students[i].getId() + " std grade:" + students[i].getGrade());
        }
        System.out.println("Lab AVG:" + avg);
    }

    /**
     * get all of the students
     * @return students object field
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * set all of the students
     */
    public void setStudents(Student[] students_1) {
        students = students_1;
    }

    /**
     * get the average grade of students
     * @return avg field
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculate the average grade of students
     */
    public void calculateAvg() {
        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getGrade();
        }
        avg = sum / students.length;
    }

    /**
     * get the day of enrolling
     * @return day field
     */
    public String getDay() {
        return day;
    }

    /**
     * set the day of enrolling
     */
    public void setDay(String day_1) {
        day = day_1;
    }

    /**
     * get the capacity of lab
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * ste the capacity of lab
     */
    public void setCapacity(int capacity_1) {
        capacity = capacity_1;
    }
}
