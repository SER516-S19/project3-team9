package src.utility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import src.model.Quiz;
import src.model.Question;

/**
 * Class that reads information from quiz JSON files saved in the quiz folder and stores
 * information into a Quiz object.
 *
 * @author Qianru (Ruby) Zhao
 * @verson 1.0
 */
public class QuizReader {
    private final String FOLDER_PATH = "./quizzes/";

    /**
     * Constructor for the QuizReader class
     */
    public QuizReader() { }

    /**
     * Reads question title, options, and correct answer from the specified quiz's
     * JSON file. Takes a quiz name and creates a JsonReader object to pass to createQuiz.
     * @param quizName String representing the name of the quiz file (ie "testQuiz", no ".json")
     * @throws IOException
     */
    public Quiz readQuiz(String quizName) throws IOException {
        String filename = FOLDER_PATH + quizName + ".json";
        File folder = new File(filename);
        System.out.println(folder.getAbsolutePath());
        JsonReader reader = new JsonReader(new FileReader(filename));

        return createQuiz(reader, quizName);
    }

    /**
     * Takes a JsonReader object and parses out the JSON file. Stores information
     * read from file into a Quiz object.
     * @param reader JsonReader object specifying the quiz to read from
     * @param quizName String name of quiz file
     * @return Quiz object requested by readQuiz
     * @throws IOException
     */
    private Quiz createQuiz(JsonReader reader, String quizName) throws IOException {
        ArrayList<Question> questionList = new ArrayList<>();

        reader.beginObject();
        System.out.println(reader.nextName()); //questions label
        reader.beginArray();

        //loop through question array
        while(reader.hasNext() && reader.peek()!= JsonToken.END_ARRAY) {
            Question question = new Question();
            String correctAnswer, opt1, opt2, opt3, opt4;

            reader.beginObject();
            reader.nextName(); //title label
            question.setDescription(reader.nextString()); //title String
            reader.nextName(); //options label
            reader.beginArray();
            opt1 = reader.nextString(); //option1
            question.setOption1(opt1);
            opt2 = reader.nextString(); //option2
            question.setOption2(opt2);
            opt3 = reader.nextString(); //option3
            question.setOption3(opt3);
            opt4 = reader.nextString(); //option4
            question.setOption4(opt4);
            reader.endArray();
            reader.nextName(); //correctAnswer label
            correctAnswer = reader.nextString(); //correct answer option
            reader.endObject();

            //determine the correct option index
            if(correctAnswer.equals(opt1)) question.setCorrectOption((short)1);
            else if(correctAnswer.equals(opt2)) question.setCorrectOption((short)2);
            else if(correctAnswer.equals(opt3)) question.setCorrectOption((short)3);
            else if(correctAnswer.equals(opt4)) question.setCorrectOption((short)4);
            else question.setCorrectOption((short)0);

            questionList.add(question);
        }
        reader.endArray();

        return new Quiz(quizName, questionList);
    }
}