/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author carlo
 */
public class Lienzo extends JPanel{
    
    private Image imageShare;
    private Mat imageMat;
   
    public Lienzo(){
    }

    @Override
    public void paintComponent(Graphics g){
        this.setPreferredSize(new Dimension(imageShare.getWidth(null), imageShare.getHeight(null)));
        super.paintComponent(g);
        g.drawImage(imageShare, 0, 0, null);
    }
    
    public void openImage(String path){
        imageMat = Imgcodecs.imread(path);
        imageShare = HighGui.toBufferedImage(imageMat);
        this.repaint();
    }
    
    public void closeImage(){
        imageShare=null;
        imageMat=null;
        this.repaint();
    }
    
    @Override
    public int getHeight(){
        if(imageShare==null){
            return 0;
        }else{
            return imageShare.getHeight(null);
        }      
    }
    
    @Override
    public int getWidth(){
        if(imageShare==null){
            return 0;
        }else{
            return imageShare.getWidth(null);
        } 
    }

    public Mat getMatImage(){
        return imageMat;
    }
}
