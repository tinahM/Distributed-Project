import java.net.*;
import java.io.*;

class ServerProtocol {
    private static final int WAITING = 0;
    private static final int ADM = 1;
    private static final int NAME = 2;
    private static final int FACULTYCOURSEDEGREE = 3;
    private static final int PERSONALCODE = 4;
    private static final int SENDALL= 5;
    private static final int DONE = 6;
    private static final int SESSIONRENEWAL = 7;

    private int state = WAITING;
    String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Please input your Admission Number";
            state = ADM;
        } else if (state == ADM) {

                //theOutput = clues[currentJoke];
            theOutput = "Please input your name?";
                state = NAME;

        } else if (state == NAME) {

                //theOutput = answers[currentJoke] + " Want another? (y/n)";
            theOutput = "Input your faculty, course and degree (faculty, course, degree)?";
                state = FACULTYCOURSEDEGREE;

        }  else if (state == FACULTYCOURSEDEGREE) {

           // theOutput = answers[currentJoke] + " Want another? (y/n)";
            theOutput = "Input your personal code (firstname-admission number)";
            state = PERSONALCODE;

        }else if (state == PERSONALCODE) {

            // theOutput = answers[currentJoke] + " Want another? (y/n)";
            theOutput = "Kindly send all the above in one instruction  (admission number, name, faculty, course, degree)";
            state = SENDALL;

        }
        else if (state == SENDALL) {

            // theOutput = answers[currentJoke] + " Want another? (y/n)";
            theOutput = "Restart? (Yes/No)";
            state = SESSIONRENEWAL;


        }else if (state == SESSIONRENEWAL) {
            if (theInput.equalsIgnoreCase("yes")) {
                theOutput = "Please input your Admission Number";

                state = ADM;
            } else {
                theOutput = "Terminating session";
                state = WAITING;
            }
        }

        return theOutput;
    }
}
