package com.jiangtf.nettytest.javare.sjms.zhuangsq;

public class runDemo {

    public static void main(String[] args) {
        Shape circle=new Circle();
//        ShapeDecorator redCircle=new RedShapeDecorator(new Circle());
//        ShapeDecorator redReactgle=new RedShapeDecorator(new Rectangle());

        Shape redCircle=new RedShapeDecorator(new Circle());
        Shape redReactgle=new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle of red border");
        redCircle.draw();

        System.out.println("Rectangle of red border");
        redReactgle.draw();

    }
}
