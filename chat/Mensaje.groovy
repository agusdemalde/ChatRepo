package com.meli.academy.grails.chat

import java.util.Date;

class Mensaje {

    String alias
	String mensaje
	Date fecha = new Date()
	

    static constraints = {
    }
}
