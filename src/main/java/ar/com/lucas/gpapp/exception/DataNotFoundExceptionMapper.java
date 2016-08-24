package ar.com.lucas.gpapp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ar.com.lucas.gpapp.entities.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage	= new ErrorMessage(exception.getMessage(),404,"http://alguna-pagina-loca.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
