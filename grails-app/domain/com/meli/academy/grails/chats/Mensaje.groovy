package com.meli.academy.grails.chats

import java.util.Date;
import javax.persistence.JoinColumn

class Mensaje {


    String alias
	String mensaje
	Date fecha = new Date()
	boolean esImagen

    static constraints = {
    }
}
