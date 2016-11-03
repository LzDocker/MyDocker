package com.zxd.mydocker.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.zxd.mydocker.R;
import com.zxd.mydocker.utils.MeasureUtil;

/**
 * Created by admin on 2016/10/14.
 */
public class circleView extends View /*implements Runnable*/{

    private Paint mPaint;// 画笔
    private Context mContext;// 上下文环境引用

    private int radiu;// 圆环半径

    private Bitmap bitmap;

    private int  x,y;// 位图绘制时左上角的起点坐标  

    public circleView(Context context) {
        this(context, null);
    }

    public circleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        // 初始化画笔
        initPaint();

        initRes(mContext);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
       /* // 实例化画笔并打开抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

		*//*
		 * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
		 *
		 * 画笔样式分三种：
		 * 1.Paint.Style.STROKE：描边
		 * 2.Paint.Style.FILL_AND_STROKE：描边并填充
		 * 3.Paint.Style.FILL：填充
		 *//*
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStyle(Paint.Style.STROKE);

        // 设置画笔颜色为浅灰色
        mPaint.setColor(Color.LTGRAY);

		*//*
		 * 设置描边的粗细，单位：像素px
		 * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
		 *//*
        mPaint.setStrokeWidth(10);
*/




        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setColor(Color.RED);

        mPaint.setStrokeWidth(10);

// 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.33F, 0.59F, 0.11F, 0, 0,
                0.33F, 0.59F, 0.11F, 0, 0,
                0.33F, 0.59F, 0.11F, 0, 0,
                0, 0, 0, 1, 0,
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }


    private void initRes(Context mContext){

        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.nner);

         /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
        x = MeasureUtil.getScreenSize((Activity) mContext)[0] / 2 - bitmap.getWidth() / 2;
        y = MeasureUtil.getScreenSize((Activity) mContext)[1] / 2 - bitmap.getHeight() / 2;

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制圆环
       // canvas.drawCircle(MeasureUtil.getScreenSize((Activity) mContext)[0] / 2, MeasureUtil.getScreenSize((Activity) mContext)[1] / 2, radiu, mPaint);

        canvas.drawBitmap(bitmap,0,0,mPaint);

    }

   /* @Override
    public void run() {
		*//*
		 * 确保线程不断执行不断刷新界面
		 *//*
        while (true) {
            try {
				*//*
				 * 如果半径小于200则自加否则大于200后重置半径值以实现往复
				 *//*
                if (radiu <= 200) {
                    radiu += 10;

                    // 刷新View
                    postInvalidate();
                } else {
                    radiu = 0;
                }

                // 每执行一次暂停40毫秒
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

}