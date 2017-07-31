package com.example.katerynakravchenko.fasebook.libs.base;

import android.widget.ImageView;

/**
 * Created by katerynakravchenko on 17.07.17.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}