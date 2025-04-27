package parkinglot.exceptions;

public class GateIdExist extends RuntimeException{
    public GateIdExist(){
        super("Gate id Already Exist!!!");
    }
}
