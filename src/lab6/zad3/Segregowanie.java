package lab6.zad3;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class Segregowanie {


    public Segregowanie(String patch) throws IndicoException, IOException {
        
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
