package com.SCM.Smart_Contact_Manager.helpers;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){
        super("Resourse Not Found");
    }

}
