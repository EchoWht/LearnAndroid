```java

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
