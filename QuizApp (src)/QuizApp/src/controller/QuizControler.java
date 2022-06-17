package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static model.UsersModel.msgBox;
import java.util.List;
import view.*;
import model.*;



public class QuizControler {
    private QuizView quizView;
    private QuizModel quizModel;

    QuizControler(QuizView quizView, QuizModel quizModel) {
        this.quizModel   =   quizModel;
        this.quizView    =   quizView;
        // Set Name Quiz
        quizView.setNameOfQuiz(""+quizModel.getQuizName());
        // Start Quiz
        setQuestion();
        // Next Question
        quizView.nextQuestion(new NextQuestionListenerButton());
        // Stop Quiz
        quizView.closeButton(new CloseListenerButton());
    }
    private boolean setQuestion(){
        try{
        List<String> question = question = quizModel.getQuestion();
        quizView.setNumOfQuestion(""+quizModel.getNumQuestion());
        // question [question, setTextOfChoiceOne , setTextOfChoiceTwo,setTextOfChoiceThree,setTextOfChoiceFour]
        quizView.setTextOfQuestion(question.get(0));
        quizView.setTextOfChoiceOne(question.get(1));
        quizView.setTextOfChoiceTwo(question.get(4));
        quizView.setTextOfChoiceThree(question.get(7));
        quizView.setTextOfChoiceFour(question.get(10));
        return true;
        }
        catch(IndexOutOfBoundsException ex){
          //msgBox(ex.getMessage());
          return false;
        }
    }
    class NextQuestionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int numAnswer = quizView.getNumSelectionButton();
            quizModel.CheckAnswer(numAnswer);
            if (numAnswer != 0){
                if(!setQuestion()){
                    msgBox("Your Score "+quizModel.getScore()+"");
                    quizModel.finishQuiz();
                    quizView.setVisible(false);
                }
            }
        }  
    }
    class CloseListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            quizView.setVisible(false);
        }  
    }
}
