<!DOCTYPE html>
<html>
	<head>
	    <meta name="layout" content="main"/>
	    <title>MELI CHAT</title>
	    <g:javascript library="jquery"/>
	</head>
	<body>
		<div id="chatMensajes"></div>
		
		<input type="text" id="mensajeBox" name="mensaje" onkeypress="mensajeKeyPress(this, event);"/>
		
		<div id="temp"></div>

	
		<div class="content scaffold-create">
			<h1>Subir imagen</h1>
			<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
			<g:uploadForm action="upload">
				<fieldset class="form">
                    <input type="file" name="file" />
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="upload" class="save" value="Upload" />
				</fieldset>
			</g:uploadForm>
		</div>
		
	
		
		
		<script>
		    function mensajeKeyPress(field, event) {
		        var code = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		        var mensaje = $('#mensajeBox').val();
		        if (code == 13){
		            <g:remoteFunction action="submitMensaje" params="\'mensaje=\' + mensaje" update="temp"/>
		            $('#mensajeBox').val('');
		            return false;
		        } else {
		            return true;
		        }
		    }

		
		    function pollMensajes() {
		    	obtenerUltimosMensajes();
		        setTimeout('pollMensajes()', 5000);
		    }

		    function obtenerUltimosMensajes() {
		        <g:remoteFunction action="obtenerUltimosMensajes" update="chatMensajes"/>
		    }
		    
		    pollMensajes();
		</script>
	
	</body>
</html>