<g:each in="${mensajes}" var="m">
    <div>
        <g:if test = "${m.esImagen == false}">
        <span class="alias">${m.alias}</span> - <span class="mensaje">${m.mensaje}</span>
        </g:if>
        <g:else>
        		<span class="alias">${m.alias}</span> - <span ><g:img dir="images" file="${m.mensaje}"/></span>
        </g:else>
    </div>
</g:each>
