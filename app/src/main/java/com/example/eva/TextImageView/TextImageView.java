package com.example.eva.TextImageView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;


import androidx.appcompat.widget.AppCompatTextView;

import com.example.eva.R;

import timber.log.Timber;

public class TextImageView extends AppCompatTextView {

        private int mLeftWidth;
        private int mLeftHeight;
        private int mTopWidth;
        private int mTopHeight;
        private int mRightWidth;
        private int mRightHeight;
        private int mBottomWidth;
        private int mBottomHeight;

        public TextImageView(Context context) {
            super(context);
        }

        public TextImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context, attrs);
        }

        public TextImageView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context, attrs);
        }


        public void init(Context context, AttributeSet attrs) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextImageView);

            mLeftWidth = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableLeftWidth, 0);
            mLeftHeight = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableLeftHeight, 0);
            mTopWidth = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableTopWidth, 0);
            mTopHeight = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableTopHeight, 0);
            mRightWidth = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableRightWidth, 0);
            mRightHeight = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableRightHeight, 0);
            mBottomWidth = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableBottomWidth, 0);
            mBottomHeight = typedArray.getDimensionPixelOffset(R.styleable.TextImageView_drawableBottomHeight, 0);
            typedArray.recycle();
            setDrawablesSize();
        }

        private void setDrawablesSize() {
            Drawable[] compoundDrawables = getCompoundDrawables();
            Timber.d("Drawable size" + compoundDrawables.length + "value = " + compoundDrawables + "");
            for (int i = 0; i < compoundDrawables.length; i++) {
                switch (i) {
                    case 0:
                        setDrawableBounds(compoundDrawables[0], mLeftWidth, mLeftHeight);
                        break;
                    case 1:
                        setDrawableBounds(compoundDrawables[1], mTopWidth, mTopHeight);
                        break;
                    case 2:
                        setDrawableBounds(compoundDrawables[2], mRightWidth, mRightHeight);
                        break;
                    case 3:
                        setDrawableBounds(compoundDrawables[3], mBottomWidth, mBottomHeight);
                        break;
                    default:

                        break;
                }

            }
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }

        private void setDrawableBounds(Drawable drawable, int width, int height) {
            if (drawable != null) {
                double scale = ((double) drawable.getIntrinsicHeight()) / ((double) drawable.getIntrinsicWidth());
                Timber.d("width/height" + drawable.getIntrinsicWidth() + "," + drawable.getIntrinsicHeight());
                Timber.d("scale = %s", scale);
                drawable.setBounds(0, 0, width, height);
                Rect bounds = drawable.getBounds();
                //高宽只给一个值时，自适应
                if (bounds.right != 0 || bounds.bottom != 0) {
                    Timber.d("before" + bounds.right + "," + bounds.bottom);
                    if (bounds.right == 0) {
                        bounds.right = (int) (bounds.bottom / scale);
                        drawable.setBounds(bounds);
                    }
                    if (bounds.bottom == 0) {
                        bounds.bottom = (int) (bounds.right * scale);
                        drawable.setBounds(bounds);
                    }
                    Timber.d("after" + bounds.right + "," + bounds.bottom);
                }

            }
        }
}
