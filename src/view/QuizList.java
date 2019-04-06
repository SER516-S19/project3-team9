package src.view;

import java.io.File;
import java.util.ArrayList;

/**
 * Class that generates a list of names for all quizzes saved in the quizzes folder.
 * Returns a list containing only JSON quiz files.
 *
 * @author Qianru (Ruby) Zhao
 * @version 1.0
 */
public class QuizList {
    private final String FOLDER_PATH = "./quizzes/";
    private ArrayList<String> quizList;

    /**
     * Constructor for QuizList
     */
    public QuizList() {
        quizList = new ArrayList<>();
    }

    /**
     * When called, generates a list of quizzes that are saved as JSON files in
     * the quizzes folder. Doesn't include the ".json" at the end of the file name.
     * @return String ArrayList of the names of each quiz
     */
    public ArrayList<String> readQuizList() {
        File folder = new File(FOLDER_PATH);
        File[] fileList = folder.listFiles();

        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                String filename = fileList[i].getName();
                String json = filename.substring(filename.length() - 5);
                if(json.equalsIgnoreCase(".json")) {
                    quizList.add(filename.substring(0, filename.length() - 5));
                }
            }
        }

        return quizList;
    }
}
