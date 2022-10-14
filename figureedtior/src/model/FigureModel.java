package model;

import javax.swing.ImageIcon;
import java.beans.*;


public class FigureModel
{
    private ImageIcon imagePath = null;
    private String caption = null;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void FigureModel() {
    }

    public void FigureModel(ImageIcon image, String caption) {
        this.imagePath = image;
        this.caption = caption;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener)
    {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener)
    {
        this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public ImageIcon getImage() {
	    return this.imagePath;
    }

    /**
     * Sets the image to the given non-null ImageIcon.
     *
     * @param newImage The ImageIcon must be non-null
     *
     * @throws IllegalArgumentException if the ImageIcon is null
     */
    public void setImage(ImageIcon newImage) {
        if (newImage == null) {
            throw new IllegalArgumentException("Your chosen image is null. Please reselect a non-null image!");
        }
        this.propertyChangeSupport.firePropertyChange("image", this.imagePath, newImage);
        this.imagePath = newImage;
    }

    public String getCaption() {
	    return this.caption;
    }

    /**
     * Sets the caption to the given non-null and non-empty String.
     *
     * @param newCaption The String must be non-null and non-empty
     *
     * @throws IllegalArgumentException if the String is null or empty
     */
    public void setCaption(String newCaption) {
        if (newCaption == null) {
            throw new IllegalArgumentException("Your chosen caption is null. Please rewrite a non-null caption!");
        }

        this.propertyChangeSupport.firePropertyChange("caption", this.caption, newCaption);
        this.caption = newCaption;
    }

    /**
     * Returns true if this figure is complete, meaning its Image
     * is non-null and its caption is non-null and non-empty, and
     * false otherwise.
     *
     * @return True if this figure is complete and false otherwise
     */
    public boolean isComplete() {
        return this.imagePath != null && (this.caption != null && this.caption.length() != 0);
    }
}
