package org.example.phoneBook.support;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    long imageId;

    @Column(name = "Image_name")
    String imageName;

    @Column(name = "Image_path")
    String imagePath;

    public ImageData(String imageName, String imagePath) {
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}
