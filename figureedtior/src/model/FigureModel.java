package model;

import javax.swing.ImageIcon;
import java.beans.*;


public class FigureModel {

    // Private variable for image path
    private ImageIcon imagePath = null;
    // Private variable for caption
    private String caption = null;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void FigureModel() {
        
        /**
         * Constructor in case no image is given
         */
    }

    public void FigureModel(ImageIcon image, String caption) {
        
        /**
         * Sets the global variables for imagepath and caption and stores them
         * Input: 
         *      image - ImageIcon
         *      caption - String
         */

        this.imagePath = image;
        this.caption = caption;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        
        /**
         * Adds Property Change Listener
         * Input:
         *      propertyChangeListener - PropertyChangeListener
         */

        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        
        /**
         * Removes the Property Change Listener
         * Input:
         *      propertyChangeListener - PropertyChangeListener
         */

        this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public ImageIcon getImage() {
        
        /**
         * returns the stored image. If no image it returns null
         */

	    return this.imagePath;
    }

    
    public void setImage(ImageIcon newImage) {
        
        /**
         * Sets the image to the given non-null ImageIcon.
         *
         * @param newImage The ImageIcon must be non-null
         *
         * @throws IllegalArgumentException if the ImageIcon is null
         */

        if (newImage == null) {
            throw new IllegalArgumentException("Your chosen image is null. Please reselect a non-null image!");
        }
        this.propertyChangeSupport.firePropertyChange("image", this.imagePath, newImage);
        this.imagePath = newImage;
    }

    public String getCaption() {
        
        /**
         * returns the caption. If no caption it returns null
         */

	    return this.caption;
    }

    
    public void setCaption(String newCaption) {
        
        /**
         * Sets the caption to the given non-null and non-empty String.
         *
         * @param newCaption The String must be non-null and non-empty
         *
         * @throws IllegalArgumentException if the String is null or empty
         */

        if (newCaption == null) {
            throw new IllegalArgumentException("Your chosen caption is null. Please rewrite a non-null caption!");
        }

        this.propertyChangeSupport.firePropertyChange("caption", this.caption, newCaption);
        this.caption = newCaption;
    }

    
    public boolean isComplete() {
        
        /**
         * Returns true if this figure is complete, meaning its Image
         * is non-null and its caption is non-null and non-empty, and
         * false otherwise.
         *
         * @return True if this figure is complete and false otherwise
         */

        return this.imagePath != null && (this.caption != null && this.caption.length() != 0);
    }
}
