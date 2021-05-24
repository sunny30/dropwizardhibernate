package io.com.dropwizard.resource;

import com.codahale.metrics.annotation.Timed;
import io.com.dropwizard.entity.GuestEntity;
import io.com.dropwizard.entity.dao.GuestEntityDAO;
import io.com.dropwizard.request.CreateGuestRequest;
import io.com.dropwizard.response.GuestResponse;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    private GuestEntityDAO dao;

    public SampleResource(GuestEntityDAO dao){
        this.dao = dao ;
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/createguest")
    public Response createGuest(final CreateGuestRequest request){
        GuestEntity entity = new GuestEntity(request.getFirstName(),request.getLastName(),request.getEmail()) ;
        try {

            GuestEntity postRequest = dao.create(entity);
            return Response.status(Response.Status.CREATED).entity(postRequest.getId()).build() ;
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build() ;
        }

    }


    @GET
    @Timed
    @UnitOfWork
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGuest(@QueryParam("id") String id){


        if(id==null){
            List<GuestEntity> guestEntities = dao.findAll() ;
            List<GuestResponse> guestResponses = new ArrayList<GuestResponse>() ;
            for(GuestEntity guestEntity : guestEntities){
                GuestResponse response = new
                        GuestResponse(guestEntity.getFirstName(), guestEntity.getLastName(),
                        guestEntity.getEmail(), guestEntity.getId());
                guestResponses.add(response);
            }
            return Response.ok(guestResponses).build();
        }else {
            Long index = Long.parseLong(id);
            GuestEntity guestEntity = dao.findById(index);
            if (guestEntity == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            GuestResponse response = new
                    GuestResponse(guestEntity.getFirstName(), guestEntity.getLastName(),
                    guestEntity.getEmail(), index);

            return Response.ok(response).build();
        }



    }


}
