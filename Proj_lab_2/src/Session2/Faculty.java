package Session2;

public class Faculty {
    private Lab[] labs;
    private Student[] students;
    private Student master;
    private String name;
    private int labNum;

    /*
     * Create a new faculty with a name and lab number.
     *
     * @param name first name of student
     * @param labNum last name of student
    */
    public Faculty(String name, int labNum) {
        this.name = name;
        this.labNum = labNum;
    }

    /**
     * set labs of faculty
     */
    public void setLabs(Lab[] labs) {
        this.labs = labs;
    }

    /**
     * set students of faculty
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * set master students of faculty
     */
    public void setMaster(Student master) {
        this.master = master;
    }

    /**
     * set the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the lab name
     */
    public void setLabNum(int labNum) {
        this.labNum = labNum;
    }

    /**
     * get the labs of faculty
     * @return labs field
     */
    public Lab[] getLabs() {
        return labs;
    }

    /**
     * get the students of faculty
     * @return students field
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * get the master students of faculty
     * @return master field
     */
    public Student getMaster() {
        return master;
    }

    /**
     * get the name of faculty
     * @return name field
     */
    public String getName() {
        return name;
    }

    /**
     * get the lab number in faculty
     * @return labNum field
     */
    public int getLabNum() {
        return labNum;
    }
}