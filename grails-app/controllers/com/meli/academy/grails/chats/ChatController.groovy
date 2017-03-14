package com.meli.academy.grails.chats
import java.io.File.*


class ChatController {

    def index() {
    }
	
    def entrar(String alias) {
        if (alias.trim() == '') {
            redirect(action:'index')
        } else {
            session.alias = alias
            render (view: 'chat')
        }
    }
	
	def obtenerUltimosMensajes() {
		def mensajes = Mensaje.listOrderByFecha(order: 'desc', max:10)
		[mensajes:mensajes.reverse()]
	
	}
	
	def submitMensaje(String mensaje) {
		new Mensaje(alias:session.alias, mensaje:mensaje, esImagen: false).save()
		render "<script>obtenerUltimosMensajes()</script>"
	}
	
	
	def upload() {
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "Archivo no puede ser vacio"
		} else {
			def mensaje = new Mensaje(alias:session.alias, mensaje:file.originalFilename, esImagen: true )
			file.transferTo(new File(grailsApplication.config.uploadFolder + mensaje.mensaje))
			mensaje.save()
			render(view:"chat")
		}
		
	}
}
