package Medium;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Music{
	private File file;//.wav	
	private AudioInputStream stream;	
	private AudioFormat format;	
	private DataLine.Info info;	
	private Clip clip;
	
	//open the music
	public void open(String s)  //���ļ���
	{
		file = new File(s);	
		try 		
		{			
			stream = AudioSystem.getAudioInputStream(file);			
			format = stream.getFormat();		
		}		
		catch (UnsupportedAudioFileException e) 		
		{			
			e.printStackTrace();		
		}		
		catch (IOException e) 		
		{			
			e.printStackTrace();		
		}
		
		//����
		info = new DataLine.Info(Clip.class, format);		
		try 		
		{			
			clip = (Clip) AudioSystem.getLine(info);			
			clip.open(stream);		
		} 		
		catch (LineUnavailableException e) 		
		{			
			e.printStackTrace();		
		}		
		catch (IOException e) 		
		{			
			e.printStackTrace();	
		}
		
	}
	
	public void start()
	{
		clip.start();
	}
	
	public void loop(int times)  //ѭ������
	{
		clip.loop(times);
	}
	
	public void close() 	//ֹͣ
	{	
		clip.close();
	}
	
}
