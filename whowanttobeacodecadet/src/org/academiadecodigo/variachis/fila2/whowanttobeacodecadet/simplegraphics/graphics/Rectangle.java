package org.academiadecodigo.variachis.fila2.whowanttobeacodecadet.simplegraphics.graphics;

import java.awt.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Rectangle implements Shape, Colorable, Fillable, Movable {
    private java.awt.Color color = java.awt.Color.BLACK;
    private boolean filled = false;
    private double x;
    private double y;
    private double width;
    private double height;

    /**
     * Constructs an empty rectangle.
     */
    public Rectangle() {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    /**
     * Constructs a rectangle.
     *
     * @param x      the leftmost x-coordinate
     * @param y      the topmost y-coordinate
     * @param width  the width
     * @param height the height
     */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the leftmost x-position of this rectangle.
     *
     * @return the leftmost x-position
     */
    @Override
    public int getX() {
        return (int) Math.round(x);
    }

    /**
     * Gets the topmost y-position of this rectangle.
     *
     * @return the topmost y-position
     */
    @Override
    public int getY() {
        return (int) Math.round(y);
    }

    /**
     * Gets the width of this rectangle.
     *
     * @return the width
     */
    @Override
    public int getWidth() {
        return (int) Math.round(width);
    }

    /**
     * Gets the height of this rectangle.
     *
     * @return the height
     */
    @Override
    public int getHeight() {
        return (int) Math.round(height);
    }

    /**
     * Moves this rectangle by a given amount.
     *
     * @param dx the amount by which to move in x-direction
     * @param dy the amount by which to move in y-direction
     */
    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
        java.awt.Canvas.getInstance().repaint();
    }

    /**
     * Resizes this rectangle both horizontally and vertically.
     *
     * @param dw the amount by which to resize the width on each side
     * @param dw the amount by which to resize the height on each side
     */
    @Override
    public void grow(double dw, double dh) {
        width += 2 * dw;
        height += 2 * dh;
        x -= dw;
        y -= dh;
        java.awt.Canvas.getInstance().repaint();
    }

    /**
     * Gets the color of this rectangle.
     *
     * @return the rectangle color
     */
    @Override
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * Sets the color of this rectangle.
     *
     * @param newColor the new color
     */
    @Override
    public void setColor(Color newColor) {
        color = newColor;
        java.awt.Canvas.getInstance().repaint();
    }

    /**
     * Draws this rectangle.
     */
    @Override
    public void draw() {
        filled = false;
        java.awt.Canvas.getInstance().show(this);
    }

    /**
     * Deletes this rectangle
     */
    @Override
    public void delete() {
        java.awt.Canvas.getInstance().hide(this);
    }

    /**
     * Fills this rectangle.
     */
    @Override
    public void fill() {
        filled = true;
        Canvas.getInstance().show(this);
    }

    /**
     * Gets if this rectangle is filled
     * @return true if is filled
     */
    @Override
    public boolean isFilled() {
        return filled;
    }

    @Override
    public void paintShape(Graphics2D g2) {
        Rectangle2D.Double rect = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
        g2.setColor(new Color((int) color.getRed(), (int) color.getGreen(), (int) color.getBlue()));

        if (filled) {

            g2.fill(rect);

        } else {
            g2.draw(rect);
        }
    }

    @Override
    public String toString() {
        return "Rectangle[x=" + getX() + ",y=" + getY() + ",width=" + getWidth() + ",height=" + getHeight() + "]";
    }
}
