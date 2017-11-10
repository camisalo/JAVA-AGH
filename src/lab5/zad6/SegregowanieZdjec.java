package lab5.zad6;

import com.sun.xml.internal.ws.server.ServerRtException;
import io.indico.*;
import io.indico.api.image.FacialEmotion;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class SegregowanieZdjec {
    public SegregowanieZdjec(String patch) throws IndicoException, IOException {
        // single example

        Indico indico = new Indico("a16f7a067abf922404162ad6a6064bfa");

        Iterator it = FileUtils.iterateFiles(new File(patch), ".img", false);
        while(it.hasNext()){
            File f = (File) it.next();
            IndicoResult single = indico.imageRecognition.predict(f);
            Map<String, Double> result = single.getImageRecognition();
            String key = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
            File dir = new File(key);



        }

        IndicoResult single = indico.imageFeatures.predict(patch);
        List<Double> result = single.getImageFeatures();
        System.out.println(result);

// batch example

        String[] batchExample = {
                "C:\\foto\\kkott.jpg",
                "C:\\foto\\bocian.jpg"
        };



        BatchIndicoResult batch = indico.analyzeImage.predict(batchExample,
            "cat"
        );
        Map<String, ArrayList<Map<FacialEmotion, Double>>> result1 = batch.getAnalyzeImage();
        System.out.println(result1);
    }
}
