package cn.newbie.designPatterns.factory.method.method_2;

public class Operation {
    private Double number_A;

    private Double number_B;

    public Double getResult(){
        Double result = 0d;

        return result;
    }

    public Double getNumber_A() {
        return number_A;
    }

    public void setNumber_A(Double number_A) {
        this.number_A = number_A;
    }

    public Double getNumber_B() {
        return number_B;
    }

    public void setNumber_B(Double number_B) {
        this.number_B = number_B;
    }
}
