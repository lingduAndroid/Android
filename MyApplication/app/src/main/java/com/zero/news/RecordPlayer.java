//package com.zero.news;
//
//import android.content.Context;
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.widget.Toast;
//import com.example.zeroc.myapplication.R;
//import java.io.File;
//
//public class RecordPlayer {
//
//	private  MediaPlayer mediaPlayer;
//	private Context mcontext;
//
//	public RecordPlayer(Context context) {
//        this.mcontext = context;
//	}
//
//	public void playRecordFile(File file) {
//		if (file.exists() && file != null) {
////			if (mediaPlayer == null) {
//				Uri uri = Uri.fromFile(file);
//				mediaPlayer = MediaPlayer.create(mcontext, uri);
////			}
//			mediaPlayer.start();
//
//			mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//
//				@Override
//				public void onCompletion(MediaPlayer paramMediaPlayer) {
//
//					Toast.makeText(mcontext, mcontext.getResources().getString(R.string.ok),
//							Toast.LENGTH_SHORT).show();
//				}
//			});
//
//		}
//	}
//
//	public void pausePalyer() {
//		if (mediaPlayer.isPlaying()) {
//			mediaPlayer.pause();
//		}
//	}
//
//
//	public void stopPalyer() {
//		// ���ﲻ����stop()������seekto(0),�Ѳ��Ž��Ȼ�ԭ���ʼ
//		if (mediaPlayer.isPlaying()) {
//			mediaPlayer.pause();
//			mediaPlayer.seekTo(0);
//		}
//	}
//}
