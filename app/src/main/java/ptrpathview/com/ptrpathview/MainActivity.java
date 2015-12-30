package ptrpathview.com.ptrpathview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ptr();
    }

    private void ptr() {

        final SVGHeader svgHeader = new SVGHeader(this);

        final PtrFrameLayout ptrFrame = (PtrFrameLayout) findViewById(R.id.ptr);
        ptrFrame.setHeaderView(svgHeader);
        ptrFrame.addPtrUIHandler(svgHeader);
        ptrFrame.setResistance(1.7f);//阻尼系数
        ptrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        ptrFrame.setDurationToClose(200);//回弹延时
        ptrFrame.setDurationToCloseHeader(200);//头部回弹时间
        ptrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrame.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
    }
}
