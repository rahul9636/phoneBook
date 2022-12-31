package org.example.phoneBook.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;


@Data
@JsonIgnoreProperties
public class ImageUpload {
    @JsonProperty("image_name")
    String ImageName; //File name with extension
    @JsonProperty("image_path")
    String ImagePath; //Location of image
}
