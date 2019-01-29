package com.lti.training.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/captcha.jpg")
public class CaptchaServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; from serializable interface
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   			response.setContentType("image/jpeg");
   			ServletOutputStream out=response.getOutputStream(); //for binary data
   			
   			String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
   			String captext="";
   			for(int i=0;i<4;i++)
   			{
   				int rno=(int) (Math.random() * str.length());
   				captext+=str.charAt(rno);
   			}
   			
   			//CODE TO GENERATE AN IMAGE
   			BufferedImage img=
   					new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
   			Graphics g=img.getGraphics();
   			
   			g.setColor(Color.cyan);
   			g.fillRect(0, 0, 100, 100);
   			g.setColor(Color.red);
   		    g.setFont(new Font("Italics",Font.BOLD,24));
   			g.drawString(captext,15, 20);
   			
   			//send this image back to the client
   			ImageIO.write(img,"jpeg",out);
	}

}
