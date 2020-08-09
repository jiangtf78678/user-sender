package com.jiangtf.nettytest.javare.sjms.zhuangsq;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
    private  void setRedBorder(Shape decorateShape){
        System.out.println("Border Color: Red");
    }
}
