package com.blskye.test;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * 一、Handler的定义
        * 主要接受子线程发送的数据，并且此数据配合主线程更新UI
        * 解释：当应用程序启动时，Android首先会开启一个主线程 (也就是UI线程) ，
        * 主线程为管理界面中的UI控件， 进行事件分发，
        * 比如说， 你要是点击一个 Button ，Android会分发事件到Button上，来响应你的操作。
        * 如果此时需要一个耗时的操作，
        *   例如: 联网读取数据或者读取本地较大的一个文件的时候，
        *   你不能把这些操作放在主线程中，如果你放在主线程中的话，界面会出现假死现象，
        *   如果5秒钟还没有完成的话，会收到Android系统的一个错误提示  "强制关闭"。
        *   这个时候我们需要把这些耗时的操作，放在一个子线程中，因为子线程涉及到UI更新，
        *   Android主线程是线程不安全的，
        *   也就是说，更新UI只能在主线程中更新，子线程中操作是危险的。
        * 这个时候，Handler就出现了来解决这个复杂的问题 ，
        * 由于Handler运行在主线程中(UI线程中)，  它与子线程可以通过Message对象来传递数据，
        * 这个时候，Handler就承担着接受子线程传过来的(子线程用sedMessage()方法传弟)Message对象，(里面包含数据)
        * 把这些消息放入主线程队列中，配合主线程进行更新UI。
        * 二、handle的一些特点
        *
        * */
    }
}
