package com.zero.news;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.example.zeroc.myapplication.R;
import com.zero.SQLite.DBManager;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//import static com.mob.MobSDK.getContext;

public  class Recorder {
    private Context context;
    public Recorder(Context context) {
        this.context = context;
    }
    private static MediaPlayer mediaPlayer;
    private static MediaRecorder mediaRecorder;
    private static File recordFile;
    private static boolean isRecording=false;
    public static String FilePath;
    private static String fileNameString;
    private static DBManager mgr;

    public String generalFileName() {
        return UUID.randomUUID().toString() + ".amr"; //UUID.randomUUID().toString()是javaJDK提供的一个自动生成主键的方法。
    }
    public  void startRecording() {
        mediaRecorder = new MediaRecorder();
        fileNameString = generalFileName();
        recordFile = new File("/mnt/sdcard",fileNameString); // 文件路径，文件名
//        if ( recordFile.exists() ) {
//            recordFile.delete();
//        }
//        Log.e("ljb", "startRecording: ");
//         fileNameString = generalFileName();
//        recordFile = new File("/mnt/sdcard",fileNameString); // 文件路径，文件名
//        Log.e("ljb", "startRecording: 1");
        FilePath= recordFile.getAbsolutePath();//getAbsolutePath返回抽象路径名的绝对路径名字符串。
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置meidaRecorder的音频源是麦克风
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);// 设置文件音频的输出格式为amr
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);// 设置音频的编码格式为amr。这里如果采用AAC主要为了适配IOS，保证在IOS上可以正常播放。
        mediaRecorder.setOutputFile(FilePath); // 设置输出文件
        Log.e("ljb", "startRecording:" );

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
            isRecording=true;
            Log.e("ljb", "startRecording: 11");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void stopRecording() {
//        if ( recordFile != null ) {
        if (isRecording) {
//                Record recordModel=new Record();
//                recordModel.setSecond((int) seconds <= 0 ? 1 : (int) seconds);
//                recordModel.setPath(FilePath);
//                recordModel.setPlayed(false);
//                mgr.add(recordModel);
            mediaRecorder.stop();
            mediaRecorder.release();
           Toast.makeText(context, "录音已停止", Toast.LENGTH_SHORT).show();
            isRecording=false;
        }
        else {
            Toast.makeText(context, "不存在可停止的录音", Toast.LENGTH_SHORT).show();
            Log.e("ljb", "stopRecording: 1");
        }
    }
    public void playRecording() {
        playRecordFile(recordFile);
    }

    public void pauseplayer() {
        pausePalyer();
    }
    public void stopplayer() {
        stopPalyer();
    }
    // 释放资源
    public void release() {
        // 严格按照api流程进行
        Log.e("ljb", "cance1: " );
//        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        Log.e("ljb", "cance2: " );
    }

    // 取消,因为prepare时产生了一个文件，所以cancel方法应该要删除这个文件，
    // 这是与release的方法的区别
    public void cancel() {
        release();
        if (FilePath != null) {
            File file = new File(FilePath);
            file.delete();//删除文件
            FilePath = null;
            Log.e("ljb", "cance3: " );
        }
    }
    public void playRecordFile(File file) {
        if (file.exists() && file != null) {
//			if (mediaPlayer == null) {
            Uri uri = Uri.fromFile(file);
            Log.e("ljb", "onClick:2 " );
            mediaPlayer = MediaPlayer.create(context, uri);
//			}
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer paramMediaPlayer) {

                    Toast.makeText(context, context.getResources().getString(R.string.ok),
                            Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public void pausePalyer() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stopPalyer() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }
}

