package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class MavenTest {
    public static void main(String[] args) throws IOException {
        String mansVards = FigletFont.convertOneLine("Marcis Kraukis");
        System.out.println(mansVards);

    }
}
