import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws FileNotFoundException, IOException {
        Path path = Paths.get(fileName);
        String result = "";

        if (Files.exists(path)) {
            TreeSet<Character> charactersSet = new TreeSet<>();
            char[] characters = Files.readString(path).toLowerCase()
                    .replaceAll("[^a-z]", "").toCharArray();

            for (char character: characters) {
                charactersSet.add(character);
            }

            int countdown = 5;
            for (Character character: charactersSet) {
                result += character;
                countdown--;

                if (countdown == 0) {
                    break;
                }
            }
        } else {
            throw new FileNotFoundException(fileName);
        }

        return result;
    }
}
