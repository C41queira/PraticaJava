package br.com.contractworked.entites;

public class Department {
    private String nameDepartment; 

    public Department(){
    }

    public Department(String nameDepartment){
        this.nameDepartment = nameDepartment; 
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
    public String getNameDepartment() {
        return nameDepartment;
    }
}
