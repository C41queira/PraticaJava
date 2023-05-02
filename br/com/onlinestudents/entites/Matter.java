package br.com.onlinestudents.entites;

import java.util.Set;
import java.util.TreeSet;

public class Matter {
    
    Set<Integer> students = new TreeSet<>();

    public Set<Integer> getStudents() {
        return students;
    }

    public void setStudents(Set<Integer> students) {
        this.students = students;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((students == null) ? 0 : students.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matter other = (Matter) obj;
        if (students == null) {
            if (other.students != null)
                return false;
        } else if (!students.equals(other.students))
            return false;
        return true;
    } 

    
}
