/* Get the Capitulo template */
function getCapituloTemplate(_nomeLivro, _numeroCapitulo) {
    $.ajax({
    	async:false,
        url: "template/versiculo.tmpl",
        dataType: "html",
        success: function( data ) {
            $( "head" ).append( data );
            updateCapituloTable(_nomeLivro, _numeroCapitulo);
        }
    });
}

/* Builds the updated table for the capitulo list */
function buildCapituloRows(versiculos) {
    return _.template( $( "#versiculo-tmpl" ).html(), {"versiculos": versiculos});
}

/* Uses JAX-RS GET to retrieve current capitulo list */
function updateCapituloTable(_nomeLivro, _numeroCapitulo) {
    $.ajax({
    	async:false,
    	type: "GET",
		url: "api/capitulo?nomeLivro=" + _nomeLivro +"&numeroCapitulo=" + _numeroCapitulo,
		dataType: "json",
        success: function(data) {
            $('#versos').empty().append(buildCapituloRows(data));
        },
        error: function(error) {
            //console.log("error updating table -" + error.status);
        }
    });
}

/*
Attempts to register a new capitulo using a JAX-RS POST.  The callbacks
the refresh the capitulo table, or process JAX-RS response codes to update
the validation errors.
 */
function registerCapitulo(capituloData) {
    //clear existing  msgs
    $('span.invalid').remove();
    $('span.success').remove();

    $.ajax({
        url: 'api/capitulo',
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        data: JSON.stringify(capituloData),
        success: function(data) {
            //console.log("capitulo registrado");

            //clear input fields
            $('#reg')[0].reset();

            //mark success on the registration form
            $('#formMsgs').append($('<span class="success">Capitulo Registrado</span>'));

            updateCapituloTable();
        },
        error: function(error) {
            if ((error.status == 409) || (error.status == 400)) {
                //console.log("Validation error registering user!");

                var errorMsg = $.parseJSON(error.responseText);

                $.each(errorMsg, function(index, val) {
                    $('<span class="invalid">' + val + '</span>').insertAfter($('#' + index));
                });
            } else {
                //console.log("error - unknown server issue");
                $('#formMsgs').append($('<span class="invalid">Unknown server error</span>'));
            }
        }
    });
}