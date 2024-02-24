package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Optional<Blog>optionalBlog=blogRepository2.findById(blogId);
      Blog blog=optionalBlog.get();
        Image image=new Image();

           image.setDescription(description);
           image.setDescription(dimensions);
           image.setBlog(blog);
        blog.getImageList().add(image);

         blogRepository2.save(blog);
        return imageRepository2.save(image);

    }

    public void deleteImage(Integer id){
          Optional<Image> optionalImage=imageRepository2.findById(id);
        Image image=optionalImage.get();

        imageRepository2.delete(image);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
           Optional<Image> optionalImage=imageRepository2.findById(id);
            Image image=optionalImage.get();
            String[] givenDimension=screenDimensions.split("X");
            String dimension= image.getDimensions();
            String[] splitDim=dimension.split("X");

            int count =0;
            int imagx=Integer.parseInt(splitDim[0]);
        int imagy=Integer.parseInt(splitDim[1]);

        int divx=Integer.parseInt(givenDimension[0]);
        int divy=Integer.parseInt(givenDimension[1]);

        int countx=divx/imagx;
        int county=divy/imagy;

         count=countx*county;
        return count;
    }
}
