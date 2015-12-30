package ptrpathview.com.ptrpathview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.eftimoff.androipathview.PathView;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * 用途：
 * <p>
 * Created by ningbo on 15/12/30.
 */
public class SVGHeader extends FrameLayout implements PtrUIHandler {

    private View view;
    private PathView pathView;

    public SVGHeader(Context context) {
        super(context);
        init(context);

    }

    public SVGHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public SVGHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @SuppressLint("NewApi")
    public SVGHeader(Context context, AttributeSet attrs,
                     int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.svg_header, this);
        pathView = (PathView) view.findViewById(R.id.pathView);
    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        float currentPercent = Math.min(1f, ptrIndicator.getCurrentPercent());
        pathView.setPercentage(currentPercent);
        invalidate();
    }
}
