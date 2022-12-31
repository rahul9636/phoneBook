package org.example.phoneBook.resources;

import io.dropwizard.hibernate.UnitOfWork;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.example.phoneBook.models.BlogData;
import org.example.phoneBook.models.ImageDataDao;
import org.example.phoneBook.models.ImageUpload;
import org.example.phoneBook.support.ImageData;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/Blog")
@Produces(MediaType.APPLICATION_JSON)
public class BlogEntryResource {
    ImageDataDao imageDataDao;

    @Inject
    public BlogEntryResource(ImageDataDao imageDataDao) {
        this.imageDataDao=imageDataDao;
    }
    @POST
    @Path("/saveBlog")
    public Response saveBlog(@NonNull BlogData blogData) {
        return Response.ok(blogData).build();
    }

    /**
     * The images will be stored in client side (UI)
     * whenever new image will be uploaded UI will call backend on this endPoint with name and path of image
     * and backend will return ID of the image ,
     * when blog is fetched , UI will call backend with the id and backend will return Image name and path .
     */
    @POST
    @Path("/saveImage")
    @UnitOfWork
    public Response saveImage(@NonNull ImageUpload imageUpload) {
        ImageData imageData = new ImageData(imageUpload.getImageName(),imageUpload.getImagePath());
        try{
            long index = imageDataDao.saveImage(imageData);
            return Response.ok(index).build();
        } catch (Exception e){
            System.out.println(e);
            return Response.ok("Image not saved").build();
        }
    }
}
