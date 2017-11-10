package lab5.zad6;

import io.indico.*;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;


import javax.sound.midi.Patch;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class SegregowanieZdjec {
    public SegregowanieZdjec(String patch) throws IndicoException, IOException {
        // single example

        Indico indico = new Indico("a16f7a067abf922404162ad6a6064bfa");

        String[] extension = {"jpg"}; int licznik=0;
        Iterator it = FileUtils.iterateFiles(new File(patch), extension, false);
        while(it.hasNext()){
            File f = (File) it.next();
            IndicoResult single = indico.imageRecognition.predict(f);
            Map<String, Double> result = single.getImageRecognition();

            String key = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();


            File dir = new File(patch + "\\" + key);
            if (!dir.mkdir()){
                System.out.println("exist");
            }

            System.out.println(f.getPath());
            Files.copy(Paths.get(f.getPath()), Paths.get(patch + "\\" + key + "\\" + licznik + key + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
            ++licznik;
        }
    }
}
