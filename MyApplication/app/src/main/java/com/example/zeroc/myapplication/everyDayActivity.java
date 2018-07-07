package com.example.zeroc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zero.SQLite.DBManager;
import com.zero.news.Recorder;

public class everyDayActivity extends AppCompatActivity implements View.OnClickListener {


    private Button start;
    private Button stop;
    private Button paly;
    private Button pause_paly;
    private Button stop_paly;
    private Button release_file;
//    private static MediaRecorder mediaRecorder;
//    public static File recordFile;
//   private RecordPlayer player;
    private Recorder recorder;
//    public static boolean isRecording=false;
//    public static String FilePath;
//    public static String  fileNameString;
    private DBManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_every_day);
//        fileNameString = generalFileName();
//        recordFile = new File("/mnt/sdcard",fileNameString); // 文件路径，文件名

        initView();
        Listener();
    }

    private void initView() {
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        paly = (Button) findViewById(R.id.paly);
        pause_paly = (Button) findViewById(R.id.pause_paly);
        stop_paly = (Button) findViewById(R.id.stop_paly);
        release_file=(Button)findViewById(R.id.release_file);
    }

    private void Listener() {
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        paly.setOnClickListener(this);
        pause_paly.setOnClickListener(this);
        stop_paly.setOnClickListener(this);
        release_file.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        recorder=new Recorder(everyDayActivity.this);
//        player = new RecordPlayer(everyDayActivity.this);
        int Id = v.getId();

        switch (Id) {
            case R.id.start:
                recorder.startRecording();
                break;
            case R.id.stop:
                recorder.stopRecording();
                break;
            case R.id.paly:
                Log.e("ljb", "onClick: " );
                recorder.playRecording();
                break;
            case R.id.pause_paly:
                recorder.pauseplayer();
                break;
            case R.id.stop_paly:
                recorder.stopplayer();
                break;
            case R.id.release_file:
                recorder.cancel();
                break;
        }
    }

//    private static String generalFileName() {
//        return UUID.randomUUID().toString() + ".amr"; //UUID.randomUUID().toString()是javaJDK提供的一个自动生成主键的方法。
//    }


//    public static void startRecording() {
//        mediaRecorder = new MediaRecorder();
//        fileNameString = generalFileName();
//        recordFile = new File("/mnt/sdcard",fileNameString); // 文件路径，文件名
////        if ( recordFile.exists() ) {
////            recordFile.delete();
////        }
////        Log.e("ljb", "startRecording: ");
////         fileNameString = generalFileName();
////        recordFile = new File("/mnt/sdcard",fileNameString); // 文件路径，文件名
////        Log.e("ljb", "startRecording: 1");
//        FilePath= recordFile.getAbsolutePath();//getAbsolutePath返回抽象路径名的绝对路径名字符串。
//        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置meidaRecorder的音频源是麦克风
//        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);// 设置文件音频的输出格式为amr
//        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);// 设置音频的编码格式为amr。这里如果采用AAC主要为了适配IOS，保证在IOS上可以正常播放。
//        mediaRecorder.setOutputFile(FilePath); // 设置输出文件
//        Log.e("ljb", "startRecording: " );
//
//        try {
//            mediaRecorder.prepare();
//            mediaRecorder.start();
//            isRecording=true;
//            Log.e("ljb", "startRecording: 11");
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public static void stopRecording() {
////        if ( recordFile != null ) {
//            if ( isRecording) {
////                Record recordModel=new Record();
////                recordModel.setSecond((int) seconds <= 0 ? 1 : (int) seconds);
////                recordModel.setPath(FilePath);
////                recordModel.setPlayed(false);
////                mgr.add(recordModel);
//                mediaRecorder.stop();
//                mediaRecorder.release();
//              Toast.makeText(getContext(), "录音已停止", Toast.LENGTH_SHORT).show();
//                isRecording=false;
//            }
//            else {
//                Toast.makeText(getContext(), "不存在可停止的录音", Toast.LENGTH_SHORT).show();
//                Log.e("ljb", "stopRecording: 1");
//           }
//
//    }
//
//    private void playRecording() {
//        player.playRecordFile(recordFile);
//    }
//
//    private void pauseplayer() {
//        player.pausePalyer();
//    }
//    private void stopplayer() {
//        player.stopPalyer();
//    }
//    // 释放资源
//    public void release() {
//        // 严格按照api流程进行
//        Log.e("ljb", "cance1: " );
////        mediaRecorder.stop();
//        mediaRecorder.release();
//        mediaRecorder = null;
//        Log.e("ljb", "cance2: " );
//    }
//
//    // 取消,因为prepare时产生了一个文件，所以cancel方法应该要删除这个文件，
//    // 这是与release的方法的区别
//    public void cancel() {
//        release();
//        if (FilePath != null) {
//            File file = new File(FilePath);
//            file.delete();//删除文件
//            FilePath = null;
//            Log.e("ljb", "cance3: " );
//        }
//    }
}

