package cisc3130;

import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.FrequencyFileLoader;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.bg.Background;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */

public class App {
	
    public static void main( String[] args ) throws FileNotFoundException, java.io.IOException {
       
    	System.out.println( "Hello World!" );
  
    	final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
    	frequencyAnalyzer.setWordFrequenciesToReturn(300);
    	frequencyAnalyzer.setMinWordLength(2);
        
        final java.util.List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("little_dark_age\\10_hand_it_over.txt");
        
        final Dimension dimension = new Dimension(640, 640);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundryBackground("cover_art\\MGMT LDA Cover Art Transparent Fix 3.png"));
        wordCloud.setFontScalar(new LinearFontScalar(15, 60));
        wordCloud.setBackgroundColor(new Color(0xf6d951));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x000000)));
        
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("images\\10_wordcloud.png");
    }
}