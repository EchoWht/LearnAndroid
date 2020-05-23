```java
private  MyThread thread;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRun){
                    thread = new MyThread();
                   thread.setName("PhoneLocation");
                    Snackbar.make(view, "开始", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    thread.start();
                    locationClient.start();
                }else {
                  thread.flag=false;
                    Snackbar.make(view, "结束", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    locationClient.stop();
                }
                isRun=!isRun;
            }
        });
public class MyThread extends Thread{
        private volatile boolean flag = true;
        @Override
        public void run() {
            int i=0;
            do {
                i++;
                try {   
                  Message message=new Message();
                  msg.what=1;
                  message.obj="123"
                  //然后将消息发送出去
                  handler.sendMessage(message);
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (flag);
        }
    }
 private Handler handler=new MyHandler();
 private Boolean isRun=true;
  @SuppressLint("HandlerLeak")
    public class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    //在这里可以进行UI操作
//                    Toast.makeText(MainActivity.this,String.valueOf(msg.what),Toast.LENGTH_SHORT).show();
                    //textView.append(String.valueOf(msg.obj));
                    break;
                default:
                    break;
            }
        }
    };
```
